package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�� ����� �����ϱ� ���� Ŭ���� - ��û ó�� �޼ҵ尡 �߻�޼ҵ�� ����� �������̽��� ��ӹ޾� �ۼ�
// => Ŭ���̾�Ʈ�� [/view.itwill]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� ��û ó�� Ŭ����
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test", "������", "����� ���α�");
		request.setAttribute("member", member);
		return "member_view";
	}

}