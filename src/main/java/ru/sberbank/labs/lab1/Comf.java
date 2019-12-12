package ru.sberbank.labs.lab1;

import java.util.Random;

class Comf {
	// TODO
	public static final Person[] Nil = new Person[0];

	Person[] generatePerson() {
		// TODO
		// Этот экземпляр создается каждый раз при вызове метода. Непрактично и неудобно. Используй static.
		// Person[]	Nil = new Person[0];
		Person[]	person = new Person[100000];
		// TODO
		// Непрактичное использование памяти. Нет никакой необходимости сохранять эти данные в массиве.
		// я хотел видеть firstname = {"Иван", "Петр", ...} lastname = {"Иванов", "Петров", ...}
		// и случайный выбор из этих массивов
		String[]	firstname = new String[person.length];
		String[]	lastname = new String[person.length];

		Random 		rand = new Random();
		Person[]	children;

		// TODO перенести генерацию этих данных в место использования (см. выше)
		for (int i = 0; i < person.length; i++) {
			firstname[i] = "first" + rand.nextInt(1000000) + "name:" + i;
			lastname[i] = "last" + rand.nextInt(1000000) + "name:" + i;
		}

		for (int i = 0; i < person.length; i++) {
			// TODO Хотелось бы чтоб детей было от 0 до 3
			children = new Person[1];
			for (int j = 0; j < children.length; j++) {
				children[j] = new Person(rand.nextInt(10), "first" + rand.nextInt(1000000) + "name:" + i, "last" + rand.nextInt(1000000) + "name:" + i, Nil);
			}
			person[i] = new Person(rand.nextInt(), firstname[i], lastname[i], children);
		}
		return person;
	}

	// TODO Крайне непрактичная реализация. Подумать и переделать.
	int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
}
