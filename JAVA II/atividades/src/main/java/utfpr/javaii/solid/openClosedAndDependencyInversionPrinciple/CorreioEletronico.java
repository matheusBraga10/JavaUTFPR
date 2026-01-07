package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

public class CorreioEletronico implements AcoesAposFaturamento{


	@Override
	public void executar(Venda venda) {
		System.out.println("Notificando Fornecedores....");
		
	}

}
