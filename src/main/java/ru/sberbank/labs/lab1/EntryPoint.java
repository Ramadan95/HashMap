package ru.sberbank.labs.lab1;

import java.sql.Array;
import java.sql.Time;
import java.util.*;

public class EntryPoint {

    public static void main(String[] args) {
    	Comf comf = new Comf();
        // 1. Реализуйте интерфейс Comparable в классе Person
		// DONE
        // 2. Создайте массив Person размерностью 100_000
		//Person[] person = new Person[100000];
        // 3. Сгенерируйте 100_000 экземпляров Person с помощью генератора случайных чисел
		Random rand = new Random();
        // Для случайной генерации строковых данных в читаемом виде можно использовать
        // предопределенные массивы строк firstname[] и lastname[]
        // 4. Поместите сгенерированные данные в массив
		ArrayList<Person> arrayPerson = new ArrayList<Person>(Arrays.asList(comf.generatePerson()));
//         5. Создайте массив Long размерностью 100_000
		int[] integers = new int[arrayPerson.size()];
        // 6. Сгенерируйте 100_000 уникальных случайных чисел в диапазоне (Long.MAX_VALUE, Long.MAX_VALUE)
		Set<Integer> setInt = new HashSet<>(integers.length);
		while (setInt.size() != arrayPerson.size()) {
			setInt.add(comf.getRandomNumberInRange(Integer.MIN_VALUE, Integer.MAX_VALUE - 1));
		}

		int q = 0;
		for (Integer integer : setInt) {
			integers[q++] = integer;
		}
//        // Используйте Set<Integer> для обеспечения уникальности создаваемых чисел
//        // 7. Создайте экземпляры HashMap и TreMap
        Map<Integer, Person> hashMap = new HashMap<Integer, Person>(100001, 1);
        Map<Integer, Person> treeMap = new TreeMap<>();
//        // 8. Используя созданный массив Integer[] и Person[] поместите
//        // данные в созданные структуры, измерьте время, затраченное на запись данных для TreeMap и HashMap
		Date currentDate = new Date();
		for (int j = 0; j < arrayPerson.size(); j++) {
			hashMap.put(integers[j], arrayPerson.get(j));
		}
		System.out.println("Start check time!");
		System.out.println("------------------------------------");
		Date afterDate = new Date();
		System.out.println("HashMap add time:" + (afterDate.getTime() - currentDate.getTime()));

		currentDate = new Date();
		for (int j = 0; j < arrayPerson.size(); j++) {
			treeMap.put(integers[j], arrayPerson.get(j));
		}
		afterDate = new Date();
		System.out.println("TreeMap add time:" + (afterDate.getTime() - currentDate.getTime()));
		System.out.println("------------------------------------");
        // 9. Используя массив Integer[] извлеките данные из структур данных, измерьте время, затраченное на чтение
		currentDate = new Date();
		for (int j = 0; j < hashMap.size(); j++) {
			hashMap.get(integers[j]);
		}
		afterDate = new Date();
		System.out.println("HashMap read time:" + (afterDate.getTime() - currentDate.getTime()));

		currentDate = new Date();
		for (int j = 0; j < treeMap.size(); j++) {
			treeMap.get(integers[j]);
		}
		afterDate = new Date();
		System.out.println("TreeMap read time:" + (afterDate.getTime() - currentDate.getTime()));

		System.out.println("------------------------------------");

		MyHashMap<Integer, Person> myHashMap = new MyHashMap<Integer, Person>();

		currentDate = new Date();
		for (int j = 0; j < arrayPerson.size(); j++) {
			myHashMap.put(integers[j], arrayPerson.get(j));
		}
		afterDate = new Date();
		System.out.println("MyHashMap add time:" + (afterDate.getTime() - currentDate.getTime()));
		System.out.println("------------------------------------");
		System.out.println("The end of time check!");

        // 10. Улучшите показатели HashMap на запись, изучив доступные конструкторы HashMap
		// (Capacity:100001, loadFactor:1) хеширование не произойдет
        // 11. Создайте свою собственную структуру данных, реализовав интерфейс IntMap
        // Изучите реализацию соответствующих методов в стандартной реализации HashMap, используйте их
        // как руководство к действию.
        // 12. Измерьте производительность созданной структуры данных.

        // P.S. Опционально: реализовать все измерительные процедуры в junit тестах

    }

}

