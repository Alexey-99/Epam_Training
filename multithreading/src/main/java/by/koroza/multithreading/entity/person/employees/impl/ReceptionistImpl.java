/** TODO объединение isHavingFreeHookahRoom и getFreeHookahRoom под ?
 * */

package by.koroza.multithreading.entity.person.employees.impl;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.employees.Receptionist;
import by.koroza.multithreading.entity.room.HookahRoom;
import by.koroza.multithreading.stutus.StatusHookahRoom;

public class ReceptionistImpl extends AbstractEmployees implements Receptionist {

	@Override
	public boolean isHavingFreeHookahRoom(Computer computer) {
		boolean result = false;
		for (HookahRoom room : computer.getHookahRooms()) {
			if (room.getStatus().equals(StatusHookahRoom.OPEN)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public HookahRoom getFreeHookahRoom(Computer computer) {
		HookahRoom hookahRoom = null;
		for (HookahRoom room : computer.getHookahRooms()) {
			if (room.getStatus().equals(StatusHookahRoom.OPEN)) {
				hookahRoom = room;
			}
		}
		return hookahRoom;
	}

	@Override
	public boolean isHavingFreePlacesInHookahRooms(Computer computer, int numberClients) {
		boolean result = isHavingFreeHookahRoom(computer);
		if(result == false && numberClients < 5) {
			for (HookahRoom room : computer.getHookahRooms()) {
				if (room.getFreePlaces() ) {
					result = true;
				}
			}
		}
		
		return result;
	}

	@Override
	public HookahRoom getFreePlacesInHookahRoom(Computer computer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHaveingFreeWaitingPlace(Computer computer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replacePersonToWaitingRoom(Computer computer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void replacePersonToWaitingArea(Computer computer) {
		// TODO Auto-generated method stub
	}

}