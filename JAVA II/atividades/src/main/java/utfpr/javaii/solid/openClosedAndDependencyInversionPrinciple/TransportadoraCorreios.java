package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class TransportadoraCorreios implements Transportadora{

	@Override
	public double calcularFrete(Venda venda) {
		return venda.getEntregaEstado().equalsIgnoreCase("Parana") ? 25 : 50;

	}
}
