package xyz.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView Ŭ���� : ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾� �ټ��� JSP ������ ���յ�
//JSP ����(���ø� ������)�� �����ϱ� ���� ����� �����ϴ� Ŭ���� - ViewResolver
//1.TilesView ���� ���̺귯��(tiles-extras ���̺귯��)�� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾� ������ ���ø� ������ ����
// => TilesView ���α׷��� ȯ�漳�������� ���� - /WEB-INF/spring/appServlet/tiles.xml
//3.Front Controller(DispatcherServlet Ŭ����)�� ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾�
//TilesView Ŭ������ �̿��Ͽ� ���� ó���ǵ��� Spring Bean Configuration File(servlet-context.xml) ����
// => InternalResourceViewResolver Ŭ�������� TilesView Ŭ������ ���� ����ǵ��� �켱 ���� ����

@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
}












