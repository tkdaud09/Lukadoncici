package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : Service Ŭ������ ������ �����̳ʰ� ������ �� �ִ� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� beanName���� �ڵ� ���������� value �Ӽ��� ����Ͽ� beanName ���� ����
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Autowired : ������ �����̳ʷκ��� Spring Bean�� �����޾� �ʵ忡 �����Ͽ� �������踦 
	//�ڵ����� �����ϱ� ���� ������̼� - DI ������ ���� ������̼�
	// => �ʵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - �ʵ� ������ ����
	// => �ʵ尡 ������ ����� ��� �ʵ帶�� @Autowired ������̼��� ����Ͽ� ������ ����
	// => bean ������Ʈ�� autowire �Ӽ����� [byType]���� ������ �Ͱ� ���� ������� ������ ���� - Setter Injection
	// => Setter �޼ҵ带 �̿��Ͽ� �������踦 ���������� Setter �޼ҵ带 �������� ���ϵ� ������ ���� ����
	//������)�ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� ������ ���� ���� - NoUniqueBeanDefinitionException �߻�
	//�ذ��-1)�ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� �ʵ忡 ����� Spring
	//Bean�� �ĺ���(beanName)�� �ʵ��� �����ϰ� ����
	// => @Autowird ������̼��� �ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ���
	//autowire �Ӽ����� [byName]���� ������ �Ͱ� ������ ������� ������ ����
	//�ذ��-2)�ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� �ʵ忡 ����� Spring
	//Bean�� Ŭ������ @Primary ������̼��� ����Ͽ� ������ ����
	//�ذ��-3)@Autowired ������̼ǿ� ���ӵ� @Qualifier ������̼��� ����Ͽ� ������ ����
	//@Qualifier : �ʵ忡 ����� Spring Bean�� ���� �����Ͽ� ������ ����
	// => value �Ӽ��� ������ ������ ���� Spring Bean �ĺ���(beanName)�� �Ӽ������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ���� 
	@Autowired
	//@Qualifier(value = "annotationStudentJdbcDAO")
	@Qualifier("annotationStudentMybatisDAO")
	private StudentDAO studentDAO;
	
	//@Autowired ������̼� ��� @Resource ������̼� �Ǵ� @Inject ������̼��� ����Ͽ� ������ ���� ����
	// => @Autowired ������̼��� Spring �����ӿ�ũ�� ���̺귯������ �����ϴ� ������̼������� 
	//@Resource ������̼� �Ǵ� @Inject ������̼��� Java ���̺귯������ �����ϴ� ������̼�
	// => @Resource ������̼� �Ǵ� @Inject ������̼��� �ٸ� �����ӿ�ũ������ ��� ����
	//@Resource ������̼� : bean ������Ʈ�� autowire �Ӽ����� [byName]���� ������ �Ͱ� ������ ������� ������ ����
	//@Inject ������̼� : bean ������Ʈ�� autowire �Ӽ����� [byType]���� ������ �Ͱ� ������ ������� ������ ����
	// => ������ �ڷ����� Spring Bean�� ������ �ִ� ��� @Named ������̼��� ����Ͽ� ������ ����
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ modifyStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ removeStudent(int num) �޼ҵ� ȣ�� ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}