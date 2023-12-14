package logic;

import java.util.Random;

public class RandomPlayer implements IPlayer {

	@Override
	public int play(int[][] Map,  Coord head) {
		//riceve il input
		Random r = new Random();
		return r.nextInt(4);
	}
}
