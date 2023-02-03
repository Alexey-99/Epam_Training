package by.koroza.multithreading.entity.room;

import by.koroza.multithreading.entity.abstraction.AbstractRoom;
import by.koroza.multithreading.entity.person.GroupClients;
import by.koroza.multithreading.entity.person.employees.HookahMaker;
import by.koroza.multithreading.entity.person.employees.impl.HookahMakerImpl;
import by.koroza.multithreading.stutus.Status;

import static by.koroza.multithreading.stutus.Status.BUSY;
import static by.koroza.multithreading.stutus.Status.NOT_BUSY;;

public class HookahRoom extends AbstractRoom {
	private HookahMaker hookahMaker;
	private Status status;
	private GroupClients clients;

	public HookahRoom(int places) {
		this.hookahMaker = new HookahMakerImpl();
		this.status = NOT_BUSY;
	}

	public HookahRoom(String nameHookahMaker) {
		this.hookahMaker = new HookahMakerImpl(nameHookahMaker);
		this.status = NOT_BUSY;
	}

	public HookahMaker getHookahMaker() {
		return hookahMaker;
	}

	public void setHookahMaker(HookahMaker hookahMaker) {
		this.hookahMaker = hookahMaker;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void changeStatusToNotBusy() {
		this.status = NOT_BUSY;
	}

	public void changeStatusToBusy() {
		this.status = BUSY;
	}

	public GroupClients getClients() {
		return clients;
	}

	public void setClients(GroupClients clients) {
		this.clients = clients;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
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