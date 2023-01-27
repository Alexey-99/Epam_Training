package by.koroza.shape.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.shape.exception.FileException;
import by.koroza.shape.validation.Validator;

public class Reader {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROW_ENTERED_INCORRECT_PATH = "You entered incorrect file path: ";
	private static final String ERROW_FILE_NOT_EXIST = "File with given path doesn't exist: path - ";
	private static final String WARN_FILE_BY_PATH = "Tht file by path '";
	private static final String WARN_NOT_HAVE_COORDINATE = "' don't have correct coordinates.";

	public List<String> getCorrectCoordinates(String path) throws FileException {
		List<String> coordinates = new ArrayList<>();
		if (Validator.isCorrectPath(path)) {
			if (Files.isReadable(Path.of(path))) {
				try {
					coordinates = Files.lines(Paths.get(path)).filter(line -> Validator.isCorrectCoordinates(line))
							.toList();
					if (coordinates.size() == 0) {
						LOGGER.log(Level.WARN, WARN_FILE_BY_PATH + path + WARN_NOT_HAVE_COORDINATE);
					}
				} catch (IOException e) {
					LOGGER.log(Level.ERROR, ERROW_ENTERED_INCORRECT_PATH + path);
					throw new FileException(ERROW_ENTERED_INCORRECT_PATH + path);
				}
			} else {
				LOGGER.log(Level.ERROR, ERROW_FILE_NOT_EXIST + path);
				throw new FileException(ERROW_FILE_NOT_EXIST + path);
			}
		} else {
			LOGGER.log(Level.ERROR, ERROW_ENTERED_INCORRECT_PATH + path);
			throw new FileException(ERROW_ENTERED_INCORRECT_PATH + path);
		}
		return coordinates;
	}
}