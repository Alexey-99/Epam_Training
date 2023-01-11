package by.koroza.array.service.impl;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.array.service.ServiceArrayCalculation;
import by.koroza.array.service.ServiceArrayCount;
import by.koroza.array.service.ServiceArrayReplacement;
import by.koroza.array.service.ServiceArraySearch;

public class ServiceArrayStreamImpl
		implements ServiceArrayCalculation, ServiceArraySearch, ServiceArrayCount, ServiceArrayReplacement {
	private static final Logger LOGGER = LogManager.getLogger(ServiceArrayImpl.class);
	private static final String INFO_SUM_ELEMENTS = "Sum elements of array is ";
	private static final String INFO_MIDDLE_NUMBER = "Middle number of array is ";
	private static final String INFO_MAX_NUMBER = "Max number of array is ";
	private static final String INFO_MIN_NUMBER = "Min number of array is ";
	private static final String INFO_POSITIVE_NUMBERS = "Positive numbers of array is ";
	private static final String INFO_NEGATIVE_NUMBERS = "Negative numbers of array is ";
	private static final String INFO_COUNT_POSITIVE_NUMBERS = "The array has the following number of positive numbers: ";
	private static final String INFO_COUNT_NEGATIVE_NUMBERS = "The array has the following number of negative numbers: ";
	private static final String INFO_COUNT_EVEN_NUMBERS = "The array has the following number of even numbers: ";
	private static final String INFO_COUNT_ODD_NUMBERS = "The array has the following number of odd numbers: ";
	private static final String INFO_REPLACING_NEGATIVE_NUMBERS = "The array with replacing negative numbers: ";
	private static final String INFO_REPLACING_POSITIVE_NUMBERS = "The array with replacing positive numbers: ";
	private static final String INFO_REPLACING_EVEN_NUMBERS = "The array with replacing even numbers: ";
	private static final String INFO_REPLACING_ODD_NUMBERS = "The array with replacing odd numbers: ";
	private static final String INFO_REPLACING_SELECTED_NUMBER = "The array with replacing selected number: ";

	@Override
	public double sumElementsOfArray(double[] array) {
		double sum = Arrays.stream(array).sum();
		LOGGER.log(Level.INFO, INFO_SUM_ELEMENTS + sum);
		return sum;
	}

	@Override
	public double middleNumberOfArray(double[] array) {
		double middleNumber = Arrays.stream(array).sum() / array.length;
		LOGGER.log(Level.INFO, INFO_MIDDLE_NUMBER + middleNumber);
		return middleNumber;
	}

	@Override
	public double findMaxNumber(double[] array) {
		double max = Arrays.stream(array).max().getAsDouble();
		LOGGER.log(Level.INFO, INFO_MAX_NUMBER + max);
		return max;
	}

	@Override
	public double findMinNumber(double[] array) {
		double min = Arrays.stream(array).min().getAsDouble();
		LOGGER.log(Level.INFO, INFO_MIN_NUMBER + min);
		return min;
	}

	@Override
	public double[] findPositiveNumbersOfArray(double[] array) {
		double[] arrayPositiveNumbers = Arrays.stream(array).filter(x -> x >= 0).toArray();
		LOGGER.log(Level.INFO, INFO_POSITIVE_NUMBERS + Arrays.toString(arrayPositiveNumbers));
		return arrayPositiveNumbers;
	}

	@Override
	public double[] findNegativeNumbersOfArray(double[] array) {
		double[] arrayNegativeNumbers = Arrays.stream(array).filter(x -> x < 0).toArray();
		LOGGER.log(Level.INFO, INFO_NEGATIVE_NUMBERS + Arrays.toString(arrayNegativeNumbers));
		return arrayNegativeNumbers;
	}

	@Override
	public int countPositiveNumbers(double[] array) {
		int counter = (int) Arrays.stream(array).filter(x -> x >= 0).count();
		LOGGER.log(Level.INFO, INFO_COUNT_POSITIVE_NUMBERS + counter);
		return counter;
	}

	@Override
	public int countNegativeNumbers(double[] array) {
		int counter = (int) Arrays.stream(array).filter(x -> x < 0).count();
		LOGGER.log(Level.INFO, INFO_COUNT_NEGATIVE_NUMBERS + counter);
		return counter;
	}

	@Override
	public int countEvenNumbers(double[] array) {
		int counter = (int) Arrays.stream(array).filter(x -> x % 2 == 0).count();
		LOGGER.log(Level.INFO, INFO_COUNT_EVEN_NUMBERS + counter);
		return counter;
	}

	@Override
	public int countOddNumbers(double[] array) {
		int counter = (int) Arrays.stream(array).filter(x -> x % 2 != 0).count();
		LOGGER.log(Level.INFO, INFO_COUNT_ODD_NUMBERS + counter);
		return counter;
	}

	@Override
	public double[] replacingNegativeNumbersWith(double[] array, double insertedElement) {
		double[] arrayReplaced = Arrays.stream(array).map(x -> x < 0 ? insertedElement : x).toArray();
		LOGGER.log(Level.INFO, INFO_REPLACING_NEGATIVE_NUMBERS + Arrays.toString(arrayReplaced));
		return arrayReplaced;
	}

	@Override
	public double[] replacingPositiveNumbersWith(double[] array, double insertedElement) {
		double[] arrayReplaced = Arrays.stream(array).map(x -> x >= 0 ? insertedElement : x).toArray();
		LOGGER.log(Level.INFO, INFO_REPLACING_POSITIVE_NUMBERS + Arrays.toString(arrayReplaced));
		return arrayReplaced;
	}

	@Override
	public double[] replacingEvenNumbersWith(double[] array, double insertedElement) {
		double[] arrayReplaced = Arrays.stream(array).map(x -> x % 2 == 0 ? insertedElement : x).toArray();
		LOGGER.log(Level.INFO, INFO_REPLACING_EVEN_NUMBERS + Arrays.toString(arrayReplaced));
		return arrayReplaced;
	}

	@Override
	public double[] replacingOddNumbersWith(double[] array, double insertedElement) {
		double[] arrayReplaced = Arrays.stream(array).map(x -> x % 2 != 0 ? insertedElement : x).toArray();
		LOGGER.log(Level.INFO, INFO_REPLACING_ODD_NUMBERS + Arrays.toString(arrayReplaced));
		return arrayReplaced;
	}

	@Override
	public double[] replacingNumberWith(double[] array, double replacingElement, double insertedElement) {
		double[] arrayReplaced = Arrays.stream(array).map(x -> x == replacingElement ? insertedElement : x).toArray();
		LOGGER.log(Level.INFO, INFO_REPLACING_SELECTED_NUMBER + Arrays.toString(arrayReplaced));
		return arrayReplaced;
	}
}