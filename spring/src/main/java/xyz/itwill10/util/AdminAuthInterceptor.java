package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.BadRequestException;

//Interceptor Ŭ���� : ��û ó�� �޼ҵ尡 ȣ��Ǳ� �� �Ǵ� �Ŀ� ���ԵǾ� ����� ����� �����ϴ� Ŭ����
// => Interceptor Ŭ������ �ݵ�� HandlerInterceptor �������̽��� ��ӹ޾� �ۼ� - �ʿ��� �޼ҵ常 �������̵� �����Ͽ� ���
// => Interceptor Ŭ������ Spring Bean Configuration File(servlet-context.xml)�� Spring Bean����
//����ϰ� ��û ó�� �޼ҵ� ȣ�� �� �Ǵ� �Ŀ� ����ǵ��� ����

//������ ���� ���� ó���� ���� �ۼ��� ���ͼ��� Ŭ����
// => ��û ó�� �޼ҵ尡 ȣ�� ���� ��α��� ������̰ų� �����ڰ� �ƴ� ����ڰ� �������� ��û��
//��� ���������� ���� �߻� - ���� �������� ���� ó��
public class AdminAuthInterceptor implements HandlerInterceptor {
	//preHandle �޼ҵ� : ��û ó�� �޼ҵ尡 ȣ��Ǳ� ���� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => false ��ȯ : ��û ó�� �޼ҵ� ��ȣ��, true ��ȯ : ��û ó�� �޼ҵ� ȣ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		//��α��� ������̰ų� �����ڰ� �ƴ� ������� ���
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			//response.sendError(HttpServletResponse.SC_FORBIDDEN);//403 �����ڵ� ����
			//return false;//��û ó�� �޼ҵ� ��ȣ��
			
			//request.getRequestDispatcher("userinfo/user_error.jsp").forward(request, response);
			//return false;
			
			throw new BadRequestException("���������� ��û�Դϴ�.");
		}
		
		return true;//��û ó�� �޼ҵ� ȣ��
	}
	
	//postHandle �޼ҵ� : ��û ó�� �޼ҵ尡 ȣ��Ǿ� ��ȯ�� ���̸����� ViewResolver�� 
	//��(View)�� �����Ǳ� ���� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => ModelAndView ��ü�� �����޾� ViewName �Ǵ� Model ��ü�� �Ӽ����� ����(����)�ϱ� ���� ����ϴ� �޼ҵ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	//afterCompletion �޼ҵ� : ��û ó�� �޼ҵ尡 ȣ��Ǿ� ��ȯ�� ���̸����� ViewResolver�� 
	//��(View)�� ������ �Ŀ� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => ��(View)�� �����ϱ� ���� ����ϴ� �޼ҵ�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}