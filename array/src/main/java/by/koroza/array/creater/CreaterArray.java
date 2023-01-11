package by.koroza.array.creater;

import java.io.File;

import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;
import by.koroza.array.parser.Parser;
import by.koroza.array.reader.Reader;

public class CreaterArray {

	public CustomArray createrArrayFromFile(File file) throws ArrayException {
		CustomArray array = null;
		String line = new Reader().readLine(file);
		if (line != null) {
			double[] arrayNumbers = new Parser().parseLine(line);
			array = new CustomArray(arrayNumbers);
		} else {
			array = new CustomArray();
		}
		return array;
	}
}