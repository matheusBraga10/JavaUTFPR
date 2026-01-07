package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

import java.util.List;

public final class Caixa {
	private final  List<AcoesAposFaturamento> acoesAposFaturamento;


	public Caixa(List<AcoesAposFaturamento> acoesAposFaturamento) {
		this.acoesAposFaturamento = acoesAposFaturamento;
	}







	public Venda faturar(Venda venda, Transportadora transportadora, TabelaDescontos tabelaDescontos) {

		venda.setFrete(transportadora.calcularFrete(venda));

		venda.setDesconto(tabelaDescontos.calculaDesconto(venda));

		System.out.println("Venda Faturada.");

		this.acoesAposFaturamento.forEach(acao -> acao.executar(venda));
		
		return venda;

	}
}
