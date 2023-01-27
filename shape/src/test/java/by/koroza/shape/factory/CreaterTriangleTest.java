package by.koroza.shape.factory;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;

public class CreaterTriangleTest {
	private CreaterTriangle creater;
	private List<String> listWithCorrectTriangle;
	private List<Triangle> listWithCorrectTriangleResult;
	private List<String> emptyList;
	private List<Triangle> emptyListResult;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		creater = new CreaterTriangle();
		listWithCorrectTriangle = new ArrayList<>();
		listWithCorrectTriangleResult = new ArrayList<>();
	}

	/**
	 * @throws CuctomException
	 */
	@DataProvider(name = "lists")
	public Object[][] dataLists() throws CuctomException {
		listWithCorrectTriangle.add("-1,-1 0,0 1,1");
		listWithCorrectTriangle.add("5,4.31 4.532,0 700.25,800.66");
		listWithCorrectTriangle.add("-2,-1 0,0 5,4");
		listWithCorrectTriangleResult.add(
				new Triangle.TriangleBuilder().setId(4).setPointA(new Point.PointBuilder().setX(5).setY(4.31).build())
						.setPointB(new Point.PointBuilder().setX(4.532).setY(0).build())
						.setPointC(new Point.PointBuilder().setX(700.25).setY(800.66).build()).build());
		listWithCorrectTriangleResult.add(
				new Triangle.TriangleBuilder().setId(5).setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
						.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
						.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build());
		emptyList = new ArrayList<>();
		emptyListResult = new ArrayList<>();
		return new Object[][] { { listWithCorrectTriangle, listWithCorrectTriangleResult },
				{ emptyList, emptyListResult } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.factory.CreaterTriangle#createTriangle(java.util.List)}.
	 * 
	 * @throws CuctomException
	 */
	@Test(dataProvider = "lists", description = "This method get List with lines of coordinates and checking this lines, if on this coordinate triangles exit - return List with triangles, if not - return empty List, if this method get null - return CuctomException.class")
	public void testCreateTriangle(List<String> coordinates, List<AbstractFigure> expected) throws CuctomException {
		List<Triangle> actual = creater.createTriangle(coordinates);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.factory.CreaterTriangle#createTriangle(java.util.List)}.
	 * 
	 * @throws CuctomException
	 */
	@Test(expectedExceptions = CuctomException.class, description = "This method get List with lines of coordinates and checking this lines, if on this coordinate triangles exit - return List with triangles, if not - return empty List, if this method get null - return CuctomException.class")
	public void testCreateTriangle() throws CuctomException {
		creater.createTriangle(null);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		creater = null;
		listWithCorrectTriangle = null;
		listWithCorrectTriangleResult = null;
		emptyList = null;
		emptyListResult = null;
	}
}