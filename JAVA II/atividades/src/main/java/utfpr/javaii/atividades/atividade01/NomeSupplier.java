package utfpr.javaii.atividades.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NomeSupplier {

	private String nome;
	
	static List<String> nomes = Arrays.asList("Ana", "João", "Maria"); 
	
	public NomeSupplier(String nome) {
		this.nome = nome;
	}

//	public static NomeSupplier getNomeFromSomewhere(String filter) {
//		if(filter.isBlank()) {
//			return null;
//		}
//		return new NomeSupplier(filter);
//	}

	public static Optional<NomeSupplier> getNomeFromSomewhere(String filter) {
		final var found = new NomeSupplier(filter);
		if(filter.isBlank()) {
			return Optional.empty();
		} else {
			return Optional.of(found);
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
	
	
}
