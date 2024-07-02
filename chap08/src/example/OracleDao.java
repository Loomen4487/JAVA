package example;

public class OracleDao implements DataAccessObject{
	public void select() {
		System.out.println("Oracle Db에서 검색");
	}
	public void insert() {
		System.out.println("Oracle Db에서 삽입");
	}

	public void update() {
		System.out.println("Oracle Db에서 수정");
	}

	public void delete() {
		System.out.println("Oracle Db에서 삭제");
	}

	

}
