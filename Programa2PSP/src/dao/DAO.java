package dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {
	
	private File file;
	String path;
	private ArrayList<String> data;
	
	public DAO (String path) {
		file = new File(path);
		this.path = path;
		data = new ArrayList<String>();
		
	}
	
	public ArrayList<String> readFiles() throws IOException {
		    BufferedReader buffer;
			FileReader reader = new FileReader(path);
	        buffer = new BufferedReader(reader);
	        String aux = buffer.readLine();
	        	while (aux != null) 
	        	{      	
	        		if(!aux.trim().equals(""))
	        		{
	        			data.add(aux);
	        		}
	        		aux = buffer.readLine();
	        	}
	        	reader.close();
	        	buffer.close();
			return data;
	}
	
	public boolean validateExtension() {
		if(file != null) {
				String filename = file.toString();
				int j = filename.lastIndexOf(".java");
				if(j == -1)
	           {
					return false;
	           }
		}
		return true;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}
	
	
	
}