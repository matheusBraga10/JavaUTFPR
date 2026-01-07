package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class TabelaPromocional implements TabelaDescontos {

	@Override
	public double calculaDesconto(Venda venda) {
		final var descontoNormal = venda.getTipoCliente().calcularDesconto(venda.getValorTotal());
		return descontoNormal*0.95;
	}

}
