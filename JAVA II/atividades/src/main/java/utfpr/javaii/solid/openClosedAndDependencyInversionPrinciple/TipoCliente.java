package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public enum TipoCliente {

	PF {
		@Override
		public Double calcularDesconto(Double valorVenda) {
			return valorVenda* 0.10;
		}
	}	,
	PJ {
		@Override
		public Double calcularDesconto(Double valorVenda) {
			return valorVenda* 0.05;
		}
	};	

	public abstract Double calcularDesconto(Double valorVenda) ;
}
