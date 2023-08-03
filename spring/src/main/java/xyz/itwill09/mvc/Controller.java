package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�� ����� �����ϴ� Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => ��� �� Ŭ������ ������ �޼ҵ尡 �ۼ��ǵ��� ��Ģ ����
// => ��Ʈ�ѷ����� �� Ŭ������ ��ü�� ��û ó�� �޼ҵ带 ���� ȣ���ϱ� ���� �������̽� �ʿ�
public interface Controller {
	//��� �� Ŭ�������� �ݵ�� �ۼ��� ��û ó�� �޼ҵ带 �߻�޼ҵ�� ����
	String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}