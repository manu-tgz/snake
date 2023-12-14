package logic;

import java.util.Scanner;

public class PersonPlayer implements IPlayer {
	@Override
	public int play(int[][] Map, Coord head) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0-3");
		return scanner.nextInt();

	}

}
