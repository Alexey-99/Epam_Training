package by.koroza.multithreading.observer;

import by.koroza.multithreading.culculation.Calculator;
import by.koroza.multithreading.entity.HookahBar;
import by.koroza.multithreading.entity.Reception;
import by.koroza.multithreading.entity.room.WaitingRoom;

public class HookahBarUpdater {

	public void updateForSetHookahRooms(HookahBar hookahBar) {
		updateWaitingRoom(hookahBar);
		updateReception(hookahBar);
	}

	private void updateWaitingRoom(HookahBar hookahBar) {
		WaitingRoom waitingRoom = hookahBar.getWaitingRoom();
		int oldMaxNumberPlaces = waitingRoom.getMaxNumberPlaces();
		waitingRoom.setMaxNumberPlaces(new Calculator().calcNumberWaitingPlaces(hookahBar.getHookahRooms()));
		int newMaxNumberPlaces = waitingRoom.getMaxNumberPlaces();
		int difference = oldMaxNumberPlaces - newMaxNumberPlaces;
		if (difference < 0) {
			waitingRoom.setCountFreeWaitingPlaces(waitingRoom.getCountFreeWaitingPlaces() + Math.abs(difference));
		} else if (difference > 0) {
			waitingRoom.setCountFreeWaitingPlaces(waitingRoom.getCountFreeWaitingPlaces() - difference);
			if (waitingRoom.getCountFreeWaitingPlaces() < 0) {
				waitingRoom.setDebt(waitingRoom.getDebt() + difference);
			}
		}
	}

	private void updateReception(HookahBar hookahBar) {
		Reception reception = hookahBar.getReception();
		reception.getComputer().setHookahRooms(hookahBar.getHookahRooms());
		reception.getComputer().setWaitingRoom(hookahBar.getWaitingRoom());
		reception.getComputer().setWaitingArea(hookahBar.getWaitingArea());
	}
}
