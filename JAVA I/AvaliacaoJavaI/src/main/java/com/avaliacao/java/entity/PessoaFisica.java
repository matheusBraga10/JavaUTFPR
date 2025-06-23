package com.avaliacao.java.entity;


/*
 * Autor: Matheus felipe Braga de Souza
 * 
 * */

public final class PessoaFisica extends ClienteBanco {
	
	private int cpf = 0;

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public void verifDoc() {
		PessoaFisica pessoaFisica= (PessoaFisica) this;
		if(pessoaFisica.getCpf() >= 10 && pessoaFisica.getCpf() <= 20) {
			System.out.println("CPF válido.");
		} else {
			System.out.println("CPF inválido.");
		}
	}
	
	
}
