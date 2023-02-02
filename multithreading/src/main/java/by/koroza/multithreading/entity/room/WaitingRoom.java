package by.koroza.multithreading.entity.room;

import by.koroza.multithreading.entity.abstraction.AbstractRoom;

public class WaitingRoom extends AbstractRoom {
	private static final int ID_WAITING_ROOM = 0;
	private int countWaitingPlaces;

	public WaitingRoom(int numberWaitingPlaces) {
		this.countWaitingPlaces = numberWaitingPlaces;
		super.setId(ID_WAITING_ROOM);
	}

	public int getCountWaitingPlaces() {
		return countWaitingPlaces;
	}

	public void setCountWaitingPlaces(int countWaitingPlaces) {
		this.countWaitingPlaces = countWaitingPlaces;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + countWaitingPlaces;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		WaitingRoom otherWaitingRoom = (WaitingRoom) object;
		if (this.countWaitingPlaces != otherWaitingRoom.countWaitingPlaces) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("\n");
		builder.append("Count waiting places: ").append(this.countWaitingPlaces);
		return builder.toString();
	}
}