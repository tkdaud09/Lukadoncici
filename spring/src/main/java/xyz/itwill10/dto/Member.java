package xyz.itwill10.dto;

import lombok.Data;

//ȸ�������� �����ϱ� ���� Ŭ���� - VO Ŭ���� : ���� ������ ������ ��ü�� �����ϱ� ���� Ŭ����
// => DAO Ŭ������ �޼ҵ忡�� ���� ��� DTO Ŭ������ ��� ����
// => ������ ��û�� ���޵� ���� �����ϱ� ���� ���ް��� �̸��� ���� �̸����� �ʵ� �ۼ�
@Data
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
}