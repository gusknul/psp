package application;

import java.util.Scanner;

import util.Gauss;
import util.LinkedList;
import util.Regression;

public class MultipleRegression {
	private static Scanner scanner;
	private static LinkedList list;
	
	public static void main(String[] args) {
		int size;
		 scanner =new Scanner(System.in);
			
		list = new LinkedList();
		
		
		System.out.println("Ingresa el rango para los datos");
		size = scanner.nextInt();
		
		double Wi[] = new double[size];
		double Xi[] = new double[size];
		double Yi[] = new double[size];
		double Zi[] = new double[size];
		
		for (int i = 0; i < size ; i++){
			System.out.println("Ingrese los valores de Wi");
			double n;
			n = scanner.nextDouble();
			Wi[i] = n;
		}
		
		for(int j = 0; j < size;j++){
			System.out.println("Ingrese los valores de Xi");
			double n;
			n = scanner.nextDouble();
			Xi[j] = n;
		}
		
		for(int k = 0; k < size;k++){
			System.out.println("Ingrese los valores de Yi");
			double n;
			n = scanner.nextDouble();
			Yi[k] = n;
		}
		
		for(int l = 0; l < size;l++){
			System.out.println("Ingrese los valores de Zi");
			double n;
			n = scanner.nextDouble();
			Zi[l] = n;
			
			
		}
		
		System.out.println("Ingrese los valores de Wk");
		double wK = scanner.nextDouble();
		
		System.out.println("Ingrese los valores de Xk");
		double xK = scanner.nextDouble();
		
		System.out.println("Ingrese los valores de Yk");
		double yK = scanner.nextDouble();
		
		for (int m = 0; m < size; m++) {
			list.addNode(Wi[m],Xi[m],Yi[m],Zi[m]);
		}
		
		Gauss gauss = new Gauss(list, size);
		Regression regression = new Regression(size,list);
		
		double[][] A = gauss.getElementsMatrix();
		double[] b = gauss.bMatrix();
		double[]betaValues = gauss.solveMatrix(A, b);
		double standardDeviation = regression.standardDeviation(betaValues[0], betaValues[1], betaValues[2], betaValues[3], size);
		double tValue = regression.getXValue();
		double[] average = regression.average();
		double SQRT = regression.getSQRTValue(wK, xK, yK, average);
		double estimatedZ = regression.estimatedZ(betaValues, wK, xK, yK);
		double range = regression.range(tValue, standardDeviation, SQRT);
		
		System.out.println("El valor de beta cero es : " + betaValues[0]);
		System.out.println("El valor de beta uno es : " + betaValues[1]);
		System.out.println("El valor de beta dos es : " + betaValues[2]);
		System.out.println("El valor de beta tres es : " + betaValues[3]);
		System.out.println("El valor de Zk es : " + estimatedZ);
		System.out.println("El valor de UPI = " + (estimatedZ + range));
		System.out.println("El valor de LPI = " + (estimatedZ - range));
		
	}

}
