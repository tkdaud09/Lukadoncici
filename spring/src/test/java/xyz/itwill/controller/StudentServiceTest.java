package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : ApplicationContext ��ü�� �ƴ� WebApplicationContext ��ü�� ������ 
//�����̳ʷ� ����� �� �ֵ��� �����ϱ� ���� ������̼�
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//@FixMethodOrder : �׽�Ʈ �޼ҵ� ȣ������� �����ϱ� ���� ������̼�
//value �Ӽ� : MethodSorters �ڷ���(Enum)�� ��� �� �ϳ��� �Ӽ������� ����
// => MethodSorters.DEFAULT : JUnit ���α׷��� ���� ��Ģ�� ���� ���ĵǾ� �޼ҵ� ȣ�� - �׽�Ʈ ���α׷� ����� ������ ������ �޼ҵ� ȣ��
// => MethodSorters.JVM : JVM�� ���� ���ĵǾ� �޼ҵ� ȣ�� - �׽�Ʈ ���α׷��� ������ ������ �ұ�Ģ���� ������ �޼ҵ� ȣ��
// => MethodSorters.NAME_ASCENDING : �׽�Ʈ �޼ҵ��� �̸��� �������� �����Ͽ� �޼ҵ� ȣ��
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() {
		/*
		Student student=new Student();
		student.setNo(7000);
		student.setName("�κ���");
		student.setPhone("010-7841-3454");
		student.setAddress("����� �߶���");
		student.setBirthday("2000-09-10");
		*/
		
		//Student Ŭ������ builder() �޼ҵ带 ȣ���Ͽ� StudentBuilder ��ü�� �����޾� �ʵ� ���� 
		//�޼ҵ�� �ʵ尪�� �����ϰ� build() �޼ҵ带 ȣ���Ͽ� Student ��ü�� ��ȯ�޾� ���
		Student student=Student.builder()
				.no(7000)
				.name("�κ���")
				.phone("010-7841-3454")
				.address("����� �߶���")
				.birthday("2000-09-10")
				.build();
		
		studentService.addStudent(student);
	}
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		
		for(Student student : studentList) {
			//DTO Ŭ������ ��ü�� toString() �޼ҵ带 ȣ���Ͽ� ��� �ʵ尪�� ���ڿ��� ��ȯ�޾� ��� ����
			log.info(student.toString());
		}
	}
}