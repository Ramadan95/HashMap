package ru.sberbank.labs.lab1;

import java.util.Random;

public class Children {
	private Random rand =	new Random();
	private int	a = 		rand.nextInt();
	private int b =			rand.nextInt();

	void say() {
		if (a > b) System.out.println("Мама!");
		else System.out.println("Папа!");
	}
}
