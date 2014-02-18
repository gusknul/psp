package app;

/**
 * Numero de programa: 3
*  Nombre de autor: Gustavo Canul Poot
*  Fecha de inicio de programa 14/02/2014
*  Descripcion del programa. programa para calcular la regresion lineal y hallar predicciones de un conjunto de datos
*/
public class Node {
	
	private double firstData;
	private double secondData;
	private Node nextNode;

	Node (double data, double secondData){
		this.firstData = data;
		this.secondData = secondData;
		this.nextNode = null;
	}

	public Node(double insertItem, double secondData, Node node) {
		this.firstData = insertItem;
		this.secondData = secondData;
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
	
}
