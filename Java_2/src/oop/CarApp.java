package oop;

//클래스로 객체를 생성하는 방법
//형식) 클래스명 참조변수 = new 클래스명(); 
//생성자(Constructor) : 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자(Default 
//Constructor)가 자동으로 생성되어 제공

// => new 연산자로 클래스의 기본생성자를 호출하여 객체를 생성하고
//	  생성된 객체의 메모리 주소를 참조변수에 저장
// => 참조변수에 저장된 객체는 . 연산자를 사용하여 필드 또는
//	  메소드에 이용해 프로그램 작성

//Car 클래스를 객체로 생성하여 작성된 프로그램
public class CarApp {
	public static void main(String[] args) {
		//Car 클래스를 객체를 생성하여 참조변수에 저장
		// => 하나의 클래스로 서로 다른 객체를 여러개 생성 가능
		// => 클래스는 객체를 생성하기 위한 틀(Template)
		// => 객체를 생성하면 객체 필드에서는 기본값을 초기값으로 자동 저장
		//	  기본값(숫자형 : 0, 논리형 : false, 참조형 : null)
		Car carOne=new Car();
		Car carTwo=new Car();
		Car carThree=new Car();
		
		System.out.println("carOne ="+carOne);
		System.out.println("carTwo ="+carTwo);
		System.out.println("carThree ="+carThree);
		System.out.println("====================================================");
		//참조변수(객체).필드명 : 참조변수에 저장된 객체가 . 연산자를 사용하여
		//                        필드에 접근
		// => 객체의 필드에는 기본값이 초기값으로 자동 저장
		carOne.modelName="싼타페";//객체의 필드값 변경
		
		System.out.println("첫번째 자동차 모델명 = "+carOne.modelName);//객체의 필드값 사용
		System.out.println("첫번째 자동차 엔진상태 = "+carOne.engineStatus);
		System.out.println("첫번째 자동차 현재속도 = "+carOne.currentSpeed);
		System.out.println("====================================================");
		carTwo.modelName="소나타";
		carTwo.engineStatus=true; //권장xx 객체지향은 메소드 출력해서하는걸 추구
		carTwo.currentSpeed=80;
		
		System.out.println("첫번째 자동차 모델명 = "+carTwo.modelName);//객체의 필드값 사용
		System.out.println("첫번째 자동차 엔진상태 = "+carTwo.engineStatus);
		System.out.println("첫번째 자동차 현재속도 = "+carTwo.currentSpeed);
		System.out.println("====================================================");
		//참조변수(객체).메소드명(값,값...) : 참조변수에 저장된 객체가 . 연산자를 사용하여 메소드 호출
		carOne.startEngine(); //>>>> 필드값 변경 false >> true
		carOne.speedUp(50);
		carOne.speedUp(30);
		carOne.speedDown(40);
		//carOne.speedZero();
		carOne.stopEngine();
		System.out.println("====================================================");
		
	
	}
}
