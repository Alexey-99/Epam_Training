/**
 * 
 */
package by.koroza.training.taskone.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;
import by.koroza.array.service.impl.ServiceArrayImpl;

public class ServiceArrayImplTest {
	private CustomArray array;
	private ServiceArrayImpl secrviceArray;
	private static final double INSERTED_ELEMENT = 100;
	private static final double REPLACING_ELEMENT = 0;

	/**
	 * @throws by.koroza.array.exception.ArrayException
	 */
	@BeforeClass
	public void setUp() throws ArrayException {
		this.array = new CustomArray(1, 9, 2, -1, 0, -5, 8);
		this.secrviceArray = new ServiceArrayImpl();
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#sumElementsOfArray(double[])}.
	 */
	@Test(description = "This method calculates sum elements of array and return sum elements in double type")
	public void testSumElementsOfArray() {
		double sumActual = secrviceArray.sumElementsOfArray(this.array.getArray());
		double sumExpected = 14;
		assertEquals(sumActual, sumExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#middleNumberOfArray(double[])}.
	 */
	@Test(description = "This method calculates middle number elements of array and return this number in double type")
	public void testMiddleNumberOfArray() {
		double numberActual = secrviceArray.middleNumberOfArray(this.array.getArray());
		double numberExpected = 2;
		assertEquals(numberActual, numberExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#findMaxNumber(double[])}.
	 */
	@Test(description = "This method find max number elements of array and return this number in double type")
	public void testFindMaxNumber() {
		double maxActual = secrviceArray.findMaxNumber(this.array.getArray());
		double maxExpected = 9;
		assertEquals(maxActual, maxExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#findMinNumber(double[])}.
	 */
	@Test(description = "This method find min number elements of array and return this number in double type")
	public void testFindMinNumber() {
		double minActual = secrviceArray.findMinNumber(this.array.getArray());
		double minExpected = -5;
		assertEquals(minActual, minExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#findPositiveNumbersOfArray(double[])}.
	 */
	@Test(description = "This method find positive numbers of elements array and return array with positive numbers in double type")
	public void testFindPositiveNumbersOfArray() {
		double[] positiveNumbersActual = secrviceArray.findPositiveNumbersOfArray(this.array.getArray());
		double[] positiveNumbersExpected = { 1, 9, 2, 0, 8 };
		assertEquals(positiveNumbersActual, positiveNumbersExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#findNegativeNumbersOfArray(double[])}.
	 */
	@Test(description = "This method find negative numbers of elements array and return array with negative numbers in double type")
	public void testFindNegativeNumbersOfArray() {
		double[] negativeNumbersActual = secrviceArray.findNegativeNumbersOfArray(this.array.getArray());
		double[] negativeNumbersExpected = { -1, -5 };
		assertEquals(negativeNumbersActual, negativeNumbersExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#countPositiveNumbers(double[])}.
	 */
	@Test(description = "This method count positive numbers of elements array and return amount of positive numbers in int type")
	public void testCountPositiveNumbers() {
		double countActual = secrviceArray.countPositiveNumbers(this.array.getArray());
		double countExpected = 5;
		assertEquals(countActual, countExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#countNegativeNumbers(double[])}.
	 */
	@Test(description = "This method count negative numbers of elements array and return amount of negative numbers in int type")
	public void testCountNegativeNumbers() {
		double countActual = secrviceArray.countNegativeNumbers(this.array.getArray());
		double countExpected = 2;
		assertEquals(countActual, countExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#countEvenNumbers(double[])}.
	 */
	@Test(description = "This method count even numbers of elements array and return amount of even numbers in int type")
	public void testCountEvenNumbers() {
		double countActual = secrviceArray.countEvenNumbers(this.array.getArray());
		double countExpected = 3;
		assertEquals(countActual, countExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#countOddNumbers(double[])}.
	 */
	@Test(description = "This method count odd numbers of elements array and return amount of odd numbers in int type")
	public void testCountOddNumbers() {
		double countActual = secrviceArray.countOddNumbers(this.array.getArray());
		double countExpected = 4;
		assertEquals(countActual, countExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#replacingNegativeNumbersWith(double[], double)}.
	 */
	@Test(description = "This method finds and replaces negative numbers of elements array with the selected element and return array with replaced numbers in double type")
	public void testReplacingNegativeNumbersWith() {
		double[] arrayWithInsertedElementActual = secrviceArray.replacingNegativeNumbersWith(this.array.getArray(),
				INSERTED_ELEMENT);
		double[] arrayWithInsertedElementExpected = { 1, 9, 2, INSERTED_ELEMENT, 0, INSERTED_ELEMENT, 8 };
		assertEquals(arrayWithInsertedElementActual, arrayWithInsertedElementExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#replacingPositiveNumbersWith(double[], double)}.
	 */
	@Test(description = "This method finds and replaces positive numbers of elements array with the selected element and return array with replaced numbers in double type")
	public void testReplacingPositiveNumbersWith() {
		double[] arrayWithInsertedElementActual = secrviceArray.replacingPositiveNumbersWith(this.array.getArray(),
				INSERTED_ELEMENT);
		double[] arrayWithInsertedElementExpected = { INSERTED_ELEMENT, INSERTED_ELEMENT, INSERTED_ELEMENT, -1,
				INSERTED_ELEMENT, -5, INSERTED_ELEMENT };
		assertEquals(arrayWithInsertedElementActual, arrayWithInsertedElementExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#replacingEvenNumbersWith(double[], double)}.
	 */
	@Test(description = "This method finds and replaces even numbers of elements array with the selected element and return array with replaced numbers in double type")
	public void testReplacingEvenNumbersWith() {
		double[] arrayWithInsertedElementActual = secrviceArray.replacingEvenNumbersWith(this.array.getArray(),
				INSERTED_ELEMENT);
		double[] arrayWithInsertedElementExpected = { 1, 9, INSERTED_ELEMENT, -1, INSERTED_ELEMENT, -5,
				INSERTED_ELEMENT };
		assertEquals(arrayWithInsertedElementActual, arrayWithInsertedElementExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#replacingOddNumbersWith(double[], double)}.
	 */
	@Test(description = "This method finds and replaces odd numbers of elements array with the selected element and return array with replaced numbers in double type")
	public void testReplacingOddNumbersWith() {
		double[] arrayWithInsertedElementActual = secrviceArray.replacingOddNumbersWith(this.array.getArray(),
				INSERTED_ELEMENT);
		double[] arrayWithInsertedElementExpected = { INSERTED_ELEMENT, INSERTED_ELEMENT, 2, INSERTED_ELEMENT, 0,
				INSERTED_ELEMENT, 8 };
		assertEquals(arrayWithInsertedElementActual, arrayWithInsertedElementExpected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceArrayImpl#replacingNumberWith(double[], double, double)}.
	 */
	@Test(description = "This method finds and replaces selected number of elements array with the selected element and return array with replaced numbers in double type")
	public void testReplacingNumberWith() {
		double[] arrayWithInsertedElementActual = secrviceArray.replacingNumberWith(this.array.getArray(),
				REPLACING_ELEMENT, INSERTED_ELEMENT);
		double[] arrayWithInsertedElementExpected = { 1, 9, 2, -1, INSERTED_ELEMENT, -5, 8 };
		assertEquals(arrayWithInsertedElementActual, arrayWithInsertedElementExpected);
	}

	@AfterClass
	public void tearDown() {
		array = null;
		secrviceArray = null;
	}
}