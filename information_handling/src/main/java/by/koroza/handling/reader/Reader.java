package by.koroza.handling.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import by.koroza.handling.exception.CustomException;

public class Reader {

	public String readTextFromFile(String path) throws CustomException {
		String text = "";
		List<String> textList = null;
		if (path != null) {
			if (Files.isReadable(Path.of(path))) {
				try {
					textList = Files.lines(Path.of(path)).toList();
				} catch (IOException e) {
					e.printStackTrace();
				}
				text = concatenationStrings(textList);
			} else {
				throw new CustomException("File doesn't readable by path: " + path);
			}
		} else {
			throw new CustomException("File path is " + path);
		}

		return text;
	}

	private String concatenationStrings(List<String> textList) {
		StringBuilder textBuilder = new StringBuilder();
		for (String lineText : textList) {
			textBuilder.append(lineText);
		}
		return textBuilder.toString();
	}
}