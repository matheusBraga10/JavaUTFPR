package utfpr.javaii.solid.liskovSubstitutionPrinciple;

public interface ManipuladorDeSaldo {

	void depositar(int valor);

	void sacar(double valor);

	void render();

	double getSaldo();

}
