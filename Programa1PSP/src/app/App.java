package app;

import java.util.Scanner;

public class App {
	int range;
	LinkedList list;
	private double mean;
	
	App(int range , LinkedList list){
		this.range = range;
		this.list = list;
	}
	
	public double mean(){
		mean = 0;
		Node current = list.firstNode;
            while(current!=null){
            	mean = mean + current.getData();
                current = current.getNextNode();
            }
            mean = mean /range;
		return mean;
	}
	
	public double standardDeviation(){
		double value = 0;
		double number = 0;
		
		Node current = list.firstNode;
        while(current!=null){

        	number = number + (current.getData() - mean) * (current.getData() - mean);
            current = current.getNextNode();
        }
        value = Math.sqrt(number/(range-1));
		return value;
	}
	
	public static void main(String args[]){
		Scanner scanner =new Scanner(System.in);
		LinkedList list = new LinkedList();
		
		int numero;
		System.out.println("Ingresa el rango para los datos");
		numero = scanner.nextInt();
		
		for (int i = 0; i < numero ; i++){
			System.out.println("Ingrese el dato");
			int n;
			n = scanner.nextInt();
			list.addNode(n);
		}
		
		App a = new App(numero,list);
		System.out.println("La media de los datos es = "+a.mean() + "\nLa desviacion estandar de los datos es = " + a.standardDeviation());
	}
}