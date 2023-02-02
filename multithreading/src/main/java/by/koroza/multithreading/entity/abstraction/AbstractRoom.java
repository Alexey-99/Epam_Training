package by.koroza.multithreading.entity.abstraction;

public abstract class AbstractRoom {
	private static long countId = 1;
	private long id;

	public AbstractRoom() {
		this.id = countId++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Long.hashCode(countId);
		result = result * PRIME + Long.hashCode(this.id);
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
		AbstractRoom otherAbstractRoom = (AbstractRoom) object;
		if (this.id != otherAbstractRoom.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: ").append(this.id);
		return builder.toString();
	}

}