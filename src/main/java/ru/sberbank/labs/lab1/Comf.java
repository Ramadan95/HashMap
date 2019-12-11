package ru.sberbank.labs.lab1;

import java.util.Random;

public class Comf {
	private Person[]	person = new Person[100];
	private String[]	firstname = new String[100];
	private String[]	lastname = new String[100];
	private Random 		rand = new Random();

	void fillInfo() {
		for (int i = 0; i < firstname.length; i++) {
			firstname[i] = "first" + rand.nextInt(1000) + "name:" + i;
			lastname[i] = "last" + rand.nextInt(1000) + "name:" + i;
		}
	}

	Person[] generatePerson() {
		fillInfo();
		for (int i = 0; i < person.length; i++) {
			person[i] = new Person(rand.nextInt(), firstname[i], lastname[i], this.person);
		}
		return person;
	}
}
