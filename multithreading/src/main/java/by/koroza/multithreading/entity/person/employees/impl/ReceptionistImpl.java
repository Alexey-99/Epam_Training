package by.koroza.multithreading.entity.person.employees.impl;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.multithreading.entity.Computer;
import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;
import by.koroza.multithreading.entity.person.employees.Receptionist;
import by.koroza.multithreading.entity.room.HookahRoom;
import by.koroza.multithreading.entity.room.WaitingRoom;
import by.koroza.multithreading.stutus.Status;

public class ReceptionistImpl extends AbstractEmployees implements Receptionist {
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public boolean isHavingFreeHookahRoom(Computer computer) {
		boolean result = false;
		for (HookahRoom room : computer.getHookahRooms()) {
			if (room.getStatus().equals(Status.NOT_BUSY)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public HookahRoom getFreeHookahRoom(Computer computer) {
		HookahRoom hookahRoom = null;
		boolean flagFor = true;
		for (int i = 0; i < computer.getHookahRooms().length && flagFor; i++) {
			if (computer.getHookahRooms()[i].getStatus().equals(Status.NOT_BUSY)) {
				hookahRoom = computer.getHookahRooms()[i];
				flagFor = false;
			}
		}
		return hookahRoom;
	}

	@Override
	public void putGroupClientsToHookahRoom(Computer computer, GroupClientsImpl clients) throws InterruptedException {
		HookahRoom hookahRoom = null;
		if (isHavingFreeHookahRoom(computer)) {
			hookahRoom = getFreeHookahRoom(computer);
			hookahRoom.changeStatusToBusy();
			LOGGER.log(Level.INFO, clients.toString() + " go to hookah room " + hookahRoom.getNumberRoom());
			TimeUnit.SECONDS.sleep(5);
		}
	}

	@Override
	public boolean isHaveingFreeWaitingPlace(Computer computer, int numberClients) {
		recalculationDebtWaitingPlaces(computer);
		return computer.getWaitingRoom().getCountFreeWaitingPlaces() >= numberClients;
	}

	@Override
	public void recalculationDebtWaitingPlaces(Computer computer) {
		WaitingRoom waitingRoom = computer.getWaitingRoom();
		if ((waitingRoom.getDebt() > 0) && (waitingRoom.getCountFreeWaitingPlaces() > 0)) {
			if (waitingRoom.getDebt() > waitingRoom.getCountFreeWaitingPlaces()) {
				waitingRoom.setDebt(waitingRoom.getDebt() - waitingRoom.getCountFreeWaitingPlaces());
				waitingRoom.setCountFreeWaitingPlaces(0);
			} else if ((waitingRoom.getDebt() < waitingRoom.getCountFreeWaitingPlaces())
					&& (waitingRoom.getDebt() == waitingRoom.getCountFreeWaitingPlaces())) {
				waitingRoom.setCountFreeWaitingPlaces(waitingRoom.getCountFreeWaitingPlaces() - waitingRoom.getDebt());
				waitingRoom.setDebt(0);
			}
		}
	}

	@Override
	public void putGroupClientsToWaitingRoom(Computer computer, GroupClientsImpl clients) {
		if (isHaveingFreeWaitingPlace(computer, clients.getClients().length)) {
			computer.getWaitingRoom().getWaitingPlaces().add(clients);
			computer.getWaitingRoom().setCountFreeWaitingPlaces(
					computer.getWaitingRoom().getCountFreeWaitingPlaces() - clients.getClients().length);
			LOGGER.log(Level.INFO, clients.toString() + " go to waiting room...");
		}
	}

	@Override
	public void putGroupClientsToWaitingArea(Computer computer, GroupClientsImpl clients) {
		computer.getWaitingArea().getClients().add(clients);
		LOGGER.log(Level.INFO, clients.toString() + " go to waiting area...");
	}

	@Override
	public void sayGreeting() {
		LOGGER.log(Level.INFO,
				"Receptionist: Good day!"
						+ (!super.getName().equals("without name") ? " My name is " + getName() + "." : "")
						+ " Can I help you?");
	}

	@Override
	public void sayIfHaveFreeHaveHookahRoom(HookahRoom freeHookahRoom) {
		LOGGER.log(Level.INFO,
				"Receptionist: Yes. We have a free hookah room number " + freeHookahRoom.getNumberRoom());
	}

	@Override
	public void sayIfNotHaveFreeHaveHookahRoom() {
		LOGGER.log(Level.INFO, "Receptionist: Sorry, all hookah rooms are currently occupied.");
	}

	@Override
	public void sayIfHaveFreeHaveWaitingPlace() {
		LOGGER.log(Level.INFO, "Receptionist: You can wait in the waiting room.");
	}

	@Override
	public void sayIfNotHaveFreeHaveWaitingPlace() {
		LOGGER.log(Level.INFO, "Receptionist: You can wait in the waiting area outside the bar.");
	}
}