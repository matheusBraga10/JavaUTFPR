package utfpr.javaii.atividades.corridaDeMotocicletas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CorridaDeMotocicletas {

	static class Competidor {
		private final String nome;
		private int pontos;

		public Competidor(String nome) {
			this.nome = nome;
			this.pontos = 0;
		}

		public String getNome() {
			return nome;
		}

		public int getPontos() {
			return pontos;
		}

		public void adicionarPontos(int pontos) {
			this.pontos += pontos;
		}
		@Override
		public String toString() {
			return nome + " - " + pontos + " pontos";
		}
	}

	public static void main(String[] args) {
		List<Competidor> competidores = new ArrayList<>();
		int totalCorridas = 10;

		for (int i = 1; i <= 10; i++) {
			competidores.add(new Competidor("Competidor #" + i));
		}


		for (int corrida = 1; corrida <= totalCorridas; corrida++) {
			int pontos = 10;
			System.out.println("Processando corrida #" + corrida);

			List<Competidor> ordemChegada = Collections.synchronizedList(new ArrayList<>());
			List<Thread> threads = new ArrayList<>();

			for (Competidor c : competidores) {
				Thread t = new Thread(() -> {
					try {
						Thread.sleep((int) (Math.random() * 1000));
						ordemChegada.add(c); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
				threads.add(t);
				t.start();
			}
			for (Thread t : threads) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (Competidor c : ordemChegada) {
				c.adicionarPontos(pontos);
				pontos--;
			}
		}
		competidores.sort(Comparator.comparingInt(Competidor::getPontos).reversed());

		System.out.println("\n================= Podio =================\n");

		for (int i = 0; i < 3; i++) {
			Competidor c = competidores.get(i);
			System.out.println((i + 1) + " - " + c);
		}
		System.out.println("\n================= Tabela de Pontos =================\n");
		for (int i = 0; i < competidores.size(); i++) {
			Competidor c = competidores.get(i);
			System.out.println((i + 1) + " - " + c);
		}
	}
}
