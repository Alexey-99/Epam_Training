package by.koroza.shape.observer;

import by.koroza.shape.entity.Analytics;

public interface WarehouseObserver {

	public Analytics get(int key);

	public void add(int key, Analytics analytics);

	public Analytics remove(Object key);

	public boolean replace(Integer key, Analytics oldValue, Analytics newValue);

	public Analytics replace(Integer key, Analytics value);
}