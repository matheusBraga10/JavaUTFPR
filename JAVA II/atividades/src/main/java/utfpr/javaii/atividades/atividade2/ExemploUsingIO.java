package utfpr.javaii.atividades.atividade2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExemploUsingIO {

	
	private static final String MY_FILE = "C:" + File.separator + "Users" + File.separator + "mathe" + File.separator +
											"Documents" +File.separator + "JAVA - UTFPR"+ File.separator + "JavaUTFPR" + File.separator +
											"JAVA II" + File.separator + "file-using-io.txt"; 
	// C:\Users\mathe\Documents\JAVA - UTFPR\JavaUTFPR\JAVA II
	// File.separator = / ou // ou \ ou \\ para passar parametros de separação para caminhos em todos os tipos de S.O.
	
	public ExemploUsingIO() {

		writeFile();
		readFile();
	}

	private void readFile() {
//		Usando Sintatic Sugar para reduzir a verbosidade do código
		
		try (final InputStream inputStream = new FileInputStream(MY_FILE)) {
			int content;
			while((content = inputStream.read()) != -1) {
				System.out.print((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void writeFile() {
//		Usando Sintatic Sugar para reduzir a verbosidade do código

		try (final OutputStream outputStream = new FileOutputStream(MY_FILE)){
			outputStream.write("Olá mundo IO.".getBytes("UTF-8"));
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		final File file = new File(MY_FILE);
//		boolean fileIsCreated = false;
		
//		try {
//			if(!file.exists()) {
//					fileIsCreated = file.createNewFile();
//			}
//			System.out.println(file.exists()); 
//			Verifica se o arquivo do caminho existe ou não
			
//			if(fileIsCreated || file.exists()) {
//				final OutputStream outputStream = new FileOutputStream(file);
//				outputStream = new FileOutputStream(MY_FILE);
//				outputStream.write("Olá mundo IO.".getBytes("UTF-8"));
//				outputStream.close();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		Caminho acima correto, porém mais verboso
		
	}

	public static void main(String[] args) {
		new ExemploUsingIO();
	}
}
