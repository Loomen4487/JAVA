package sec02;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		float var1 = 10f;
		float var2 = var1/100;
		
		if(var2 == 0.1f) {
			System.out.println("10%입니다.");
		}else {
			System.out.println("10%가 아닙니다.");
		}
	}
}
