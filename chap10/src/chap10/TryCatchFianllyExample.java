package chap10;

public class TryCatchFianllyExample {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("chap10.TryCatchFianllyExample");
			Class clazz = Class.forName("String2");
		} catch(ClassNotFoundException e){
			System.out.println("클래스가 존재하지 않습니다");
		}
		System.out.println("프로그램 종료");
	}
}
