package ru.sberbank.labs.lab1;

import java.util.Random;

class Comf {

	private static final Person[] Nil = new Person[0];

	private static final String[] firstname = {"Константин", "Петр", "Никита", "Александр",
			"Кирилл", "Даниил", "Сергей", "Георгий", "Саша", "Герман"};
	private static final String[]	lastname = {"Овчинников", "Ермаков", "Алексеев", "Шарапов",
			"Тимофеев", "Зюганов", "Матвеев", "Трифонов", "Федотов", "Афанасьев"};

	private static final Random rand = new Random();

	Person[] generatePerson(int size) {
		Person[] person = new Person[size];
		for (int i = 0; i < person.length; i++) {
			Person[] children = new Person[rand.nextInt(10)];
			for (int j = 0; j < children.length; j++) {
				children[j] = new Person(rand.nextInt(10), firstname[rand.nextInt(10)], lastname[rand.nextInt(10)], Nil);
			}
			person[i] = new Person(getRandomNumberInRange(18 + children.length * 3, 60), firstname[rand.nextInt(10)], lastname[rand.nextInt(10)], children);
		}
		return person;
	}

	private int getRandomNumberInRange(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
