package by.koroza.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.multithreading.entity.abstraction.AbstractEstablishment;

public class Campany {
	private String name;
	private List<AbstractEstablishment> establishments;

	public Campany(String name) {
		this.name = name;
		this.establishments = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbstractEstablishment> getEstablishments() {
		return establishments;
	}

	public void addEstablishment(AbstractEstablishment stablishment) {
		this.establishments.add(stablishment);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.name != null ? this.name.hashCode() : 1);
		result = result * PRIME + (this.establishments != null ? this.establishments.hashCode() : 1);
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
		Campany otherCampany = (Campany) object;
		if (this.name == null) {
			if (otherCampany.name != null) {
				return false;
			}
		} else if (!this.name.equals(otherCampany.name)) {
			return false;
		}
		if (this.establishments == null) {
			if (otherCampany.establishments != null) {
				return false;
			}
		} else if (!this.establishments.equals(otherCampany.establishments)) {

		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Campany [name=");
		builder.append(this.name);
		builder.append(", establishments=");
		builder.append(this.establishments);
		builder.append("]");
		return builder.toString();
	}
}