package app;

import java.util.Scanner;

import javax.xml.bind.helpers.PrintConversionEventImpl;

public class Application {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LinkedList list = new LinkedList();
		
		
		int range;
		int number;
		
		System.out.println("Ingresa el rango para los datos");
		range = scanner.nextInt();
		double oneDate[] = new double[range];
		double secondDate[] = new double[range];
		System.out.println("Ingresa el numero de datos a leer (1 o 2)");
		number = scanner.nextInt();
		Calculations calculations;
		
		switch (number) {
		case 1:
			for (int i = 0; i < range ; i++){
				System.out.println("Ingrese el dato");
				int n;
				n = scanner.nextInt();
				list.addNode(n);
			}
			calculations = new Calculations(list, range);
			calculations.getMeanLogarithmic();
			calculations.getStandardDeviation();
			System.out.println("Los valores de very Small es : " + calculations.getVerySmall());
			System.out.println("Los valores de Small es : " + calculations.getSmall());
			System.out.println("Los valores de Medium es : " + calculations.getMedium());
			System.out.println("Los valores de Large es : " + calculations.getLarge());
			System.out.println("Los valores de very Large es : " + calculations.getVeryLarge());
			
			break;
			
		case 2:
			
			for (int i = 0; i < range ; i++){
				System.out.println("Ingrese los datos de la primera columna");
				int n;
				n = scanner.nextInt();
				oneDate[i] = n;
			}
			
			for (int i = 0; i < range ; i++){
				System.out.println("Ingrese los datos de la segunda columna");
				int n;
				n = scanner.nextInt();
				list.addNode(oneDate[i] / n);
			}
			
			calculations = new Calculations(list, range);
			calculations.getMeanLogarithmic();
			calculations.getStandardDeviation();
			System.out.println("Los valores de very Small es : " + calculations.getVerySmall());
			System.out.println("Los valores de Small es : " + calculations.getSmall());
			System.out.println("Los valores de Medium es : " + calculations.getMedium());
			System.out.println("Los valores de Large es : " + calculations.getLarge());
			System.out.println("Los valores de very Large es : " + calculations.getVeryLarge());
			
			break;

		default:
			break;
		}
		
	}

}
