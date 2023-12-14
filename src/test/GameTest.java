package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import logic.Game;

public class GameTest {

	@Test
	public void testCreateSnake() {
	//	Game game = new Game();
	//	game.createMap(5, 5);
	//	game.createSnake();

		//assertTrue(game.getSnake().getBody().size()==1);
	}
	
	@Test
	public void testCreateEgg() {
	//	Game game = new Game();
		//game.createMap(5, 5);
		//game.createSnake();
	//	game.createEgg();
	//	assertNotNull(game.getEgg());
	}
	
	@Test
	public void testGamei() {
		Game game = new Game();
		game.init();
	}

}
