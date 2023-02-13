package by.koroza.handling.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {

	public List<String> readTextFromFile(String path) {
		List<String> text = null;
		try {
			text = Files.lines(Path.of(path)).toList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}