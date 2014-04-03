package com.fmat.gcp.app;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import com.fmat.gcp.utils.DistributionT;
import com.fmat.gcp.utils.SimpsonRule;

public class Aplication {
	
	private static int NUMBER_OF_SEGMENTS = 10;
	private static float X_VALUE = 1.0f;
	private static final double E = .00001;
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
		SimpsonRule ruleSecond;
		float firstResult;
		float secondResult;
		int i = 1;
		float d = (float) 0.5;
		float x = X_VALUE;
		float compareToOne = 0;
		float compareToTwo = 0;
		float temp = 0;
		float temp2 = 0;
		
		ruleFirst = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS * i);
		firstResult = (float) ruleFirst.funcionP();
		compareToOne = Math.abs ( firstResult - p ) ;
		System.out.println(firstResult);
		if((firstResult - p) == 0 || compareToOne <E){
			System.out.println(MESSAGE + x);
		}
		else{
			if((firstResult - p) < 0){
				x +=d;
			}
			else{
				x -=d;
			}
//			
			ruleSecond = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS * i);
			secondResult = (float) ruleSecond.funcionP();
			compareToTwo = (float) Math.abs(secondResult - p);
			if((secondResult-p) == 0 || compareToTwo <E){
				System.out.println(MESSAGE + x);
			}
			
			else{
				do {
					d = Aplication.getDValue(d, firstResult - p, secondResult-p);


					if((secondResult - p) < 0){
						x +=d;
					}
					else{
						x-=d;
					}
					ruleFirst = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS * i);
					temp2 = (secondResult -p);
					temp = (float) (ruleFirst.funcionP() - p);
				} while ((Math.abs(ruleFirst.funcionP() - p)) > E);
				System.out.println(MESSAGE + x);
			}
		}
		
	}
	
	public static float getDValue(float d, float dif, float dif2){
		
		if (dif < 0 && dif2 < 0){
            return d;
            
        }
        else {
            if (dif > 0 && dif2 > 0){
                return d;
                
            }
            else{
                return d/2;
            }
        }
		
	}
}
