package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

//@Controller : ��û ó�� Ŭ����(Controller Ŭ����)�� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� Spring Bean�� �ĺ���(beanName)���� �ڵ� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
// => value �Ӽ��� ����Ͽ� Spring Bean�� �ĺ���(beanName) ���� ����

@Slf4j
//@Controller ������̼��� ����ϸ� Controller �������̽��� ��ӹ��� �ʾƵ� ��û ó�� Ŭ������ �ۼ� ����
// => @RequestMapping ������̼��� ����Ͽ� �޼ҵ带 ��û ó�� �޼ҵ� ó���ǵ��� �ۼ�
// => @RequestMapping ������̼��� ����Ͽ� ��û ó�� �޼ҵ带 ������ ���� ���� 
@Controller
public class HelloController {
	
	//��û ó�� �޼ҵ�� Front Controller���� �ݵ�� ���̸�(ViewName) ����
	// => Front Controller�� �������� ���̸��� �̿��Ͽ� ViewResolver ��ü�� ���� ó���ǵ��� ��ȯ
	//1.�޼ҵ��� ��ȯ���� [void]�� �ۼ��� ��� �޼ҵ��� �̸��� ���̸����� ���� 
	//2.�޼ҵ��� ��ȯ���� [String]�� �ۼ��� ��� �޼ҵ��� ��ȯ��(���ڿ�)�� ���̸����� ���� 
	//3.�޼ҵ��� ��ȯ���� [ModelAndView]�� �ۼ��� ��� ��ȯ�� ModelAndView ��ü�� ���̸��� �����Ͽ� ����

	//Front Controller�� InternalResourceViewResolver�� ����� ��� ���̸����� ������ JSP ������ ���� ó��  
	//Front Controller�� BeanNameViewResolver�� ����� ��� Spring Bean���� ���� ó�� ����
	// => ��û ó�� �޼ҵ��� ��ȯ���� Map �������̽� �Ǵ� Model �������̽��� ���� ����  

	//@RequestMapping : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �޼ҵ�� �����ϱ� ���� ������̼�
	// => �⺻������ Ŭ���̾�Ʈ�� ��� ��û���(Method - GET, POST, PUT, PATCH, DELETE ��)�� 
	//���� ȣ��Ǵ� ��û ó�� �޼ҵ带 �ۼ��� ��� ����ϴ� ������̼�
	// => Ŭ���̾�Ʈ�� ��û����� �����Ͽ� ��û ó�� �޼ҵ带 ȣ���ϰ��� �� ��� @GetMapping
	//, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping ���� ������̼��� ��� ����
	//value �Ӽ� : Ŭ���̾�Ʈ�� ��û����(URL �ּ�)�� �Ӽ������� ����
	// => Ŭ���̾�Ʈ�� ��û URL �ּҷ� Front Controller�� ���� ��û ó�� �޼ҵ� �ڵ� ȣ��
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	// => �ٸ� ��û ó�� �޼ҵ��� value �Ӽ����� �ߺ��� ��� WAS ���α׷� ���۽� ���� �߻�
	@RequestMapping(value = "/hello")
	public void hello() {//��û ó�� �޼ҵ�
		//��û ó�� ��� �ۼ� - Service Ŭ������ �޼ҵ� ȣ��
		log.info("[/hello] ������ ��û : HelloController Ŭ������ hello() �޼ҵ� ȣ��");
	}

	@RequestMapping("/helloViewName")
	public String helloViewName() {
		log.info("[/helloViewName] ������ ��û : HelloController Ŭ������ helloViewName() �޼ҵ� ȣ��");
		return "hello";
	}
	
	@RequestMapping("/helloMav")
	public ModelAndView helloModelAndView() {
		log.info("[/helloMav] ������ ��û : HelloController Ŭ������ helloModelAndView() �޼ҵ� ȣ��");
		
		//ModelAndView : ó������� �Ӽ������� �����ϰ� ���̸�(ViewName)�� �����ϱ� ���� ��ü
		//ModelAndView modelAndView=new ModelAndView();
		//modelAndView.setViewName("hello");//Setter �޼ҵ�� ���̸� ����
		
		ModelAndView modelAndView=new ModelAndView("hello");//�����ڷ� ���̸� ����
		
		return modelAndView;
	}
}