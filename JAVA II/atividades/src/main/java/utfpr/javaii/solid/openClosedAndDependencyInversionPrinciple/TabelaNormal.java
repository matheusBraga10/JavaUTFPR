package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class TabelaNormal implements TabelaDescontos{

	@Override
	public double calculaDesconto(Venda venda) {
		return venda.getTipoCliente().calcularDesconto(venda.getValorTotal());
	}

}
