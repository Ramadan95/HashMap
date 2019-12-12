package ru.sberbank.labs.lab1;

import java.util.Random;

public class Children {
	private String	name;
	private int		age;

	public Children(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void say() {
		Random rand =	new Random();
		int	a = 		rand.nextInt();
		int b =			rand.nextInt();

		if (a > b) System.out.println("Мама!");
		else System.out.println("Папа!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
