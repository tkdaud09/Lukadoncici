package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AnnotationStudentMybatisDAO implements StudentDAO {
	public AnnotationStudentMybatisDAO() {
		System.out.println("### AnnotationStudentMybatisDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ updateStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ deleteStudent(int num) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
}