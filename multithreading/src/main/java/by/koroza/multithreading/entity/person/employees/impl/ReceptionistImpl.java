/** TODO объединение isHavingFreeHookahRoom и getFreeHookahRoom под ?
 * */

package by.koroza.multithreading.entity.person.employees.impl;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.GroupClients;
import by.koroza.multithreading.entity.person.employees.Receptionist;
import by.koroza.multithreading.entity.room.HookahRoom;
import by.koroza.multithreading.stutus.Status;

public class ReceptionistImpl extends AbstractEmployees implements Receptionist {

	@Override
	public boolean isHavingFreeHookahRoom(Computer computer) {
		boolean result = false;
		for (HookahRoom room : computer.getHookahRooms()) {
			if (room.getStatus().equals(Status.NOT_BUSY)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public HookahRoom getFreeHookahRoom(Computer computer) {
		HookahRoom hookahRoom = null;
		for (HookahRoom room : computer.getHookahRooms()) {
			if (room.getStatus().equals(Status.NOT_BUSY)) {
				hookahRoom = room;
			}
		}
		return hookahRoom;
	}

	@Override
	public void putGroupClientsToHookahRoom(Computer computer, GroupClients clients) {
		if (isHavingFreeHookahRoom(computer)) {
			HookahRoom hookahRoom = getFreeHookahRoom(computer);
			hookahRoom.setClients(clients);
			hookahRoom.changeStatusToBusy();
			// TODO TIMEUNIT
		}
	}

	@Override
	public boolean isHavingFreePlacesInHookahRooms(Computer computer, int numberClients) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public HookahRoom getFreePlacesInHookahRoom(Computer computer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHaveingFreeWaitingPlace(Computer computer, int numberClients) {
		return computer.getWaitingRoom().getCountFreeWaitingPlaces() >= numberClients;
	}

	@Override
	public void putGroupClientsToWaitingRoom(Computer computer, GroupClients clients) {
		if (isHaveingFreeWaitingPlace(computer, clients.getClients().length)) {
			computer.getWaitingRoom().getWaitingPlaces().add(clients);
			computer.getWaitingRoom().setCountFreeWaitingPlaces(
					computer.getWaitingRoom().getCountFreeWaitingPlaces() - clients.getClients().length);
		}
	}

	@Override
	public void putGroupClientsToWaitingArea(Computer computer, GroupClients clients) {
		computer.getWaitingArea().getClients().add(clients);
	}
}