package xyz.itwill10.dao;

//SpringMVC ������� �����α׷� �ۼ��� Mybatis �����ӿ�ũ�� �̿��Ͽ� DAO Ŭ������ �ۼ��ϴ� ���
//1.DataSource ���� ���̺귯���� Mybatis ���� ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
//2.Mybatis �����ӿ�ũ�� ȯ�漳������(mybatis-config.xml - settings ������Ʈ) �ۼ�
// => [src/main/webapp] ������ �ۼ��ؾ߸� ������ �����̳�(WebApplicationContext ��ü)��
//Mybatis �����ӿ�ũ�� ȯ�漳�������� �о SqlSessionFactory Ŭ������ Spring Bean���� ��� ó��
// => [src/main/java] �Ǵ� [src/main/resources] ������ Mybatis �����ӿ�ũ�� ȯ�漳������ �ۼ� ����
//3.DataSource ���� Ŭ����, SqlSessionFactory ���� Ŭ����, SqlSession ���� Ŭ������ Spring Bean���� ���
// => SpringMVC ���α׷����� ������ �����̳ʸ� �ʱ�ȭ ó���ϱ� ���� Spring Bean Configuration
//File���� bean ������Ʈ�� Ŭ������ Spring Bean ��� - root-context.xml �Ǵ� servlet-context.xml

public class StudentDAOImpl {

}