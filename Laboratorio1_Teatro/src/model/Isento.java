package model;

//Por isento entendi um ingresso gratis, com pre�o = 0;

public class Isento extends Ingresso {
	public Isento(Cadeira cadeira) {
		super(cadeira);
	}
		
	@Override
	public double getValor() {
		return 0;
	}
}
