package logic;

import java.util.LinkedList;

public class Snake {
private LinkedList <Coord> body ;

public Snake() {
	body = new LinkedList<Coord>();
}

public void AddBody(Coord v){
	this.setHead(v);
}

public void AddBodyAndRemove(Coord v){
	body.removeLast();
	this.setHead(v);
}

public LinkedList <Coord> getBody() {
	return body;
}

public Coord getHead() {
	return body.get(0);
}
public Coord getQueue() {
	return body.get(body.size()-1);
}

private void setHead(Coord head) {
	body.addFirst(head);
}
}
