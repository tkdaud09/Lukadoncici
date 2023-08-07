package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Data;
import xyz.itwill10.dto.Member;


@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login_form";
	}
	
	/*
	//���ް�(�α�������)�� �����޾� ���� ó�� �� ���� ���� ������ Session Scope �Ӽ������� �����ϰ�
	//�α��� ���� �޼����� ����ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���ް��� String Ŭ������ �Ű������� �ϳ��� �����޾� ���
	// => Session Scope �Ӽ����� �����ϱ� ���� �Ű������� HttpSession ��ü�� �����޾� ��� 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, HttpSession session, Model model) {
		if(!id.equals("abc123") || !passwd.equals("123456")) {//���� ����
			//���� ���� ���� ������ Request Scope �Ӽ������� ���� - �Է�������(JSP)���� ��� ����
			//Request Scope : ���� ��û ó�� �޼ҵ�� ������ �̵� �Ǵ� ��(JSP)������ �Ӽ����� �����޾� ���
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� �߸� �Է� �Ͽ����ϴ�.");
			model.addAttribute("id", id);
			return "login_form";//�Է��������� �̵�
		}
		
		//���� ���� - ���� ���� ������ Session Scope �Ӽ������� ����
		//Session Scope : ������ ������ ����ϴ� ��� ��û ó�� �޼ҵ�� �信�� �Ӽ����� �����޾� ���
		session.setAttribute("loginId", id);
		
		return "login_display";
	}
	*/

	//���ް�(�α�������)�� �����޾� ���� ó�� �� ���� ���� ������ Session Scope �Ӽ������� �����ϰ�
	//�α��� ���� �޼����� ����ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��� ���ް��� Member Ŭ������ �Ű������� �ʵ尪���� �����޾� ���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Member member, HttpSession session, Model model) {
		if(!member.getId().equals("abc123") || !member.getPasswd().equals("123456")) {//���� ����
			//���� ���� ���� ������ Request Scope �Ӽ������� ���� - �Է�������(JSP)���� ��� ����
			//Request Scope : ���� ��û ó�� �޼ҵ�� ������ �̵� �Ǵ� ��(JSP)������ �Ӽ����� �����޾� ���
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� �߸� �Է� �Ͽ����ϴ�.");
			return "login_form";//�Է��������� �̵�
		}
		
		//���� ���� - ���� ���� ������ Session Scope �Ӽ������� ����
		//Session Scope : ������ ������ ����ϴ� ��� ��û ó�� �޼ҵ�� �信�� �Ӽ����� �����޾� ���
		session.setAttribute("loginId", member.getId());
		
		return "login_display";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginId");
		session.invalidate();
		
		return "logout_display";
	}
	
	@RequestMapping("/login_display")
	public String login(HttpSession session, Model model) {
		if(session.getAttribute("loginId")==null) {
			model.addAttribute("message", "�α��� ����ڸ� ���� �����մϴ�.");
			return "login_form";
		} 
		
		return "login_display";
	}
}