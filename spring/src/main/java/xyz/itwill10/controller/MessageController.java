package xyz.itwill10.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import xyz.itwill10.dto.Product;

//������ �޼���(Spring Message) : �޼��� �����ϱ� ���� ���
//1.�޼����� ����� Properties ���� ���� - �޼����� {������} ������ ǥ������ ����Ͽ� �ۼ� ����
//2.Spring Bean Configuration File(servlet-context.xml)�� �޼��� ���� ����� �����ϴ� Ŭ������ Spring Bean���� ���
// => �޼����� ����� Properties ������ ��θ� ��ü�� �ʵ尪���� ����ȵ��� ������ ó�� 
//3.��������(JSP ����)���� message �±�(code �Ӽ�)�� ����Ͽ� �޼����� �����޾� ��� ó��
// => {������} ������ ǥ���Ŀ��� arguments �Ӽ��� ����Ͽ� ǥ���� ��� ��µ� ���� ����  

@Controller
@RequestMapping("/msg")
public class MessageController {
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String msg(@ModelAttribute Product product) {
		return "message/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String msg(@ModelAttribute @Valid Product product, Errors errors, HttpSession session) {
		//Locale ��ü�� ����Ͽ� ��� �� ����
		Locale locale=new Locale("en");
		//Session ��ü�� Locale ��ü�� �Ӽ������� ����
		// => �ݵ�� �Ӽ����� SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME ����� ����
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		
		if(errors.hasErrors()) {
			return "message/register";
		}
		return "message/success";
	}
}




