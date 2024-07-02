package sec02;

public class Child extends Parent{
	@Override
	void method2() {
		System.out.println("Child의 method2");
				// 부모클래스의 method2메소드 호출
	}
	void method3() {
		System.out.println("Child의 method3");
		
	}

}
