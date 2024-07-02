package sec02;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();  //한국 타이어가 굴러갑니다 x4
		
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontLightTire = new KumhoTire();
		
		myCar.run();

	}

}
