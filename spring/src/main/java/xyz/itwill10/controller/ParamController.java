package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	//��û ó�� �޼ҵ��� �Ű������� HttpServletRequest �������̽��� �Ű������� �����ϸ� Front Controller����
	//Ŭ���̾�Ʈ�� ��û������ ����� HttpServletRequest ��ü�� �����޾� ��� ����
	// => HttpServletRequest ��ü�� �޼ҵ带 ȣ���Ͽ� ���� ������ ��û�� ���޵� ���� ��ȯ�޾� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String food=request.getParameter("food");
		request.setAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//��û ó�� �޼ҵ忡�� ���� �������� ��û�� �� ���޵� ���� �̸��� ���� �̸����� ������ �Ǵ� String 
	//Ŭ������ �Ű������� �����ϸ� Front Controller�� ���ް��� �Ű������� �ڵ����� �����Ͽ� ����
	// => ���ް��� �̸��� �Ű������� �̸��� ���� ���� ��� String �ڷ����� �Ű��������� [null] ���� 
	// => �������� �Ű������� ���ް��� �̸��� �Ű������� �̸��� ���� ���� ��� �Ǵ� �������� 
	//���� ���� ���� ���޵� ��� 400 �����ڵ� �߻�
	//�Ű������� �̿��Ͽ� ���ް��� �����޾� ����ϱ� ���� ������Ʈ �޼��� ��ü�ο� ����Ǿ�
	//���޵Ǵ� ���� ���� ��������(ĳ���ͼ�) ���� ó�� - ���ڵ� �ʵ� ���
	//����(Filter) : �����α׷� ���� ���� �Ŀ� ����� ����� �����ϴ� ����� ���α׷�
	// => Filter �������̽��� ��ӹ��� �ڽ�Ŭ����(Filter Ŭ����)�� �����Ͽ� [web.xml] ���Ͽ� ���ͷ� ����Ͽ� ���
	// => ���ʹ� Front Controller ���� ���� ��ġ�Ͽ� �ʿ��� ��� ���� - WAS ���α׷����� ����
	//Ŭ���̾�Ʈ�� ��� ��û�� ���� ������Ʈ �޼��� ��ü�ο� ����Ǿ� ���޵Ǵ� ���� ����
	//��������(ĳ���ͼ�)�� �����ϴ� ���ڵ� ���Ͱ� ���ǵ��� [web.xml] ���� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//���ް��� �����޾� �����ϱ� ���� �Ű������� @RequestParam ������̼��� ��� - ����
	//@RequestParam : ���ް��� �����޾� �Ű������� �����ϱ� ���� ������̼�
	// => �Ű������� �̸��� ���� �̸����� ���޵� ���� ���� ��� 400 �����ڵ� �߻�
	// => ���ް��� �̸��� �Ű������� �̸��� ������ �Ͽ� �Ű������� �ݵ�� ���ް��� ����ǵ���
	//�����ϱ� ���� ������̼�
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(@RequestParam String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//required �Ӽ� : false(���� ���ް�) �Ǵ� true(�ʵ� ���ް� - �⺻��) �� �ϳ��� �Ӽ������� ����
	// => required �Ӽ����� [true]�� �����ϸ� �Ű������� �̸��� ���ް��� �̸��� �����ϰ� �ۼ�
	//�Ͽ� �Ű������� ���ް��� ����ǵ��� ���� 
	// => required �Ӽ����� [true]�� ������ ��� ���ް��� �̸��� �Ű������� �̸��� ���Ƶ� ���ް���
	//������ �Ű������� [null] ���� - 400 �����ڵ� �̹߻� 
	//value �Ӽ� : ���ް��� �̸��� �Ӽ������� ����
	// => @RequestParam ������̼��� value �Ӽ����� �̿��Ͽ� ���ް��� �����޾� �Ű������� ����
	// => ���ް��� �̸��� �Ű������� �̸��� �ٸ��� �ۼ��� ��� ����ϴ� �Ӽ�
	// => �ٸ� �Ӽ��� ������ �Ӽ����� ���� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(@RequestParam(required = true, value = "foodname") String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	//defaultValue �Ӽ� : ���ް��� �Ű������� �̸��� �ٸ� ��� �Ű������� ����� �⺻���� �Ӽ������� ����
	// => ���ް��� ���� ��쿡�� �Ű������� [null] ��� ����� �⺻������ ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(@RequestParam(defaultValue = "�����", value = "foodname") String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
}