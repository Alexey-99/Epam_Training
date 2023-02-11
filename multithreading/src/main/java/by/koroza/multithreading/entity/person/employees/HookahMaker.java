/** actions persons
 * 1) hookah room preparation
 * 2) hookah preparation
 * 3) hookah room cleaning
 * */

package by.koroza.multithreading.entity.person.employees;

public interface HookahMaker {

	public void hookahRoomPreparation() throws InterruptedException;

	public void hookahPreparation() throws InterruptedException;

	public void hookahRoomCleaning() throws InterruptedException;

	public int hashCode();

	public boolean equals(Object object);

	public String toString();

}