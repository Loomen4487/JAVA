package Practice02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddLineNumberExample {

	public static void main(String[] args) throws Exception {
		String filePath = "src/practice02/AddLineNumberExample.java";
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
	
	int rowNumber = 1;
	while(true) {
		String dataLine = br.readLine();
		if(dataLine == null) break;
		System.out.println((rowNumber++) + ": " + dataLine);
	}
	br.close();
	
	}

}
