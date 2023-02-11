package by.koroza.multithreading.generation;

import java.util.Random;

public class Generator {

	public int generNumber(int min, int max) {
		int number = 0;
		Random rand = new Random();
		do {
			number = rand.nextInt(max) + min;
		} while ((number < min) && (number > max));
		return number;
	}
}