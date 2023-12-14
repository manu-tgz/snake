package dataStructure;

public class Node<T> {
	private Node father;
	private Node son;
	private T value;
	
	public Node(Node father, T value) {
		this.father=father;
		this.value=value;
	}
	
	public Node getFather() {
		return father;
	}
	public void setFather(Node father) {
		this.father = father;
	}
	public Node getSon() {
		return son;
	}
	public void setSon(Node son) {
		this.son = son;
	}

	
}
