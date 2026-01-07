package utfpr.javaii.solid.interfaceSegregationPrinciple;

import java.util.List;

public class Isp {

	public static void main(String[] args) {
		final Isp isp = new Isp();
		isp.executa();

	}

	private void executa() {

		final var analista = new Analista("José", "123", 1000);
		final var vendedor = new Vendedor("Manuel", "321", 1500);

		final List<Comissionavel> colaboradores = List.of(vendedor);

		colaboradores.forEach(colaborador -> System.out
				.printf("A comissão é de %s", colaborador.getComissao()).println());
	}
}
