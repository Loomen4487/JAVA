package sec02;

public class Car {
	Tire frontLeftTire = new HankookTire();	//인터페이스 자동형변환
	Tire frontLightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backLightTire = new HankookTire();
	
	void run() {
		frontLeftTire.roll();
		frontLightTire.roll();
		backLeftTire.roll();
		backLightTire.roll();
	}

}
