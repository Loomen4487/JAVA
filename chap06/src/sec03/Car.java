package sec03;

public class Car {
	// (만약 기본 생성자가 만들어지지 않더라도 내부적으로 기본생성자가 없다면 자동으로 만들어줌.)
	// 단, 다른 생성자가 생성되어 있다면 기본 생성자는 자동으로 생성도지 않음.
	public Car() { 	// 기본 생성자
		System.out.println("기본 생성자 출력");
	} 
	
	public Car(String model, String color, String maxSpeed) { // 3개의 인수를 가진 생성자
		System.out.println("인수가 3개인 생성자 출력");
		
	}
	
	public Car(String color, int cc) {
		System.out.println("인수가 2개인 생성자 출력");
		
	}
}
