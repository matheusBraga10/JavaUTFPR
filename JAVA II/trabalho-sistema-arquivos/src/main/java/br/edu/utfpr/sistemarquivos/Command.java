package br.edu.utfpr.sistemarquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
*	Aluno: Matheus Felipe Braga de Souza - UTFPR
*/ 

public enum Command {

	LIST() {
		@Override
		boolean accept(String command) {
			final var commands = command.split(" ");
			return commands.length > 0 && commands[0].startsWith("LIST") || commands[0].startsWith("list");
		}

		@Override
		Path execute(Path path) throws IOException {

			try (Stream<Path> stream = Files.list(path)) {
				stream.map(Path::getFileName)
				.forEach(System.out::println);
			} 

			return path;
		}
	},
	SHOW() {
		private String[] parameters = new String[]{};

		@Override
		void setParameters(String[] parameters) {
			this.parameters = parameters;
		}

		@Override
		boolean accept(String command) {
			final var commands = command.split(" ");
			return commands.length > 0 && commands[0].startsWith("SHOW") || commands[0].startsWith("show");
		}

		@Override
		Path execute(Path path) throws IOException {
			if (this.parameters == null || this.parameters.length <= 1 || this.parameters[1] == null || this.parameters[1].isBlank()) {
				throw new UnsupportedOperationException("invalid command.");
			}
			String param = this.parameters[1];
			path = path.resolve(param);
			FileReader fileReader = new FileReader();
			
			if(Files.isDirectory(path)) {
				throw new UnsupportedOperationException("This command should be used with files only.");
			}
			if(!path.getFileName().toString().contains(".txt")) {
				throw new UnsupportedOperationException("Extension is not supported.");
			}
			try {
				fileReader.read(path);
			} catch (IOException e) {
						e.printStackTrace();
			}

			return path;
		}
	},
	BACK() {
		@Override
		boolean accept(String command) {
			final var commands = command.split(" ");
			return commands.length > 0 && commands[0].startsWith("BACK") || commands[0].startsWith("back");
		}

		@Override
		Path execute(Path path) throws IOException {
			if(!path.endsWith("hd")) {
				path = Path.of(path.getParent().toUri());
			}
			return path;
		}
	},
	OPEN() {
		private String[] parameters = new String[]{};

		@Override
		void setParameters(String[] parameters) {
			this.parameters = parameters;
		}

		@Override
		boolean accept(String command) {
			final var commands = command.split(" ");
			return commands.length > 0 && commands[0].startsWith("OPEN") || commands[0].startsWith("open");
		}

		@Override
		Path execute(Path path) {
			if (this.parameters == null || this.parameters.length <= 1 || this.parameters[1] == null || this.parameters[1].isBlank()) {
				throw new UnsupportedOperationException("invalid command.");
			}
			String param = this.parameters[1];
			path = Path.of(path.toAbsolutePath().toString(), param);
			return path;
		}
	},
	DETAIL() {
		private String[] parameters = new String[]{};

		@Override
		void setParameters(String[] parameters) {
			this.parameters = parameters;
		}

		@Override
		boolean accept(String command) {
			final var commands = command.split(" ");
			return commands.length > 0 && commands[0].startsWith("DETAIL") || commands[0].startsWith("detail");
		}

		@Override
		Path execute(Path path) throws IOException {
			if (this.parameters == null || this.parameters.length <= 1 || this.parameters[1] == null || this.parameters[1].isBlank()) {
				throw new UnsupportedOperationException("invalid command.");
			}
			Map<String, Object> details = new HashMap<>();
			String param = this.parameters[1];
			path = path.resolve(param);

			BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
			LocalDateTime created = attrs.creationTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime lastAccess = attrs.lastAccessTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


			details.put("Is directory", Files.isDirectory(path));
			details.put("Size", attrs.size());
			details.put("Created on", created);
			details.put("Last access time", lastAccess);

			for (Map.Entry<String, Object> entry : details.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			return path;
		}
	},
	EXIT() {
		@Override
		boolean accept(String command) {
			final var commands = command.split(" ");
			return commands.length > 0 && commands[0].startsWith("EXIT") || commands[0].startsWith("exit");
		}

		@Override
		Path execute(Path path) {
			System.out.print("Saindo...");
			return path;
		}

		@Override
		boolean shouldStop() {
			return true;
		}
	};

	abstract Path execute(Path path) throws IOException;

	abstract boolean accept(String command);

	void setParameters(String[] parameters) {
	}

	boolean shouldStop() {
		return false;
	}

	public static Command parseCommand(String commandToParse) {

		if (commandToParse.isBlank()) {
			throw new UnsupportedOperationException("Type something...");
		}

		final var possibleCommands = values();

		for (Command possibleCommand : possibleCommands) {
			if (possibleCommand.accept(commandToParse)) {
				possibleCommand.setParameters(commandToParse.split(" "));
				return possibleCommand;
			}
		}

		throw new UnsupportedOperationException("Can't parse command [%s]".formatted(commandToParse));
	}
}
