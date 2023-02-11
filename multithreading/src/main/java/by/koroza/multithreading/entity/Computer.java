package by.koroza.multithreading.entity;

import java.util.Arrays;

import by.koroza.multithreading.entity.room.HookahRoom;
import by.koroza.multithreading.entity.room.WaitingRoom;

public class Computer {
	private HookahRoom[] hookahRooms;
	private WaitingRoom waitingRoom;
	private WaitingAreaOutSideBar waitingArea;

	public Computer() {

	}

	public HookahRoom[] getHookahRooms() {
		return hookahRooms;
	}

	public void setHookahRooms(HookahRoom[] hookahRooms) {
		this.hookahRooms = hookahRooms;
	}

	public WaitingRoom getWaitingRoom() {
		return waitingRoom;
	}

	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	public WaitingAreaOutSideBar getWaitingArea() {
		return waitingArea;
	}

	public void setWaitingArea(WaitingAreaOutSideBar waitingArea) {
		this.waitingArea = waitingArea;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (this.hookahRooms != null ? this.hookahRooms.hashCode() : 1);
		result = PRIME * result + (this.waitingArea != null ? this.waitingArea.hashCode() : 1);
		result = PRIME * result + (this.waitingRoom != null ? this.waitingRoom.hashCode() : 1);
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
		Computer otherComputer = (Computer) object;
		if (this.hookahRooms == null) {
			if (otherComputer.hookahRooms != null) {
				return false;
			}
		} else if (!this.hookahRooms.equals(otherComputer.hookahRooms)) {
			return false;
		}
		if (this.waitingArea == null) {
			if (otherComputer.waitingArea != null) {
				return false;
			}
		} else if (!this.waitingArea.equals(otherComputer.waitingArea)) {
			return false;
		}
		if (this.waitingRoom == null) {
			if (otherComputer.waitingRoom != null) {
				return false;
			}
		} else if (!this.waitingRoom.equals(otherComputer.waitingRoom)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Computer [hookahRooms=");
		builder.append(Arrays.toString(this.hookahRooms));
		builder.append(", waitingRoom=");
		builder.append(waitingRoom);
		builder.append(", waitingArea=");
		builder.append(waitingArea);
		builder.append("]");
		return builder.toString();
	}

	public static class ComputerBuilder {
		private Computer computer;

		public ComputerBuilder() {
			this.computer = new Computer();
		}

		public ComputerBuilder setHookahRooms(HookahRoom[] hookahRooms) {
			this.computer.setHookahRooms(hookahRooms);
			return this;
		}

		public ComputerBuilder setWaitingRoom(WaitingRoom waitingRoom) {
			this.computer.setWaitingRoom(waitingRoom);
			return this;
		}

		public ComputerBuilder setWaitingArea(WaitingAreaOutSideBar waitingArea) {
			this.computer.setWaitingArea(waitingArea);
			return this;
		}

		public Computer build() {
			return this.computer;
		}
	}
}