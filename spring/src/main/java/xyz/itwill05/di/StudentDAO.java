package xyz.itwill05.di;

import java.util.List;

//�л������� ó���ϴ� DAO Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => ��ü���� ���յ��� ���� ���������� ȿ���� ����
public interface StudentDAO {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int num);
	Student selectStudent(int num);
	List<Student> selectStudentList();
}