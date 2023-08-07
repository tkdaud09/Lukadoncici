package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		//Model ��ü�� ����Ͽ� ��(View)���� ������ ��ü�� �Ӽ������� ���� - Request Scope
		model.addAttribute("name", "ȫ�浿");
		
		//�並 �����ϱ� ���� ���̸�(ViewName) ��ȯ
		// => Front Controller(DispatchServlet Ŭ����)�� �������� ���̸��� InternalResourceViewResolver 
		//��ü�� ����Ͽ� JSP ������ ��ȯ�ϰ� JSP ������ ������ �̵��Ͽ� ���� ó��
		//������ �̵� : ���� ���ο��� ���� �����α׷��� �����带 �ٸ� �����α׷����� �̵��Ͽ� ���� ó��
		// => Ŭ���̾�Ʈ�� ��û URL �ּҴ� ������� ������ Request Scope �Ӽ����� ��ü�� �����޾� ��� ����
		return "display_forward";
	}
	
	/*
	@RequestMapping("/redirect_move")
	public String redirect(Model model) {
		model.addAttribute("name", "�Ӳ���");
		return "display_redirect";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//��û ó�� �޼ҵ��� ��ȯ��(���̸�)�� redirect ���λ縦 ����Ͽ� URL �ּҸ� ��ȯ�ϸ� Front
		//Controller(DispatchServlet Ŭ����)�� ��ȯ���� ���̸��� URL �ּҸ� Ŭ���̾�Ʈ���� ����
		// => URL �ּҸ� ���޹��� Ŭ���̾�Ʈ�� �������� ��û URL �ּҸ� �����Ͽ� URL �ּ���
		//�����α׷��� ��û�Ͽ� �������� ����޾� ��� ó�� - �����̷�Ʈ �̵�
		//�����̷�Ʈ �̵� : Ŭ���̾�Ʈ�� URL �ּҸ� �����Ͽ� �������� ���û�� �����α׷��� 
		//�������� �����޾� ���� ó��
		// => Ŭ���̾�Ʈ�� ��û URL �ּҴ� ��������� Request Scope �Ӽ��� ��� �Ұ���
		return "redirect:/redirect_move"; 
	}
	*/
	
	/*
	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
	
	
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		//Model ��ü�� ����� �Ӽ����� �����̷�Ʈ �̵��� �������� ��û ó�� �޼ҵ�� �信�� ��� �Ұ���
		// => Model ��ü�� ����� �Ӽ���(��ü)�� ���ǹ��ڿ�(QueryString)�� ��û �������� ���� 
		model.addAttribute("name", �Ӳ���);
		return "redirect:/redirect_move"; 
	}
	*/
	
	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
	
	//��û ó�� �޼ҵ忡 RedirectAttributes �������̽��� �Ű������� �ۼ��Ͽ� RedirectAttributes
	//��ü�� Front Controller���� �����޾� ��� ����
	//RedirectAttributes ��ü : ����̷�Ʈ �̵��Ǵ� �������� ��û ó�� �޼ҵ�� �信�� ���
	//������ Request Scope �Ӽ����� �����ϱ� ���� ��ü
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => Request Scope �Ӽ����� �����Ͽ� ���ٷ���Ʈ �̵��Ǵ� �������� ��û ó�� �޼ҵ��
		//�信�� �Ӽ����� �����ϱ� ���� �޼ҵ�
		attributes.addFlashAttribute("name", "�Ӳ���");
		return "redirect:/redirect_move"; 
	}
}