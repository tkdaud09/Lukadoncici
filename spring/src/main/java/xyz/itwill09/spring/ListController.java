package xyz.itwill09.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//모델 기능을 제공하기 위한 클래스 - 요청 처리 클래스
// => Spring 프레임워크의 라이브러리로 제공되는 Controller 인터페이스를 상속받아 작성
// => 클라이언트가 [/list.do]의 URL 주소로 요청한 경우 컨트롤러에 의해 실행될 요청 처리 클래스
public class ListController implements Controller {
	//클라이언트 요청에 의해 자동 호출되는 요청 처리 메소드
	// => ModelAndView 객체에 응답 관련 정보를 저장하여 반환
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView 객체 : 처리결과 및 응답처리를 위한 이동 관련 정보를 저장하기 위한 객체
		ModelAndView modelAndView=new ModelAndView();
		
		//데이타 처리 - Service 클래스의 메소드 호출
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1000,"컴퓨터"));
		productList.add(new Product(2000,"노트북"));
		productList.add(new Product(3000,"테블릿"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => 
		// => 
		
		modelAndView.addObject("productList", productList);
		
		modelAndView.setViewName("product_list");
		
		return modelAndView;
	}
}

























