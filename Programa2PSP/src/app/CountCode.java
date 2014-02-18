package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import dao.DAO;





public class CountCode {
	DAO dao;
	ArrayList<String> coding;
	String path;
	
	public CountCode(String path) throws IOException {
		// TODO Auto-generated constructor stub
		dao = new DAO(path);
		coding = dao.readFiles();
		this.path = path;
	}
	
	public void countCodeLines() throws IOException {
		File file = new File(path);
		if(dao.validateExtension()) {
		System.out.println("La clase " + file.getName() +  " tiene "+ coding.size() + " lineas de codigo ");
		}
	}
	public void countMethods() throws IOException {
		File file = new File(path);
		int methods = 0;
		int i = 0;
		if(dao.validateExtension()) {
			while(i < coding.size()){
				if(coding.get(i).trim().startsWith("public") || 
						coding.get(i).trim().startsWith("protected") 
						||coding.get(i).trim().startsWith("private")) {
					
					if(!coding.get(i).trim().startsWith("public class")) {
						
						if(coding.get(i).trim().endsWith("{")){
							methods++;
						}
					}
				}
				i++;
			}
		}
				System.out.println("La clase " + file.getName() + " tiene "+ methods + " metodos ");
		
	}
}
