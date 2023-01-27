package by.koroza.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class ChainHookahBars {
	private static final String STRING_ID = "ID: ";
	private static long countId = 1;
	private long id;
	private static final List<ChainHookahBars> hookahBars = new ArrayList<>();

	public ChainHookahBars() {
		this.id = countId++;
		hookahBars.add(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Long.hashCode(countId);
		result = result * PRIME + Long.hashCode(this.id);
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
		ChainHookahBars otherChainHookahBars = (ChainHookahBars) object;
		if (this.id != otherChainHookahBars.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_ID).append(this.getId());
		return builder.toString();
	}
}