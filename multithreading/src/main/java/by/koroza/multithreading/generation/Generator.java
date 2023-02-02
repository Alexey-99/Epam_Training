package by.koroza.multithreading.generation;

import java.util.Random;

public class Generator {

	public int generNumberPlacesHookahRoom(int min, int max) {
		int numberPlaces = 0;
		Random rand = new Random();
		do {
			numberPlaces = rand.nextInt(max) + min;
		} while ((numberPlaces < min) && (numberPlaces > max));
		return numberPlaces;
	}

}
