package by.koroza.shape.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractFigure {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Warehouse WAREHOUSE = Warehouse.getInstance();
	private static int count = 1;
	private int id;
	private static final String STRING_ID = "ID: ";

	public AbstractFigure() {
		LOGGER.log(Level.DEBUG, "The constructor of the AbstractFigure class object has opened.");
		this.id = count++;
		LOGGER.log(Level.DEBUG, "Initializing the ID field to " + this.id);
		WAREHOUSE.add(this.id, new Analytics());
		LOGGER.log(Level.DEBUG,
				"Adding a shape to a class Warehouse with parameter ID and new Object class Analytics.");
		LOGGER.log(Level.DEBUG, "The constructor of the AbstractFigure class object has closed.");
	}

	public static int getCount() {
		LOGGER.log(Level.DEBUG, "The method getCount() opened/closed");
		return count;
	}

	public int getId() {
		LOGGER.log(Level.DEBUG, "The method getId() opened/closed");
		return id;
	}

	public void setId(int id) {
		LOGGER.log(Level.DEBUG, "The method setId() opened.");
		Analytics analytics = getAnalytics();
		LOGGER.log(Level.DEBUG, "Getting object Analitics class of object AbstractFigure class");
		WAREHOUSE.remove(id);
		LOGGER.log(Level.DEBUG, "Remove object AbstractFigure class from WAREHOUSE with ID " + this.id);
		this.id = id;
		LOGGER.log(Level.DEBUG, "Initializing the ID field to " + this.id);
		WAREHOUSE.add(this.id, analytics);
		LOGGER.log(Level.DEBUG, "Add object Abstract class to WAREHOUSE with ID " + this.id);
		LOGGER.log(Level.DEBUG, "The method setId() closed.");
	}

	public static Warehouse getWarehouse() {
		LOGGER.log(Level.DEBUG, "The method getWarehouse() opened/closed");
		return WAREHOUSE;
	}

	public Analytics getAnalytics() {
		LOGGER.log(Level.DEBUG, "The method getAnalytics() opened/closed");
		return WAREHOUSE.get(this.id);
	}

	public abstract Point[] getPoints();

	@Override
	public int hashCode() {
		LOGGER.log(Level.DEBUG, "The method hashCode() opened");
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (WAREHOUSE != null ? WAREHOUSE.hashCode() : 1);
		result = result * PRIME + count;
		result = result * PRIME + id;
		LOGGER.log(Level.DEBUG, "Result hashCode = " + result);
		LOGGER.log(Level.DEBUG, "The method hashCode() closed");
		return result;
	}

	@Override
	public boolean equals(Object object) {
		LOGGER.log(Level.DEBUG, "The method equals() opened");
		if (this == object) {
			LOGGER.log(Level.DEBUG,
					new StringBuilder().append("Result equals() = ").append(true).append(", because links object { ")
							.append(this.toString()).append(" } and { ").append(object.toString())
							.append(" } are equal.").toString());
			LOGGER.log(Level.DEBUG, "The method equals() closed");
			return true;
		}
		if (object == null) {
			LOGGER.log(Level.DEBUG, new StringBuilder().append("Result equals() = ").append(false)
					.append(", because passed object == null").toString());
			LOGGER.log(Level.DEBUG, "The method equals() closed");
			return false;
		}
		if (!this.getClass().equals(object.getClass())) {
			LOGGER.log(Level.DEBUG,
					new StringBuilder().append("Result equals() = ").append(false).append(", because object { ")
							.append(this.toString()).append(" } of class ").append(this.getClass())
							.append(" and pathed object { ").append(object.toString()).append(" } of class ")
							.append(object.getClass()).append(" and their not equal").toString());
			LOGGER.log(Level.DEBUG, "The method equals() closed");
			return false;
		}
		AbstractFigure otherAbstractFigure = (AbstractFigure) object;
		if (this.id != otherAbstractFigure.id) {
			LOGGER.log(Level.DEBUG, new StringBuilder().append("Result equals() = ").append(false)
					.append(", because object { ").append(this.toString()).append(" } with ID = ").append(this.id)
					.append(" and pathed object { ").append(otherAbstractFigure.toString()).append(" } with ID ")
					.append(otherAbstractFigure.id).append(" and their not equal").toString());
			LOGGER.log(Level.DEBUG, "The method equals() closed");
			return false;
		}
		LOGGER.log(Level.DEBUG, "Result equals() = " + true);
		LOGGER.log(Level.DEBUG, "The method equals() closed");
		return true;
	}

	@Override
	public String toString() {
		LOGGER.log(Level.DEBUG, "The method toString() opened");
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_ID).append(this.getId());
		LOGGER.log(Level.DEBUG, "The method toString() closed");
		return builder.toString();
	}
}