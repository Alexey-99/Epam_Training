package by.koroza.multithreading.entity.person.employees;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.person.GroupClients;
import by.koroza.multithreading.entity.room.HookahRoom;

public interface Receptionist {

	// have free hookah room / paleces

	public boolean isHavingFreeHookahRoom(Computer computer);

	public HookahRoom getFreeHookahRoom(Computer computer); // isHavingFreeHookahRoom() - true

	public void putGroupClientsToHookahRoom(Computer computer, GroupClients clients);

	public boolean isHavingFreePlacesInHookahRooms(Computer computer, int numberClients); // isHavingFreeHookahRoom() -
																							// false; If one -
	// four Clients

	public HookahRoom getFreePlacesInHookahRoom(Computer computer);// isHavingFreePlacesInHookahRooms() - true

	// Don't have free hookah room / paleces

	public boolean isHaveingFreeWaitingPlace(Computer computer, int numberClients); // isHavingFreeHookahRoom() &&
	// isHavingFreePlacesInHookahRooms() - false

	public void putGroupClientsToWaitingRoom(Computer computer, GroupClients clients);// isHaveingFreeWaitingPlace() -
																						// true

	public void putGroupClientsToWaitingArea(Computer computer, GroupClients clients);// isHaveingFreeWaitingPlace() -
																						// false

}