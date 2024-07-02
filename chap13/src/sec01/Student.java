package sec01;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student)obj;	// 강제형변환
			return student.name.equals(this.name) && student.sno == this.sno;
			}
		return false;
	}
	

}
