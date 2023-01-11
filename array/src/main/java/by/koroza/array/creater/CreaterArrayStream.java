package by.koroza.array.creater;

import java.io.File;
import java.io.IOException;

import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;
import by.koroza.array.parser.ParserStream;
import by.koroza.array.reader.ReaderStream;

public class CreaterArrayStream {

	public CustomArray createrArrayFromFile(File file) throws ArrayException, IOException {
		CustomArray array = null;
		String line = new ReaderStream().readLine(file);
		if (line != null) {
			double[] arrayNumbers = new ParserStream().parseLine(line);
			array = new CustomArray(arrayNumbers);
		} else {
			array = new CustomArray();
		}
		return array;
	}
}