package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.mapper.StudentMapper;

//SpringMVC ������� �����α׷� �ۼ��� Mybatis �����ӿ�ũ�� �̿��Ͽ� DAO Ŭ������ �ۼ��ϴ� ���
//1.DataSource ���� ���̺귯���� Mybatis ���� ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
//2.Mybatis �����ӿ�ũ�� ȯ�漳������(mybatis-config.xml - settings ������Ʈ) �ۼ�
// => [src/main/webapp] ������ �ۼ��ؾ߸� ������ �����̳�(WebApplicationContext ��ü)��
//Mybatis �����ӿ�ũ�� ȯ�漳�������� �о SqlSessionFactory Ŭ������ Spring Bean���� ��� ó��
// => [src/main/java] �Ǵ� [src/main/resources] ������ Mybatis �����ӿ�ũ�� ȯ�漳������ �ۼ� ����
//3.DataSource ���� Ŭ����, SqlSessionFactory ���� Ŭ����, SqlSession ���� Ŭ������ Spring Bean���� ���
// => SpringMVC ���α׷����� ������ �����̳ʸ� �ʱ�ȭ ó���ϱ� ���� Spring Bean Configuration
//�١١� File���� bean ������Ʈ�� Ŭ������ Spring Bean ��� - root-context.xml(��� front controller�� ���� ��ü�� ����ϰ� ������)
//															�Ǵ� servlet-context.xml (���� ���) �١١�
//4.���̺� ���� >> DTO Ŭ���� �ۼ� >> ���� ���� �ۼ� >> DAO Ŭ���� �ۼ�

//DAO Ŭ����(Repository Ŭ����) : �����ü(DBMS)���� �࿡ ���� ����, ����, ����, ���� ����� �����ϱ� ���� Ŭ����
//=> DAO Ŭ������ �޼ҵ忡���� DBMS ������ SQL ����� �����Ͽ� �����ϰ� �������� Java ��ü(��)���� ��ȯ�ǵ��� �ۼ�
//=> DAO Ŭ������ ����ŵ� ��������� ������ Service Ŭ������ ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� �ۼ�

//DAO Ŭ������ Service Ŭ�������� ��ü�� �����Ǿ� ���ǵ��� �ݵ�� Spring Bean���� ���
//=> DAO Ŭ������ @Repository ������̼��� ����Ͽ� Spring Bean���� ���
//=> @Repository ������̼��� ����ϸ� SQL ������� �߻��Ǵ� ����(SQLException)�� Spring ���ܷ� �����ǵ��� ó��
//=> @Repository ������̼Ǹ� ������ �����̳ʰ� ó���ϱ� ���� �ݵ�� Ŭ������ �ۼ��� ��Ű����
//Spring Bean Configuration File(servlet-context.xml)�� component-scan ������Ʈ�� �˻��ǵ��� ����
@Repository
//final �����ڷ� �ۼ��� �ʵ常 �ʱ�ȭ ó���ϴ� �����ڸ� ������ִ� ������̼�
// => �����ڰ� �ϳ��� �ִ� ��� �����ڿ� @AutoWired ������̼��� ���� ����
@RequiredArgsConstructor
public class StudentDAOImpl implements StudentDAO {
	//Mybatis �����ӿ�ũ�� ����Ͽ� DAO Ŭ������ �ۼ��� ��� ���ۿ� ��ϵ� SQL ����� �����޾�
	//�����Ͽ� �����ϰ� �������� Java ��ü(��)���� ��ȯ�ޱ� ���� SqlSession ��ü �ʿ�
	// => SqlSession ��ü�� ������ �� �ִ� �ʵ带 �����Ͽ� ������ �����̳ʰ� �����ϴ�
	//Spring Bean�� �����޾� ������ ����(DI)
	// => �Ű������� ����� �����ڸ� �ۼ��Ͽ� @Autowired ������̼��� ����Ͽ� ������ ���� - �ټ�ȯ���� ������  
	private final SqlSession sqlSession;
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}
}