package ru.sberbank.labs.lab1;

import java.util.*;

public class EntryPoint {

    public static void main(String[] args) {
    	Comf comf = new Comf();
    	int size = 100000;
        // 1. Реализуйте интерфейс Comparable в классе Person
		// 2. Создайте массив Person размерностью 100_000
		Person[] person;
        // 3. Сгенерируйте 100_000 экземпляров Person с помощью генератора случайных чисел
		Random rand = new Random();
        // Для случайной генерации строковых данных в читаемом виде можно использовать
        // предопределенные массивы строк firstname[] и lastname[]
        // 4. Поместите сгенерированные данные в массив
		person = comf.generatePerson(size);
//         5. Создайте массив Long размерностью 100_000
		int[] integers = comf.generateIntegers(size);
        // 6. Сгенерируйте 100_000 уникальных случайных чисел в диапазоне (Long.MAX_VALUE, Long.MAX_VALUE)
//		done in #5
        // 7. Создайте экземпляры HashMap и TreMap
        Map<Integer, Person> hashMap = new HashMap<>(size, 1);
        Map<Integer, Person> treeMap = new TreeMap<>();
        // 8. Используя созданный массив Integer[] и Person[] поместите
        // данные в созданные структуры, измерьте время, затраченное на запись данных для TreeMap и HashMap
		System.out.println("Start check time!");
		long m = System.currentTimeMillis();
		for (int j = 0; j < person.length; j++) {
			hashMap.put(integers[j], person[j]);
		}
		// TODO в чем смысл приведения к double // Опечатка
		System.out.println("HashMap add time test: " + (System.currentTimeMillis() - m));

		m = System.currentTimeMillis();
		for (int j = 0; j < person.length; j++) {
			treeMap.put(integers[j], person[j]);
		}
		System.out.println("TreeMap add time test: " + (System.currentTimeMillis() - m));
		System.out.println("------------------------------------");
        // 9. Используя массив Integer[] извлеките данные из структур данных, измерьте время, затраченное на чтение
		m = System.currentTimeMillis();
		for (int j = 0; j < hashMap.size(); j++) {
			hashMap.get(integers[j]);
		}
		System.out.println("HashMap read time test: " + (System.currentTimeMillis() - m));

		m = System.currentTimeMillis();
		for (int j = 0; j < treeMap.size(); j++) {
			treeMap.get(integers[j]);
		}
		System.out.println("TreeMap read time test: " + (System.currentTimeMillis() - m));

		System.out.println("------------------------------------");
        // 10. Улучшите показатели HashMap на запись, изучив доступные конструкторы HashMap
		// (Capacity:people.len, loadFactor:1) хеширование не произойдет
        // 11. Создайте свою собственную структуру данных, реализовав интерфейс IntMap
        // Изучите реализацию соответствующих методов в стандартной реализации HashMap, используйте их
        // как руководство к действию.
		MyHashMap<Person> myHashMap = new MyHashMap<>();
		m = System.currentTimeMillis();
		for (int j = 0; j < person.length; j++) {
			myHashMap.put(integers[j], person[j]);
		}
		System.out.println("MyHashMap add time test: " + (System.currentTimeMillis() - m));

		m = System.currentTimeMillis();
		for (int j = 0; j < person.length; j++) {
			myHashMap.get(integers[j]);
		}
		System.out.println("MyHashMap read time test: " + (System.currentTimeMillis() - m));
        // 12. Измерьте производительность созданной структуры данных.
		System.out.println("The end of time check!");
        // P.S. Опционально: реализовать все измерительные процедуры в junit тестах
    }
}



























