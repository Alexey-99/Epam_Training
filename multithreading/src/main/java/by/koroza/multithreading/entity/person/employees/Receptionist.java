package by.koroza.multithreading.entity.person.employees;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.room.HookahRoom;

public interface Receptionist {

	// have free hookah room / paleces

	public boolean isHavingFreeHookahRoom(Computer computer);

	public HookahRoom getFreeHookahRoom(Computer computer); // isHavingFreeHookahRoom() - true

	public boolean isHavingFreePlacesInHookahRooms(Computer computer); // isHavingFreeHookahRoom() - false; If one -
																		// four Clients

	public HookahRoom getFreePlacesInHookahRoom(Computer computer);// isHavingFreePlacesInHookahRooms() - true

	// Don't have free hookah room / paleces

	public boolean isHaveingFreeWaitingPlace(Computer computer); // isHavingFreeHookahRoom() &&
																	// isHavingFreePlacesInHookahRooms() - false

	public void replacePersonToWaitingRoom(Computer computer);// isHaveingFreeWaitingPlace() - true

	public void replacePersonToWaitingArea(Computer computer);// isHaveingFreeWaitingPlace() - false

}