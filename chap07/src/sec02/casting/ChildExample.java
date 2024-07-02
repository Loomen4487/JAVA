package sec02.casting;

public class ChildExample {

	public static void main(String[] args) {
		Parent parent = new Child(); // 자동형변환
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/*
		parent.field2 = "data2";	// error
		parent.method3();			// error
		*/
		
		// 강제형변환(Casting)
		Child child = (Child) parent; // 강제형변환
		child.field2 = "data2";
		child.method3();
		
		/*
		Parent parent2 = new Parent();
		Child child2 = (Child) parent2;
		*/
	}

}
