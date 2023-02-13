package HW1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MainClass {
	public static void main(String[] args) {

		// Создаем массив и заполняем его
		Player players[] = new Player[12];
		players[0] = new Player ("Karim Benzema", "Real Madrid", 185, 35);
		players[1] = new Player ("Sadio Mane", "Bayern Munich", 174, 30);
		players[2] = new Player ("Kevin De Bruyne", "Manchester City", 181, 31);
		players[3] = new Player ("Robert Lewandowski", "Barcelona", 185, 34);
		players[4] = new Player ("Mohamed Salah", "Liverpool", 175, 30);
		players[5] = new Player ("Kylian Mbappe", "Paris Saint-Germain", 178, 24);
		players[6] = new Player ("Thibaut Courtois", "Real Madrid", 200, 30);
		players[7] = new Player ("Vinicius Junior", "Real Madrid", 176, 22);
		players[8] = new Player ("Luka Modric", "Real Madrid", 172, 37);
		players[9] = new Player ("Erling Haaland", "Manchester City", 195, 22);
		players[10] = new Player ("Son Heung-min", "Tottenham Hotspur", 183, 30);
		players[11] = new Player ("Riyad Mahrez", "Manchester City", 179, 31);
				
		// Сортировка
		sortArray(players, 1);

		// Вывод в консоль заголовков	
		players[0].printTitlesToConsole();
		for (Player player : players) {			
			player.print();
		}

		// Запись в файл		
		try {
			PrintStream out = new PrintStream(new File("C:/Users/mail4/Desktop/players.txt"));
			players[0].printTitlesToFile(out);
			for (Player player : players) {
				player.printToFile(out);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}	
		
	}
	
	// Описание метода сортировки массива по возрасту (по возрастанию)	
	private static void sortArray(Player[] players, int column) {		
		for (int i=0; i < players.length; i++) {
			int j_max = i;
			for (int j = i+1; j < players.length; j++) {
				// Если 2-й параметр в функции равен 4, то сортируем по 4-й колонке (возрасту)				
				if ((column == 4) & (players[j_max].age> players[j].age)) {
					j_max = j;
				}
				// Если 2-й параметр в функции равен 3, то сортируем по 3-й колонке (росту)
				else if ((column == 3) &  (players[j_max].height> players[j].height)) {
					j_max = j;
				}
				// Если 2-й параметр в функции равен 2, то сортируем по 2-й колонке (клубу)
				else if (column == 2) {
					// Находим длину наименьшего названия команды
					int i1 = Math.min(players[j_max].club.length(), players[j].club.length());
					for (int k=0; k < i1; k++) {
						if ((int) (players[j_max].club.charAt(k)) > (int) (players[j].club.charAt(k))) {
							j_max = j;
							k = i1;
						}	
						else if ((int) (players[j_max].club.charAt(k)) < (int) (players[j].club.charAt(k))) {
							k = i1;
						}
					}
				}
				
				// Если 2-й параметр в функции равен 1, то сортируем по 1-й колонке (имени)
				else if (column == 1) {
					// Находим длину наименьшего названия команды
					int i1 = Math.min(players[j_max].name.length(), players[j].name.length());
					for (int k=0; k < i1; k++) {
						if ((int) (players[j_max].name.charAt(k)) > (int) (players[j].name.charAt(k))) {
							j_max = j;
							k = i1;
						}	
						else if ((int) (players[j_max].name.charAt(k)) < (int) (players[j].name.charAt(k))) {
							k = i1;
						}
					}
				}
			}
			
			Player temp = players[i];
			players[i] = players[j_max];
			players[j_max] = temp;
		}
	}

}
