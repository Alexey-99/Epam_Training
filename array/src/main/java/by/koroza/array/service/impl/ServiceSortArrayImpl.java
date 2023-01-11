package by.koroza.array.service.impl;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.array.service.ServiceSortArray;

public class ServiceSortArrayImpl implements ServiceSortArray {
	private final Logger LOGGER = LogManager.getLogger(ServiceSortArrayImpl.class);
	private static final String INFO_BUBBLE_SORT = "Array sorted by bubble method: ";
	private static final String INFO_SELECT_SORT = "Array sorted by select method: ";
	private static final String INFO_INSERTION_SORT = "Array sorted by insertion method: ";

	public double[] bubbleSort(double[] array) {
		double[] arrayClone = array.clone();
		for (int i = 0; i < arrayClone.length; i++) {
			for (int j = i; j < arrayClone.length; j++) {
				if (arrayClone[i] > arrayClone[j]) {
					transferElements(arrayClone, i, j);
				}
			}
		}
		LOGGER.log(Level.INFO, INFO_BUBBLE_SORT + Arrays.toString(arrayClone));
		return arrayClone;
	}

	public double[] selectSort(double[] array) {
		double[] arrayClone = array.clone();
		for (int i = 0; i < arrayClone.length; i++) {
			int indexMinElement = i;
			for (int j = i; j < arrayClone.length; j++) {
				if (arrayClone[indexMinElement] > arrayClone[j]) {
					indexMinElement = j;
				}
			}
			if (arrayClone[i] != arrayClone[indexMinElement]) {
				transferElements(arrayClone, i, indexMinElement);
			}
		}
		LOGGER.log(Level.INFO, INFO_SELECT_SORT + Arrays.toString(arrayClone));
		return arrayClone;
	}

	public double[] insertionSort(double[] array) {
		double[] arrayClone = array.clone();
		for (int i = 0; i < arrayClone.length; i++) {
			double value = arrayClone[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (value < arrayClone[j]) {
					arrayClone[j + 1] = arrayClone[j];
				} else {
					break;
				}
			}
			if (arrayClone[j + 1] != value) {
				arrayClone[j + 1] = value;
			}

		}
		LOGGER.log(Level.INFO, INFO_INSERTION_SORT + Arrays.toString(arrayClone));
		return arrayClone;
	}

	private void transferElements(double[] array, int indexI, int indexJ) {
		double buffer = array[indexI];
		array[indexI] = array[indexJ];
		array[indexJ] = buffer;
	}
}