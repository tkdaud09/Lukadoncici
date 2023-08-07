package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	//ȸ�������� �Է¹ޱ� ���� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	//���ް�(ȸ������)�� �����޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ����ϴ� JSP ������
	//���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���ް��� ���� �̸��� �Ű������� �����Ͽ� ���ް��� �����޾� ��û ó�� �޼ҵ忡�� ���
	// => �Ű������� @RequestParam ������̼��� ����Ͽ� ���ް��� �̸��� �Ű������� �̸��� 
	//�ٸ� ��� 400 �����ڵ尡 �߻��ǵ��� �ۼ�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	/*
	//���ް�(ȸ������)�� �����޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ����ϴ� JSP ������
	//���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���ް��� ���� �̸��� �Ű������� �����Ͽ� ���ް��� �����޾� ��û ó�� �޼ҵ忡�� ���
	// => �Ű������� @RequestParam ������̼� ��� @ModelAttribute ������̼� ��� ����
	//@ModelAttribute : ��ü(��)�� �信�� �����ϱ� ���� ������̼�
	// => @ModelAttribute ������̼��� �޼ҵ忡 ����ϸ� �޼ҵ��� ��ȯ���� ��û ó�� Ŭ������
	//��� ��û ó�� �޼ҵ��� �信�� ����
	// => @ModelAttribute ������̼��� �Ű������� ����ϸ� �Ű������� ����� ���� ���� ��û  
	//ó�� �޼ҵ��� �信�� ���� - Model ��ü�� ������� �ʰ� �信�� �ʿ��� ��ü(��)�� �Ӽ������� ���� 
	//value �Ӽ� : �信�� �Ӽ����� ����ϱ� ���� �Ӽ����� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute(value="id") String id, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name, @ModelAttribute("email") String email) {
		return "join_display";
	}
	*/

	/*
	//���ް�(ȸ������)�� �����޾� VO Ŭ������ ��ü �ʵ尪���� �����Ͽ� Request Scope �Ӽ�������
	//�����ϰ� �Ӽ����� ����ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		//VO(DTO) Ŭ������ ��ü �����Ͽ� �Ű������� ����� ���ް����� �ʵ尪 ����
		Member member=new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		
		//model.addAttribute("member", member);
		//Model.addAttribute(Object attributeValue) : ��ü�� �Ӽ����� �����Ͽ� �信�� �����ϴ� 
		//�޼ҵ� - Request Scope
		// => �Ű������� �Ӽ����� ����� �� �ִ� �Ӽ����� �������� ������ �Ӽ������� ����Ǵ�
		//��ü�� �ڷ���(Ŭ����)�� �̸��� �Ӽ������� ��� - ù���ڴ� �ҹ��ڷ� ��ȯ�Ǿ� ���
		// => �Ӽ����� ���ð�(Wrapper ��ü) �Ǵ� ���ڿ�(String ��ü)�� �ݵ�� �Ӽ����� ����
		model.addAttribute(member);
		
		return "join_display";
	}
	*/
	
	/*
	//��û ó�� �޼ҵ��� �Ű������� VO(STO) Ŭ������ �ۼ��ϸ� Front Controller�� VO(DTO) 
	//Ŭ������ ��ü�� �����Ͽ� �Ű������� ����ǵ��� ����
	// => ������ ��û�� ���ް��� ���� �̸��� �ʵ忡 ���ް��� �����޾� �����Ͽ� �Ű������� 
	//VO(DTO) Ŭ������ ��ü�� ����
	//Command ��ü : ���ް��� �����޾� �ʵ忡 ����� ��ü�� �Ӽ������� ����Ǿ� ��û ó��
	//�޼ҵ��� �信�� ���� �� �ֵ��� ����
	// => Command ��ü�� �����ϱ� ���� �Ű������� @ModelAttribute ������̼� ���
	// => @ModelAttribute ������̼��� �����ص� �ڵ����� @ModelAttribute ������̼��� ������ �Ͱ� �����ϰ� ó��
	// => @ModelAttribute ������̼��� value �Ӽ��� �����ϸ� Command ��ü�� �ڷ���(Ŭ����)��
	//�Ӽ������� �ڵ� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute ������̼��� value �Ӽ��� ����Ͽ� �信�� ������ �Ӽ����� �Ӽ����� ���� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc123")) {//���̵� �ߺ��� ���
			model.addAttribute("message", "�̹� ������� ���̵� �Է� �Ͽ����ϴ�");
			return "join_form";
		}
		return "join_display";
	}
	*/
	
	//��û ó�� �޼ҵ��� �Ű������� Map �������̽��� �ۼ��ϸ� Front Controller�� Map(HashMap) 
	//��ü�� �����Ͽ� �Ű������� ����ǵ��� ����
	// => ������ ��û�� ��� ���ް��� Map ��ü�� ��Ʈ���� �߰��Ͽ� �Ű������� Map ��ü�� ����
	// => Map ��ü���� ���ް��� �̸��� ��Ű(MapKey - String)�� �����ް� ���ް��� �ʰ�
	//(MapValue - String)�� �����޾� ��Ʈ���� �߰� 
	// => �Ű������� ���ް��� ����� Map ��ü�� �����ϱ� ���ؼ��� �ݵ�� �Ű������� 
	//@RequestParam ������̼��� ���
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("mem", map);
		return "join_display";
	}
	
	@RequestMapping(value = "/same_param", method = RequestMethod.GET)
	public String input() {
		return "same_form";
	}
	
	//���� �̸����� ���޵� ���� �ִ� ��� �迭�� ������ �� �ִ� �Ű������� �ۼ��Ͽ� ���ް���
	//���ڿ� �迭�� �����޾� ����
	@RequestMapping(value = "/same_param", method = RequestMethod.POST)
	public String input(@RequestParam String[] food, Model model) {
		model.addAttribute("food", food);
		return "same_display";
	}
}
