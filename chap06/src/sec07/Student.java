package sec07;

public class Student extends People {		// 기본생성자가 없어서 error가 나옴
	public int studentNO;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);		// 부모가 가지는 2개의 인수를 가진 생성자 호출
		
		this.studentNO = studentNO;
	}
}
