/**
 * 
 */
package by.koroza.shape.repository;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.shape.comparator.SortComparator;
import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;
import by.koroza.shape.repository.specifications.IdSpecification;
import by.koroza.shape.repository.specifications.TriangleClassSpecification;
import by.koroza.shape.repository.specifications.area.BetweenMinMaxAreaSpecification;
import by.koroza.shape.repository.specifications.area.MaxAreaSpecification;
import by.koroza.shape.repository.specifications.area.MinAreaSpecification;
import by.koroza.shape.repository.specifications.perimeter.BetweenMinMaxPerimeterSpecification;
import by.koroza.shape.repository.specifications.perimeter.MaxPerimeterSpecification;
import by.koroza.shape.repository.specifications.perimeter.MinPerimeterSpecification;
import by.koroza.shape.repository.specifications.square.FirstSquareSpecification;
import by.koroza.shape.repository.specifications.square.FourthSquareSpecification;
import by.koroza.shape.repository.specifications.square.SecondSquareSpecification;
import by.koroza.shape.repository.specifications.square.ThirdSquareSpecification;

public class FigureRepositoryTest {
	private FigureRepository repository;
	private List<AbstractFigure> spTrianglesID;
	private List<AbstractFigure> spTrianglesTriangleClass;
	private List<AbstractFigure> spTrianglesBetweenMinMaxArea;
	private List<AbstractFigure> spTrianglesMaxArea;
	private List<AbstractFigure> spTrianglesMinArea;
	private List<AbstractFigure> spTrianglesBetweenMinMaxPerimeter;
	private List<AbstractFigure> spTrianglesMaxPerimeter;
	private List<AbstractFigure> spTrianglesMinPerimeter;
	private List<AbstractFigure> spTrianglesFirstSquare;
	private List<AbstractFigure> spTrianglesSecondSquare;
	private List<AbstractFigure> spTrianglesThirdSquare;
	private List<AbstractFigure> spTrianglesFourthSquare;
	private List<AbstractFigure> sortTrianglesId;
	private List<AbstractFigure> sortTrianglesFirstX;
	private List<AbstractFigure> sortTrianglesFirstY;
	private List<AbstractFigure> sortTrianglesArea;
	private List<AbstractFigure> sortTrianglesPerimeter;

	/**
	 * @throws CuctomException
	 */
	@BeforeClass
	public void setUpBeforeClass() throws CuctomException {
		repository = new FigureRepository();
		repository.add(new Triangle.TriangleBuilder().setPointA(new Point.PointBuilder().setX(5).setY(4.31).build())
				.setPointB(new Point.PointBuilder().setX(4.532).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(700.25).setY(800.66).build()).build());
		repository.add(new Triangle.TriangleBuilder().setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build());
		repository.add(new Triangle.TriangleBuilder().setPointA(new Point.PointBuilder().setX(0).setY(-6).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(5.7).build())
				.setPointC(new Point.PointBuilder().setX(7.6446).setY(8.761).build()).build());
		repository.add(new Triangle.TriangleBuilder().setPointA(new Point.PointBuilder().setX(1.732).setY(0).build())
				.setPointB(new Point.PointBuilder().setX(3).setY(8.56).build())
				.setPointC(new Point.PointBuilder().setX(10.564).setY(9.61561).build()).build());
		repository.add(new Triangle.TriangleBuilder().setPointA(new Point.PointBuilder().setX(0).setY(2).build())
				.setPointB(new Point.PointBuilder().setX(1).setY(3).build())
				.setPointC(new Point.PointBuilder().setX(100.0).setY(95.0).build()).build());
	}

