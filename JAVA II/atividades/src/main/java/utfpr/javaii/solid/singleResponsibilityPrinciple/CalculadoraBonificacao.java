package utfpr.javaii.solid.singleResponsibilityPrinciple;

public class CalculadoraBonificacao {

	public double calculaBonificacao(Colaborador colaborador) {
		/*
		 * Com uso do Single Responsibility Principle
		 */

		final var salarioBase = colaborador.salario();
		final var cargo = colaborador.cargo();

		return cargo.calculaBonificacao(salarioBase);

		/*
		 * Muito verboso - Passando apra SuiteCase
		 */

//		double bonificacao = 0;
//		if(colaborador.cargo() == Cargo.GERENTE) {
//			bonificacao = salarioBase*0.08;
//		}
//		if(colaborador.cargo() == Cargo.ANALISTA) {
//			bonificacao = salarioBase*0.05;
//		}
//		if(colaborador.cargo() == Cargo.DESENVOLVEOR) {
//			bonificacao = salarioBase*0.001;
//		}
//		if(colaborador.cargo() == Cargo.CEO) {
//			bonificacao = salarioBase*0.10;
//		}
//		if(colaborador.cargo() == Cargo.ESTAGIARIO) {
//			bonificacao = salarioBase*0.00;
//		}

//		return bonificacao;

		/*
		 * Sem uso do Single REsposibility Principle
		 */
//		return switch (colaborador.cargo()) {
//		case GERENTE -> salarioBase * 0.08;
//		case ANALISTA -> salarioBase * 0.05;
//		case DESENVOLVEOR -> salarioBase * 0.01;
//		case CEO -> salarioBase * 0.1;
//		case ESTAGIARIO -> salarioBase * 0.0;
//		default -> throw new IllegalArgumentException("Cargo não reconhecido");
//		};

	}
}
