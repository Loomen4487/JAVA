package sec01;

import java.io.*;

public class WriteExample {

	public static void main(String[] args) throws Exception {
//		OutputStream os = new FileOutputStream("./test1.db");	// 현재 실행 위치의 이진데이터 파일을 만듬.
		OutputStream os = new FileOutputStream("./test3.db");
		
		//byte a = 10;
		//byte b = 20;
		//byte c = 30;
		
		byte[] array = {10, 20, 30, 40, 50};
		os.write(array, 1, 3);
		//os.write(a);	// test1.db파일에 1byte씩 데이터를 출력
		//os.write(b);
		//os.write(c);
		
		os.flush();		// test1.db파일에 실제 남아있는 버퍼에 모든 바이트를 출력
		os.close();		// 출력 스트림을 닫음
		
		System.out.println("프로그램 종료");
	}
}
