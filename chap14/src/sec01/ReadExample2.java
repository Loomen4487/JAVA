package sec01;

import java.io.*;

public class ReadExample2 {

	public static void main(String[] args) throws Exception{
		Reader reader = new FileReader("./test1.text1");
		/*
		while(true) {
			int data = reader.read();
			if(data == -1) break;
			System.out.println("1char data -> " + (char)data);
		}
//		System.out.println("1char data -> " + (char)data);
		*/
		char[] bufferArray = new char[100];
		
		while(true) {
			int readCharNum = reader.read(bufferArray);
			if(readCharNum == -1) break;
			
			for(char buffer : bufferArray) {
				System.out.println("1char data -> " + (char)buffer);
			}
		}

	}

}
