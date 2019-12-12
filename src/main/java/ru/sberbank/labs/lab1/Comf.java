package ru.sberbank.labs.lab1;

import java.util.Random;

class Comf {

	Person[] generatePerson() {
		Person[]	Nil = new Person[0];
		Person[]	person = new Person[100000];
		String[]	firstname = new String[person.length];
		String[]	lastname = new String[person.length];
		Random 		rand = new Random();
		Person[]	children;

		for (int i = 0; i < person.length; i++) {
			firstname[i] = "first" + rand.nextInt(1000000) + "name:" + i;
			lastname[i] = "last" + rand.nextInt(1000000) + "name:" + i;
		}

		for (int i = 0; i < person.length; i++) {
			children = new Person[1];
			for (int j = 0; j < children.length; j++) {
				children[j] = new Person(rand.nextInt(10), "first" + rand.nextInt(1000000) + "name:" + i, "last" + rand.nextInt(1000000) + "name:" + i, Nil);
			}
			person[i] = new Person(rand.nextInt(), firstname[i], lastname[i], children);
		}
		return person;
	}

	int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
}
