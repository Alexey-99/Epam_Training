package by.koroza.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class HookahBar extends ChainHookahBars {
	private final List<Room> rooms = new ArrayList<>();

	public List<Room> getRooms() {
		return rooms;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + (rooms != null ? rooms.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		HookahBar hookahBar = (HookahBar) object;
		if (rooms == null) {
			if (hookahBar.rooms != null) {
				return false;
			}
		} else if (!this.rooms.equals(hookahBar.rooms)) {
			return false;
		}
		return true;
	}
}