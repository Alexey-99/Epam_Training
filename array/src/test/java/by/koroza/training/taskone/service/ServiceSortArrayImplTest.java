package by.koroza.training.taskone.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;
import by.koroza.array.service.impl.ServiceSortArrayImpl;

public class ServiceSortArrayImplTest {
	private CustomArray array;
	private ServiceSortArrayImpl secrviceSortArray;

	/**
	 * @throws by.koroza.array.exception.ArrayException
	 */
	@BeforeClass
	public void setUp() throws ArrayException {
		this.array = new CustomArray(1, 9, 2, -1, 0, -5, 8);
		this.secrviceSortArray = new ServiceSortArrayImpl();
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceSortArrayImpl#bubbleSort(double[])}.
	 */
	@Test(description = "The method sorts array by bubble method")
	public void testBubbleSort() {
		double[] actualArray = this.secrviceSortArray.bubbleSort(this.array.getArray());
		double[] expectedArray = { -5, -1, 0, 1, 2, 8, 9 };
		assertEquals(actualArray, expectedArray);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceSortArrayImpl#selectSort(double[])}.
	 */
	@Test(description = "The method sorts array by select method")
	public void testSelectSort() {
		double[] actualArray = this.secrviceSortArray.selectSort(this.array.getArray());
		double[] expectedArray = { -5, -1, 0, 1, 2, 8, 9 };
		assertEquals(actualArray, expectedArray);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceSortArrayImpl#insertionSort(double[])}.
	 */
	@Test(description = "The method sorts array by insertion method")
	public void testInsertionSort() {
		double[] actualArray = this.secrviceSortArray.insertionSort(this.array.getArray());
		double[] expectedArray = { -5, -1, 0, 1, 2, 8, 9 };
		assertEquals(actualArray, expectedArray);
	}

	@AfterClass
	public void tearDown() {
		this.array = null;
		this.secrviceSortArray = null;
	}
}