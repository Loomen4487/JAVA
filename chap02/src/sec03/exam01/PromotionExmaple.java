package sec03.exam01;

public class PromotionExmaple {

	public static void main(String[] args) {
		/*자동 타입 변환
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue: "+ intValue);
		
		char charValue = '가';
		intValue = charValue;
		System.out.println("가의 유니코드: "+ intValue);
		
		intValue = 50;
		long longValue = intValue;
		System.out.println("longValue: "+ longValue);
		
		longValue = 100;
		float floatValue = longValue;
		System.out.println("floatValue: "+ floatValue);
		
		floatValue = 100.5F;
		double doubleValue = floatValue;
		System.out.println("doubleValue: "+ doubleValue);		
		*/ //----------------------------------------------------------------
		
		/*	강제 타입 변환
		int intValue = 44032;
		char charValue = (char) intValue;
		System.out.println(charValue);
		
		long longValue = 500;
		intValue = (int) longValue;
		System.out.println(intValue);
		
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue);
		*/ //----------------------------------------------
		
		/* // 정수 연산에서의 자동타입 변환(byte 예제)
		byte result1 = 10 + 20;
		System.out.println(result1);
		
		byte x = 10;
		byte y = 20;
		int result2 = x + y;
		System.out.println(result2);
		*/ //----------------------------------------------
		
		/* // 정수 연산에서의 자동타입 변환(long 예제)
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000L;
		long result = value1 + value2 + value3;
		System.out.println(result);
		*/ //----------------------------------------------
		
		/* 실수에서 자동타입 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValye3 = byteValue1 + byteValue2; 컴파일 에러
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		//char charValye3 = charValue1 + charValue2; 컴파일 에러
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드=" + intValue2);
		System.out.println("출력문자=" + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		//int intValue6 = 10 / 4.0;	컴파일 에러
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		System.out.println(result);
		*/ //----------------------------------------------
		
		
		//'+' 연산에서의 문자열 자동 타입 변환 예제
		int value = 10 + 2 + 8;
		System.out.println("value: "+ value);
		
		//결합연산
		String str1 = 10 + 2 + "8";		//128
		System.out.println("str1: "+ str1);
		
		String str2 = 10 + "2" + 8; 	//1028
		System.out.println("str2: "+ str2);
		
		String str3 = "10" + 2 + 8;		//1028
		System.out.println("str3: "+ str3);
		
		String str4 = "10" + (2 + 8);	//1010 가로 안이 우선 순위
		System.out.println("str4: "+ str4);
		//----------------------------------------------
		// 문자열을 기본타입으로 강제 타입 변환 예제
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");	// true <-> "true"
		
		System.out.println("value1: "+ value1);
		System.out.println("value2: "+ value2);
		System.out.println("value3: "+ value3);
		
		String str12 = String.valueOf(10);
		String str22 = String.valueOf(3.14);
		String str32 = String.valueOf(true);
		
		System.out.println("str12: "+ str12);
		System.out.println("str22: "+ str22);
		System.out.println("str32: "+ str32);
		
	}
}
