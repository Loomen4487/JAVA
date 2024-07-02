package sec07;

public class Practice01 {
	public String nation;
	
	public Practice01() {
		this("대한민국");
		System.out.println("Practice() call");
	}
	
	public Practice01(String nation) {
		this.nation = nation;
		System.out.println("Practice(String nation) call");
	}

}
