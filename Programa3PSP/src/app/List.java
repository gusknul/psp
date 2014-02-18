package app;
/**
 * Numero de programa: 3
*  Nombre de autor: Gustavo Canul Poot
*  Fecha de inicio de programa 14/02/2014
*  Descripcion del programa. programa para calcular la regresion lineal y hallar predicciones de un conjunto de datos
*/
public abstract class List {
	
	
	protected Node firstNode;
	protected Node lastNode;
	protected String name;
	
	public List(String name){
        this.name = name;
        this.firstNode = null;
        this.lastNode = null;
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List(){
		this("Lista ");
	}
	public boolean isEmpty(){
		return firstNode == null; 	
	}
	
	public Node getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}

	public Node getLastNode() {
		return lastNode;
	}

	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}

	public abstract void addNode(double firstData, double secondData);
	public abstract Node nextNode(Node node);
	public abstract Node prevNode(Node node);
	public abstract Object removeNode() throws EmptyListException;
}
