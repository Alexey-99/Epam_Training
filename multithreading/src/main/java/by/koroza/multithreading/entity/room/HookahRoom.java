package by.koroza.multithreading.entity.room;

import by.koroza.multithreading.entity.abstraction.AbstractRoom;
import by.koroza.multithreading.entity.person.employees.HookahMaker;
import by.koroza.multithreading.entity.person.employees.impl.HookahMakerImpl;

public class HookahRoom extends AbstractRoom {
	private int freePlaces;
	private HookahMaker hookahMaker;

	public HookahRoom(int places) {
		this.freePlaces = places;
		this.hookahMaker = new HookahMakerImpl();
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

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + this.freePlaces;
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("\n");
		return builder.toString();
	}
}