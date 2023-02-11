package by.koroza.multithreading.communication.impl;

import java.util.concurrent.locks.Condition;

import by.koroza.multithreading.communication.Communication;
import by.koroza.multithreading.entity.Reception;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;
import by.koroza.multithreading.entity.person.employees.Receptionist;
import by.koroza.multithreading.entity.room.HookahRoom;

public class CommunicatorImpl implements Communication {

	public CommunicatorImpl() {
	}

	@Override
	public HookahRoom communicationReceptionAndClients(Reception reception, GroupClientsImpl clients, Condition condition) {
		boolean isFreeHookahRoom = true;
		HookahRoom freeHookahRoom = null;

		Receptionist receptionist = reception.getReceptionist();
		receptionist.sayGreeting();
		do {
			try {
				clients.sayIsHaveFreeHookahRoom();
				isFreeHookahRoom = receptionist.isHavingFreeHookahRoom(reception.getComputer());

				if (isFreeHookahRoom) {
					freeHookahRoom = receptionist.getFreeHookahRoom(reception.getComputer());
					receptionist.sayIfHaveFreeHaveHookahRoom(freeHookahRoom);
					receptionist.putGroupClientsToHookahRoom(reception.getComputer(), clients);
				} else {
					receptionist.sayIfNotHaveFreeHaveHookahRoom();
					boolean isHaveingFreeWaitingPlace = receptionist.isHaveingFreeWaitingPlace(reception.getComputer(),
							clients.getClients().length);
					if (isHaveingFreeWaitingPlace) {
						receptionist.sayIfHaveFreeHaveWaitingPlace();
						receptionist.putGroupClientsToWaitingRoom(reception.getComputer(), clients);
						clients.setPriority(Thread.MAX_PRIORITY);
						condition.await();
						clients.goFromWaitingRoomToReception();
					} else {
						receptionist.sayIfNotHaveFreeHaveWaitingPlace();
						receptionist.putGroupClientsToWaitingArea(reception.getComputer(), clients);
						clients.setPriority(Thread.MIN_PRIORITY);
						condition.await();
						clients.goFromWaitingAreaToReception();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (isFreeHookahRoom == false);
		return freeHookahRoom;
	}

	@Override
	public HookahRoom communicationHookahMakerAndClients(HookahRoom hookahRoom, GroupClientsImpl clients) {
		try {
			hookahRoom.getHookahMaker().hookahRoomPreparation();
			hookahRoom.getHookahMaker().hookahPreparation();
			clients.smokeHookah();
			hookahRoom.getHookahMaker().hookahRoomCleaning();
			hookahRoom.changeStatusToNotBusy();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hookahRoom;
	}
}