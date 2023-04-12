package enumerate;

public class InterfaceApp {
	public static void main(String[] args) {
		//인터페이스에 선언된 상수필드값 출력
		System.out.println("삽입 = "+InterfaceOne.INSERT);
		System.out.println("변경 = "+InterfaceOne.UPDATE);
		System.out.println("삭제 = "+InterfaceOne.DELETE);
		System.out.println("검색 = "+InterfaceOne.SELECT);
	}
}
