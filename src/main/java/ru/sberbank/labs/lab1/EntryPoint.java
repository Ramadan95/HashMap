package ru.sberbank.labs.lab1;

import java.util.*;

public class EntryPoint {

    public static void main(String[] args) {
    	Comf comf = new Comf();
        // 1. Реализуйте интерфейс Comparable в классе Person
//         2. Создайте массив Person размерностью 100_000
		Person[] person = new Person[100000];
        // 3. Сгенерируйте 100_000 экземпляров Person с помощью генератора случайных чисел
		Random rand = new Random();
        // Для случайной генерации строковых данных в читаемом виде можно использовать
        // предопределенные массивы строк firstname[] и lastname[]
        // 4. Поместите сгенерированные данные в массив
		// TODO
		// Никогда не объявляй переменные типом реализации при наличии низлежащего интерфейса
		// В Java это дурной тон
		// Зачем обернул Arrays.asList в ArrayList? В чем смысл этого действия? TODO Почему-то прочитал, что это по Т3 надо сделать
//		ArrayList<Person> arrayPerson = new ArrayList<>(Arrays.asList(comf.generatePerson()));

		person = comf.generatePerson();
//         5. Создайте массив Long размерностью 100_000
		int[] integers = new int[person.length];
        // 6. Сгенерируйте 100_000 уникальных случайных чисел в диапазоне (Long.MAX_VALUE, Long.MAX_VALUE)
		Set<Integer> setInt = new HashSet<>();
		while (setInt.size() != person.length) {
			setInt.add(comf.getRandomNumberInRange(Integer.MIN_VALUE, Integer.MAX_VALUE - 1));
		}

		int q = 0;
		for (Integer integer : setInt) {
			integers[q++] = integer;
		}
//        // Используйте Set<Integer> для обеспечения уникальности создаваемых чисел
//        // 7. Создайте экземпляры HashMap и TreMap
        Map<Integer, Person> hashMap = new HashMap<>(100000, 1);
        Map<Integer, Person> treeMap = new TreeMap<>();
//        // 8. Используя созданный массив Integer[] и Person[] поместите
//        // данные в созданные структуры, измерьте время, затраченное на запись данных для TreeMap и HashMap
		System.out.println("Start check time!");
		long m = System.currentTimeMillis();
		for (int j = 0; j < person.length; j++) {
			hashMap.put(integers[j], person[j]);
		}
		System.out.println("HashMap add time test: " + (double) (System.currentTimeMillis() - m));
		// TODO
		// Никогда не используй Date. Забудь что такой существует, взгляни на java.time или TODO done
		m = System.currentTimeMillis();
		for (int j = 0; j < person.length; j++) {
			treeMap.put(integers[j], person[j]);
		}
		System.out.println("TreeMap add time test: " + (double) (System.currentTimeMillis() - m));
		System.out.println("------------------------------------");
        // 9. Используя массив Integer[] извлеките данные из структур данных, измерьте время, затраченное на чтение
		m = System.currentTimeMillis();
		for (int j = 0; j < hashMap.size(); j++) {
			hashMap.get(integers[j]);
		}
		System.out.println(hashMap.size());
		System.out.println("HashMap read time test: " + (double) (System.currentTimeMillis() - m));

		m = System.currentTimeMillis();
		for (int j = 0; j < treeMap.size(); j++) {
			treeMap.get(integers[j]);
		}
		System.out.println("TreeMap read time test: " + (double) (System.currentTimeMillis() - m));

		System.out.println("------------------------------------");

		MyHashMap<Person> myHashMap = new MyHashMap<>();
		m = System.currentTimeMillis();
//		for (int j = 0; j < person.length; j++) {
//			myHashMap.put(integers[j], person[j]);
//		}
		System.out.println("MyHashMap add time test: " + (double) (System.currentTimeMillis() - m));

//		m = System.currentTimeMillis();
//		for (int j = 0; j < person.length; j++) {
//			myHashMap.get(integers[j]);
//		}
//		System.out.println("MyHashMap read time test: " + (double) (System.currentTimeMillis() - m));

		System.out.println("The end of time check!");
//		System.out.println(myHashMap.size());
//		for (int i = 0; i < person.length; i++) {
//			System.out.println(person[i]);
//		}

		Map<Integer, Person> hash = new HashMap<>();
//
		myHashMap.put(1, person[0]);
		myHashMap.put(1, person[1]);
		myHashMap.put(1, person[2]);
		myHashMap.put(1, person[3]);
		myHashMap.put(1, person[4]);
//
		hash.put(1, person[0]);
		hash.put(1, person[1]);
		hash.put(1, person[2]);
		hash.put(1, person[3]);
		hash.put(1, person[4]);
//
		for (int i = 0; i < 5; i++) {
			System.out.println(myHashMap.get(i));
		}
		System.out.println("------------------------------------");
		for (int i = 0; i < hash.size(); i++) {
			System.out.println(hash.get(i));
		}

        // 10. Улучшите показатели HashMap на запись, изучив доступные конструкторы HashMap
		// (Capacity:people.len, loadFactor:1) хеширование не произойдет
        // 11. Создайте свою собственную структуру данных, реализовав интерфейс IntMap
        // Изучите реализацию соответствующих методов в стандартной реализации HashMap, используйте их
        // как руководство к действию.
        // 12. Измерьте производительность созданной структуры данных.

        // P.S. Опционально: реализовать все измерительные процедуры в junit тестах

    }

}



























