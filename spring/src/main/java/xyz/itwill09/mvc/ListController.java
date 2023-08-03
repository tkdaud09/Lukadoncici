package xyz.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��(Model) : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �ۼ��� ��û ó�� �޼ҵ尡 ����� Ŭ����

//�� ����� �����ϱ� ���� Ŭ���� - ��û ó�� �޼ҵ尡 �߻�޼ҵ�� ����� �������̽��� ��ӹ޾� �ۼ�
// => Ŭ���̾�Ʈ ��û�� �Ѱ��� ��û ó�� Ŭ������ ����Ͽ� ��û ó�� - Command Pattern
// => Ŭ���̾�Ʈ�� [/list.itwill]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� ��û ó�� Ŭ����
public class ListController implements Controller {
	//��û ó�� �޼ҵ� : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => ���� ó���� JSP ������ �̸�(ViewName)�� ��ȯ
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��û ó�� ��� �ۼ� - ����Ÿ ó�� : Service Ŭ������ �޼ҵ� ȣ��
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("abc", "ȫ�浿", "����� ������"));
		memberList.add(new Member("xyz", "�Ӳ���", "��õ�� ���̱�"));
		memberList.add(new Member("opq", "����ġ", "������ �ȴޱ�"));
		
		//��û�� ���� ó������� JSP ������ �����ϱ� ���� request �Ӽ������� ����
		request.setAttribute("memberList", memberList);
			
		//ó������� �����޾� Ŭ���̾�Ʈ���� ����ó���� JSP ������ �̸�(ViewName)�� ��ȯ 		
		return "member_list";
	}

}










