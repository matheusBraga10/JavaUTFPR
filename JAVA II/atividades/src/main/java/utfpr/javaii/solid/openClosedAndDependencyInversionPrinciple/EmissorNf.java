package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class EmissorNf implements AcoesAposFaturamento{

	
	@Override
	public void executar(Venda venda) {
			System.out.println("Emitindo NF.");
	}

}
