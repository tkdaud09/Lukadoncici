package xyz.itwill08.dao;

import lombok.Data;

/*
�̸�       ��?       ����            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE   
*/

//�л������� �����ϱ� ���� Ŭ���� - DTO Ŭ����
@Data
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}