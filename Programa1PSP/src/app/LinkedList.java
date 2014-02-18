package app;


public class LinkedList extends List{

	@Override
	public void addNode(double data) {
		if (isEmpty()) this.firstNode = lastNode = new Node(data);
        
        else {
        	this.firstNode = new Node(data,this.firstNode);
        }
	}

	@Override
	public Object removeNode() throws EmptyListException {
		if(isEmpty()) 
            throw new EmptyListException();
        Object removedItem = this.firstNode.getData();
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
