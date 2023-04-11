package inheritance;

//학원인적자원(학생, 강사, 직원) 관리 프로그램
public class AcademyApp {
	public static void main(String[] args) {
		/*
		//학생정보를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyStudent[] students=new AcademyStudent[300];
		
		//강사정보를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyInstructor[] inteructors=new AcademyInstructor[50];
		
		//직원정보를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyStaff[] staffs=new AcademyStaff[100];
		*/
		
		//사람정보(AcademyPerson)를 저장하기 위한 요소들이 존재하는 배열 생성
		// = > 배열 요소에 학생정보(Student 객체), 강사정보(Instructor), 직원정보(Staff) 저장 가능
		// => 부모클래스의 참조변수에 자식클래스의 생성자로 객체를 생성하여 저장 가능
		// => 
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//자식클래스의 생성자로 객체를 생성하면 부모클래스의 객체를 먼저 생성한 후
		//자식클래스의 객체를 생성
		// => 배열 요소에는 부모클래스의 객체가 저장되어 부모클래스의 메소드 호출
		// => 객체의 형변환을 이용하여 배열 요소를 자식클래스의 객체를 일시적으로 저장하여
		//    자식클래스의 메소드 호출 가능
		
		persons[0]=enw AcademyStudent(1000, "홍길동", "웹개발자 과정");
		persons[1]=enw AcademyStudent(2000, "임꺽정", "Java 과목");
		persons[2]=enw AcademyStudent(3000, "전우치", "운영관리팀");
		persons[3]=enw AcademyStudent(4000, "일지매", "웹디자인 과정");
		persons[4]=enw AcademyStudent(5000, "장길산", "경영회계팀");
		
		
		
	}
}
