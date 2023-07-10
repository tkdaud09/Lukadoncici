package xyz.itwill.dao;

public class UserinfoModelOneDAO extends JdbcDAO {
	private static UserinfoModelOneDAO _dao;
	
	public UserinfoModelOneDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new UserinfoModelOneDAO();
	}
	
	public static UserinfoModelOneDAO getDAO() {
		return _dao;
	}
	
	
	//회원정보를 전달받아 USERINFO 테이블의 회원정보로 삽입하고 삽입행을 갯수를 반환하는 메소드
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 메소드
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 List 객체로 반환하는 메소드
	
}
