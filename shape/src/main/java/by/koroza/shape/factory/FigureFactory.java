package by.koroza.shape.factory;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;
import by.koroza.shape.exception.FileException;
import by.koroza.shape.reader.Reader;

public class FigureFactory {
	private static final String ERROR_CAN_NOT_CREATE_FIGURE = "Factory can't create this figure: ";
	private static final Logger LOGGER = LogManager.getLogger();

	public List<? extends AbstractFigure> createFiguresFromFile(String nameFigure, String path)
			throws FileException, CuctomException {
		List<? extends AbstractFigure> figures = null;
		if (nameFigure != null) {
			switch (nameFigure != null ? nameFigure.toLowerCase() : nameFigure) {
			case "triangle" -> figures = triangleFactory(path);
			default -> {
				LOGGER.log(Level.ERROR, ERROR_CAN_NOT_CREATE_FIGURE + nameFigure);
				throw new CuctomException(ERROR_CAN_NOT_CREATE_FIGURE + nameFigure);
			}
			}
		} else {
			LOGGER.log(Level.ERROR, ERROR_CAN_NOT_CREATE_FIGURE + nameFigure);
			throw new CuctomException(ERROR_CAN_NOT_CREATE_FIGURE + nameFigure);
		}
		return figures;
	}

	private List<Triangle> triangleFactory(String path) throws FileException, CuctomException {
		List<String> coordinates = new Reader().getCorrectCoordinates(path);
		List<Triangle> triangles = new CreaterTriangle().createTriangle(coordinates);
		return triangles;
	}
}