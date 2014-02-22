package app;

/**
 * 
 * @author gustavo
 *
 */

public class Node {
	
	private double data;
	private Node nextNode;

	Node (double data){
		this.data = data;
		this.nextNode = null;
	}

	public Node(double insertItem, Node node) {
		this.data = insertItem;
        this.nextNode = node;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}
