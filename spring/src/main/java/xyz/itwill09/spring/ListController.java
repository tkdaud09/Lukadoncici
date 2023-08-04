package xyz.itwill09.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//�� ����� �����ϱ� ���� Ŭ���� - ��û ó�� Ŭ����(Controller Ŭ����)
// => Spring �����ӿ�ũ�� ���̺귯���� �����Ǵ� Controller �������̽��� ��ӹ޾� �ۼ�
// => Ŭ���̾�Ʈ�� [/list.do]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� ��û ó�� Ŭ����
public class ListController implements Controller {
	//Ŭ���̾�Ʈ ��û�� ���� �ڵ� ȣ��Ǵ� ��û ó�� �޼ҵ�
	// => ModelAndView ��ü�� ���� ���� ������ �����Ͽ� ��ȯ
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView ��ü : ó����� �� ����ó���� ���� �̵� ���� ������ �����ϱ� ���� ��ü
		ModelAndView modelAndView=new ModelAndView();
		
		//����Ÿ ó�� - Service Ŭ������ �޼ҵ� ȣ��
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1000, "��ǻ��"));
		productList.add(new Product(2000, "��Ʈ��"));
		productList.add(new Product(3000, "�׺�"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView ��ü�� ó������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope
		// => request.setAttribute() �޼ҵ�� ������ ����� �����ϴ� �޼ҵ�
		modelAndView.addObject("productList", productList);
		
		//ModelAndView.setViewName(String viewName) : ModelAndView ��ü�� ���̸�(ViewName)�� �����ϴ� �޼ҵ�
		// => ��Ʈ�ѷ��� ���� ���̸��� JSP ������ �����Ͽ� ������ �̵� - ���� ó��
		modelAndView.setViewName("product_list");
		
		return modelAndView;
	}

}