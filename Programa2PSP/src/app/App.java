package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
*Numero de programa: 2
*Nombre de autor: Gustavo Canul Poot
*Fecha de inicio de programa 29/01/2014
*Descripcion del programa. programa que sirve para contar lineas de codigo y el numero de metodos que existen en el programa.
*/


public class App {
	
	private static final String MESSAGE = "Ingresa el path del codigo fuente que quieres analizar";
	
	public static void main(String args[]) throws IOException {
		
		String path = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el directorio de los archivos a analizar");
		path = scanner.nextLine();
		File file  = new File(path);
		String pathAbsolute = file.getAbsolutePath() + "\\";
		String[] files = file.list();
		CountCode countCode;
		for(int i = 0; i < files.length ; i++) {
			countCode = new CountCode(pathAbsolute + files[i]);
				countCode.countCodeLines();
			    countCode.countMethods();
		}	   
	}
}