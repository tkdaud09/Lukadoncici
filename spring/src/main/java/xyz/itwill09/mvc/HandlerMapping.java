package xyz.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//Ŭ���̾�Ʈ�� ��û������ ��û ó�� Ŭ������ ��ü�� Map ��ü�� ��Ʈ���� �����Ͽ� �����ϴ� ����� Ŭ����
public class HandlerMapping {
	//Map ��ü�� �����ϱ� ���� �ʵ�
	// => ��Ʈ���� ���׸����� ��Ű�� ��û������ �����ϱ� ���� String Ŭ������ �����ϰ�
	//�ʰ��� ��û ó�� Ŭ������ ��ü�� �����ϱ� ���� Controller �������̽��� ����
	private Map<String, Controller> mappings;
	
	//�����ڷ� Map ��ü�� �����Ͽ� �ʵ忡 �����ϰ� ��û������ ��û ó�� Ŭ������ ��ü��	��Ʈ���� �߰�
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/list.itwill", new ListController());
		mappings.put("/view.itwill", new ViewController());
	}
	
	//�Ű������� Ŭ���̾�Ʈ�� ��û������ ���޹޾� ��û�� ó���ϱ� ���� ��ü�� Map ��ü���� 
	//�˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public Controller getController(String command) {
		return mappings.get(command);
	}
}