package sec01;

public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
		Key compareKey = (Key)obj;	// 강제형변환
		
		if(this.number == compareKey.number) 
			return true;
		  
		}
		return false;
	}
	
	@Override
	public int hashCode() {	// 주소값이 hashcode값이 아니라 number가 해시코드가 되도록 재정의
		return number;
	}

}
