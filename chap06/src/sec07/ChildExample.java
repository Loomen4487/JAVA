package sec07;

public class ChildExample {

	public static void main(String[] args) {
		
		Child child = new Child();
		
		child.method1();
		child.method2();
		child.method3();
		
		Parent parent = new Parent();
		//parent.method3();	//child의 method3
		parent.method2();	//parent의 method2


	}

}
