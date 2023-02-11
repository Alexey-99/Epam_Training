package by.koroza.multithreading.entity.person.client.impl;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.multithreading.entity.HookahBar;
import by.koroza.multithreading.entity.person.client.Client;
import by.koroza.multithreading.entity.person.client.GroupClientsOfHookahBar;

public class GroupClientsImpl extends Thread implements GroupClientsOfHookahBar {
	private static final Logger LOGGER = LogManager.getLogger();
	private static long countId = 1;
	private long id;
	private Client[] clients;
	private HookahBar hookahBar;

	public GroupClientsImpl(int numberClients, HookahBar hookahBar) {
		this.id = countId++;
		initArrayClients(numberClients);
		this.hookahBar = hookahBar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client[] getClients() {
		return clients;
	}

	public void setClients(Client[] clients) {
		this.clients = clients;
	}

	@Override
	public void run() {
		this.hookahBar.goToHookahBar(this);
	}

	@Override
	public void smokeHookah() throws InterruptedException {
		TimeUnit.SECONDS.sleep(15);
		LOGGER.log(Level.INFO, this.toString() + " smoking hookah...");
	}

	@Override
	public void goFromWaitingRoomToReception() {
		this.hookahBar.getWaitingRoom().setCountFreeWaitingPlaces(
				this.hookahBar.getWaitingRoom().getCountFreeWaitingPlaces() + this.clients.length);
		this.hookahBar.getWaitingRoom().getWaitingPlaces().remove(this);
		LOGGER.log(Level.INFO, this.toString() + " go from waiting room to reception.");
	}

	@Override
	public void goFromWaitingAreaToReception() {
		this.hookahBar.getWaitingArea().getClients().remove(this);
		LOGGER.log(Level.INFO, this.toString() + " go from waiting area to reception.");
	}

	@Override
	public void sayIsHaveFreeHookahRoom() {
		LOGGER.log(Level.INFO, this.toString() + ": Do you have a free hookah room?");
	}

	private void initArrayClients(int numberClients) {
		this.clients = new Client[numberClients];
		for (int i = 0; i < this.clients.length; i++) {
			this.clients[i] = new Client();
		}
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Long.hashCode(countId);
		result = result * PRIME + Long.hashCode(this.id);
		result = result * PRIME + (this.clients != null ? this.clients.hashCode() : 1);
		result = result * PRIME + (this.hookahBar != null ? this.hookahBar.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!this.getClass().equals(object.getClass())) {
			return false;
		}
		GroupClientsImpl otherGroupClients = (GroupClientsImpl) object;
		if (this.id != otherGroupClients.id) {
			return false;
		}
		if (this.clients == null) {
			if (otherGroupClients.clients != null) {
				return false;
			}
		} else if (this.clients.length != otherGroupClients.clients.length) {
			return false;
		}
		if (this.hookahBar == null) {
			if (otherGroupClients.hookahBar != null) {
				return false;
			}
		} else if (this.hookahBar.equals(otherGroupClients.hookahBar)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GroupClients id: ").append(this.id).append(" with ").append(this.clients.length)
				.append(" clients");
		return builder.toString();
	}
}