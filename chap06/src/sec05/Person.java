package sec05;

public class Person {
	final String nation = "korea";
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	// final로 선언된 값은 무조건 클래스 초기화할 떄 fianl로 선언된 변수를 초기화 해야한다.
	// public Person() {}

}
