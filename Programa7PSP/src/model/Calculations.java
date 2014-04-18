package model;

import app.Application;


/**
 * Numero de programa: 3
*  Nombre de autor: Gustavo Canul Poot
*  Fecha de inicio de programa 14/02/2014
*  Descripcion del programa. programa para calcular la regresion lineal y hallar predicciones de un conjunto de datos
*/


public class Calculations {
	
	int range;
	LinkedList list;
	private double mean[];
	private double meanXi;
	private double meanYi;
	double squareR;
	double bZero;
	double bOne;
	double coefficientR;public static final int NUMBER_OF_SEGMENTS = 10;
	private static final double E = .000001;
	
	public Calculations(int range , LinkedList list){
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
	
	public double getX(double coefficientR){		
		return (Math.abs(coefficientR) * Math.sqrt( (double) range - 2 ) ) /
				Math.sqrt(1 - Math.pow(coefficientR, 2));
	}
	
	public double standardDeviattion(double b0 , double b1){
		double temp = 0;
		
		Node current = list.firstNode;
            
		while(current!=null){
            	temp += Math.pow(current.getSecondData() - b0 - (b1 * current.getFirstData()) ,  2);
            	current = current.getNextNode();
            }
		
		double temp4 = 1 / ((double) range - 2);

		return Math.sqrt(temp4 * temp);
		
	}
	
	public double rangePrediction(double standardDeviattion, double estimatedNumber){
		double rangePrediction;
		double temp = 0;
		Node current = list.firstNode;
		while(current != null){
			temp += Math.pow(current.getFirstData() - mean[0], 2);
			current = current.getNextNode();
		}
		rangePrediction = getXValue() * standardDeviattion *
				(Math.sqrt(1 + ( (double) 1 /range) + (Math.pow(estimatedNumber - mean[0] , 2) / temp )));
		
		return rangePrediction;
	}
	
	
	public double getXValue(){
		
		float secondResult;
		float d = (float) 0.5;
		float x = 1;
		float p = .35f;
		float compareToTwo = 0;
		SimpsonRule ruleFirst = new SimpsonRule(range-2, x, 10);
		float firstResult = (float) ruleFirst.funcionP();
		float compareToOne = Math.abs(firstResult - p);
		
			if ((firstResult - p) == 0 || compareToOne <= E) {
				return x;
			}
		
			else {
				if ((firstResult - p) < 0) {
					x += d;
				}
			
				else {
					x -= d;
				}
			
				ruleFirst = new SimpsonRule(range-2, x, NUMBER_OF_SEGMENTS);
				secondResult = (float) ruleFirst.funcionP();
				compareToTwo = (float) Math.abs(secondResult - p);
				
				if ((secondResult - p) == 0 || compareToTwo <= E) {
					return x;
				}

				else {
					do {
						d = Application.getDValue(d, firstResult - p,
								(float) (ruleFirst.funcionP() - p));
						if ((secondResult - p) < 0) {
							x += d;
						} else {
							x -= d;
						}
						ruleFirst = new SimpsonRule(range-2, x, NUMBER_OF_SEGMENTS);
						secondResult = (float) ruleFirst.funcionP();

					} while ((Math.abs(ruleFirst.funcionP() - p)) > E);
				return x;
				}
			}

	}
	
	

}