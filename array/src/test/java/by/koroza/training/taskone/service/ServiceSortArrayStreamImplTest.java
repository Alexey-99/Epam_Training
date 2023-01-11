package by.koroza.training.taskone.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;
import by.koroza.array.service.impl.ServiceSortArrayStreamImpl;

public class ServiceSortArrayStreamImplTest {
	private CustomArray array;
	private ServiceSortArrayStreamImpl secrviceSortArrayStream;

	@BeforeClass
	public void setUp() throws ArrayException {
		this.array = new CustomArray(1, 9, 2, -1, 0, -5, 8);
		this.secrviceSortArrayStream = new ServiceSortArrayStreamImpl();
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.service.impl.ServiceSortArrayStreamImpl#sort(double[])}.
	 */
	@Test(description = "The method sorts the array in ascending order")
	public void testSort() {
		double[] actualArray = this.secrviceSortArrayStream.sort(this.array.getArray());
		double[] expectedArray = { -5, -1, 0, 1, 2, 8, 9 };
		assertEquals(actualArray, expectedArray);
	}

	@AfterClass
	public void tearDown() {
		this.array = null;
		this.secrviceSortArrayStream = null;
	}
}