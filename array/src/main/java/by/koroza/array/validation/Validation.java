package by.koroza.array.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {
	private static final Logger LOGGER = LogManager.getLogger(Validation.class);
	private static final String INFO_INCORRECT_LINE = "InCorrect line: ";
	private static final String STRING_SPACE = " ";
	private static final String REG_EX_CHECK_FOR_NUMBERS = "\\d+|(-\\d+)";
	private static final String REG_EX_SPACE = "\\s+";

	public static boolean validReadLines(String[] lines) {
		boolean result = true;
		if (lines.length > 0) {
			int index = 0;
			while ((index < lines.length) && (result == true)) {
				if (lines[index].matches(REG_EX_CHECK_FOR_NUMBERS) == false) {
					result = false;
					LOGGER.log(Level.INFO, INFO_INCORRECT_LINE + connectLines(lines));
				} else {
					index++;
				}
			}
		} else {
			result = false;
		}
		return result;
	}

	public static boolean validReadLinesStream(String line) {
		String[] lineElements = line.split(REG_EX_SPACE);
		return validReadLines(lineElements);
	}

	private static String connectLines(String[] lines) {
		StringBuilder builder = new StringBuilder();
		for (String line : lines) {
			builder.append(line).append(STRING_SPACE);
		}
		return builder.toString();
	}
}