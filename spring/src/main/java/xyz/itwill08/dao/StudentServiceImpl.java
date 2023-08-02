package xyz.itwill08.dao;

import java.util.List;

import lombok.Setter;

public class StudentServiceImpl implements StudentService {
	//StudentDAO �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü�� �����ϱ� ���� �ʵ�
	// => Spring Bean Configuration File���� Service Ŭ������ Spring Bean���� ����� �� StudentDAO
	//�������̽��� ��ӹ��� �ڽ�Ŭ������ Spring Bean�� �����޾� ������ ���� - Setter Injection
	@Setter
	private StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}
}
