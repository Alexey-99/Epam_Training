package by.koroza.shape.validation;

import by.koroza.shape.entity.Triangle;

public class Validator {
	private static final String REG_EX_CORRECT_FILE_PATH = "(\\w+\\/?)+\\.txt";
	private static final String REG_EX_CORRECT_COORDINATES = "((((\\d+|\\-\\d+)(\\.\\d+)?)\\,((\\d+|\\-\\d+)(\\.\\d+)?))\\s?){3}";

	public static boolean isCorrectPath(String lineCoordinates) {
		return lineCoordinates != null && !lineCoordinates.isBlank()
				&& lineCoordinates.matches(REG_EX_CORRECT_FILE_PATH);
	}

	public static boolean isCorrectCoordinates(String lineCoordinates) {
		return lineCoordinates != null && !lineCoordinates.isBlank()
				&& lineCoordinates.matches(REG_EX_CORRECT_COORDINATES);
	}

	public static boolean isExistTriangle(Triangle triangle) {
		return isInitAllPoints(triangle) == true ? (triangle.getSideAB() < triangle.getSideBC() + triangle.getSideCA())
				&& (triangle.getSideBC() < triangle.getSideCA() + triangle.getSideAB())
				&& (triangle.getSideCA() < triangle.getSideAB() + triangle.getSideBC()) : false;
	}

	public static boolean isInitAllPoints(Triangle triangle) {
		return (triangle != null) && (triangle.getPointA() != null) && (triangle.getPointB() != null)
				&& (triangle.getPointC() != null);
	}
}