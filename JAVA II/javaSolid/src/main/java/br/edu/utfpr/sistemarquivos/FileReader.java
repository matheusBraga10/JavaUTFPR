package br.edu.utfpr.sistemarquivos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/*
*	Aluno: Matheus Felipe Braga de Souza - UTFPR
*/

public class FileReader {

    public void read(Path path) throws IOException {
    	Files.readAllLines(path, StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
