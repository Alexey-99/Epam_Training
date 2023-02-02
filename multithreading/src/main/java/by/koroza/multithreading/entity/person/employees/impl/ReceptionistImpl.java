package by.koroza.multithreading.entity.person.employees.impl;

import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.employees.Receptionist;
import by.koroza.multithreading.entity.room.HookahRoom;

public class ReceptionistImpl extends AbstractEmployees implements Receptionist {

	@Override
	public boolean isHavingFreeHookahRoom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HookahRoom getFreeHookahRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHavingFreePlacesInHookahRooms() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HookahRoom getFreePlacesInHookahRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHaveingFreeWaitingPlace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replacePersonToWaitingRoom() {
		// TODO Auto-generated method stub
	}

	@Override
	public void replacePersonToWaitingArea() {
		// TODO Auto-generated method stub
	}

}