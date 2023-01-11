package by.koroza.array.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.array.exception.ArrayException;
import by.koroza.array.validation.Validation;

public class Reader {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String INFO_FOUND_CORRECT_LINE = "Found correct line: ";
	private static final String INFO_NOT_FIND_CORRECT_LINE = "Correct line didn't find in file.";
	private static final String ERROR_FILE_NOT_FOUND = "File not found by path: ";
	private static final String REG_EX_SPACE = "\\s+";

	public String readLine(File file) throws ArrayException {
		String correctline = "";
		if (file.exists() == true) {
			try (Scanner scan = new Scanner(file)) {
				boolean flag = true;
				while ((scan.hasNextLine()) && (flag == true)) {
					String readedLine = scan.nextLine();
					String[] arrayReadedLineElements = readedLine.split(REG_EX_SPACE);
					if (Validation.validReadLines(arrayReadedLineElements) == true) {
						correctline = readedLine;
						flag = false;
					}
				}
				if (!correctline.equals("")) {
					LOGGER.log(Level.INFO, INFO_FOUND_CORRECT_LINE + correctline);
				} else {
					LOGGER.log(Level.WARN, INFO_NOT_FIND_CORRECT_LINE);
				}
			} catch (FileNotFoundException e) {
				LOGGER.log(Level.ERROR, ERROR_FILE_NOT_FOUND + file.getPath());
				throw new ArrayException(ERROR_FILE_NOT_FOUND);
			}
		} else {
			LOGGER.log(Level.ERROR, ERROR_FILE_NOT_FOUND + file.getPath());
			throw new ArrayException(ERROR_FILE_NOT_FOUND + file.getPath());
		}
		return correctline != "" ? correctline : null;
	}
}