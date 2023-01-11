package by.koroza.array.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.array.exception.ArrayException;
import by.koroza.array.validation.Validation;

public class ReaderStream {
	private static final Logger LOGGER = LogManager.getLogger(ReaderStream.class);
	private static final String INFO_FOUND_CORRECT_LINE = "Found correct line: ";
	private static final String INFO_NOT_FOUND_CORRECT_LINE = "File doesn't have a correct line by file path: ";
	private static final String ERROR_FILE_NOT_FOUND = "File didn't find by path: ";

	public String readLine(File file) throws ArrayException, IOException {
		String correctLine = "";
		if (file.exists()) {
			Stream<String> readingLines = Files.lines(Paths.get(file.getPath()));
			correctLine = findCorrectLine(readingLines);
			if (correctLine != null) {
				LOGGER.log(Level.INFO, INFO_FOUND_CORRECT_LINE + correctLine);
			} else {
				LOGGER.log(Level.WARN, INFO_NOT_FOUND_CORRECT_LINE + file.getPath());
			}
			return correctLine;
		} else {
			LOGGER.log(Level.ERROR, ERROR_FILE_NOT_FOUND + file.getPath());
			throw new ArrayException(ERROR_FILE_NOT_FOUND + file.getPath());
		}
	}

	private String findCorrectLine(Stream<String> readingLines) {
		List<String> correctLine = readingLines.filter(line -> Validation.validReadLinesStream(line)).limit(1).toList();
		return (correctLine.size() > 0 ? correctLine.get(0) : null);
	}
}