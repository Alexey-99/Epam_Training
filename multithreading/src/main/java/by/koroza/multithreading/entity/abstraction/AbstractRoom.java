package by.koroza.multithreading.entity.abstraction;

public abstract class AbstractRoom {
	private static long countNumberRoom = 1;
	private long numberRoom;

	public AbstractRoom() {
		this.numberRoom = countNumberRoom++;
	}

	public long getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(long numberRoom) {
		this.numberRoom = numberRoom;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Long.hashCode(countNumberRoom);
		result = result * PRIME + Long.hashCode(this.numberRoom);
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
		if (this.numberRoom != otherAbstractRoom.numberRoom) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractRoom [number room=");
		builder.append(this.numberRoom);
		builder.append("]");
		return builder.toString();
	}

}