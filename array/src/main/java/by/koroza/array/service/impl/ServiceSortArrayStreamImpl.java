package by.koroza.array.service.impl;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.array.service.ServiceSortArrayStream;

public class ServiceSortArrayStreamImpl implements ServiceSortArrayStream {
	private static final Logger LOGGER = LogManager.getLogger(ServiceSortArrayStreamImpl.class);
	private static final String INFO_SORT_ARRAY = "Array sorted: ";

	public double[] sort(double[] array) {
		double[] sortedArray = Arrays.stream(array).sorted().toArray();
		LOGGER.log(Level.INFO, INFO_SORT_ARRAY + Arrays.toString(sortedArray));
		return sortedArray;
	}
}