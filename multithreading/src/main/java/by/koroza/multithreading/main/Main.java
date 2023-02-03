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

import by.koroza.multithreading.entity.Campany;
import by.koroza.multithreading.entity.HookahBar;
import by.koroza.multithreading.entity.person.Client;

public class Main {

	public static void main(String[] args) {
		Client[] clients = new Client[1];
		System.out.println(clients.hashCode());
		Campany campany = new Campany("Stark Industry");
		campany.addEstablishment(new HookahBar());
		campany.addEstablishment(new HookahBar());
	}
}