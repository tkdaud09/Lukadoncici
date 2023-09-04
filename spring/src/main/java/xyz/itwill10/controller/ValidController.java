package xyz.itwill10.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Employee;

//������ ����(Spring Validation) : ����� �Է°��� ���� ��ȿ�� �˻縦 �����ϱ� ���� ���
//1.validation-api ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.HTML �±� ��� Spring �±׸� ����Ͽ� ������ ��û�� �Է°��� ���޵ǵ��� �� �ۼ�
//3.Controller Ŭ������ ��û ó�� �޼ҵ忡�� ���ް��� ����� Command ��ü�� �����ϴ� �Ű�������
//@Valid ������̼��� ����Ͽ� Command ��ü�� �����ϴ� VO Ŭ�������� ��ȿ�� ������ �ǵ��� ����

@Controller
@RequestMapping("/valid")
public class ValidController {
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public String html() {
		return "valid/html_form";
	}
	
	@RequestMapping(value = "/html", method = RequestMethod.POST)
	public String html(@ModelAttribute Employee employee, Model model) {
		//���ް��� ���� �Է°� ���� - ����
		if(employee.getId() == null || employee.getId().equals("")) {
			model.addAttribute("idMsg", "���̵� �Է��� �ּ���.");
			return "valid/html_form";
		}
		
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, employee.getId())) {
			model.addAttribute("idMsg", "���̵� ���Ŀ� �°� �Է��� �ּ���.");
			return "valid/html_form";
		}
		
		employee.setPasswd(BCrypt.hashpw(employee.getPasswd(), BCrypt.gensalt()));
				
		return "valid/result";
	}
	
	//Spring Form �±׿��� ����ϱ� ���� Command ��ü�� ������ �Ű����� ����
	@RequestMapping(value = "/spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Employee employee) {
		//List ��ü�� �����Ͽ� �信�� ����
		//model.addAttribute("genderList", Arrays.asList("����", "����"));
		return "valid/spring_form";
	}
	
	//@Valid  : Spring �±׿� ���� ���޵� ���� Command ��ü�� �ʵ忡 �����ϱ� ���� ���ް���
	//���� ��ȿ�� ���� ����� �����ϱ� ���� ������̼�
	// => VO(DTO) Ŭ������ �ʵ忡 ��ȿ�� ���� ���� ������̼� ��� - hibernate-validator 
	//���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
	//Errors ��ü : ��ȿ�� ���� �� �߻��Ǵ� ��� ���� ���� ������ �����ϱ� ���� ��ü
	@RequestMapping(value = "/spring", method = RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Employee employee, Errors errors) {
		//Errors.hasErrors() : Errors ��ü�� ���� ���� ������ ������ ��� [true]�� ��ȯ�ϴ� �޼ҵ�
		if(errors.hasErrors()) {
			//model.addAttribute("genderList", Arrays.asList("����", "����"));
			return "valid/spring_form";
		}
		
		employee.setPasswd(BCrypt.hashpw(employee.getPasswd(), BCrypt.gensalt()));

		return "valid/result";
	}
	
	//��� ��û ó�� �޼ҵ��� �信�� ��ȯ���� �����ϴ� ������̼�
	@ModelAttribute("genderList")
	public List<String> genderList() {
		return Arrays.asList("����", "����");
	}
}




