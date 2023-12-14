package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.Coord;
import logic.Map;

public class MapTest {
	//#TODO: metodi private
	//#TODO: Unit Name Convention
	
	
	@Test
	public void testBfsEmptyMatrix() {
		Map a = new Map(3, 3);
		int [][] map = new int [3][3];
		
		List<Coord> visited = new ArrayList<Coord>();
		Coord n1 = new Coord(1, 0);
		Coord n2 = new Coord(2, 0);
		Coord n3 = new Coord(0, 2);
		Coord n4 = new Coord(0, 1);
		
		Coord n5 = new Coord(1, 1);
		Coord n6 = new Coord(1, 2);
		Coord n7 = new Coord(2, 2);
		Coord n8 = new Coord(2, 1);
		
		visited.add(n1);
		visited.add(n2);
		visited.add(n3);
		visited.add(n4);
		
		visited.add(n5);
		visited.add(n6);
		visited.add(n7);
		visited.add(n8);
		
		a.setMap(map);
		List<Coord> visitedResult =a.bfs(new Coord(0, 0));
		
		assertTrue(visitedResult.size()==9);
		assertTrue(visitedResult.containsAll(visited));
	}
	
	@Test
	public void testBfsInvalidMatrix() {
		int [][] map = new int [3][3];
		map[1][0]= -1;
		map[0][1]= -1;
		map[1][2]= -1;
		map[2][1]= -1;
		
		Coord init = new Coord(1, 1);
		
		Map a = new Map(3, 3);
		a.setMap(map);
		List<Coord> visitedResult =a.bfs( new Coord(0, 0));
		assertTrue(visitedResult.size()==4);
	}
	
	
	@Test
	public void testCreateObs() {
		Map a = new Map(3, 3);
		a.createMap(3,3);
	}
	
	@Test
	public void testCreateMap() {
		Map a = new Map(3,4);
		assertEquals(3, a.getMap().length);
		assertEquals(4, a.getMap()[0].length);
	}
	
	@Test
	public void testValidNeighbors(){
		//#TODO: controllare bfs dentro della classe mapa
		int [][] map = new int [3][3];
		Coord zero = new Coord(0, 0);
		
		List<Coord> neighborsZero = new ArrayList<Coord>();
		Coord zeroNeighborsRigth = new Coord(1, 0);
		Coord zeroNeighborsLeft = new Coord(2, 0);
		Coord zeroNeighborsUp = new Coord(0, 2);
		Coord zeroNeighborsDown = new Coord(0, 1);
		
		neighborsZero.add(zeroNeighborsRigth);
		neighborsZero.add(zeroNeighborsLeft);
		neighborsZero.add(zeroNeighborsDown);
		neighborsZero.add(zeroNeighborsUp);
		
		Map a = new Map(3, 3);
		a.setMap(map);
		assertTrue(a.validNeighbors(zero).containsAll(neighborsZero));
		
	}
	
	@Test
	public void testValidNeighborsWithObs(){
		//#TODO: controllare bfs dentro della classe mapa
		int [][] map = new int [3][3];
		map[1][0]= -1;
		map[0][1]= -1;
		map[1][2]= -1;
		map[2][1]= -1;
		
		Coord init = new Coord(1, 1);
		
		Map a = new Map(3, 3);
		a.setMap(map);
		assertTrue(a.validNeighbors(init).size()==0);
		
	}

}
