package utfpr.javaii.solid.liskovSubstitutionPrinciple;

public class ContaPremium implements ManipuladorDeSaldo {

	private int saldo;

	@Override
	public void depositar(int valor) {
		this.saldo += valor;

	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;

	}

	@Override
	public void render() {
		this.saldo += this.saldo * 0.10;

	}

	@Override
	public double getSaldo() {
		return saldo;
	}

}
