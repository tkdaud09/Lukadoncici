package xyz.itwill09.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

//ȸ�������� �����ϱ� ���� Ŭ���� - DTO Ŭ����
@AllArgsConstructor
@Data
public class Member {
	private String id;
	private String name;
	private String address;
}