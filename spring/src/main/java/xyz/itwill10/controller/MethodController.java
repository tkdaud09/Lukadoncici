package xyz.itwill10.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//����ڿ��� ���� �Է¹ޱ� ���� JSP ������ ���� ���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Ŭ���̾�Ʈ�� ��û��Ŀ� ������� ������ ��û ó�� �޼ҵ� ȣ��
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	//���ް��� ��ȯ�޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ����ϱ� ���� JSP ������
	//���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Ŭ���̾�Ʈ�� ��û��Ŀ� ������� ������ ��û ó�� �޼ҵ� ȣ��
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Ŭ���̾�Ʈ�� ���� �������� GET ������� ��û�� ��� - ���������� ��û
		if(request.getMethod().equals("GET")) {
			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//Ŭ���̾�Ʈ���� 405 �����ڵ� ����
			response.sendRedirect("method_input");//Ŭ���̾�Ʈ���� ���û�� �� �ִ� URL �ּ� ����
			return null;
		}
		
		//POST ������� ��û�Ǿ� ���޵� ���� ���� ĳ���ͼ� ����
		// => UnsupportedEncodingException �߻��ǹǷ� �ݵ�� ���� ó��
		request.setCharacterEncoding("utf-8");
		//���ް��� ��ȯ�޾� ����
		String name=request.getParameter("name");
		//���ް��� request ��ü�� �Ӽ������� ����
		request.setAttribute("name", name);
		return "method_output";
	}
	
	//����ڿ��� ���� �Է¹ޱ� ���� JSP ������ ���� ���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Ŭ���̾�Ʈ�� ���� �������� [GET] ������� ��û�� ��� ��û ó�� �޼ҵ� ȣ��
	//method �Ӽ� : RequestMethod �ڷ���(Enum)�� ���(Constant) �� �ϳ��� �Ӽ������� ����
	// => RequestMethod �ڷ���(Enum)�� Ŭ���̾�Ʈ�� ��û����� ����� �����ϴ� �ڷ���
	// => method �Ӽ������� ������ ��û����� �ƴ� ���·� ��û�� ��� Ŭ���̾�Ʈ���� 405 �����ڵ� ����
	//[GET] ������� ��û ó�� �޼ҵ带 ȣ���ϱ� ���� @RequestMapping ������̼� ��� @GetMapping ������̼� ��� ����
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	//���ް��� ��ȯ�޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ����ϱ� ���� JSP ������
	//���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Ŭ���̾�Ʈ�� ���� �������� [POST] ������� ��û�� ��� ��û ó�� �޼ҵ� ȣ��
	//��û ó�� �޼ҵ带 ȣ���ϴ� ��û URL �ּҰ� ���Ƶ� ��û����� �ٸ��� �����ϸ� �ٸ��� ���� ó��
	//[POST] ������� ��û ó�� �޼ҵ带 ȣ���ϱ� ���� @RequestMapping ������̼� ��� @PostMapping ������̼� ��� ����
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
	
}