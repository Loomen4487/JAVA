package sec07;

public class Practice02 {
	private String name;
	
	public Practice02() {
		this("홍길동");
		System.out.println("Practice02() call");
	}
	
	public Practice02(String name) {
		this.name = name;
		System.out.println("Practice02(String name) call");
	}
}