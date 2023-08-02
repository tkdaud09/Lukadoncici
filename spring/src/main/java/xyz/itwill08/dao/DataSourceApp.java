package xyz.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//DataSource ��ü : �ټ��� Connection ��ü�� �̸� �����Ͽ� �����ϰ� �ִ� ��ü - DBCP(DataBase Connection Pool)
// => Spring Bean Configuration File���� DataSource �������̽��� ��ӹ��� �ڽ�Ŭ������ SpringBean���� ����Ͽ� ������ �����̳ʿ��� �����޾� ���
// => DataSource �������̽��� ��ӹ��� �ڽ�Ŭ������ Spring �����ӿ�ũ���� �����ϴ� spring-jdbc ���̺귯���� ���� ó�� - ���̺� ��� : pom.xml
// => DataSource ���� ���̺귯���ܿ� Oracle Driver ���� ���̺귯���� ������Ʈ ���� ó��

//������ �����̳ʿ��� DataSource ��ü�� �����޾� Connection ��ü�� ��ȯ�޾� ���
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("==========================================================");
		System.out.println("dataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	
	}
}




