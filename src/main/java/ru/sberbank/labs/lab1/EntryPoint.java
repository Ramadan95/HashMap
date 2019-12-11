package ru.sberbank.labs.lab1;

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
		System.out.println("Good");
		System.out.println(arrayPerson.get(9));
		System.out.println(arrayPerson.size());
//        // 5. Создайте массив Long размерностью 100_000
//		int[] integers = new int[100000];
//        // 6. Сгенерируйте 100_000 уникальных случайных чисел в диапазоне (Long.MAX_VALUE, Long.MAX_VALUE)
//		Set<Integer> setInt = new HashSet<Integer>();
//		int randomGen = (int) (Math.random() * (Integer.MAX_VALUE) - Integer.MIN_VALUE);
//		while (setInt.size() < 100000) {
//			setInt.add(randomGen);
//		}
//		Iterator<Integer> i = setInt.iterator();
//		int q = 0;
//		while (i.hasNext()) {
//			integers[q++] = i.next();
//		}
//        // Используйте Set<Integer> для обеспечения уникальности создаваемых чисел
//        // 7. Создайте экземпляры HashMap и TreMap
//        Map<Integer, Person> hashMap = new HashMap<>();
//        Map<Integer, Person> treeMap = new TreeMap<>();
//        // 8. Используя созданный массив Integer[] и Person[] поместите
//        // данные в созданные структуры, измерьте время, затраченное на запись данных для TreeMap и HashMap
//		Date currentDate = new Date();
//		for (int j = 0; j < 100000; j++) {
//			hashMap.put(integers[j], arrayPerson.get(j));
//		}
//		Date afterDate = new Date();
//		System.out.println("HashMap add time:" + (afterDate.getTime() - currentDate.getTime()));
//
//		currentDate = new Date();
//		for (int j = 0; j < 100000; j++) {
//			treeMap.put(integers[j], arrayPerson.get(j));
//		}
//		afterDate = new Date();
//		System.out.println("TreeMap add time:" + (afterDate.getTime() - currentDate.getTime()));
//        // 9. Используя массив Integer[] извлеките данные из структур данных, измерьте время, затраченное на чтение
//		currentDate = new Date();
//		for (int j = 0; j < hashMap.size(); j++) {
//			hashMap.get(integers[j]);
//		}
//		afterDate = new Date();
//		System.out.println("HashMap read time:" + (afterDate.getTime() - currentDate.getTime()));
//
//		currentDate = new Date();
//		for (int j = 0; j < treeMap.size(); j++) {
//			treeMap.get(integers[j]);
//		}
//		afterDate = new Date();
//		System.out.println("TreeMap read time:" + (afterDate.getTime() - currentDate.getTime()));
//        // 10. Улучшите показатели HashMap на запись, изучив доступные конструкторы HashMap
//        // 11. Создайте свою собственную структуру данных, реализовав интерфейс IntMap
//        // Изучите реализацию соответствующих методов в стандартной реализации HashMap, используйте их
//        // как руководство к действию.
//        // 12. Измерьте производительность созданной структуры данных.
//
//        // P.S. Опционально: реализовать все измерительные процедуры в junit тестах

    }

}

