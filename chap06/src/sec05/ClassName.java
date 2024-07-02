package sec05;

public class ClassName {
	// 인스턴스 필드와 메소드
	int field1;
	void methid1() {}
	// 정적 필드와 메소드
	static int field2;
	static void method2() {}
	
	// 정적 메소드
	static void method3() {
		// 정적 메소드 안에서는 정적 필드만 사용 가능
		// this.field = 10;
		// this.method1();
		field2 = 10;
		method2();
		
		ClassName obj1 = new ClassName();
		// obj1.field = 10;
		// obj1.method1();
		
		
	}

}
