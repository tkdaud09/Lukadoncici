package xyz.itwill.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

//Spring �����ӿ�ũ�� ����Ͽ� ���(���� ���α׷�)�� �˻��ϴ� �׽�Ʈ ���α׷� �ۼ� ���
// => SpringMVC ���α׷����� ����ϴ� ��� : DAO Ŭ����, Service Ŭ����, Controller Ŭ���� ��
//1.junit ���̺귯���� spring-test ���̺귯���� ������Ʈ ���� ó�� - ���̺� : pom.xml
//2.�׽�Ʈ ���α׷����� ���� �α� ����ü�� ���� ȯ�漳������ ����
// => [src/test/resources] ������ [log4j.xml] ������ ���� ����
//3.[src/test/java] ������ �׽�Ʈ ���α׷� ���� Ŭ���� �ۼ�
// => junit ���̺귯���� spring-test ���̺귯���� scope �Ӽ��� �ּ� ó���� �� �׽�Ʈ ���α׷�
//���� Ŭ���� �ۼ� - �׽�Ʈ ���α׷� ���� Ŭ���� �ۼ� �� �ּ� ����
//4.�׽�Ʈ ���α׷��� �����Ͽ� ��� �˻�

//@RunWith : �׽�Ʈ ���α׷��� �����ϱ� ���� ���� Ŭ������ �����ϴ� ������̼�
// => �׽�Ʈ ���α׷� ���� Ŭ������ ��ü�� �����Ͽ� �޼ҵ带 ȣ���ϱ� ���� Ŭ���� ����
//value �Ӽ� : �׽�Ʈ ���α׷��� �����ϱ� ���� Ŭ����(Class ��ü)�� �Ӽ������� ����
// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
//SpringJUnit4ClassRunner Ŭ������ ����Ͽ� �׽�Ʈ ���α׷��� ������ ��� �ڵ����� ������
//�����̳�(ApplicationContext ��ü)�� �����Ͽ� ����
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : �׽�Ʈ ���α׷����� ���� Spring Bean�� �����ϱ� ���� Spring Bean 
//Configuration File�� �����ϱ� ���� ������̼�
//locations �Ӽ� : Spring Bean Configuration File�� ��θ� ��ҷ� ������ �迭�� �Ӽ������� ����
// => Spring Bean Configuration File�� ��δ� file ���λ縦 ����Ͽ� ���� �ý��� �������� ǥ���Ͽ� ����
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class DataSourceTest {
	//�׽�Ʈ Ŭ������ �޼ҵ忡�� ����� ��ü�� �����ϱ� ���� �ʵ� ����
	// => �ʵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - �����ڸ� �̿��� ������ ���� �Ұ��� 
	@Autowired
	private DataSource dataSource;
	
	//@Test : �׽�Ʈ �޼ҵ带 �����ϴ� ������̼� - �׽�Ʈ ����� �ۼ��Ͽ� ����
	// => SpringJUnit4ClassRunner Ŭ������ ���� �׽�Ʈ ���α׷� ���� Ŭ������ ��ü�� ������ �� �ڵ� ȣ�� �޼ҵ�
	@Test
	public void testDataSource() throws SQLException {
		log.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		log.info("Connection = "+connection);
		connection.close();
	}
}