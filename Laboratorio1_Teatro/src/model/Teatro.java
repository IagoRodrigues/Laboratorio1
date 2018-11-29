package model;

public class Teatro {
	private final int fileiras = 10;
	private final int cadeiras = 20;
	private int tamanho;
	private int ocupados;
	private Cadeira[] assentos;
	
	public Teatro() {
		int posicao;
	
		assentos = new Cadeira[tamanhoTeatro()];
	
		posicao = 0;
		for(int i = 1; i <= fileiras; i++) {
			for(int j = 1; j <= cadeiras; j++) {
				assentos[posicao] = new Cadeira(i, j);
				posicao += 1;
			}
		}
	}
	
	public boolean vender(int fila, int assento) {
		Cadeira cadeira;
		boolean deuCerto = false;
		
		if((estaValida(fila, assento)) == true) {
			
			cadeira = buscaCadeira(fila, assento);
			
			if(cadeira.estaLivre()) {
				cadeira.ocupar();
				deuCerto = true;
				this.ocupados++;
			}
		}
		
		return deuCerto;
	}
	
	private boolean estaValida(int fila, int assento) {
		boolean valida = false;
		
		if(fila <= fileiras && assento <= cadeiras) {
			valida = true;
		}
		
		return valida;
	}

	public Cadeira buscaCadeira(int fila, int assento) {
		Cadeira cadeira = null;
		int i = 0;
		
			while(cadeira == null && i < tamanhoTeatro()) {
				if(assentos[i].getFileira() == fila) {
					if(assentos[i].getAssento() == assento) {
						cadeira = assentos[i];
					}
				} 
				i++;
			}
			return cadeira;
	}
	
	//Retorna o tamanho do teatro; Implementado por Iago Rodrigues
	public int tamanhoTeatro() {
		this.tamanho = fileiras * cadeiras;
		
		return tamanho;
	}
	
	public int getOcupados() {
		
		return this.ocupados;
	}
	
}