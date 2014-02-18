/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author GustavoCanul, NoeCob, ArandiLopez
 */
public abstract class List {
    protected ListNode firstNode;
    protected ListNode lastNode;
    protected String name;
    
    public List(String name){
        this.name = name;
        this.firstNode = null;
        this.lastNode = null;
    }
    
    public List(){
        this("Lista");
    }
    
    public boolean isEmpty(){
        return firstNode == null;
    }
    
    public void print(){
        
        if(isEmpty()) System.out.println("La lista esta vacia.");
        
        else{
            System.out.println("La lista es: ");
            ListNode current = this.firstNode;
            
            while(current!=null){
                System.out.print(current.getData().toString() + "-->");
                current = current.getNext();
            }
            
            System.out.println("");
        }
    }
    
    public abstract void insertAtBack(Object insertItem);
    
    public abstract void insertAtFront(Object insertItem);
    
    public abstract void insertInOrder(Object insertItem);
    
    public abstract Object removeFromFront() throws EmptyListException;
    
    public abstract Object removeFromBack() throws EmptyListException;
    
    public abstract Object removeObject(Object elemento) throws EmptyListException;
    
    /**
     * @return the firstNode
     */
    public ListNode getFirstNode() {
        return firstNode;
    }

    /**
     * @param firstNode the firstNode to set
     */
    public void setFirstNode(ListNode firstNode) {
        this.firstNode = firstNode;
    }

    /**
     * @return the lastNode
     */
    public ListNode getLastNode() {
        return lastNode;
    }

    /**
     * @param lastNode the lastNode to set
     */
    public void setLastNode(ListNode lastNode) {
        this.lastNode = lastNode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
