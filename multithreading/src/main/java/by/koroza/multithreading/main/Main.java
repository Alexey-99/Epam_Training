/** Task. Многопоточность 
 * 
 * Требования  
 * ➢ Любая сущность, желающая получить доступ к разделяемому ресурсу, должна быть потоком. 
 * ➢ Программа должна использовать возможности синхронизации, поставляемые библиотеками java.util.concurrent, java.util.concurrent.atomic и java.util.concurrent.locks. 
 * ➢ Не использовать synchronized, volatile, а также BlockingQueue и другие ограниченно потокобезопасные коллекции. 
 * ➢ Классы и другие сущности приложения должны быть грамотно структурированы по пакетам и иметь отражающую их функциональность название. 
 * ➢ Использовать шаблон State для описания состояний объекта, если только этих состояний больше двух. 
 * ➢ Для создания потоков разрешается использовать по возможности Callable 
 * ➢ Запускать потоки с помощью ExecutorService. 
 * ➢ Вместо Thread.sleep использовать только возможности перечисления TimeUnit. 
 * ➢ Данные инициализации объектов считывать из файла. Данные в файле корректны. 
 * ➢ В приложении должен присутствовать потокобезопасный Singleton. При его создании запрещено использовать enum. 
 * ➢ Для записи логов использовать Log4J2. 
 * ➢ Разрешается для вывода работы потоков использовать метод main.  
 * 
 * Индивидуальные задания
 * Кальянная. 
 * Доступны несколько кальянов. Несколько посетителей (группа друзей) могут использовать один кальян. 
 * Кальян может использоваться одним посетителем. 
 * Группы друзей и одиночные посетители кому кальян не достался ожидают в очереди внутри помещения, а при недостатке мест, вне его.  
 * */

package by.koroza.multithreading.main;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.koroza.multithreading.entity.Campany;
import by.koroza.multithreading.entity.HookahBar;
import by.koroza.multithreading.entity.person.client.impl.GroupClientsImpl;
import by.koroza.multithreading.exception.CustomException;
import by.koroza.multithreading.generation.Generator;

public class Main {

	public static void main(String[] args) throws CustomException {
		Campany campany = createCampanyWithBars(1);
		createThreads(new Generator().generNumber(1, 15), campany);
	}

	private static Campany createCampanyWithBars(int numberHookahBars) throws CustomException {
		Campany campany = new Campany("Stark Industry");
		for (int i = 0; i < numberHookahBars; i++) {
			campany.addEstablishment(new HookahBar(new Generator().generNumber(1, 10)));
		}
		return campany;
	}

	private static void createThreads(int numberThreads, Campany campany) throws CustomException {
		List<GroupClientsImpl> threads = new ArrayList<>();
		for (int i = 0; i < numberThreads; i++) {
			threads.add(new GroupClientsImpl(new Generator().generNumber(1, 20),
					(HookahBar) campany.getEstablishments().get(0)));
		}
		System.out.println(
				"Number hookah rooms: " + ((HookahBar) campany.getEstablishments().get(0)).getHookahRooms().length);
		System.out.println("Number waiting places: "
				+ ((HookahBar) campany.getEstablishments().get(0)).getWaitingRoom().getMaxNumberPlaces());
		System.out.println("Number Group clients: " + threads.size() + "\n");
		ExecutorService service = Executors.newFixedThreadPool(threads.size());
		threads.forEach(group -> service.submit(group));
		service.shutdown();
	}
}