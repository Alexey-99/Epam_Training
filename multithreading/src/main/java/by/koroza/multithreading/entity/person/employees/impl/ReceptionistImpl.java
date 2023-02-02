package by.koroza.multithreading.entity.person.employees.impl;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.employees.Receptionist;
import by.koroza.multithreading.entity.room.HookahRoom;

public class ReceptionistImpl extends AbstractEmployees implements Receptionist {

	@Override
	public boolean isHavingFreeHookahRoom(Computer computer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HookahRoom getFreeHookahRoom(Computer computer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHavingFreePlacesInHookahRooms(Computer computer) {
		// TODO Auto-generated method stub
		return false;
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