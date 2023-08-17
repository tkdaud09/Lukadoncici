package xyz.itwill10.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill10.dto.RestMember;

//REST(Representational State Transfer) : �ڿ�(Resource)�� ǥ��(Representational)�� ����
//����(State)�� ����(Transfer)�ϴ� ���� �ǹ�
// => ������ ��û�� ���� �������� Ŭ���̾�Ʈ���� XML �̳� JSON ������ �ؽ�Ʈ ����Ÿ�� ���� ó��
//Restful API : REST ����� ����Ͽ� �� ��ǻ���� �ý����� �����ϰ� ���� �ְ� �ޱ� ���� ���α׷�
// => ����Ʈ����� ���α׷�(��) ������ ���޹޾� ����ϰų� �������� �����޾� ����ϱ� ���� ���

@Controller
@RequestMapping("/rest")
public class RestfulController {
	//ȸ�������� �Է¹ޱ� ���� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "rest/input";
	}
	
	/*
	//���ް��� �Ű������� �����޾� �信�� �Ӽ������� �����Ͽ� ����ϱ� ���� JSP ������ ���̸���
	//��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => �ϳ��� ���ް��� �ϳ��� �Ű������� �����޾� ��û ó�� �޼ҵ忡�� ��� - @RequestParam ������̼� ���
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	*/

	//@ResponseBody : ��û ó�� �޼ҵ��� ��ȯ��(���ڿ�)�� �������� �޼��� ��ü�ο� �����Ͽ�
	//Ŭ���̾�Ʈ���� �ؽ�Ʈ ����Ÿ�� ����ǵ��� ó���ϴ� ������̼�
	// => ��ȯ���� ViewResolver ��ü�� ����Ͽ� ��� ��ȯ�� ���� ó������ �ʰ� ��û ó�� 
	//�޼ҵ尡 ���� ���� ó��
	// => @ResponseBody ������̼� ��� ResponseEntity Ŭ������ ����Ͽ� ���� ó�� ����
	//@RequestBody : ������Ʈ �޼��� ��ü�ο� ����� ��� ���ް��� ���ڿ��� �����ޱ� ���� ������̼�
	// => POST, PUT, PATCH, DELETE ���� ��û������� �������� ��û�� ��� ������Ʈ �޼��� ��ü�ο� 
	//����� ��� ���޵� ���� [�̸�=��&�̸�=��&...] ������ ���ڿ��� �����޾� ��� ����
	// => GET ������� �������� ��û�� ��� ������Ʈ �޼��� ��ü�ΰ� ��� �����Ƿ� @RequestBody ������̼� ��� �Ұ���
	// => ������ ��û�� JSON ������ �ؽ�Ʈ ����Ÿ�� ���޵� ���� �Ű������� �����޾� �����ϱ� ���� ���
	// => @RequestBody ������̼� ��� RequestEntity Ŭ������ ����Ͽ� ��û ó�� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestBody String input) {
		return input;
	}	
	
	/*
	//@ResponseBody ������̼��� ����Ͽ� ��û ó�� �޼ҵ��� ��ȯ��(RestMember ��ü)�� ��������
	//�޼��� ��ü�ο� �����Ͽ� �ؽ�Ʈ ����Ÿ�� Ŭ���̾�Ʈ���� ����ǵ��� ó��
	//������)�������� �޼��� ��ü�ο��� Java ��ü�� �����Ͽ� ���� ó�� �Ұ��� - 406 �����ڵ� �߻�
	//�ذ��)��û ó�� �޼ҵ忡 ���� ��ȯ�Ǵ� Java ��ü�� ���ڿ�(XML �Ǵ� JSON)�� ��ȯ�Ͽ�  
	//�������� �޼��� ��ü�ο� �����Ͽ� ���� ó��
	// => jackson-databind ���̺귯���� ������Ʈ�� ���� ó���ϸ� ��û ó�� �޼ҵ忡 ���� ��ȯ�Ǵ�
	//Java ��ü�� JSON ������ ���ڿ��� �ڵ� ��ȯ�Ͽ� ���� ó�� - ���̺� : pom.xml
	@RequestMapping("/member")
	@ResponseBody
	public RestMember restMember() {
		//RestMember ��ü�� �����Ͽ� ��ȯ 
		// => jackson-databind ���̺귯���� ���� JSON ������ ���ڿ��� �ڵ� ��ȯ�Ǿ� ���� ó��
		// => Java ��ü�� �ڹٽ�ũ��Ʈ�� Object ��ü�� JSON ������ �ؽ�Ʈ ����Ÿ�� ��ȯ�Ǿ� ���� ó��
		return RestMember.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build();
	}
	*/
	
	//@ResponseBody ������̼� ��� ��û ó�� �޼ҵ忡�� ResponseEntity ��ü�� ��ȯ�ص� 
	//Ŭ���̾�Ʈ���� �ؽ�Ʈ ����Ÿ�� ���� ó�� ����
	// => ResponseEntity ��ü�� ���׸����� ���� ó���� Java ��ü�� �ڷ���(Ŭ����)�� ���� 
	@RequestMapping("/member")
	public ResponseEntity<RestMember> restMember() {
		try {
			RestMember member=RestMember.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build();
			//Ŭ���̾�Ʈ���� �����ڵ� 200�� �������� �ؽ�Ʈ�� ���� ó��
			return new ResponseEntity<RestMember>(member, HttpStatus.OK);
		} catch (Exception e) {
			//Ŭ���̾�Ʈ���� �����ڵ� 400���� ���� ó��
			return new ResponseEntity<RestMember>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/member_list")
	@ResponseBody
	public List<RestMember> restMemberList() {
		List<RestMember> memberList=new ArrayList<RestMember>();
		
		memberList.add(RestMember.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build());
		memberList.add(RestMember.builder().id("opq456").name("�Ӳ���").email("opq@itwill.xyz").build());
		memberList.add(RestMember.builder().id("xyz789").name("����ġ").email("xyz@itwill.xyz").build());
		
		//List ��ü�� �ڹٽ�ũ��Ʈ�� Array ��ü�� JSON ������ �ؽ�Ʈ ����Ÿ�� ��ȯ�Ǿ� ���� ó��
		return memberList;
	}

	@RequestMapping("/member_map")
	@ResponseBody
	public Map<String, Object> restMemberMap() {
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("id", "abc123");
		map.put("name", "ȫ�浿");
		map.put("email", "abc@itwill.xyz");
		
		//Map ��ü�� �ڹٽ�ũ��Ʈ�� Object ��ü�� JSON ������ �ؽ�Ʈ ����Ÿ�� ��ȯ�Ǿ� ���� ó��
		return map;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board() {
		return "rest/board";
	}
}
