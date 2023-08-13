package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.BadRequestException;

//�α��� ����� ���� ���� ó���� ���� �ۼ��� ���ͼ��� Ŭ����
// => ��û ó�� �޼ҵ尡 ȣ�� ���� ��α��� ����ڰ� �������� ��û�� ��� ���������� ���� �߻�
public class LoginAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		//��α��� ������� ���
		if(loginUserinfo == null) {
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		
		return true;//��û ó�� �޼ҵ� ȣ��
	}
}