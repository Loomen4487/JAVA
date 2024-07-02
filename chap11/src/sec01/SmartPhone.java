package sec01;

public class SmartPhone {
	// 필드
	private String company;
	private String os;
	
	// 생성자
	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	
	// 메소드
	@Override
	public String toString() {
		System.out.println("SmartPhone의 toString()이 실행됨");
		return company + "," + os;
	}
	
	

}
