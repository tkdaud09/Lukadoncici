package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

//SpringMVC ����� ����Ͽ� �����α׷��� �ۼ��ϴ� ���
// => ���̺� >> DTO Ŭ���� >> DAO Ŭ����(Mybatis) >> Service Ŭ���� >> Controller Ŭ����
// >> �׽�Ʈ ���α׷�(JUnit) - ���� ���α׷�(���) �׽�Ʈ >> HTML ������ JSP ������ ��ȯ
// >> ���� ���α׷� �׽�Ʈ - ������ �̿�

//Mybatis �����ӿ�ũ���� �߻��Ǵ� �α� �̺�Ʈ�� Spring �����ӿ�ũ�� �α� ����ü�� ����ϴ� ���
//1.log4jdbc-log4j2-jdbc4 ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.Spring Bean Configuration File(root-context.xml)���� DataSource ���� Ŭ������ Spring Bean���� 
//����� bean ������Ʈ�� driverClassName �ʵ�� url �ʵ��� ���� ���� 
//3.[src/main/resources] ������ [log4jdbc.log4j2.properties] ���� �ۼ�
// => Mybatis �����ӿ�ũ���� �߻��Ǵ� �α� �̺�Ʈ�� Spring �����ӿ�ũ�� �α� ����ü���� ����
//�ϱ� ���� SpyLogDelegator Ŭ������ �����ϱ� ���� ����
//4.SpyLogDelegator ��ü�� ���� �߻��� �α� �̺�Ʈ�� Spring �����ӿ�ũ�� �α� ����ü�� ��ϵǵ���
//ȯ�漳������ ���� - log4j.xml : logger ������Ʈ �߰�

//Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �����ϱ� ���� Ŭ����

//Controller Ŭ������ Front Controller(DispatchServlet Ŭ����)���� ��ü�� �����Ǿ� ���ǵ��� �ݵ�� Spring Bean���� ���
// => Controller Ŭ������ @Controller ������̼��� ����Ͽ� Spring Bean���� ���
//=> @Controller ������̼��� ����ϸ� Ŭ���̾�Ʈ ��û�� ���� ȣ��Ǵ� ��û ó�� �޼ҵ� �ۼ�
//=> @Controller ������̼��� ������ �����̳ʰ� ó���ϱ� ���� �ݵ�� Ŭ������ �ۼ��� ��Ű����
//Spring Bean Configuration File(servlet-context.xml)�� component-scan ������Ʈ�� �˻��ǵ��� ����

@Controller
@RequiredArgsConstructor
public class StudentController {
	//Controller Ŭ������ ��û ó�� �޼ҵ忡�� ���� Service Ŭ������ ��ü�� �����ϱ� ���� �ʵ�
	// => �����ڸ� �̿��Ͽ� �ʵ忡 Service Ŭ������ ��ü(Spring Bean)�� ����ǵ��� ������ ����
	private final StudentService studentService;
	
	//�л������� �Է¹ޱ� ���� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String add() {
		return "student/student_add";
	}
	
	//���ް�(�л�����)�� �����޾� STUDENT ���̺� �л������� �����ϰ� �л������ ����ϴ� 
	//JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Service Ŭ������ ��ü�� �޼ҵ带 ȣ���Ͽ� ����Ÿ ó�� ��� ���� 
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			//Service Ŭ������ �޼ҵ� ȣ��� ���� �߻� - �ߺ��� �л���ȣ�� ���޵Ǿ� PK �������� ���� 
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "�̹� ������� �л���ȣ�� �Է� �Ͽ����ϴ�.");
			return "student/student_add";//������ �̵�
		}
		return "redirect:/student/display";//����̷�Ʈ �̵�
	}
	
	//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� �Ӽ������� �����ϰ� �л������ ����ϴ�
	//JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping("/student/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/student_display";
	}
}