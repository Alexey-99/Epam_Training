package by.koroza.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;

public class WaitingAreaOutSideBar {
	private List<GroupClientsImpl> clients;

	public WaitingAreaOutSideBar() {
		this.setClients(new ArrayList<>());
	}

	public List<GroupClientsImpl> getClients() {
		return clients;
	}

	public void setClients(List<GroupClientsImpl> clients) {
		this.clients = clients;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.clients != null ? this.clients.hashCode() : 1);
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
		WaitingAreaOutSideBar otherWaitingAreaOutSideBar = (WaitingAreaOutSideBar) object;
		if (this.clients == null) {
			if (otherWaitingAreaOutSideBar.clients != null) {
				return false;
			}
		} else if (!this.clients.equals(otherWaitingAreaOutSideBar.clients)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WaitingAreaOutSideBar [clients=");
		builder.append(clients);
		builder.append("]");
		return builder.toString();
	}
}