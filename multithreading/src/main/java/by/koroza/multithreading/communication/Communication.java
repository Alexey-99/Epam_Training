package by.koroza.multithreading.communication;

import java.util.concurrent.locks.Condition;

import by.koroza.multithreading.entity.Reception;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;
import by.koroza.multithreading.entity.room.HookahRoom;

public interface Communication {

	public HookahRoom communicationReceptionAndClients(Reception reception, GroupClientsImpl clients,
			Condition condition);

	public HookahRoom communicationHookahMakerAndClients(HookahRoom hookahRoom, GroupClientsImpl clients);
}
