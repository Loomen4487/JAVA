package sec01;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("구글", "안드로이드");
		
		String strObj = myPhone.toString();
		System.out.println("toString()값: " + strObj);
		
		System.out.println("myPhone객체를 String print했을 경우의 값: " + myPhone);
		
		System.out.println("1");
		System.out.println(1);		// 1 -> 내부적으로 숫자 1을 toStirng()메소드에서 
		System.out.println(1.0);	// 1.0 -> 내부적으로 숫자 1.0을 toString()메소드해서 
		
		

	}

}

// Object클래스의 가장 많이 사용하는 메소드들
// 1. equals()
// 2. hashCode()
// 3. toString()