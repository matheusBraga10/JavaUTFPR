package utfpr.javaii.atividades.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExemploConsumer {

	public static void main(String[] args) {
		
		Consumer<String> printer = message -> System.out.println(message); 
		printer.accept("Olá, mundo!"); // Imprime: Olá, mundo!
		System.out.println();
		List<String> nomes = Arrays.asList("Ana", "João", "Maria"); 
		nomes.forEach(name -> System.out.println("Nome: " + name));
		// Nome: Ana
		// Nome: João
		// Nome: Maria
		System.out.println();
		nomes.forEach(System.out::println);
		// Ana
		// João
		// Maria
		
		System.out.println();
		for(var name: nomes) {
			System.out.println(name);
		}
		// Ana
		// João
		// Maria
	}

}
