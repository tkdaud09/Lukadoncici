package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

//학생정보를 관리하는 프로그램 작성
// => 메뉴 선택에 따른 학생정보 삽입,변경,삭제,검색 기능 제공
// => 입력과 출력은 프로그램에서 구현하고 데이타 처리는 DAO 클래스의 메소드를 호출하여 처리
public class StudentCUIApp {
	//키보드 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	public StudentCUIApp() {
		//키보드로부터 문자열을 입력받기 위한 입력스트림을 생성하여 필드에 저장
		in=new BufferedReader(new InputStreamReader(System.in));
		
		String[] menu={"1.학생정보 삽입","2.학생정보 변경","3.학생정보 삭제"
			,"4.학생정보 검색","5.학생목록 출력","6.프로그램 종료"};
		
		System.out.println("<< 학생 관리 프로그램 >>");
		
		while(true) {
			//메뉴 출력
			for(String item : menu) {
				System.out.println(item);
			}
			
			int choice;
			try {
				System.out.print("메뉴 선택[1~6] >> ");
				//키보드로 문자열을 입력받아 정수값으로 변환하여 변수에 저장
				choice=Integer.parseInt(in.readLine());
				//메뉴 선택을 잘못한 경우 인위적 예외 발생 
				if(choice < 1 || choice > 6) throw new Exception();
			} catch (Exception e) {
				System.out.println("[에러]메뉴를 잘못 선택 하였습니다.");
				System.out.println();
				continue;//반복문(while) 재실행
			}
			System.out.println();

			if(choice == 6) break;//반복문(while) 종료
			
			//메뉴 선택에 따른 기능 구현 - 메소드 호출
			switch(choice) {
			case 1: addStudent(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			}
			System.out.println();
		}
		System.out.println("[메세지]학생 관리 프로그램을 종료합니다.");
	}
	
	public static void main(String[] args) {
		new StudentCUIApp();
	}
	
	//[1.학생정보 삽입] 메뉴를 선택한 경우 호출되는 메소드
	// => 키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 처리결과를 출력하는 메소드
	public void addStudent() {
		System.out.println("### 학생정보 삽입 ###");
		
		try {
			//키보드로 학생정보를 입력받아 저장 - 입력값 검증
			// => 입력값 검증이 실패한 경우 재입력되도록 처리
			
			int no;//학번을 입력받아 저장하기 위한 변수
			while(true) {//학번 입력값을 검증하기 위한 반복문
				System.out.print("학번 입력 >> ");
				String noTemp=in.readLine();
				
				if(noTemp == null || noTemp.equals("")) {//입력값이 없는 경우
					System.out.println("[입력오류]학번을 반드시 입력해 주세요.");
					continue;//반복문 재실행 - 비정상적인 값 입력 : 재입력
				}
				
				//학번에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String noReg="^[1-9][0-9]{3}$";
				if(!Pattern.matches(noReg, noTemp)) {//정규표현식과 입력값의 입력패턴이 다른 경우
					System.out.println("[입력오류]학번은 4자리 숫자로만 입력해 주세요.");
					continue;	
				}
				
				no=Integer.parseInt(noTemp);//문자열을 정수값으로 변환하여 변수에 저장
				
				//입력된 학번이 STUDENT 테이블에 저장된 기존 학생정보의 학번과 비교하여
				//중복된 경우 비정상적인 값이므로 재입력 처리
				
				//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여
				//반환하는 DAO 클래스의 메소드 호출
				// => null 반환 : 학생정보 미검색 , StudentDTO 객체 반환 : 학생정보 검색
				//싱글톤 클래스는 객체를 반환받아 직접 메소드 호출 - 참조변수 불필요
				StudentDTO student=StudentDAOImpl.getDAO().selectStudent(no);
				
				if(student != null) {//키보드로 입력된 학번의 학생정보가 검색된 경우 - 학번 중복
					System.out.println("[입력오류]이미 사용중인 학번을 입력 하였습니다.");
					continue;	
				}
				
				break;//반복문 종료 - 정상적인 값 입력
			}
			
			String name;//이름을 저장하기 위한 변수
			while(true) {
				System.out.print("이름 입력 >> ");
				name=in.readLine();
				
				if(name == null || name.equals("")) {
					System.out.println("[입력오류]이름을 반드시 입력해 주세요.");
					continue;
				}
				
				//이름에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String nameReg="^[가-힣]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[입력오류]이름은 2~5 범위의 한글로만 입력해 주세요.");
					continue;	
				}
				
				break;
			}
			
			String phone;//전화번호를 저장하기 위한 변수
			while(true) {
				System.out.print("전화번호 입력 >> ");
				phone=in.readLine();
				
				if(phone == null || phone.equals("")) {
					System.out.println("[입력오류]전화번호를 반드시 입력해 주세요.");
					continue;
				}
				
				//전화번호에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(!Pattern.matches(phoneReg, phone)) {
					System.out.println("[입력오류]전화번호를 형식에 맞게 입력해 주세요.");
					continue;	
				}
				
				break;
			}
			
			String address;//주소를 저장하기 위한 변수
			while(true) {
				System.out.print("주소 입력 >> ");
				address=in.readLine();
				
				if(address == null || address.equals("")) {
					System.out.println("[입력오류]주소를 반드시 입력해 주세요.");
					continue;
				}
				
				break;
			}
			
			String birthday;//생년월일을 저장하기 위한 변수
			while(true) {
				System.out.print("생년월일 입력 >> ");
				birthday=in.readLine();
				
				if(birthday == null || birthday.equals("")) {
					System.out.println("[입력오류]생년월일을 반드시 입력해 주세요.");
					continue;
				}
				
				//생년월일에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if(!Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[입력오류]생년월일을 형식에 맞게 입력해 주세요.");
					continue;	
				}
				
				break;
			}
			
			//키보드로 입력받은 학생정보를 STUDENT 테이블에 행으로 삽입 - DAO 클래스의 메소드 호출
			
			//학생정보를 저장하기 위한 StudentDTO 객체 생성
			StudentDTO student=new StudentDTO();
			//키보드로 입력받은 값으로 StudentDTO 객체의 필드값 변경
			student.setNo(no);
			student.setName(name);
			student.setPhone(phone);
			student.setAddress(address);
			student.setBirthday(birthday);
			
			
			//학생정보를 전달받아 STUDENT 테이블에 삽입하는 DAO 클래스의 메소드 호출
			int rows=StudentDAOImpl.getDAO().insertStudent(student);
			
			System.out.println("[처리결과]"+rows+"명의 학생정보를 삽입 하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
