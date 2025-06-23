package com.avaliacao.java.entity;

import com.avaliacao.java.exceptions.NumException;
import com.avaliacao.java.interfaces.Verifica;

/*
 * Autor: Matheus felipe Braga de Souza
 * 
 * */

public  abstract class ClienteBanco implements Verifica {
	
	private int numeroConta = 0;
	private String nome = "";
	private Endereco ender = new Endereco();
	

	public void verifDoc() {
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) throws NumException {
		if(numeroConta < 0) {
			throw new NumException();
		} else {
			this.numeroConta = numeroConta;
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return ender;
	}
	public void setEndereco(Endereco endereco) {
		this.ender = endereco;
	}

	@Override
	public void validar() {
		if(getNumeroConta() % 2 == 0) {
			System.out.println("O Número da Conta é PAR");
		} else {
			System.out.println("O Número da Conta é IMPAR");
		}
		
	}
	
}
