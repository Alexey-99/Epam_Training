package by.koroza.shape.entity;

public abstract class AbstractFigure {
	private static final Warehouse WAREHOUSE = Warehouse.getInstance();
	private static int count = 1;
	private int id;
	private static final String STRING_ID = "ID: ";

	public AbstractFigure() {
		this.id = count++;
		WAREHOUSE.add(this.id, new Analytics());
	}

	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Analytics analytics = getAnalytics();
		WAREHOUSE.remove(id);
		this.id = id;
		WAREHOUSE.add(this.id, analytics);
	}

	public static Warehouse getWarehouse() {
		return WAREHOUSE;
	}

	public Analytics getAnalytics() {
		return WAREHOUSE.get(this.id);
	}

	public abstract Point[] getPoints();

	@Override
	public int hashCode() {

		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (WAREHOUSE != null ? WAREHOUSE.hashCode() : 1);
		result = result * PRIME + count;
		result = result * PRIME + id;
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
		if (!this.getClass().equals(object.getClass())) {
			return false;
		}
		AbstractFigure otherAbstractFigure = (AbstractFigure) object;
		if (this.id != otherAbstractFigure.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_ID).append(this.getId());
		return builder.toString();
	}
}