package com.fmat.gcp.app;

import java.util.Scanner;

import com.fmat.gcp.utils.DistributionT;
import com.fmat.gcp.utils.SimpsonRule;

public class Aplication {
	
	private static int NUMBER_OF_SEGMENTS = 10;
	private static float X_VALUE = 1.0f;
	private static final double E = 0.000001;
	private static final String MESSAGE = "El valor de x es : ";
	private static final String VALUE = "Ingrese el valor de p";
	private static final String DOF = "Ingrese los grados de libertad";
	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println(VALUE);
		float p = scanner.nextFloat();
		System.out.println(DOF);
		int DOF = scanner.nextInt();
		SimpsonRule ruleFirst;
		float firstResult;
		float secondResult;
		int i = 1;
		float d = (float) 0.5;
		float x = X_VALUE;
		float value = x;
		float compareToOne = 0;
		float compareToTwo = 0;
		float compareToComplete = 0;
		
		ruleFirst = new SimpsonRule(DOF, value,NUMBER_OF_SEGMENTS * i);
		firstResult = (float) ruleFirst.funcionP();
		compareToOne = Math.abs ( firstResult - p ) ;
		
		if((firstResult - p) == 0 || compareToOne <= E){
			System.out.println(MESSAGE + value);
		}
		else{
			if(compareToOne < 0){
				value +=d;
			}
			else{
				value -=d;
			}
			
			ruleFirst = new SimpsonRule(DOF, value,NUMBER_OF_SEGMENTS * i);
			secondResult = (float) ruleFirst.funcionP();
			compareToTwo = (float) Math.abs(secondResult - p);
			
			if((secondResult-p) == 0 || compareToOne<=E){
				System.out.println(MESSAGE + value);
			}
			
			else{
				do {
					if((secondResult-p) < 0){
						if(compareToOne < 0 && compareToTwo < 0){
							value +=d;
						}
						else{
							if(compareToOne > 0 && compareToTwo > 0){
								value +=d;
							}
							else{
								value += (d/2);
							}
						}
					}
					else{
						if(compareToOne < 0 && compareToTwo < 0){
							value -=d;
						}
						else{
							if(compareToOne > 0 && compareToTwo > 0){
								value -=d;
							}
							else{
								value -= (d/2);
							}
						}
						
					}
					ruleFirst = new SimpsonRule(DOF, value,NUMBER_OF_SEGMENTS * i);
					compareToOne = compareToTwo;
					compareToTwo = (float) (ruleFirst.funcionP() - p);
					compareToComplete = (float) Math.abs(ruleFirst.funcionP() - p);
				} while (compareToOne > E);
				System.out.println(MESSAGE + value);
			}
		}
		
	}		
}
