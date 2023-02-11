package by.koroza.multithreading.culculation;

import by.koroza.multithreading.entity.room.HookahRoom;

public class Calculator {

	public int calcNumberWaitingPlaces(HookahRoom[] hookahRooms) {
		return hookahRooms.length >= 3 ? hookahRooms.length / 3 : hookahRooms.length == 0 ? 0 : 1;
	}
}