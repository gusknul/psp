package com.fmat.gcp.app;

import java.util.Scanner;

import com.fmat.gcp.utils.SimpsonRule;

public class Aplication {
	
	private static int NUMBER_OF_SEGMENTS = 10;
	private static final double E = 0.000001;
	private static final String MESSAGE = "El valor de p es : ";
	private static final String VALUE = "Ingrese el valor de x";
	private static final String DOF = "Ingrese los grados de libertad";
	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println(VALUE);
		float x = scanner.nextFloat();
		System.out.println(DOF);
		int DOF = scanner.nextInt();
		SimpsonRule ruleFirst;
		SimpsonRule ruleSecond;
		float firstResult;
		float secondResult;
		int i = 1;
		float compareTo = 0;
		do{
			ruleFirst = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS * i);
			ruleSecond = new SimpsonRule(DOF, x,(NUMBER_OF_SEGMENTS * (i + 1)));
			firstResult = (float) ruleFirst.funcionP();
			secondResult = (float) ruleSecond.funcionP();
			compareTo = Math.abs(firstResult - secondResult);
			i++;
		}while(!(compareTo < E));
		
		System.out.print( MESSAGE + secondResult);
	}
		
}
