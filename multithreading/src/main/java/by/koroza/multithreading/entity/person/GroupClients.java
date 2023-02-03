package by.koroza.multithreading.entity.person;

import java.util.Arrays;

public class GroupClients {
	private static long countId = 1;
	private long id;
	private Client[] clients;

	public GroupClients(int numberClients) {
		this.id = countId++;
		createArrayClients(numberClients);
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

	private void createArrayClients(int numberClients) {
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
		GroupClients otherGroupClients = (GroupClients) object;
		if (this.id != otherGroupClients.id) {
			return false;
		}
		if (this.clients == null) {
			if (otherGroupClients != null) {
				return false;
			}
		} else if (this.clients.length != otherGroupClients.clients.length) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GroupClients [id=");
		builder.append(id);
		builder.append(", clients=");
		builder.append(Arrays.toString(clients));
		builder.append("]");
		return builder.toString();
	}
}