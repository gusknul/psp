package app;

/**
 * Numero de programa: 3
*  Nombre de autor: Gustavo Canul Poot
*  Fecha de inicio de programa 14/02/2014
*  Descripcion del programa. programa para calcular la regresion lineal y hallar predicciones de un conjunto de datos
*/

import java.util.Scanner;

public class Calculations {
	
	int range;
	LinkedList list;
	private double mean[];
	private double meanXi;
	private double meanYi;
	double squareR;
	double bZero;
	double bOne;
	double coefficientR;
	
	Calculations(int range , LinkedList list){
		this.range = range;
		this.list = list;
	}
	
	/**
	 * metodo para hallar la media del conjunto de valores Xi, Yi
	 * @return
	 */
	public double[] getMean(){
		mean = new double[2];
		Node current = list.firstNode;
            while(current!=null){
            	meanXi = meanXi + current.getFirstData();
            	meanYi  = meanYi + current.getSecondData();
                current = current.getNextNode();
            }
            meanXi = meanXi /range;
            meanYi = meanYi / range;
            
            mean[0]= meanXi;
            mean[1]= meanYi;
            
		return mean;
	}

	/**
	 * metodo para hallar el coeficiente de correlacion r^2
	 * @return
	 */
	public double squareR(){
		return Math.pow(coefficientR,2);
	}
	
	/**
	 * metodo para hallar el coeficiente de correlacion r(x,y)
	 * @return
	 */
	public double coefficientR(){
		
		double temp1 = 0;
		double temp2 = 0;
		double temp3 = 0;
		double temp4 = 0;
		double temp5 = 0;
		
		Node current = list.firstNode;
        while(current!=null){
        	
        	temp1 += ((current.getFirstData() * current.getSecondData()));
        	temp2 += current.getFirstData();
        	temp3 += current.getSecondData();
        	temp4 += Math.pow(current.getFirstData(), 2);
        	temp5 += Math.pow(current.getSecondData(), 2);
            current = current.getNextNode();
        }        
        coefficientR = ((range * temp1) - (temp2 * temp3)) / Math.sqrt( ((range * temp4) - (Math.pow(temp2, 2))) * ((range * temp5) - (Math.pow(temp3, 2)))); 
		return coefficientR;
	}
	
	/**
	 * metodo para hallar b0
	 * @return
	 */
	public double bZero(){
		return mean[1] - (bOne() * mean[0]);
	}
	
	/**
	 * metodo para hallar b1
	 * @return
	 */
	public double bOne(){
		bOne = 0;
		double temp = 0;
		double temp2 = 0;
		
		Node current = list.firstNode;
            while(current!=null){
            	temp = temp + (current.getFirstData()*current.getSecondData());
            	temp2 = temp2 + (Math.pow(current.getFirstData(), 2));
                current = current.getNextNode();
            }
            bOne = (temp - (range * mean[0] * mean[1])) / (temp2-(range * Math.pow(mean[0], 2)));
		return bOne;
	}
	
	/**
	 * metodo para hallar la prediccion de la regresion
	 * @param value
	 * @return
	 */
	public double linearRegression(double value){
		return bZero() + (bOne() * value);
	}

}