package realization; 

public class JdbcApp {
	public static void main(String[] args) {
		JdbcMysql mysql=new JdbcMysql();
		
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		
	}
}
