package xyz.itwill10.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import xyz.itwill10.exception.BadRequestException;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

//@ControllerAdvice : ���� ó�� �޼ҵ常 �ۼ��� Controller Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => ��� Controller Ŭ������ ��û ó�� �޼ҵ忡�� �߻��Ǿ� ���޵� ���ܸ� �����޾� ó�� ����
@ControllerAdvice
public class ExceptionController {
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
	
	/*
	@ExceptionHandler(value = Exception.class)	
	public String exceptionHander() {
		return "userinfo/user_error";
	}
	*/
}