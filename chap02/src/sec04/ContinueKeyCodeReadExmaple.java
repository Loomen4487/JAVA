package sec04;

public class ContinueKeyCodeReadExmaple {

	public static void main(String[] args) throws Exception {
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.print("keyCode" + keyCode);
			
			if(keyCode == 113) {
				break;
			}
		}
	}
}
