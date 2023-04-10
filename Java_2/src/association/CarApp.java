package association;

public class CarApp {
	public static void main(String[] args) {
		//엔진 생성
		Engine engine=new Engine();
		
		engine.setFualType("경유");
		engine.setDisplacement(2000);
		
		//engine.displayEngine();
		
		//자동차 생성
		Car carOne=new Car();
		
		carOne.setModelName("쏘렌토");
		carOne.setProductionYear(2020);
		//Setter 메소드를 호출하여 매개변수에 엔진정보(Engine 객체)를 전달받아 필드에 전달
		carOne.setCarEngine(engine);
		
		carOne.displayCar();
		
	}
}