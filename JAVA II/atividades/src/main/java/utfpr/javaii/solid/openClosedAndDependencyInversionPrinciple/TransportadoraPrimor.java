package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class TransportadoraPrimor implements Transportadora {
	
	@Override
	public double calcularFrete(Venda venda) {
		return venda.getEntregaEstado().equalsIgnoreCase("Parana") ? 10 : 20;
	}
}
