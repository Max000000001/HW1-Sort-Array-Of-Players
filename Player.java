package HW1;

import java.io.PrintStream;

public class Player {
	// Задаем поля класса
	String name;
	String club;
	int height;
	int age;
	
	// Описание конструктора	
	public Player(String name, String club, int height, int age) {
		this.name = name;
		this.club = club;
		this.height = height;
		this.age = age;
	}

	// Описание функции вывода заголовков в консоль
	void printTitlesToConsole() {
		System.out.printf("%20s %20s %10s %10s", "NAME", "CLUB", "HEIGHT", "AGE");
	}	
	
	// Описание функции вывода данных в консоль	
	void print() {
		System.out.printf("\n%20s %20s %10s %10s", name, club, height, age);
	}

	// Описание функции вывода заголовков в файл	
	void printTitlesToFile(PrintStream stream) {
		stream.printf("%20s %20s %10s %10s", "NAME", "CLUB", "HEIGHT", "AGE");
	}

	// Описание функции вывода данных в файл
	void printToFile(PrintStream stream) {
		stream.printf("\n%20s %20s %10s %10s", name, club, height, age);
	}
	
}


