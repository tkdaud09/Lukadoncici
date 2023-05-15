package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		String sql1="update student set name='임걱정' where no=2000";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[메세지]"+rows+"명의 학생정보를 변경 하였습니다.");
		System.out.println("=============================================================");
		String sql2="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("=============================================================");
		ConnectionFactory.close(con, stmt, rs);
		
	}
}
