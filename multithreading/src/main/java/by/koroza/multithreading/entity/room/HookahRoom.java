package by.koroza.multithreading.entity.room;

import by.koroza.multithreading.entity.abstraction.AbstractRoom;
import by.koroza.multithreading.entity.person.employees.HookahMaker;
import by.koroza.multithreading.entity.person.employees.impl.HookahMakerImpl;
import by.koroza.multithreading.stutus.StatusHookahRoom;

import static by.koroza.multithreading.stutus.StatusHookahRoom.CLOSE;
import static by.koroza.multithreading.stutus.StatusHookahRoom.OPEN;

public class HookahRoom extends AbstractRoom {
	private int freePlaces;
	private HookahMaker hookahMaker;
	private StatusHookahRoom status;

	public HookahRoom(int places) {
		this.freePlaces = places;
		this.hookahMaker = new HookahMakerImpl();
		this.status = OPEN;
	}

	public HookahRoom(int places, String nameHookahMaker) {
		this.freePlaces = places;
		this.hookahMaker = new HookahMakerImpl(nameHookahMaker);
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	public void setFreePlaces(int freePlaces) {
		this.freePlaces = freePlaces;
	}

	public HookahMaker getHookahMaker() {
		return hookahMaker;
	}

	public void setHookahMaker(HookahMaker hookahMaker) {
		this.hookahMaker = hookahMaker;
	}

	public StatusHookahRoom getStatus() {
		return status;
	}

	public void setStatus(StatusHookahRoom status) {
		this.status = status;
	}

	public void changeStatusToOpen() {
		this.status = OPEN;
	}

	public void changeStatusToClose() {
		this.status = CLOSE;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + this.freePlaces;
		result = result * PRIME + (this.hookahMaker != null ? this.hookahMaker.hashCode() : 1);
		result = result * PRIME + (this.status != null ? this.status.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		HookahRoom otherHookahRoom = (HookahRoom) object;
		if (this.freePlaces != otherHookahRoom.freePlaces) {
			return false;
		}
		if (this.hookahMaker == null) {
			if (otherHookahRoom != null) {
				return false;
			}
		} else if (!this.hookahMaker.equals(otherHookahRoom.hookahMaker)) {
			return false;
		}
		if (this.status == null) {
			if (otherHookahRoom.status != null) {
				return false;
			}
		} else if (!this.status.equals(otherHookahRoom.status)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("\n");
		return builder.toString();
	}
}