package util;

/**
 * Numero de programa: 8
*  Nombre de autor: Gustavo Canul Poot
*  Fecha de inicio de programa 27/04/2014
*  Descripcion del programa.Node para una lista ligada
*/
public class Node {
	
	private double firstData;
	private double secondData;
	private double thirdData;
	private double fourData;
	private Node nextNode;

	Node (double firstData , double secondData , double thirdData , double fourData ){
		this.firstData = firstData;
		this.secondData = secondData;
		this.thirdData = thirdData;
		this.fourData = fourData;
		this.nextNode = null;
	}

	public Node(double insertItem, double secondData, double thirdData , double fourData, Node node) {
		this.firstData = insertItem;
		this.secondData = secondData;
		this.thirdData = thirdData;
		this.fourData = fourData;
        this.nextNode = node;
	}

	public double getSecondData() {
		return secondData;
	}

	public void setSecondData(double secondData) {
		this.secondData = secondData;
	}

	public double getFirstData() {
		return firstData;
	}

	public void setFirstData(double data) {
		this.firstData = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public double getThirdData() {
		return thirdData;
	}

	public void setThirdData(double thirdData) {
		this.thirdData = thirdData;
	}

	public double getFourData() {
		return fourData;
	}

	public void setFourData(double fourData) {
		this.fourData = fourData;
	}
	
}
