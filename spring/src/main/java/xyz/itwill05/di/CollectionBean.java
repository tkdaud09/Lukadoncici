package xyz.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private Set<String> nameSet;
	private List<String> nameList;
	//�ݷ��� ��ü�� ���׸��� �������̽��� �����ϸ� �ݷ��� ��ü���� �������̽��� ��ӹ���
	//��� �ڽ�Ŭ������ ������ ��ü�� ��� �߰� ����
	private Set<Controller> controllerSet;
	private List<Controller> controllerList;
	private Map<String, Controller> controllerMap;
	private Properties controllerProperties;
	
	public CollectionBean() {
		System.out.println("### CollectionBean Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

	public Properties getControllerProperties() {
		return controllerProperties;
	}

	public void setControllerProperties(Properties controllerProperties) {
		this.controllerProperties = controllerProperties;
	}
}