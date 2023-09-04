package xyz.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Employee {
	//@NotNull : ���ް��� [null]�� ��� ������ �߻��ϴ� ������̼�
	//@NotBlank : ���ް��� [null]�̰ų� ���ް��� ������ �ִ� ��� ������ �߻��ϴ� ������̼�
	//@NotEmpty : ���ް��� [null]�̰ų� [""] ��� ������ �߻��ϴ� ������̼�
	// => ���� �߻��� �⺻���� �޼����� �����޾� �信�� ����
	//message �Ӽ� : �信�� ������ ���� �޼����� �Ӽ������� ����
	@NotEmpty(message = "���̵� �Է��� �ּ���.")
	//@Size : ���ް��� ũ�⸦ ���Ͽ� ������ �߻��ϴ� ������̼�
	//min �Ӽ� : ���ް��� �ּ� ũ�⸦ �Ӽ������� ����
	//max �Ӽ� : ���ް��� �ִ� ũ�⸦ �Ӽ������� ����
	//@Size(min = 6, max = 20, message = "���̵�� �ּ� 6�� �̻� �ִ� 20�� ���Ϸθ� �Է��� �ּ���.")
	//@Pattern : ����ǥ������ ���ϰ� ���� ���� ��� ������ �߻��ϴ� ������̼�
	//regexp �Ӽ� : ���ް��� ������ ���ϱ� ���� ����ǥ������ �Ӽ������� ����
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "���̵� ���Ŀ� �°� �Է��� �ּ���.")
	private String id;
	@NotEmpty(message = "��й�ȣ�� �Է��� �ּ���.")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "��й�ȣ�� ���Ŀ� �°� �Է��� �ּ���.")
	private String passwd;
	@NotEmpty(message = "�̸��� �Է��� �ּ���.")
	private String name;
	@NotEmpty(message = "�̸����� �Է��� �ּ���.")
	//@Email : �̸��� ������ Ʋ�� ��� ������ �߻��ϴ� ������̼�
	@Email(message = "�̸����� ���Ŀ� �°� �Է��� �ּ���.")
	private String email;
	@NotEmpty(message = "������ �Է��� �ּ���.")
	private String gender;
}