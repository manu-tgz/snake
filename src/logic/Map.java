package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Map {
	private int[][] Map;

	public Map(int x, int y) {
		Map = new int[x][y];
	}
	public int[][] getMap() {
		return Map;
	}

	public void setMap(int[][] map) {
		Map = map;
	}
	
	public void createMap(int x, int y) {
		createObs();
	}
	public void setValue(Coord v, int value) {
		Map[v.x][v.y] = value;
	}
	private void createObs() {
		int count = 0;
		int numObs = (Map.length * Map[0].length * 3) / 10;
		while (count < numObs) {
			Coord temp = RandomCoord();;
			do {
				temp = RandomCoord();
			} while (!isValidMap(temp, count));
			if(temp !=null) {
				Map[temp.x][temp.y] = -1;	
				count+=1;
			}
		}
	}
	public Coord RandomCoord() {
		Random r = new Random();
		return new Coord(r.nextInt(Map.length), r.nextInt(Map[0].length - 1));
	}
	
	public Coord RandomFreeCoord() {
		Coord temp;
		do {
			temp = RandomCoord();
		} while (isValidCoord(temp));
		
		return temp;
	}
	
	public ArrayList<Coord> bfs(Coord node ){
		ArrayList<Coord> visited = new ArrayList<Coord>();
		LinkedList<Coord> queue = new LinkedList<Coord>();
		queue.add(node);
		visited.add(node);
		
		while (!queue.isEmpty()) {
			Coord v = queue.pop();
			
			ArrayList<Coord> neighbors = validNeighbors(v);
			for (Coord coord : neighbors) {
				if(!visited.contains(coord)) {
					queue.add(coord);
					visited.add(coord);
				}
			}
		}
		return visited;		
	}

	private boolean mapIsValid(Coord temp, int count) {
		
		Map[temp.x][temp.y] = -1;
		ArrayList<Coord> visited = bfs(freeCoord());
		Map[temp.x][temp.y] = 0;
		
		return Map.length * Map[0].length == (visited.size()+count+1);
	}

	public ArrayList<Coord> validNeighbors(Coord v) {
		int[] neighborsX = { -1, 0, 1, 0 };
		int[] neighborsY = { 0, -1, 0, 1 };
		ArrayList<Coord> neighbors = new ArrayList<Coord>();
		for (int i = 0; i < neighborsY.length; i++) {
			Coord temp = new Coord((v.x + neighborsX[i] + Map.length) % Map.length, (v.y + neighborsY[i] + Map[0].length) % Map[0].length);
			if (isValidCoord(temp)) {
				neighbors.add(temp);
			}
		}
		return neighbors;
	}

	public int CircleCoord(int currentPosition, int move, int lenght) {
		return (currentPosition + move + lenght)%lenght;
		
	}
	
	public Coord freeCoord() {
		for (int i = 0; i < Map.length; i++) {
			for (int j = 0; j < Map[0].length; j++) {
				if (Map[i][j] == 0) {
					return new Coord(i, j);
				}
			}
		}
		return null;
	}
	private boolean isValidMap(Coord temp, int  count) {

		return isValidCoord(temp) && (count<0 || mapIsValid(temp, count));
	}
	private boolean isValidCoord(Coord temp) {
		//Exception out of bounds
		return Map[temp.x][temp.y] == 0;
	}

}
