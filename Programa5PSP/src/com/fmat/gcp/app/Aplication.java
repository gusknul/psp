package com.fmat.gcp.app;

import java.security.SignatureException;
import java.util.Scanner;

import com.fmat.gcp.utils.SimpsonRule;

public class Aplication {
	
	private static int NUMBER_OF_SEGMENTS = 10;
	private static final double E = 0.00001;
	private static final String MESSAGE = "El valor de p es : ";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el valor de x");
		float x = scanner.nextFloat();
		System.out.println("Ingrese los grados de libertad");
		int DOF = scanner.nextInt();
		
		
		SimpsonRule ruleFirst = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS);
		SimpsonRule ruleSecond = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS*2);
		
		float firstResult = (float) ruleFirst.funcionP();
		float secondResult =  (float) ruleSecond.funcionP();
		int i = 2;
		float compareTo = Math.abs(firstResult - secondResult);
		while(!(compareTo < E)){
			ruleFirst = new SimpsonRule(DOF, x,NUMBER_OF_SEGMENTS * i);
			ruleSecond = new SimpsonRule(DOF, x,(NUMBER_OF_SEGMENTS * (i + 1)));
			firstResult = (float) ruleFirst.funcionP();
			secondResult = (float) ruleSecond.funcionP();
			i++;
		}
		
		System.out.print( MESSAGE + secondResult);
	}
	
}
