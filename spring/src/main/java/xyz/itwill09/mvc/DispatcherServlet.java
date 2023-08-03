package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ�� ��� ��û�� �޾� URL �ּҸ� �м��Ͽ� �ʿ��� ��û ó�� 
//Ŭ����(Model)�� �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û�� ó���ϰ� JSP ����(View)�� �����带 
//�̵��Ͽ� ����ó�� �ǵ��� ���α׷��� �帧�� �����ϴ� ��� ���� - ����(Servlet)���� ����

//��Ʈ�ѷ� ����� �����ϱ� ���� ���� Ŭ����
// => Ŭ���̾�Ʈ�� ��� ��û�� �޾� ó���ϴ� ���� �������� ��Ȱ�� ���� - Front Controller Pattern
// => [web.xml] ���Ͽ��� Ŭ������ ����(�����α׷�)���� ����ϰ� Ŭ���̾�Ʈ�� ��� ��û�� 
//�޾� ó���� �� �ֵ��� URL ���� ����
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �ڵ� ȣ��Ǵ� �޼ҵ带 �������̵� ����
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Ŭ���̾�Ʈ�� ��û URL �ּҸ� �м��Ͽ� ��û������ ��ȯ�޾� ����
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//2.Ŭ���̾�Ʈ�� ��û������ �̿��Ͽ� ��û ó�� Ŭ����(Model)�� ��ü�� �����޾� ��ü��
		//�޼ҵ� ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û�� ó���ϰ� ���� ���� ����(View)�� ��ȯ�޾� ����
		//�������̽��� ���������� �����ϸ� �������̽��� ��ӹ��� ��� �ڽ�Ŭ������ ��ü ���� ����
		/*
		Controller controller=null;
		//Ŭ���̾�Ʈ�� ��û������ ���Ͽ� ��û ó�� Ŭ����(Model)�� ��ü�� �����Ͽ� ����
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/
		
		//HandlerMapping Ŭ������ ��ü ����
		// => HandlerMapping Ŭ���� :Ŭ���̾�Ʈ�� ��û������ ��û ó�� Ŭ������ ��ü�� ��Ʈ����
		//����� Map ��ü�� �����ϱ� ���� Ŭ����
		HandlerMapping handlerMapping=new HandlerMapping();
		//HandlerMapping ��ü�� �޼ҵ带 ȣ���Ͽ� �Ű������� ���޵� ��û������ ���� ��û ó��
		//Ŭ������ ��ü�� ��ȯ�޾� ����
		Controller controller=handlerMapping.getController(command);
		
		//��û ó�� Ŭ������ �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û�� ó���ϰ� ���� ó���� JSP
		//������ �̸�(ViewName)�� ��ȯ�޾� ����
		String viewName=controller.handleRequest(request, response);
		
		//3.JSP ������ ������ �̵��Ͽ� Ŭ���̾�Ʈ���� ó������� ����ǵ��� ó��
		// => ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �̿��Ͽ� JSP ������ ��θ� �ϼ��Ͽ� ������ �̵�
		//ViewResolver Ŭ������ ��ü ����
		// => ViewResolver Ŭ���� : ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �̿��Ͽ� ���� ó����
		//JSP ������ ��θ� �ϼ��Ͽ� ��ȯ�ϴ� �޼ҵ�
		ViewResolver viewResolver=new ViewResolver();
		String view=viewResolver.getView(viewName);//������ JSP ������ ��θ� ��ȯ�޾� ����
		request.getRequestDispatcher(view).forward(request, response);//JSP ������ ������ �̵�
	}
}