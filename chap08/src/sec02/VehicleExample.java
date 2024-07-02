package sec02;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//vehicle.checkFare	// error-> Vehicle 인터페이스에는 checkFare메소드가 없음.
		
		Bus bus = (Bus)vehicle;
		bus.run();
		bus.checkFare();

	}

}
