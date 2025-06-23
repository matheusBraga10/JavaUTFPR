package com.avaliacao.java;

import com.avaliacao.java.entity.PessoaJuridica;
import com.avaliacao.java.exceptions.NumException;


/*
 * Autor: Matheus felipe Braga de Souza
 * 
 * */

public class TstConta {
	
	private static PessoaJuridica pessoaJuridica = new PessoaJuridica();
	
	public static void main(String[] args) {
		
		pessoaJuridica.setCnpj(12);
		pessoaJuridica.getEndereco().setRua("Rua dos Aymores");
		pessoaJuridica.getEndereco().setNum(5);
		try {
			pessoaJuridica.setNumeroConta(14);
		} catch (NumException e) {
			e.impMsg();
			return; // Implementado para parar o programa quando a exceção for lançada.
		}
		pessoaJuridica.getResponsavel().setCpf(15);
		pessoaJuridica.getResponsavel().setNome("João de Deus");
		
		System.out.println("-----------------------------------------");
		System.out.println("------------ SAÍDA DE DAODS -------------");
		System.out.println("-----------------------------------------\n\n");
		System.out.println("Número da conta: " + pessoaJuridica.getNumeroConta());
		pessoaJuridica.validar();
		System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
		System.out.println("Rua: " + pessoaJuridica.getEndereco().getRua());
		System.out.println("CPF do responsável pela conta (pessoa fisica): " + pessoaJuridica.getResponsavel().getCpf());
		pessoaJuridica.getResponsavel().verifDoc();
		System.out.println("Nome: " + pessoaJuridica.getResponsavel().getNome());
		pessoaJuridica.verifDoc();
		
		
	}

}
