package by.koroza.shape.entity;

public class Point {
	private double x;
	private double y;

	public Point() {

	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + Double.hashCode(x);
		result = result * prime + Double.hashCode(y);
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
		if (!getClass().equals(object.getClass())) {
			return false;
		}
		Point otherPoint = (Point) object;
		if (x != otherPoint.x) {
			return false;
		}
		if (y != otherPoint.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("X = ").append(x);
		builder.append(", Y = ").append(y);
		return builder.toString();
	}

	public static class PointBuilder {
		private Point point;

		public PointBuilder() {
			point = new Point();
		}

		public PointBuilder setX(double x) {
			point.setX(x);
			return this;
		}

		public PointBuilder setY(double y) {
			point.setY(y);
			return this;
		}

		public Point build() {
			return point;
		}
	}
}