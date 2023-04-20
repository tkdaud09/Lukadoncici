package xyz.itwill.util;

import java.util.List;

import javax.naming.directory.SearchControls;

public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		
		//저장매체에 학생정보를 삽입하는 메소드 호출
		manager.insertStudent(new Student(1000, "홍길동"));
		manager.insertStudent(new Student(2000, "임꺽정"));
		manager.insertStudent(new Student(3000, "전우치"));
		manager.insertStudent(new Student(4000, "일지매"));
		
		if(manager.insertStudent(new Student(5000, "장길산"))) {
			System.out.println("[메세지]학생정보를 성공적으로 삽입 하였습니다.");
		} else {
			System.out.println("[메세지]이미 저장된 학번의 학생정보이므로 삽입되지 않았습니다.");
		}
		System.out.println("==============================================================");
		// 저장매체에 저장된 학생정보 중 학번이 2000인 학생정보를 검색하여 반환하는 메소드 호출
		Student serchStudent=manager.selectStuent(2000);
		if(serchStudent != null) {
			System.out.println(serchStudent);
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("==============================================================");
		//저장매체에 저장된 학생정보 중 학번이 2000인 학생의 이름을 [임걱정]으로 변경하는 메소드 호출
		serchStudent.setName("임걱정");
		if(manager.updateStudent(serchStudent)) {
			System.out.println("[메세지]학생정보를 성공적으로 변경 하였습니다.");
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("==============================================================");
		//저장매체에 저장된 학생정보 중 학번이 [4000]인 학생정보를 삭제학는 메소드 호출
		if(manager.deleteStudent(4000)) {
			System.out.println("[메세지]학생정보를 성공적으로 삭제"
					+ " 하였습니다.");
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("==============================================================");
		List<Student> studentList=manager.selectStudentList();
		
		for(Student student : studentList) { // student에 있는 객체를 일괄처리
			System.out.println(student);//toString() 메소드 자동 호출
		}
		System.out.println("==============================================================");
	}
}