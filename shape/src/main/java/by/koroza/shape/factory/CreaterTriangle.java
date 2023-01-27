package by.koroza.shape.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;
import by.koroza.shape.validation.Validator;

public class CreaterTriangle {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String WARN_NOT_EXIST_TRIANGLE__FIRST_PART = "The triangle with these coordinates doesn't exist.";
	private static final String WARN_NOT_EXIST_TRIANGLE__SECOND_PART = " doesn't exist.";
	private static final String ERROR_PARAMETER_NULL = "The passed parameter is null";

	public List<Triangle> createTriangle(List<String> coordinates) throws CuctomException {
		List<Triangle> triangles = new ArrayList<>();
		if (coordinates != null) {
			if (coordinates.size() > 0) {
				List<String[]> linesCoordinates = coordinates.stream().map(line -> line.split("\s")).toList();
				for (int i = 0; i < linesCoordinates.size(); i++) {
					Triangle triangle = new Triangle();
					List<double[]> coordinatesDouble = Arrays.stream(linesCoordinates.get(i)).map(coordinate -> Arrays
							.stream(coordinate.split(",")).mapToDouble(x -> Double.parseDouble(x)).toArray()).toList();
					for (int j = 0; j < coordinatesDouble.size(); j++) {
						try {
							switch (j) {
							case 0 -> triangle.setPointA(new Point.PointBuilder().setX(coordinatesDouble.get(j)[0])
									.setY(coordinatesDouble.get(j)[1]).build());
							case 1 -> triangle.setPointB(new Point.PointBuilder().setX(coordinatesDouble.get(j)[0])
									.setY(coordinatesDouble.get(j)[1]).build());
							case 2 -> triangle.setPointC(new Point.PointBuilder().setX(coordinatesDouble.get(j)[0])
									.setY(coordinatesDouble.get(j)[1]).build());
							}
						} catch (CuctomException e) {
							LOGGER.log(Level.WARN, WARN_NOT_EXIST_TRIANGLE__FIRST_PART
									+ Arrays.toString(triangle.getPoints()) + WARN_NOT_EXIST_TRIANGLE__SECOND_PART);
						}
					}
					if (Validator.isExistTriangle(triangle)) {
						triangles.add(triangle);
					} else {
						LOGGER.log(Level.WARN, WARN_NOT_EXIST_TRIANGLE__FIRST_PART
								+ Arrays.toString(triangle.getPoints()) + WARN_NOT_EXIST_TRIANGLE__SECOND_PART);
					}
				}
			}
		} else {
			LOGGER.log(Level.ERROR, ERROR_PARAMETER_NULL);
			throw new CuctomException(ERROR_PARAMETER_NULL);
		}
		return triangles;
	}
}