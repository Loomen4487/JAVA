package chap10;

public class NumberFromatExceptionExample {

	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		// 문자열 data1 100을 숫자 100으로 변경시도 -> 통과
		int value1 = Integer.parseInt(data1);
		// 문자열 data2 a100을 숫자로 변경시도		 -> error 
		int value2 = Integer.parseInt(data2);	// a를 숫자로 바꿀 수 없어서 numberformatexception이 발생
	}

}
