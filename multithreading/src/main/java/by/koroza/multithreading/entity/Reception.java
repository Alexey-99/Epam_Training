package by.koroza.multithreading.entity;

import by.koroza.multithreading.entity.person.employees.Receptionist;

public class Reception {
	private Receptionist receptionist;
	private Computer computer;

	public Reception(Receptionist receptionist, Computer computer) {
		this.receptionist = receptionist;
		this.computer = computer;
	}

	public Receptionist getReceptionist() {
		return receptionist;
	}

	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (this.receptionist != null ? this.receptionist.hashCode() : 1);
		result = PRIME * result + (this.computer != null ? this.computer.hashCode() : 1);
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
		Reception otherReception = (Reception) object;
		if (this.receptionist == null) {
			if (otherReception.receptionist != null) {
				return false;
			}
		} else if (!this.receptionist.equals(otherReception.receptionist)) {
			return false;
		}
		if (this.computer == null) {
			if (otherReception.computer != null) {
				return false;
			}
		} else if (!this.computer.equals(otherReception.computer)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reception [receptionist=");
		builder.append(this.receptionist);
		builder.append(", computer=");
		builder.append(this.computer);
		builder.append("]");
		return builder.toString();
	}
}