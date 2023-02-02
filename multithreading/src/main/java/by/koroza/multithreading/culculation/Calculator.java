package by.koroza.multithreading.culculation;

import java.util.List;

import by.koroza.multithreading.entity.room.HookahRoom;

public class Calculator {

	public int calcNumberWaitingPlaces(List<HookahRoom> hookahRooms) {
		return hookahRooms.size() / 3;
	}
}