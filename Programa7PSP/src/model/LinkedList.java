package model;
/**
 * Numero de programa: 3
*  Nombre de autor: Gustavo Canul Poot
*  Fecha de inicio de programa 14/02/2014
*  Descripcion del programa. programa para calcular la regresion lineal y hallar predicciones de un conjunto de datos
*/


public class LinkedList extends List{

	@Override
	public void addNode(double firstData, double secondData) {
		if (isEmpty()) this.firstNode = lastNode = new Node(firstData,secondData);
        
        else {
        	this.firstNode = new Node(firstData,secondData,this.firstNode);
        }
	}

	@Override
	public Object removeNode() throws EmptyListException {
		if(isEmpty()) 
            throw new EmptyListException();
        Object removedItem = this.firstNode.getFirstData();
        if(firstNode==lastNode){
            this.firstNode = this.lastNode = null;
        }else{
            this.firstNode = firstNode.getNextNode();
        }
        return removedItem;
	}
	
	@Override
	public Node nextNode(Node node){
		// TODO Auto-generated method stub
		return node;
	}

	@Override
	public Node prevNode(Node node) {
		// TODO Auto-generated method stub
		return node;
	}
}
