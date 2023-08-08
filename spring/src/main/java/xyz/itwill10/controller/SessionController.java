package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import xyz.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : Model ��ü�� ����Ͽ� ����Ǵ� �Ӽ����� ���� ��û ó�� Ŭ����(Controller Ŭ����)��
//��� ��û ó�� �޼ҵ�� �信�� �����ϱ� ���� ������̼�
// => Model ��ü�� ����Ͽ� ����Ǵ� �Ӽ����� Request Scope �Ӽ����� �ƴ� �������� Session Scope �Ӽ�����
//��ȯ�Ͽ� ���ǵ��� �����ϴ� ������̼�
// => �ٺ��� ó���� ȣ��Ǵ� ��û ó�� �޼ҵ忡�� ������ ��ü�� �˻����� �ʰ� �信���� ����
//�������� �ʵ��� �������� Session Scope �Ӽ����� �����ϱ� ���� ����
//��value �Ӽ��� : �������� Session Scope �Ӽ������� ��ȯ�ϱ� ���� �Ӽ����� �Ӽ������� ����
// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
@SessionAttributes("hewon")
public class SessionController {
	//���̵� ���޹޾� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ� - Service Ŭ������ �޼ҵ�
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setName("ȫ�浿");
		hewon.setEmail("abc@itwill.xyz");
		return hewon;
	}
	
	//���̵� ���޹޾� ���̵��� ȸ�������� �˻��Ͽ� �信�� �����ϱ� ���� ��û ó�� �޼ҵ�
	// => ��û ó�� �޼ҵ忡�� �˻��� ȸ�������� �Ӽ������� �����Ͽ� ��(JSP)���� HTML �±׸� ����Ͽ� ��µǵ��� ���� ó��
	@RequestMapping("/hewon_view")
	public String view(@RequestParam(defaultValue = "abc123") String id, Model model) {
		//Service Ŭ������ �޼ҵ带 ȣ���Ͽ� �Ű������� ���޵� ���̵��� ȸ�������� �˻��Ͽ� ��ȯ�޾� ����
		Hewon hewon=getHewon(id);
		
		//Model ��ü�� ����Ͽ� �˻��� ȸ�������� �Ӽ������� �����Ͽ� �信�� ����
		// => ���� ��û ó�� �޼ҵ��� �信�Ը� �Ӽ����� �����Ͽ� ���� ó�� - Request Scope
		//model.addAttribute("hewon", hewon);
		
		//�Ӽ����� �����ϸ� �Ӽ������� ����� ��ü�� �ڷ���(Ŭ����)�� �̸��� �Ӽ������� �ڵ� ����
		// => �Ӽ����� Ŭ���� �̸��� ù���ڴ� �ҹ��ڷ� �ڵ� ��ȯ
		//@SessionAttributes ������̼ǿ� ���� Model ��ü�� ����� �Ӽ����� �������� Session Scope 
		//�Ӽ������� ��ȯ�Ǿ� ���� ��û ó�� Ŭ������ ��� ��û ó�� �޼ҵ�� �信�� �Ӽ��� ����
		model.addAttribute(hewon);//�Ӽ��� ���� ����
		
		return "hewon_view";
	}
	
	/*
	//���̵� ���޹޾� ���̵��� ȸ�������� �˻��Ͽ� �信�� �����ϱ� ���� ��û ó�� �޼ҵ�
	// => ��û ó�� �޼ҵ忡�� �˻��� ȸ�������� �Ӽ������� �����Ͽ� ��(JSP)���� �Է� �±��� �ʱⰪ���� ���ǵ��� ���� ó��
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update(@RequestParam(defaultValue = "abc123") String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "hewon_update";
	}
	*/

	//@SessionAttributes ������̼ǿ� ���� ������ ȸ�������� ��û ó�� �޼ҵ�� �信�� ��� ����
	// => ���̵� ���޹޾� ȸ�������� �˻��ϴ� ��ɰ� �信�� �Ӽ����� �����Ͽ� �����ϴ� ��� ���ʿ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update() {
		return "hewon_update";
	}
	
	/*
	//ȸ�������� ���޹޾� ����� ȸ�������� �信�� �����ϴ� ��û ó�� �޼ҵ�
 	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon) {
 		return "hewon_result";
	}
	*/

	//��û ó�� �޼ҵ��� �Ű��������� @SessionAtrributes ������̼ǿ� ���� ������ ȸ��������
	//���޹޾� �����ϰ� ���氪���� �Ű������� ����� ��ü�� �ʵ尪�� ���� ó��
	//SessionStatus �������̽��� �Ű������� �ۼ��Ͽ� SessionStatus ��ü�� �����޾� ����
	// => SessionStatus ��ü : @SessionAtrributes ������̼ǿ� ���� ������ �������� Session
	//Scope �Ӽ����� ���������� �����ϱ� ���� ��ü
 	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon, SessionStatus sessionStatus) {
 		//SessionStatus.setComplete() : @SessionAtrributes ������̼ǿ� ���� ������ �������� 
 		//Session Scope �Ӽ����� �����ϴ� �޼ҵ�
 		// => �ٸ� ��û ó�� �޼ҵ�� �信�� �������� Session Scope �Ӽ����� ������� ���ϵ��� ����
 		sessionStatus.setComplete();
		return "hewon_result";
	}
}






