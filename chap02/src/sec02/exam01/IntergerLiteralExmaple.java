package sec02.exam01;

public class IntergerLiteralExmaple {

	public static void main(String[] args) {
		int var1 = 0b1011;		//2진수(0b)
		int var2 = 0206;		//8진수(0)
		int var3 = 365;			//10진주(없음)
		int var4 = 0xB3;		//16진수(0x)
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		
		long bal = 300000000L;		//long은 L을 붙여줄것!
	}
}
