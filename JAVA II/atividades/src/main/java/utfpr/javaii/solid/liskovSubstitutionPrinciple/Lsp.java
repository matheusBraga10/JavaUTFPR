package utfpr.javaii.solid.liskovSubstitutionPrinciple;

import java.util.List;

/*
 * No lugar da Herança, utilizamos interfaces para implementar contratos (Conjunção)
 * */

public class Lsp {

	public static void main(String[] args) {

		final Lsp lsp = new Lsp();
		lsp.executa();
	}

	private void executa() {
		final var conta1 = new Conta();
		final var conta2 = new ContaPremium();
		final var conta3 = new ContaUniversitaria();

		conta1.depositar(100);
		conta2.depositar(100);
		conta3.depositar(100);

		final List<ManipuladorDeSaldo> contas = List.of(conta1, conta2, conta3);

		contas.stream().peek(ManipuladorDeSaldo::render)
				.forEach(conta -> System.out.println("Saldo da conta: " + conta.getSaldo()));
	}
}
