package by.koroza.multithreading.entity.room;

import java.util.ArrayList;
import java.util.List;

import by.koroza.multithreading.entity.abstraction.AbstractRoom;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;

public class WaitingRoom extends AbstractRoom {
	private static final int NUMBER_WAITING_ROOM = 0;
	private List<GroupClientsImpl> waitingPlaces;
	private int countFreeWaitingPlaces;
	private int maxNumberPlaces;
	private int debt;

	public WaitingRoom() {

	}

	public WaitingRoom(int numberWaitingPlaces) {
		super.setNumberRoom(NUMBER_WAITING_ROOM);
		this.waitingPlaces = new ArrayList<>();
		this.countFreeWaitingPlaces = numberWaitingPlaces;
		this.maxNumberPlaces = numberWaitingPlaces;
		this.debt = 0;
	}

	public int getCountFreeWaitingPlaces() {
		return countFreeWaitingPlaces;
	}

	public void setCountFreeWaitingPlaces(int countFreeWaitingPlaces) {
		this.countFreeWaitingPlaces = countFreeWaitingPlaces;
	}

	public int getMaxNumberPlaces() {
		return maxNumberPlaces;
	}

	public void setMaxNumberPlaces(int maxNumberPlaces) {
		this.maxNumberPlaces = maxNumberPlaces;
	}

	public List<GroupClientsImpl> getWaitingPlaces() {
		return waitingPlaces;
	}

	public void setWaitingPlaces(List<GroupClientsImpl> waitingPlaces) {
		this.waitingPlaces = waitingPlaces;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + this.countFreeWaitingPlaces;
		result = result * PRIME + this.maxNumberPlaces;
		result = result * PRIME + (this.waitingPlaces != null ? this.waitingPlaces.hashCode() : 1);
		result = result * PRIME + this.debt;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		WaitingRoom otherWaitingRoom = (WaitingRoom) object;
		if (this.countFreeWaitingPlaces != otherWaitingRoom.countFreeWaitingPlaces) {
			return false;
		}
		if (this.maxNumberPlaces != otherWaitingRoom.maxNumberPlaces) {
			return false;
		}
		if (this.waitingPlaces == null) {
			if (otherWaitingRoom.waitingPlaces != null) {
				return false;
			}
		} else if (!this.waitingPlaces.equals(otherWaitingRoom.waitingPlaces)) {
			return false;
		}
		if (this.debt != otherWaitingRoom.debt) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WaitingRoom [waitingPlaces=");
		builder.append(this.waitingPlaces);
		builder.append(", countFreeWaitingPlaces=");
		builder.append(this.countFreeWaitingPlaces);
		builder.append(", maxNumberPlaces=");
		builder.append(this.maxNumberPlaces);
		builder.append(", debt=");
		builder.append(this.debt);
		builder.append("]");
		return builder.toString();
	}

	public static class WaitingRoomBuilder {
		private WaitingRoom waitingRoom;

		public WaitingRoomBuilder() {
			this.waitingRoom = new WaitingRoom();
		}

		public WaitingRoomBuilder setNumberRoom(long numberRoom) {
			this.waitingRoom.setNumberRoom(numberRoom);
			return this;
		}

		public WaitingRoomBuilder setCountFreeWaitingPlaces(int countFreeWaitingPlaces) {
			this.waitingRoom.setCountFreeWaitingPlaces(countFreeWaitingPlaces);
			return this;
		}

		public WaitingRoomBuilder setMaxNumberPlaces(int maxNumberPlaces) {
			this.waitingRoom.setMaxNumberPlaces(maxNumberPlaces);
			return this;
		}

		public WaitingRoomBuilder setWaitingPlaces(List<GroupClientsImpl> waitingPlaces) {
			this.waitingRoom.setWaitingPlaces(waitingPlaces);
			return this;
		}

		public void setDebt(int debt) {
			this.waitingRoom.setDebt(debt);
		}

		public WaitingRoom build() {
			return this.waitingRoom;
		}
	}
}