	/**
	 * @throws CuctomException
	 */
	@DataProvider(name = "providerSpecifications")
	public Object[][] providerSpecifications() throws CuctomException {
		spTrianglesID = new ArrayList<>();
		spTrianglesID.add(repository.get(0));

		spTrianglesTriangleClass = new ArrayList<>();
		spTrianglesTriangleClass.add(repository.get(0));
		spTrianglesTriangleClass.add(repository.get(1));
		spTrianglesTriangleClass.add(repository.get(2));
		spTrianglesTriangleClass.add(repository.get(3));
		spTrianglesTriangleClass.add(repository.get(4));

		spTrianglesBetweenMinMaxArea = new ArrayList<>();
		spTrianglesBetweenMinMaxArea.add(repository.get(2));
		spTrianglesBetweenMinMaxArea.add(repository.get(3));
		spTrianglesBetweenMinMaxArea.add(repository.get(4));

		spTrianglesMaxArea = new ArrayList<>();
		spTrianglesMaxArea.add(repository.get(1));
		spTrianglesMaxArea.add(repository.get(3));
		spTrianglesMaxArea.add(repository.get(4));

		spTrianglesMinArea = new ArrayList<>();
		spTrianglesMinArea.add(repository.get(0));
		spTrianglesMinArea.add(repository.get(2));
		spTrianglesMinArea.add(repository.get(3));

		spTrianglesBetweenMinMaxPerimeter = new ArrayList<>();
		spTrianglesBetweenMinMaxPerimeter.add(repository.get(1));
		spTrianglesBetweenMinMaxPerimeter.add(repository.get(2));
		spTrianglesBetweenMinMaxPerimeter.add(repository.get(3));

		spTrianglesMaxPerimeter = new ArrayList<>();
		spTrianglesMaxPerimeter.add(repository.get(1));
		spTrianglesMaxPerimeter.add(repository.get(2));
		spTrianglesMaxPerimeter.add(repository.get(3));
		spTrianglesMaxPerimeter.add(repository.get(4));

		spTrianglesMinPerimeter = new ArrayList<>();
		spTrianglesMinPerimeter.add(repository.get(0));
		spTrianglesMinPerimeter.add(repository.get(2));
		spTrianglesMinPerimeter.add(repository.get(3));
		spTrianglesMinPerimeter.add(repository.get(4));

		spTrianglesFirstSquare = new ArrayList<>();
		spTrianglesFirstSquare.add(repository.get(0));
		spTrianglesFirstSquare.add(repository.get(3));
		spTrianglesFirstSquare.add(repository.get(4));

		spTrianglesSecondSquare = new ArrayList<>();

		spTrianglesThirdSquare = new ArrayList<>();

		spTrianglesFourthSquare = new ArrayList<>();

		return new Object[][] { { new IdSpecification(1), spTrianglesID },
				{ new TriangleClassSpecification(), spTrianglesTriangleClass },
				{ new BetweenMinMaxAreaSpecification(3, 50), spTrianglesBetweenMinMaxArea },
				{ new MaxAreaSpecification(40), spTrianglesMaxArea },
				{ new MinAreaSpecification(30), spTrianglesMinArea },
				{ new BetweenMinMaxPerimeterSpecification(10, 40), spTrianglesBetweenMinMaxPerimeter },
				{ new MaxPerimeterSpecification(300), spTrianglesMaxPerimeter },
				{ new MinPerimeterSpecification(20), spTrianglesMinPerimeter },
				{ new FirstSquareSpecification(), spTrianglesFirstSquare },
				{ new SecondSquareSpecification(), spTrianglesSecondSquare },
				{ new ThirdSquareSpecification(), spTrianglesThirdSquare },
				{ new FourthSquareSpecification(), spTrianglesFourthSquare } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.repository.FigureRepository#query(by.koroza.shape.repository.TriangleSpecification)}.
	 */
	@Test(dataProvider = "providerSpecifications", description = "This method filters objects by condition")
	public void testQuery(TriangleSpecification specification, List<? extends AbstractFigure> expected) {
		List<? extends AbstractFigure> actual = repository.query(specification);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.repository.FigureRepository#queryStream(by.koroza.shape.repository.TriangleSpecification)}.
	 */
	@Test(dataProvider = "providerSpecifications", description = "This method filters objects by condition")
	public void testQueryStream(TriangleSpecification specification, List<? extends AbstractFigure> expected) {
		List<? extends AbstractFigure> actual = repository.query(specification);
		assertEquals(actual, expected);
	}

	/**
	 * @throws CuctomException
	 */
	@DataProvider(name = "prividerComparators")
	public Object[][] prividerComparators() throws CuctomException {
		sortTrianglesId = new ArrayList<>();
		sortTrianglesId.add(repository.get(0));
		sortTrianglesId.add(repository.get(1));
		sortTrianglesId.add(repository.get(2));
		sortTrianglesId.add(repository.get(3));
		sortTrianglesId.add(repository.get(4));

		sortTrianglesFirstX = new ArrayList<>();
		sortTrianglesFirstX.add(repository.get(1));
		sortTrianglesFirstX.add(repository.get(2));
		sortTrianglesFirstX.add(repository.get(4));
		sortTrianglesFirstX.add(repository.get(3));
		sortTrianglesFirstX.add(repository.get(0));

		sortTrianglesFirstY = new ArrayList<>();
		sortTrianglesFirstY.add(repository.get(2));
		sortTrianglesFirstY.add(repository.get(1));
		sortTrianglesFirstY.add(repository.get(3));
		sortTrianglesFirstY.add(repository.get(4));
		sortTrianglesFirstY.add(repository.get(0));

		sortTrianglesArea = new ArrayList<>();
		sortTrianglesArea.add(repository.get(1));
		sortTrianglesArea.add(repository.get(4));
		sortTrianglesArea.add(repository.get(3));
		sortTrianglesArea.add(repository.get(2));
		sortTrianglesArea.add(repository.get(0));

		sortTrianglesPerimeter = new ArrayList<>();
		sortTrianglesPerimeter.add(repository.get(1));
		sortTrianglesPerimeter.add(repository.get(3));
		sortTrianglesPerimeter.add(repository.get(2));
		sortTrianglesPerimeter.add(repository.get(4));
		sortTrianglesPerimeter.add(repository.get(0));

		return new Object[][] { { SortComparator.ID.getComparator(), sortTrianglesId },
				{ SortComparator.FIRST_X.getComparator(), sortTrianglesFirstX },
				{ SortComparator.FIRST_Y.getComparator(), sortTrianglesFirstY },
				{ SortComparator.AREA.getComparator(), sortTrianglesArea },
				{ SortComparator.PERIMETER.getComparator(), sortTrianglesPerimeter } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.repository.FigureRepository#sortCopy(java.util.Comparator)}.
	 */
	@Test(dataProvider = "prividerComparators", description = "This method sorts objects by condition")
	public void testSortCopy(Comparator<AbstractFigure> comparator, List<AbstractFigure> expected) {
		List<? extends AbstractFigure> actual = repository.sortCopy(comparator);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.repository.FigureRepository#sort(java.util.Comparator)}.
	 */
	@Test(dataProvider = "prividerComparators", description = "This method sorts objects by condition")
	public void testSort(Comparator<AbstractFigure> comparator, List<AbstractFigure> expected) {
		repository.sort(comparator);
		assertEquals(FigureRepository.getFigures(), expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		repository = null;
		spTrianglesID = null;
		spTrianglesTriangleClass = null;
		spTrianglesBetweenMinMaxArea = null;
		spTrianglesMaxArea = null;
		spTrianglesMinArea = null;
		spTrianglesBetweenMinMaxPerimeter = null;
		spTrianglesMaxPerimeter = null;
		spTrianglesMinPerimeter = null;
		spTrianglesFirstSquare = null;
		spTrianglesSecondSquare = null;
		spTrianglesThirdSquare = null;
		spTrianglesFourthSquare = null;
		sortTrianglesId = null;
		sortTrianglesFirstX = null;
		sortTrianglesFirstY = null;
		sortTrianglesArea = null;
		sortTrianglesPerimeter = null;
	}
}