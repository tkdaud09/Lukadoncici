package xyz.itwill10.dto;

import lombok.Data;

//DTO Ŭ���� : DAO Ŭ������ �޼ҵ忡�� ����ϱ� ���� ���� ǥ���ϱ� ���� Ŭ����
// => ���̺��� Java Ŭ������ ǥ���Ͽ� ��ü�� �����Ͽ� ����ϱ� ���� �ۼ�

@Data
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}