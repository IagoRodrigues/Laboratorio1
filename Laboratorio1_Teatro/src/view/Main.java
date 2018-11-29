package view;
import model.Vendas;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		Vendas vendas;
		int fileira;
		int assento;
		int inteira;
		int meia;
		boolean vendeu = false;
		
		vendas = new Vendas();
		
		do {
			JOptionPane.showMessageDialog(null, "Venda de ingressos!\n Disponíveis: " + vendas.teatroDisponivel(), "Ingressos do Teatro POO",
					JOptionPane.INFORMATION_MESSAGE);
		
			fileira = Integer.parseInt(JOptionPane.showInputDialog("Fileira"));
			assento = Integer.parseInt(JOptionPane.showInputDialog("Cadeira"));
			inteira = JOptionPane.showConfirmDialog(null, "Ingresso preço cheio?",
				"Ingressos do Teatro POO", JOptionPane.YES_NO_OPTION);

			if(inteira == JOptionPane.YES_OPTION) {
				//se inteira == YES_OPTION, vende inteira
				vendeu = vendas.novaVenda(fileira, assento, Vendas.INTEIRA);
			}
			
			//se inteira == NO_OPTION, perguntar se é meia
			if(inteira == JOptionPane.NO_OPTION) {
				meia = JOptionPane.showConfirmDialog(null, "Ingresso preço meia?",
						"Ingressos do Teatro POO", JOptionPane.YES_NO_OPTION);
				
				if(meia == JOptionPane.YES_OPTION) {
					//se meia == YES_OPTION, vende meia
					vendeu = vendas.novaVenda(fileira, assento, Vendas.MEIA);
				}else {
					//se meia == NO_OPTION, vende isento
					vendeu = vendas.novaVenda(fileira, assento, Vendas.ISENTO);
				}
			}
			
			
			if(!vendeu) {
				JOptionPane.showMessageDialog(null, "Cadeira ocupada ou inválida", "Ingresso do Teatro POO",
						JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Bom espetáculo", "Ingresso do Teatro POO",
						JOptionPane.WARNING_MESSAGE);
			}
		}while(JOptionPane.showConfirmDialog(null, "Deseja encerrar o sistema?",
			"Ingressos do Teatro POO", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
		
		JOptionPane.showMessageDialog(null, "Total de vendas: R$" + vendas.valorArrecadado(),
			"Teatro POO", JOptionPane.INFORMATION_MESSAGE);
	}
}