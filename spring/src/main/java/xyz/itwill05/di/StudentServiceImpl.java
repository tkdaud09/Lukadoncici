package xyz.itwill05.di;

import java.util.List;

//Service Ŭ���� : ���α׷� ���࿡ �ʿ��� ����Ÿ ó�� ����� �����ϴ� Ŭ���� - ���۳�Ʈ
// => Service Ŭ������ �޼ҵ�� �ټ��� DAO ��ü�� �޼ҵ带 ȣ���Ͽ� �ۼ� - DAO ���ȭ
// => Service Ŭ������ �޼ҵ忡�� DAO ��ü�� ����ϱ� ���� ���԰���(��������)�� �����ǵ��� �ۼ�
// => Service Ŭ������ ����ŵ� Service Ŭ������ ����ϴ� Ŭ����(��Ʈ�ѷ� - ��)�� ������ 
//�ּ�ȭ �ϱ� ���� �ݵ�� �������̽��� ��ӹ޾� �ۼ� - ���յ��� ���� ���������� ȿ���� ����
public class StudentServiceImpl implements StudentService {
	//StudentJdbcDAO Ŭ������ �ʵ� ���� - StudentJdbcDAO ��ü�� ���� ������ �ʵ�
	// => �ʵ忡 StudentJdbcDAO ��ü�� �����ؾ߸� ���԰���(��������)�� �ϼ�
	// => StudentServiceImpl Ŭ������ �޼ҵ忡�� �ʵ忡 ����� StudentJdbcDAO ��ü�� �޼ҵ� ȣ�� ����
	//������)DAO Ŭ������ ����� ��� Service Ŭ������ �ʵ� �� �޼ҵ� ���� ����
	// => ���յ��� ���� ���������� ȿ���� ����
	//private StudentJdbcDAO studentJdbcDAO;

	//StudentDAO �������̽��� �ʵ� ���� - StudentDAO �������̽��� ��ӹ��� �ڽ�Ŭ������ ������ ��� ��ü ����
	// => �ʵ忡 StudentDAO �������̽��� ��ӹ��� DAO Ŭ������ ��ü�� �����ؾ߸� ���԰���(��������)�� �ϼ�
	// => StudentServiceImpl Ŭ������ �޼ҵ忡�� �������̽��� ������ �ʵ��� �߻�޼ҵ带 ȣ���ϸ�
	//�ʵ忡 ����� �ڽ�Ŭ���� ��ü�� �޼ҵ� ȣ�� - �������̵��� ���� ������
	// => DAO Ŭ������ ����ŵ� Service Ŭ������ ���� �ּ�ȭ - ���յ��� ���� ���������� ȿ���� ����
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentDAO(StudentDAO studentDAO) �޼ҵ� ȣ�� ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ modifyStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ removeStudent(int num) �޼ҵ� ȣ�� ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}