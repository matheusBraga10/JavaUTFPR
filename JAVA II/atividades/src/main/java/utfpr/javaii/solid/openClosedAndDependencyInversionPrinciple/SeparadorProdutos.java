package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class SeparadorProdutos implements AcoesAposFaturamento{

	@Override
	public void executar(Venda venda) {

		System.out.println("Produto sendo separado.");
	}

}
