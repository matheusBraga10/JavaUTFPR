package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

import java.util.List;

public class OcpDip {
	public static void main(String[] args) {
		final OcpDip ocpDip = new OcpDip();
		ocpDip.executa();
	}

	private void executa() {
		final List<Item> itens = List.of(new Item("CPU Razen 5600x", 1, 325), new Item("MB Asus TUF X570-Plus", 1, 165),
				new Item("Mem DDR4 HyperX Fury16GB", 2, 189), new Item("VGA GeForce RTX 3060Ti", 1, 499),
				new Item("SSD Samsung 980 Pro NVMe 500GB", 2, 100));
		final Venda venda = new Venda("Nerd", TipoCliente.PF, "Parana", itens);
		final List<AcoesAposFaturamento> acoesAposFaturamentos = List.of(new EmissorNf(), new CorreioEletronico(),
				new IntegraParaEstoque(), new SeparadorProdutos());
		final Caixa caixa = new Caixa(acoesAposFaturamentos);
		final Venda vendaFaturada2 = caixa.faturar(venda, new TransportadoraPrimor(), new TabelaPromocional());

		System.out.println("O desconto da venda é: " + vendaFaturada2.getDesconto());
		System.out.println("O frete da venda é: " + vendaFaturada2.getFrete());
	}
}
