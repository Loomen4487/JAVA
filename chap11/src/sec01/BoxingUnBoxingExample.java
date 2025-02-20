package sec01;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		// 박싱
		Integer obj1 = new Integer(100);	//밑줄은 deprecated된 것을 표현
		Integer obj2 = new Integer("200");
		Integer obj3 = Integer.valueOf("300");
		
		// 언박싱
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		// 자동 박싱
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());
		
		// 대입시 자동 언박싱
		int value = obj;
		System.out.println("value: " + value);
		
		// 연산시 자동 언박싱
		int result = obj + 100;
		System.out.println("result: " + result);

	}

}
