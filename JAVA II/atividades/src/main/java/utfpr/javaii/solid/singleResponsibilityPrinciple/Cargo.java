package utfpr.javaii.solid.singleResponsibilityPrinciple;

public enum Cargo {

	/*
	 * Sem uso de Single Responsibility Principle
	 */
//	GERENTE, ANALISTA, DESENVOLVEOR, CEO, ESTAGIARIO

	/*
	 * Com uso de Single Responsibility Principle
	 */
	GERENTE {
		@Override
		public double calculaBonificacao(double salarioBase) {
			return salarioBase * 0.08;
		}
		
	}, 
	
	ANALISTA {
		@Override
		public double calculaBonificacao(double salarioBase) {
			return salarioBase * 0.05;
		}
		
	}, 
	
	DESENVOLVEOR {
		@Override
		public double calculaBonificacao(double salarioBase) {
			return salarioBase * 0.01;
		}
		
	}, 
	
	CEO{

		@Override
		public double calculaBonificacao(double salarioBase) {
			return salarioBase * 0.1;
		}
		
	}, 
	
	ESTAGIARIO,
	APRENDIZ;

	
	public double  calculaBonificacao(double salarioBase) {
		return 0;
	}
}
