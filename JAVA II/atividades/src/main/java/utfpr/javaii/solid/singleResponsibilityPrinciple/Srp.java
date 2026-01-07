package utfpr.javaii.solid.singleResponsibilityPrinciple;

import java.util.List;

public class Srp {

	public static void main(String[] args) {
		final Srp srp = new Srp();
		srp.executar();
		
	}

	private void executar() {
		final List<Colaborador> colaboradores = List.of(
				new Colaborador("Hugo", Cargo.DESENVOLVEOR, 500),
				new Colaborador("Zé", Cargo.ANALISTA, 1000),
				new Colaborador("Luiz", Cargo.GERENTE, 2000),
				new Colaborador("Tio Patinhas", Cargo.CEO, 5000),
				new Colaborador("Duck", Cargo.ESTAGIARIO, 500)
				);
		final CalculadoraBonificacao calculadora = new CalculadoraBonificacao();
		
		colaboradores.forEach(colaborador -> {
			System.out.printf("O colaborador %s tem bonificacao de %f%n",
					colaborador.nome(), calculadora.calculaBonificacao(colaborador)).println();
		});
		
	}
	
	
}
