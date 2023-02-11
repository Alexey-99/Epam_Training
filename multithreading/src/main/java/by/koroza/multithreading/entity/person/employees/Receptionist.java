package by.koroza.multithreading.entity.person.employees;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;
import by.koroza.multithreading.entity.room.HookahRoom;

public interface Receptionist {

	public boolean isHavingFreeHookahRoom(Computer computer);

	public HookahRoom getFreeHookahRoom(Computer computer);

	public void putGroupClientsToHookahRoom(Computer computer, GroupClientsImpl clients) throws InterruptedException;

	public boolean isHaveingFreeWaitingPlace(Computer computer, int numberClients);

	public void recalculationDebtWaitingPlaces(Computer computer);

	public void putGroupClientsToWaitingRoom(Computer computer, GroupClientsImpl clients);

	public void putGroupClientsToWaitingArea(Computer computer, GroupClientsImpl clients);

	public void sayGreeting();

	public void sayIfHaveFreeHaveHookahRoom(HookahRoom freeHookahRoom);

	public void sayIfNotHaveFreeHaveHookahRoom();

	public void sayIfHaveFreeHaveWaitingPlace();

	public void sayIfNotHaveFreeHaveWaitingPlace();
}