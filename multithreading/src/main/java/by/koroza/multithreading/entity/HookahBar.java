package by.koroza.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.multithreading.culculation.Calculator;
import by.koroza.multithreading.entity.abstraction.AbstractEstablishment;
import by.koroza.multithreading.entity.person.employees.impl.ReceptionistImpl;
import by.koroza.multithreading.entity.room.HookahRoom;
import by.koroza.multithreading.entity.room.WaitingRoom;

public class HookahBar extends AbstractEstablishment {
	private List<HookahRoom> hookahRooms;
	private WaitingRoom waitingRoom;
	private Reception reception;
	private WaitingAreaOutSideBar waitingArea;

	public HookahBar() {
		this.hookahRooms = new ArrayList<>();
		this.waitingRoom = new WaitingRoom(new Calculator().calcNumberWaitingPlaces(this.hookahRooms));
		this.reception = new Reception(new ReceptionistImpl(),
				new Computer.ComputerBuilder().setHookahRooms(this.hookahRooms).setWaitingRoom(this.waitingRoom)
						.setWaitingArea(this.waitingArea).build());
		this.waitingArea = new WaitingAreaOutSideBar();
	}

	public List<HookahRoom> getHookahRooms() {
		return hookahRooms;
	}

	public void setHookahRooms(List<HookahRoom> hookahRooms) {
		this.hookahRooms = hookahRooms;
	}

	public void addRoom(HookahRoom hookahRoom) {
		this.hookahRooms.add(hookahRoom);
	}

	public WaitingRoom getWaitingRoom() {
		return waitingRoom;
	}

	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
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
		result = result * PRIME + super.hashCode();
		result = result * PRIME + (this.hookahRooms != null ? this.hookahRooms.hashCode() : 1);
		result = result * PRIME + (this.waitingRoom != null ? this.waitingRoom.hashCode() : 1);
		result = result * PRIME + (this.reception != null ? this.reception.hashCode() : 1);
		result = result * PRIME + (this.waitingArea != null ? this.waitingArea.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		HookahBar otherHookahBar = (HookahBar) object;
		if (this.hookahRooms == null) {
			if (otherHookahBar.hookahRooms != null) {
				return false;
			}
		} else if (!this.hookahRooms.equals(otherHookahBar.hookahRooms)) {
			return false;
		}
		if (this.reception == null) {
			if (otherHookahBar.reception != null) {
				return false;
			}
		} else if (!this.reception.equals(otherHookahBar.reception)) {
			return false;
		}
		if (this.waitingArea == null) {
			if (otherHookahBar.waitingArea != null) {
				return false;
			}
		} else if (!this.waitingArea.equals(otherHookahBar.waitingArea)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("\n");
		builder.append("HookahBar [hookahRooms=");
		builder.append(this.hookahRooms);
		builder.append(", waitingRoom=");
		builder.append(this.waitingRoom);
		builder.append(", reception=");
		builder.append(this.reception);
		builder.append(", waitingArea=");
		builder.append(this.waitingArea);
		builder.append("]");
		return builder.toString();
	}

	public static class HookahBarBuilder {
		private HookahBar hookahBar;

		public HookahBarBuilder() {
			this.hookahBar = new HookahBar();
		}

		public HookahBarBuilder setHookahRooms(List<HookahRoom> hookahRooms) {
			hookahBar.setHookahRooms(hookahRooms);
			return this;
		}

		public HookahBarBuilder setWaitingRoom(WaitingRoom waitingRoom) {
			hookahBar.setWaitingRoom(waitingRoom);
			return this;
		}

		public HookahBarBuilder setReception(Reception reception) {
			hookahBar.setReception(reception);
			return this;
		}

		public HookahBarBuilder setWaitingArea(WaitingAreaOutSideBar waitingArea) {
			hookahBar.setWaitingArea(waitingArea);
			return this;
		}

		public HookahBar build() {
			return hookahBar;
		}
	}
}