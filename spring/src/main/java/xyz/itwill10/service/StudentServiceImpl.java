package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

//Service Ŭ���� : ����Ÿ ó�� ���� ����� ���ȭ�Ͽ� �����ϱ� ���� ����� �����ϱ� ���� Ŭ����
// => Service Ŭ������ �޼ҵ忡���� ����Ÿ ó���� �ʿ��� ����� �����ϱ� ���� DAO Ŭ������ �޼ҵ带 
//ȣ���Ͽ� �ۼ� - ���۳�Ʈ(Component)
// => Service Ŭ������ ����ŵ� ��������� ������ Controller Ŭ������ ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� �ۼ�
 
//Service Ŭ������ Controller Ŭ������ ��ü�� �����Ǿ� ���ǵ��� �ݵ�� Spring Bean���� ���
// => Service Ŭ������ @Service ������̼��� ����Ͽ� Spring Bean���� ���
// => @Service ������̼��� ����ϸ� TransactionManager�� ���� Ʈ������ ���� ����
// => @Service ������̼��� ������ �����̳ʰ� ó���ϱ� ���� �ݵ�� Ŭ������ �ۼ��� ��Ű����
//Spring Bean Configuration File(servlet-context.xml)�� component-scan ������Ʈ�� �˻��ǵ��� ����
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	//Service Ŭ������ �޼ҵ忡�� ���� DAO Ŭ������ ��ü�� �����ϱ� ���� �ʵ�
	// => �����ڸ� �̿��Ͽ� �ʵ忡 DAO Ŭ������ ��ü(Spring Bean)�� ����ǵ��� ������ ����
	private final StudentDAO studentDAO;
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}