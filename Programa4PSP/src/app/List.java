package app;
/**
 * 
 * @author gustavo
 *
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

	public abstract void addNode(double data);
	public abstract Node nextNode(Node node);
	public abstract Node prevNode(Node node);
	public abstract Object removeNode() throws EmptyListException;
}
