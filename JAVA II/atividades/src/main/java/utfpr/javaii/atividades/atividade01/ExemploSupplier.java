package utfpr.javaii.atividades.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExemploSupplier {

	public static void main(String[] args) {
		
		List<String> nomes = Arrays.asList("Ana", "João", "Maria"); 
		nomes.forEach(name -> System.out.println("Nome: " + name));
		// Nome: Ana
		// Nome: João
		// Nome: Maria
		System.out.println();
//		final NomeSupplier nomeSupplier = NomeSupplier.getNomeFromSomewhere("Qualquer nome");
//		final NomeSupplier nomeSupplierNull = NomeSupplier.getNomeFromSomewhere("");
		final var nomeSupplier = NomeSupplier.getNomeFromSomewhere("Qualquer nome");
		final var nomeSupplierNull = NomeSupplier.getNomeFromSomewhere("");
		
//		final Supplier<NomeSupplier> supplier = () -> NomeSupplier.getNomes().get(0);
//		
//		if( nomeSupplier != null) {
//			System.out.println(nomeSupplier.getNome());
//		} if(nomeSupplierNull != null ) {
//			System.out.println(nomeSupplierNull.getNome());	
//		} if(nomeSupplierNull == null || nomeSupplier != null) {
//			System.out.println("Nenhum nome encontrado.");
//		}
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
