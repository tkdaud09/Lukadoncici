package xyz.itwill09.mvc;

//���� ���� ������ �����ϱ� ���� Ŭ����
public class ViewResolver {
	//�Ű������� ViewName�� ���޹޾� ����ó���� JSP ������ ��θ� �����Ͽ� ��ȯ
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}