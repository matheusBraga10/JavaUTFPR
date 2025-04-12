package com.exercicios.java.exercicio05;

public final class Passeio extends Veiculo implements Calcular {

	private int qtdPassageiros;

	public Passeio() {
		qtdPassageiros=0;
	}

	@Override
	public float calcVel(float velocMax) {
		return velocMax*1000;
	}
	
	@Override
	public int calcular() {
		int somaLetras = getCor().length() + getMarca().length() + getModelo().length() + getPlaca().length();
		return somaLetras;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}


}