package app;


/**
*Numero de programa: 3
*Nombre de autor: Gustavo Canul Poot
*Fecha de inicio de programa 14/02/2014
*Descripcion del programa. programa para calcular la regresion lineal y hallar predicciones de un conjunto de datos
*
*Declaracion de clases para el funcionamiento del programa
*
*Application.java
*Calculations.java
*EmptyListException.java
*LinkedList.java
*List.java
*Node.java
*/
/**
 * 
 */
import java.util.Scanner;

public class Application {
	
	static int size;
	static LinkedList list;
	static Scanner scanner;
	static Calculations calculations;
	
	public static void main(String args[]){
		 scanner =new Scanner(System.in);
		
		list = new LinkedList();
		
		
		System.out.println("Ingresa el rango para los datos");
		size = scanner.nextInt();
		double Xi[] = new double[size];
		double Yi[] = new double[size];
		for (int i = 0; i < size ; i++){
			System.out.println("Ingrese los valores de Xi");
			double n;
			n = scanner.nextDouble();
			Xi[i] = n;
		}
		
		for(int j = 0; j < size;j++){
			System.out.println("Ingrese los valores de Yi");
			double n;
			n = scanner.nextDouble();
			Yi[j] = n;
		}
		
		for (int k = 0; k < size; k++) {
			list.addNode(Xi[k], Yi[k]);
		}
		
		System.out.println("\n Ingrese el valor de la estimacion deseada");
		double estimatedNumber;
		estimatedNumber = scanner.nextDouble();
		
		calculations = new Calculations(size,list);
		calculations.getMean();
		double bOne = calculations.bOne();
		
		System.out.println("\n \nEl valor de B cero es : " + calculations.bZero());
		System.out.println("El valor de B uno es : " + bOne);
		System.out.println("El coeficiente de correlacion r(x,y) es : " + calculations.coefficientR());
		System.out.println("El coeficiente de correlacion r^2 es : " + calculations.squareR());
		System.out.println("La prediccion de los valores es : " + calculations.linearRegression(estimatedNumber));
	}

}
