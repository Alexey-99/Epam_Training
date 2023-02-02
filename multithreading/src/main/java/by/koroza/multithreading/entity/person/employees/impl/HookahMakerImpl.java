package by.koroza.multithreading.entity.person.employees.impl;

import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.employees.HookahMaker;

public class HookahMakerImpl extends AbstractEmployees implements HookahMaker {

	public HookahMakerImpl() {

	}

	public HookahMakerImpl(String name) {
		super(name);
	}

	@Override
	public void hookahRoomPreparation() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hookahPreparation() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hookahRoomCleaning() {
		// TODO Auto-generated method stub
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		return null;
	}
}