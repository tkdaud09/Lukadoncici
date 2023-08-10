package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.BadRequestException;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;
import xyz.itwill10.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
@RequiredArgsConstructor
public class UserinfoController {
	private final UserinfoService userinfoService;
	
	//ȸ�������� �Է¹ޱ� ���� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����� �Ǵ� �����ڰ� �ƴ� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	// => ���� ó�� �޼ҵ�(Exception Handle Method)�� �̿��Ͽ� ���� ó��
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(HttpSession session) throws BadRequestException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			//throw new Exception("���������� ��û�Դϴ�.");
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		return "userinfo/user_write";
	}
	
	/*
	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϰ� �α��� �������� ��û�� �� �ִ� URL �ּҸ�
	//Ŭ���̾�Ʈ���� �����Ͽ� ���� ó���ϴ� ��û ó�� �޼ҵ�
	// => UserinfoService ��ü�� �޼ҵ� ȣ��� ���� �߻� - try~catch ������ ����Ͽ� ���� ó��
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			//�Ű������� ���޹��� ȸ�������� ���̵� �ߺ��� ��� ExistsUserinfoException �߻�
			userinfoService.addUserinfo(userinfo);
		} catch (ExistsUserinfoException e) {
			//ExistsUserinfoException ��ü�� ����� ���� �޼����� ��ȯ�޾� �Ӽ������� ����
			model.addAttribute("message", e.getMessage());
			
			//ExistsUserinfoException ��ü�� ����� ȸ������(Userinfo ��ü)�� ��ȯ�޾� �Ӽ������� ����
			//model.addAttribute("userinfo", e.getUserinfo());
			
			//���̵� �ߺ��Ǿ� ���ܰ� �߻��� ��� ȸ�������� �Է¹ޱ� ���� ���̸� ��ȯ
			return "userinfo/user_write";
		}
		
		return "redirect:/userinfo/login";
	}
	*/

	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϰ� �α��� �������� ��û�� �� �ִ� URL �ּҸ�
	//Ŭ���̾�Ʈ���� �����Ͽ� ���� ó���ϴ� ��û ó�� �޼ҵ�
	// => UserinfoService ��ü�� �޼ҵ� ȣ��� ���� �߻� - ���� ó�� �޼ҵ带 �̿��Ͽ� ���� ó��
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo) throws ExistsUserinfoException {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";
	}
	
	
	//�α��������� �Է¹ޱ� ���� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	/*
	//�α��������� ���޹޾� �α��� ó���ϰ� ȯ���޼����� ����ϴ� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���� ������ �α��� ȸ�������� ������ �Ӽ������� ���� - ����
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, Model model, HttpSession session) {
		try {
			//�Ű������� ���޹��� ȸ�������� ���� ���е� ��� LoginAuthFailException �߻�
			Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
			
			//LoginAuthFailException �̹߻� - ���� ����
			session.setAttribute("loginUserinfo", authUserinfo);
		} catch (LoginAuthFailException e) {
			 model.addAttribute("message", e.getMessage());
			 model.addAttribute("userid", e.getUserid());
			 return "userinfo/user_login";
		}
		
		return "userinfo/user_login";
	}
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) throws LoginAuthFailException {
		Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
		session.setAttribute("loginUserinfo", authUserinfo);
		return "userinfo/user_login";
	}
	
	//�α׾ƿ� ó���ϰ� �α��� �������� ��û�� �� �ִ� URL �ּҸ� Ŭ���̾�Ʈ���� �����Ͽ� 
	//���� ó���ϴ� ��û ó�� �޼ҵ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUserinfo");
		session.invalidate();
		
		return "redirect:/userinfo/login";
	}

	//USEINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� �Ӽ������� �����Ͽ� ȸ������� ����ϴ�
	//���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) throws BadRequestException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo == null) {
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	
	//���̵� ���޹޾� USEINFO ���̺� ����� ȸ�������� �˻��Ͽ� �Ӽ������� �����Ͽ� 
	//ȸ�������� ����ϴ� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model, HttpSession session) throws BadRequestException, UserinfoNotFoundException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo == null) {
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}

	//���̵� ���޹޾� USEINFO ���̺� ����� ȸ�������� �˻��Ͽ� �Ӽ������� �����Ͽ� 
	//ȸ�������� �����ϴ� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����� �Ǵ� �����ڰ� �ƴ� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid, Model model, HttpSession session) throws BadRequestException, UserinfoNotFoundException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_modify";
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϰ� ȸ�������� ����ϴ� 
	//�������� ��û�� �� �ִ� URL �ּҸ� Ŭ���̾�Ʈ���� �����Ͽ� ���� ó���ϴ� ��û ó�� �޼ҵ�
	// => ȸ�������� ����ϴ� ������ ��û�� ���̵� ����
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Userinfo userinfo, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.modifyUserinfo(userinfo);
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		//�α��� ����ڿ� ���� ó���� ����ڰ� ������ ���
		if(loginUserinfo.getUserid().equals(userinfo.getUserid())) {
			//���ǿ� ���� ���� ����(ȸ������)�� ����� �Ӽ��� ����
			session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		}
		
		return "redirect:/userinfo/view?userid="+userinfo.getUserid();
	}

	//���̵� ���޹޾� USEINFO ���̺� ����� ȸ�������� �����ϰ� ȸ����� �����������
	//��û�� �� �ִ� URL �ּҸ� Ŭ���̾�Ʈ���� �����Ͽ� ���� ó���ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����� �Ǵ� �����ڰ� �ƴ� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	@RequestMapping("/remove")
	public String remove(@RequestParam String userid, HttpSession session) throws BadRequestException, UserinfoNotFoundException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		
		userinfoService.removeUserinfo(userid);
		
		if(loginUserinfo.getUserid().equals(userid)) {
			return "redirect:/userinfo/logout";
		}
		
		return "redirect:/userinfo/list";
	}
	
	
	/*
	//@ExceptionHandler : �޼ҵ忡 ���� ó�� ����� �����ϱ� ���� ������̼�
	// => Controller Ŭ������ ��û ó�� �޼ҵ忡�� ���ܰ� �߻��Ǿ� Front Controller���� ���ܰ�
	//���޵� ��� ���� ��ü�� �����޾� ���� ó���ϱ� ���� �޼ҵ� - ���� ó�� �޼ҵ�
	// => ���� ó�� �޼ҵ�� �Ű������� �̿��Ͽ� ���� ó���� �ʿ��� ��ü�� �����޾� ��� �����ϸ�
	//Ŭ���̾�Ʈ���� �����ϱ� ���� ���̸� ��ȯ - �����̷�Ʈ �̵� ����
	//value �Ӽ� : ���� ó���ϱ� ���� Ŭ����(Class ��ü)�� �Ӽ������� ����
	@ExceptionHandler(value = BadRequestException.class)	
	public String badRequestExceptionHander() {
		return "userinfo/user_error";
	}
	
	@ExceptionHandler(value = ExistsUserinfoException.class)	
	public String existsUserinfoExceptionHander(ExistsUserinfoException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";
	}
	
	@ExceptionHandler(value = LoginAuthFailException.class)
	public String loginAuthFailExceptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";
	}
	
	@ExceptionHandler(value = UserinfoNotFoundException.class)
	public String userinfoNotFoundExceptionHandler() {
		return "userinfo/user_error";
	}
	
	@ExceptionHandler(value = Exception.class)	
	public String exceptionHander() {
		return "userinfo/user_error";
	}
	*/
}