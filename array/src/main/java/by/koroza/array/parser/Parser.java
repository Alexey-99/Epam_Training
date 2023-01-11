package by.koroza.array.parser;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String REG_EX_SPACE = "\\s+";
	private static final String INFO_FOUND_CORRECT_LINE = "Found correct line: ";
	private static final String INFO_ARRAY_DOUBLE_NUMBERS = ", array double numbers: ";

	public double[] parseLine(String line) {
		if (line != null) {
			String[] splitedLine = line.split(REG_EX_SPACE);
			double[] arrayNumbers = parseToDouble(splitedLine);
			LOGGER.log(Level.INFO,
					INFO_FOUND_CORRECT_LINE + line + INFO_ARRAY_DOUBLE_NUMBERS + Arrays.toString(arrayNumbers));
			return arrayNumbers;
		} else {
			return new double[0];
		}
	}

	private double[] parseToDouble(String[] lines) {
		double[] array = new double[lines.length];
		int indexArray = 0;
		for (String line : lines) {
			array[indexArray++] = Double.parseDouble(line);
		}
		return array;
	}
}