package by.koroza.array.entity;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.array.exception.ArrayException;

public class CustomArray {
	private static final String ERROR_ENTERED_INDEX = "Index must be > 0 and < than the total length of the array";
	private static final String ERROR_ARRAY_CREATION = "Array can't be null";
	private static final Logger LOGGER = LogManager.getLogger(CustomArray.class);

	private double[] array;

	public CustomArray() {
		this.array = new double[0];
	}

	public CustomArray(double... array) throws ArrayException {
		if (array != null) {
			this.array = array;
		} else {
			LOGGER.log(Level.ERROR, ERROR_ARRAY_CREATION);
			throw new ArrayException(ERROR_ARRAY_CREATION);
		}
	}

	public double[] getArray() {
		return this.array.clone();
	}

	public void setArray(double... array) throws ArrayException {
		if (array != null) {
			this.array = array;
		} else {
			LOGGER.log(Level.ERROR, ERROR_ARRAY_CREATION);
			throw new ArrayException(ERROR_ARRAY_CREATION);
		}
	}

	public double getElement(int index) throws ArrayException {
		if ((index >= 0) && (index < this.array.length)) {
			return this.array[index];
		} else {
			LOGGER.log(Level.ERROR, ERROR_ENTERED_INDEX);
			throw new ArrayException(ERROR_ENTERED_INDEX);
		}
	}

	public void setElement(double number, int index) throws ArrayException {
		if ((index >= 0) && (index < this.array.length)) {
			this.array[index] = number;
		} else {
			LOGGER.log(Level.ERROR, ERROR_ENTERED_INDEX);
			throw new ArrayException(ERROR_ENTERED_INDEX);
		}
	}

	public int length() {
		return this.array.length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + Arrays.hashCode(this.array);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!getClass().equals(object.getClass())) {
			return false;
		}
		CustomArray array = (CustomArray) object;
		return Arrays.equals(array.getArray(), this.array);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.array);
	}
}