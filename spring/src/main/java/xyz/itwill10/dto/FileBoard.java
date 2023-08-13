package xyz.itwill10.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//create table fileboard(idx number primary key, writer varchar2(20), subject varchar2(100)
//	, origin varchar2(100), upload varchar(100));
//create sequence fileboard_seq;

/*
�̸�      ��?       ����            
------- -------- ------------- 
IDX     NOT NULL NUMBER        - �۹�ȣ
WRITER           VARCHAR2(20)  - �ۼ���
SUBJECT          VARCHAR2(100) - ���� 
ORIGIN           VARCHAR2(100) - ����ڷκ��� �Է¹��� ���ϸ�
UPLOAD           VARCHAR2(100) - ������ ����� ���ϸ�
*/

//DAO Ŭ������ �޼ҵ忡�� ����ϱ� ���� ��ü�� ǥ���ϱ� ���� Ŭ���� - DTO Ŭ����
// => ���ް��� ����� Command ��ü�� ǥ���ϱ� ���� Ŭ������ ��� 
@Data
public class FileBoard {
	private int idx;
	private String writer;
	private String subject;
	private String origin;
	private String upload;
	//����ڷκ��� �ԷµǾ� ���޵� ���������� �����ϱ� �ʵ�
	private MultipartFile multipartFile;
}
