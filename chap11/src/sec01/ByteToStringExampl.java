package sec01;

public class ByteToStringExampl {

	public static void main(String[] args) {
		// 아스키코드 표 참조
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		
		// 숫자된 것을 문자로 변경
		String str1 = new String(bytes);
		System.out.println(str1); // Hello java
		
		// 문자의 인덱스를 지정하여 원하는 문자열만 가져오기
		String str2 = new String(bytes, 6, 4);	// 인덱스 번호 6번에서 시작하여 4개의 값을 가져오기
		System.out.println(str2);	//java
	}

}
