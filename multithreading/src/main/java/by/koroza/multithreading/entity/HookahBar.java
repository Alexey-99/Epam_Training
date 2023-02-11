package by.koroza.multithreading.entity;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.multithreading.communication.Communication;
import by.koroza.multithreading.communication.impl.CommunicatorImpl;
import by.koroza.multithreading.culculation.Calculator;
import by.koroza.multithreading.entity.abstraction.AbstractEstablishment;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;
import by.koroza.multithreading.entity.person.employees.impl.ReceptionistImpl;
import by.koroza.multithreading.entity.room.HookahRoom;
import by.koroza.multithreading.entity.room.WaitingRoom;
import by.koroza.multithreading.exception.CustomException;
import by.koroza.multithreading.observer.HookahBarUpdater;

public class HookahBar extends AbstractEstablishment {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final int DEFAULT_NUMBER_HOOKAH_ROOM = 0;
	private static final int DEFAULT_NUMBER_WAITING_PLACES = 0;
	private static final HookahBarUpdater hookahBarUpdater = new HookahBarUpdater();

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	private HookahRoom[] hookahRooms;
	private WaitingRoom waitingRoom;
	private Reception reception;
	private WaitingAreaOutSideBar waitingArea;

	public HookahBar() {
		initArrayHookahRooms(DEFAULT_NUMBER_HOOKAH_ROOM);
		this.waitingRoom = new WaitingRoom(DEFAULT_NUMBER_WAITING_PLACES);
		this.waitingArea = new WaitingAreaOutSideBar();
		this.reception = new Reception(new ReceptionistImpl(),
				new Computer.ComputerBuilder().setHookahRooms(this.hookahRooms).setWaitingRoom(this.waitingRoom)
						.setWaitingArea(this.waitingArea).build());
	}

	public HookahBar(int numberHookahRooms) throws CustomException {
		if (numberHookahRooms >= 0) {
			initArrayHookahRooms(numberHookahRooms);
			this.waitingRoom = new WaitingRoom(new Calculator().calcNumberWaitingPlaces(this.hookahRooms));
			this.waitingArea = new WaitingAreaOutSideBar();
			this.reception = new Reception(new ReceptionistImpl(),
					new Computer.ComputerBuilder().setHookahRooms(this.hookahRooms).setWaitingRoom(this.waitingRoom)
							.setWaitingArea(this.waitingArea).build());
		} else {
			LOGGER.log(Level.ERROR,
					"You entered incorrectly number hookah rooms. Number hookah rooms: " + numberHookahRooms);
			throw new CustomException(
					"You entered incorrectly number hookah rooms. Number hookah rooms: " + numberHookahRooms);
		}
	}

	public void goToHookahBar(GroupClientsImpl groupClient) {
		Communication communicator = new CommunicatorImpl();
		lock.lock();
		HookahRoom hookahRoom = communicator.communicationReceptionAndClients(this.reception, groupClient, condition);
		lock.unlock();
		communicator.communicationHookahMakerAndClients(hookahRoom, groupClient);
		lock.lock();
		condition.signalAll();
		lock.unlock();
		System.out.println();

	}

	public HookahRoom[] getHookahRooms() {
		return hookahRooms;
	}

	public void setHookahRooms(HookahRoom[] hookahRooms) {
		this.hookahRooms = hookahRooms;
		hookahBarUpdater.updateForSetHookahRooms(this);
	}

	public void setHookahRooms(int numberHookahRooms) throws CustomException {
		if (numberHookahRooms >= 0) {
			initArrayHookahRooms(numberHookahRooms);
			hookahBarUpdater.updateForSetHookahRooms(this);
		} else {
			LOGGER.log(Level.ERROR,
					"You entered incorrectly number hookah rooms. Number hookah rooms: " + numberHookahRooms);
			throw new CustomException(
					"You entered incorrectly number hookah rooms. Number hookah rooms: " + numberHookahRooms);
		}
	}

	public void addHookahRoom(HookahRoom hookahRoom) {
		HookahRoom[] otherHookahRooms = new HookahRoom[this.hookahRooms.length + 1];
		System.arraycopy(this.hookahRooms, 0, otherHookahRooms, 0, this.hookahRooms.length);
		otherHookahRooms[otherHookahRooms.length - 1] = hookahRoom;
		this.hookahRooms = otherHookahRooms;
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

	private void initArrayHookahRooms(int numberHookahRooms) {
		this.hookahRooms = new HookahRoom[numberHookahRooms];
		for (int i = 0; i < this.hookahRooms.length; i++) {
			this.hookahRooms[i] = new HookahRoom();
		}
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
		} else if (!Arrays.equals(this.hookahRooms, otherHookahBar.hookahRooms)) {
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
		builder.append(Arrays.toString(this.hookahRooms));
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

		public HookahBarBuilder setHookahRooms(HookahRoom[] hookahRooms) {
			hookahBar.setHookahRooms(hookahRooms);
			return this;
		}

		public void setHookahRooms(int numberHookahRooms) throws CustomException {
			hookahBar.setHookahRooms(numberHookahRooms);
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