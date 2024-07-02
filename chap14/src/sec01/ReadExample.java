package sec01;

import java.io.*;

public class ReadExample {

	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("./test1.db");
		
//		while(true) {
//			int data = is.read();	// test1.db안의 1바이트 읽어 리턴. 만약에 못 읽으면 -1을 리턴
//			if(data == -1) {
//				break;
//			}
//			System.out.println("1byte -> " + data);
		}
		/*
		int data1 = is.read();	// test1.db안의 1바이트 읽어 리턴
		System.out.println("1byte -> " + data1);
		int data2 = is.read();	// test1.db안의 1바이트 읽어 리턴
		System.out.println("1byte -> " + data2);
		*/
		/*
		InputStream os = new FileInputStream("./test3.db");
		byte[] buffer = new byte[3];
		
		int readByteNum = os.read(buffer);		// buffer크기만큼  test2.db에 있는 데이터를 가져온다.
		
		for(byte b1 : buffer) {
			System.out.println(b1);
		}
		*/
	byte[] buffer = new byte[5];
	int readByteNum = is.read(buffer, 2, 3);
	if (readByteNum != -1) {
		for(byte b1 : buffer) {
			System.out.println(b1);
		}
		
		
		is.close();
		}
	}
}
