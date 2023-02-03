package by.koroza.multithreading.entity.room;

import java.util.ArrayList;
import java.util.List;

import by.koroza.multithreading.entity.abstraction.AbstractRoom;
import by.koroza.multithreading.entity.person.GroupClients;

public class WaitingRoom extends AbstractRoom {
	private static final int ID_WAITING_ROOM = 0;
	private List<GroupClients> waitingPlaces;
	private int countFreeWaitingPlaces;
	private int maxNumberPlaces;

	public WaitingRoom(int numberWaitingPlaces) {
		super.setId(ID_WAITING_ROOM);
		this.waitingPlaces = new ArrayList<>();
		this.countFreeWaitingPlaces = numberWaitingPlaces;
		this.maxNumberPlaces = numberWaitingPlaces;
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

	public List<GroupClients> getWaitingPlaces() {
		return waitingPlaces;
	}

	public void setWaitingPlaces(List<GroupClients> waitingPlaces) {
		this.waitingPlaces = waitingPlaces;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + this.countFreeWaitingPlaces;
		result = result * PRIME + this.maxNumberPlaces;
		result = result * PRIME + (this.waitingPlaces != null ? this.waitingPlaces.hashCode() : 1);
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("\n");
		builder.append("Count free waiting places: ").append(this.countFreeWaitingPlaces);
		return builder.toString();
	}
}