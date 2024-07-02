package sec01;

public class Car {

	public static void main(String[] args) throws Exception {
		// 첫번째 방법
				Class clazz1 = Car.class;
				// 두번째 방법
				//Class clazz2 = Class.forName("java.lang.String");
				
				// 세번째 방법
				//String str1 = "aaa";
				//Class clazz3 = str1.getClass();
				
				System.out.println(clazz1.getName());
				System.out.println(clazz1.getSimpleName());
				System.out.println(clazz1.getPackageName());
		

	}

}
