package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component : Ŭ������ ������ �����̳ʰ� ������ �� �ִ� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� beanName���� �ڵ� ���� - Ŭ������ �̸����� ù���ڴ� �ҹ��ڷ� ��ȯ
// => @Compontent ������̼��� value �Ӽ��� ����Ͽ� beanName ���� ����
//@Component

//@Repository : DAO Ŭ������ ������ �����̳ʰ� ������ �� �ִ� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� beanName���� �ڵ� ���������� value �Ӽ��� ����Ͽ� beanName ���� ����
@Repository
//@Primary : ������ ������ ���� �켱���� �����ϱ� ���� ������̼� 
// => ������ �ڷ����� Ŭ������ @Primary ������̼��� ������ ����ϸ� ������ ���� ����
//@Primary
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ updateStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ deleteStudent(int num) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
}