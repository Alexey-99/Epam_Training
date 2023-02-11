package by.koroza.multithreading.entity.person.employees.impl;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.multithreading.entity.abstraction.AbstractEmployees;
import by.koroza.multithreading.entity.person.employees.HookahMaker;

public class HookahMakerImpl extends AbstractEmployees implements HookahMaker {
	private static final Logger LOGGER = LogManager.getLogger();

	public HookahMakerImpl() {

	}

	public HookahMakerImpl(String name) {
		super(name);
	}

	@Override
	public void hookahRoomPreparation() throws InterruptedException {
		LOGGER.log(Level.INFO, "Hookah marker preparations hookah room.");
		TimeUnit.SECONDS.sleep(10);

	}

	@Override
	public void hookahPreparation() throws InterruptedException {
		LOGGER.log(Level.INFO, "Hookah marker preparations hookah.");
		TimeUnit.SECONDS.sleep(8);
	}

	@Override
	public void hookahRoomCleaning() throws InterruptedException {
		LOGGER.log(Level.INFO, "Hookah marker cleaning hookah room");
		TimeUnit.SECONDS.sleep(10);
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