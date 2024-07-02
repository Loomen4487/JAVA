package sec02.casting;

public class InstanceofExample {
	// 부모 클래스를 자식 클래스 강제형변환을 안전하게 리턴하는 메소드
	public static void method1(Parent parent) {
				
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		}else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	//부모 클래스를 자식 클래스 강제형변환을 불안전하게 리턴하는 메소드
	public static void method2(Parent parent) {
		// 강제형변환(casting) -> ClassCastExaception 발생할 가능성이 있음
		Child child = (Child) parent;
		System.out.println("method2 - Child로 변환 성공");
	}
	
		public static void main(String[] args) {
			Parent parentA = new Child();
			method1(parentA);
			method2(parentA);
			
			Parent parentB = new Parent();
			method1(parentB);
			method2(parentB);
			//method1(new Child())		// instanceof -> true
			//method2(new parent())		// instanceof -> false
		}
	}

