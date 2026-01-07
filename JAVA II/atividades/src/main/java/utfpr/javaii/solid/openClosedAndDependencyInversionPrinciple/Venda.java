package utfpr.javaii.solid.openClosedAndDependencyInversionPrinciple;

import java.util.Collections;
import java.util.List;

public class Venda {

	private final List<Item> itens;
	private double desconto;
	private String cliente;
	private TipoCliente tipoCliente;
	private String entregaEstado;
	private Double frete;

	public Venda(String cliente, TipoCliente tipoCliente, String entregaEstado, List<Item> itens) {
		this.cliente = cliente;
		this.tipoCliente = tipoCliente;
		this.entregaEstado = entregaEstado;
		this.itens = itens;
	}

	public double getValorTotal() {
		return this.itens.stream()
				.mapToDouble(Item::valor)
				.sum();
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getEntregaEstado() {
		return entregaEstado;
	}

	public void setEntregaEstado(String entregaEstado) {
		this.entregaEstado = entregaEstado;
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(this.itens);
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

}
