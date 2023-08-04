package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//��û ó�� �޼ҵ��� ���� ó���� ����� ��(JSP ����)���� �����ϴ� ���
//1.ModelAndView ��ü�� addObject() �޼ҵ带 ȣ���Ͽ� ó������� �Ӽ������� �����Ͽ� ����
//2.HttpServletRequest ��ü�� setAttribute() �޼ҵ带 ȣ���Ͽ� ó������� �Ӽ������� �����Ͽ� ����
//3.Model ��ü�� addAttribute() �޼ҵ带 ȣ���Ͽ� ó������� �Ӽ������� �����Ͽ� ����

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");

		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView ��ü�� ó������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope
		// => ��(JSP ����)������ EL �Ǵ� JSTL�� �̿��Ͽ� �Ӽ������� �Ӽ����� �����޾� ���
		modelAndView.addObject("mavName", "ȫ�浿");
		
		return modelAndView;
	}
	*/

	//��û ó�� �޼ҵ�� Front Controller�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => ��û ó�� �޼ҵ忡 �Ű������� �ۼ��ϸ� Front Controller�� ������ �����̳�(WebApplicationContext ��ü)
	//���� �Ű������� ���� ������ ��ü(Spring Bean)�� �����޾� ����
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "ȫ�浿");
		return modelAndView;
	}	
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		//HttpServletRequest.setAttribute(String attributeName, Object attributeValue)
		// => HttpServletRequest ��ü�� ó������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope
		request.setAttribute("requestName", "�Ӳ���");
		return "result_display";		
	}
	
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model ��ü : ó������� �Ӽ������� �����Ͽ� �信�� �����ϱ� ���� ��ü
		//model.addAttribute((String attributeName, Object attributeValue)
		// => Model ��ü�� ó������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope
		model.addAttribute("modelName", "����ġ");
		return "result_display";
	}
}