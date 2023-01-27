package by.koroza.shape.entity;

import java.util.HashMap;
import java.util.Map;

import by.koroza.shape.observer.WarehouseObserver;

public class Warehouse implements WarehouseObserver {
	private static Warehouse instance;
	private static final Map<Integer, Analytics> ANALYSTS = new HashMap<>();

	public static Warehouse getInstance() {
		if (instance == null) {
			instance = new Warehouse();
		}
		return instance;
	}

	@Override
	public Analytics get(int key) {
		return ANALYSTS.get(key);
	}

	@Override
	public void add(int key, Analytics analytics) {
		ANALYSTS.put(key, analytics);
	}

	@Override
	public Analytics remove(Object key) {
		return ANALYSTS.remove(key);
	}

	@Override
	public boolean replace(Integer key, Analytics oldValue, Analytics newValue) {
		return ANALYSTS.replace(key, oldValue, newValue);
	}

	@Override
	public Analytics replace(Integer key, Analytics value) {
		return ANALYSTS.replace(key, value);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (ANALYSTS != null ? ANALYSTS.hashCode() : 1);
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
		if (!getClass().equals(object.getClass())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.append(ANALYSTS.toString()).toString();
	}
}