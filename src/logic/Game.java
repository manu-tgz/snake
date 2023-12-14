package logic;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class Game {
	private Map gameMap;
	private Snake snake;
	private Egg egg;
	private IPlayer player;
	private int lastMove;
	private boolean end;

	private int count;
	static final int SNAKEVALUE = -2;

	public Game() {
		startGame();
	}

	public Map getGameMap() {
		return gameMap;
	}

	public Snake getSnake() {
		return snake;
	}

	private void startGame() {
		player = new PersonPlayer();
		createMap(5, 5);
		count = 0;
		createSnake();
		createEgg();
	}

	private boolean endGame() {
		return end;
	}

	public void init() {
		printMatrix(gameMap.getMap());
		while (!endGame()) {
			int move = player.play(gameMap.getMap(), snake.getHead());
			Coord nextHead = move(move, snake.getHead());

			if ((lastMove != move) && (lastMove + move) % 2 == 0) {
				nextHead = move(lastMove, snake.getHead());
			}

			switch (matrixValue(nextHead)) {
			case 0:
				gameMap.setValue(snake.getQueue(), 0);
				snake.AddBodyAndRemove(nextHead);
				gameMap.setValue(nextHead, -2);
				break;
			case -1:
				end = true;
				break;
			case -2:
				end = true;
				break;
			default:
				snake.AddBody(nextHead);
				gameMap.setValue(nextHead, -2);
				if (gameMap.freeCoord() == null) {
					end = true;
					break;
				}
				createEgg();
			}
			lastMove = move;
			printMatrix(gameMap.getMap());
		}
		// Chiama al giocatori per fare il primo movimento.
	}

	public void printMatrix(int[][] map) {
		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}

	public void createMap(int x, int y) {
		gameMap = new Map(5, 5);
		gameMap.createMap(5, 5);
	}

	private int matrixValue(Coord coord) {
		// torna il valore della coordenata nella matrice
		return gameMap.getMap()[coord.x][coord.y];
	}

	public Coord move(int nextMove, Coord head) {
		switch (nextMove) {
		case 0:
			return new Coord(gameMap.CircleCoord(head.x, -1, gameMap.getMap().length), head.y);

		case 1:
			return new Coord(head.x, gameMap.CircleCoord(head.y, +1, gameMap.getMap()[0].length));

		case 2:
			return new Coord(gameMap.CircleCoord(head.x, +1, gameMap.getMap().length), head.y);

		case 3:
			return new Coord(head.x, gameMap.CircleCoord(head.y, -1, gameMap.getMap()[0].length));

		default:
			return move(lastMove, head);
		}
	}

	public Egg getEgg() {
		return egg;
	}

	public void createEgg() {
		// Coord eggCoord = gameMap.RandomFreeCoord();
		Coord eggCoord = gameMap.freeCoord();
		egg = new Egg(eggCoord);
		gameMap.setValue(egg.coord, egg.value);
	}

	public void createSnake() {
		snake = new Snake();
		// createHead
		Coord head = gameMap.freeCoord();
		snake.AddBody(head);
		gameMap.setValue(head, SNAKEVALUE);
	}
}
