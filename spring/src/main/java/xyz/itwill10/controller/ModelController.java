package xyz.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name", "ȫ�浿");
		//model.addAttribute("now", new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		return "model_display";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name", "�Ӳ���");
		//model.addAttribute("now", new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		return "model_display";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name", "����ġ");
		//model.addAttribute("now", new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		return "model_display";
	}
	
	//�ý����� ���� ��¥�� �ð��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	//@ModelAttribute : �޼ҵ忡 @ModelAttribute ������̼��� ����ϸ� �޼ҵ忡 ���� ��ȯ�Ǵ� 
	//��ü(��)�� ���� Controller Ŭ������ �ۼ��� ��� ��û ó�� �޼ҵ��� �信�� �����ϴ� ������̼�
	// => ��û ó�� �޼ҵ忡 ���� ���� ó���� �信�� ���������� ���Ǵ� ��ü(��)�� ������ �������� ���
	//value �Ӽ� : �޼ҵ忡 ���� ��ȯ�� ��ü(��)�� �信�� ����ϱ� ���� �̸�(�Ӽ���)�� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@ModelAttribute(value = "now")
	public String getNow() {
		return new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date());
	}
}