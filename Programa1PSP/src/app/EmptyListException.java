package app;

public class EmptyListException extends RuntimeException {
	
	public EmptyListException(){
        super("La Lista esta vacia");
    }
}
