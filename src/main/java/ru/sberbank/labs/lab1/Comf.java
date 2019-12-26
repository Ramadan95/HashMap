package ru.sberbank.labs.lab1;

import java.rmi.MarshalException;
import java.util.Random;
import java.util.Timer;
import java.util.stream.Stream;

class Comf {
	// TODO
	private static final Person[] Nil = new Person[0];

	Person[] generatePerson() {
		// TODO
		// Этот экземпляр создается каждый раз при вызове метода. Непрактично и неудобно. Используй static.
		// Person[]	Nil = new Person[0];
		Person[]	person = new Person[100000];
		// TODO
		// Непрактичное использование памяти. Нет никакой необходимости сохранять эти данные в массиве.
		// я хотел видеть firstname = {"Иван", "Петр", ...} lastname = {"Иванов", "Петров", ...}
		// и случайный выбор из этих массивов
		String[] firstname = {"Константин", "Петр", "Никита", "Александр",
						"Кирилл", "Даниил", "Сергей", "Георгий", "Саша", "Герман"};
		String[]	lastname = {"Овчинников", "Ермаков", "Алексеев", "Шарапов",
				"Тимофеев", "Зюганов", "Матвеев", "Трифонов", "Федотов", "Афанасьев"};

		Random 		rand = new Random();
		Person[]	children;

//		// TODO перенести генерацию этих данных в место использования (см. выше)


		for (int i = 0; i < person.length; i++) {
			// TODO Хотелось бы чтоб детей было от 0 до 3
			children = new Person[rand.nextInt(10)];
			for (int j = 0; j < children.length; j++) {
				children[j] = new Person(rand.nextInt(10), firstname[rand.nextInt(10)], lastname[rand.nextInt(10)], Nil);
			}
			person[i] = new Person(getRandomNumberInRange(18 + children.length * 3, 60), firstname[rand.nextInt(10)], lastname[rand.nextInt(10)], children);
		}
		return person;
	}


	// TODO Крайне непрактичная реализация. Подумать и переделать.
	private int getRandomNumberInRange(int min, int max) {
//		return (int) (min + Math.random() * (max - min + 1));
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}

	public static void main(String[] args){

	}
}
