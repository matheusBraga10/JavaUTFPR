package utfpr.javaii.atividades.atividade2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class UsingNIO {

	private static final String MY_FILE = "C:" + File.separator + "Users" + File.separator + "mathe" + File.separator +
			"Documents" +File.separator + "JAVA - UTFPR"+ File.separator + "JavaUTFPR" + File.separator +
			"JAVA II" + File.separator + "file-using-nio.txt";

	public UsingNIO() {
		try {
			writeFile();
			System.out.println("--------------------------------------------------------");
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void readFile() throws IOException {
		final RandomAccessFile file = new RandomAccessFile (MY_FILE, "rw"); // "rw" representa o modo de escrita e leitura do arquivo
		final FileChannel fileChannel = file.getChannel();

		final long fileSize = fileChannel.size();
		final ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

		fileChannel.read(buffer);
		buffer.flip();

		for(int i = 0; i < fileSize; i++) {
			System.out.print((char) buffer.get());
		}

		fileChannel.close();
		file.close();
		
	}

	private void writeFile() throws IOException {

		final RandomAccessFile file = new RandomAccessFile (MY_FILE, "rw"); // "rw" representa o modo de escrita e leitura do arquivo
		final FileChannel fileChannel = file.getChannel();

		fileChannel.write(ByteBuffer.wrap("Ola mundo NIO".getBytes(StandardCharsets.UTF_8))); //escreve no arquivo criado 
		fileChannel.close();
		file.close();
		
		System.out.println("Dados gravados no arquivo.");

	}


	public static void main(String[] args) {
		new UsingNIO();
	}

}
