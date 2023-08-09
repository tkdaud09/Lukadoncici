package xyz.itwill.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointBoardService;

//Spring �����ӿ�ũ�� TransactionManager ���� Ŭ������ �̿��Ͽ� Ʈ������ ó���ϴ� ���
//1.spring-tx ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
// => spring-jdbc ���̺귯���� ���� ó���ϸ� ���� ���迡 ���� �ڵ� ���� ó��
//2.Spring Bean Configuration File(root-context.xml)�� TransactionManager ���� Ŭ������ Spring Bean���� ���
//3.Spring Bean Configuration File(servlet-context.xml)�� Ʈ������ ó���� ���� AOP ����
// => Spring Bean Configuration File�� AOP ������ �̿��Ͽ� TaransactionManager ��ü�� ����Ͽ�
//Ʈ������ ó�� �� ���� ������ @Tranactional ������̼��� ����Ͽ� Ʈ������ ó�� ����

//TaransactionManager ��ü�� �̿��Ͽ� Ʈ������ ó�� ����� �������� �޼ҵ忡 @Tranactional 
//������̼� ����ϸ� �޼ҵ��� ��� ����� ����(Exception)�� �߻��� ��� �ڵ����� �ѹ� ó��
// => @Tranactional ������̼��� ����ϱ� ���� Spring Bean Configuration File(root-context.xml)��
//tx ���ӽ����̽��� �߰��Ͽ� spring-tx.xsd ������ �����޾� annotaion-driven ������Ʈ�� �ݵ�� ����
// => �׽�Ʈ Ŭ������ �׽�Ʈ �޼ҵ忡 @Tranactional ������̼��� ����ϸ� �׽�Ʈ �޼ҵ��� 
//��� ���� �� ������ �ѹ� ó��

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class PointBoardServiceTest {
	@Autowired
	private PointBoardService pointBoardService;
	
	@Transactional
	@Test
	public void test1() throws Exception {
		//�Խñ�(PointBoard ��ü) ����
		PointBoard board=PointBoard.builder().writer("abc123").subject("�׽�Ʈ").build();
		//PointBoard board=PointBoard.builder().writer("xyz789").subject("�׽�Ʈ").build();
		
		//PointBoardService Ŭ������ addPointBoard() �޼ҵ带 ȣ���Ͽ� POINTBOARD ���̺� �Խñ� ����
		// => POINTUSER ���̺� ����� ȸ������ �� �Խñ� �ۼ��ڿ� ���� ȸ�������� ����Ʈ ����
		// => POINTUSER ���̺� ����� ȸ������ �� �Խñ� �ۼ����� ȸ�������� �˻��Ͽ� ��ȯ
		// => �Ű������� ���޹��� �Խñۿ��� �Խñ� �ۼ��ڰ� ���� ��� ���� �߻�
		//������)���� �߻����� ����� �Խñ� ���Կ� ���� SQL ����� �̹� DBMS ������ ���޵Ǿ� 
		//����� �����̹Ƿ� POINTBOARD ���̺��� ���������� �Խñ� ����
		// => POINTBOARD ���̺� �Խñ� �ۼ��ڰ� �������� �ʴ� �Խñ� ���� - �Խñ��� �˻��Ͽ� ����� ��� ���������� ��� ����
		//�ذ��)���ܰ� �߻��Ǳ� ���� ����� SQL ��ɿ� ���� ��� �ѹ� ó���ǵ��� ����
		// => Spring �����ӿ�ũ���� �����ϴ� Ʈ������ ���� ����� ����Ͽ� Ʈ������ ó��
		// => TransactionManager ���� Ŭ���� �̿��Ͽ� �ϰ��� �ִ� Ʈ������ ó�� ��� ����
		PointUser user=pointBoardService.addPointBoard(board);

		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���
		log.info(user.toString());
		
		//PointBoardService Ŭ������ getPointBoardList() �޼ҵ带 ȣ���Ͽ� �Խñ� ����� ��ȯ�޾� ���
		log.info(pointBoardService.getPointBoardList().toString());
	}
	
	/*
	@Transactional
	@Test
	public void test2() throws Exception {
		//PointBoardService Ŭ������ removePointBoard() �޼ҵ带 ȣ���Ͽ� POINTBOARD ���̺� ����� �Խñ� ����
		// => POINTUSER ���̺� ����� ȸ������ �� �Խñ� �ۼ��ڿ� ���� ȸ�������� ����Ʈ ����
		// => POINTUSER ���̺� ����� ȸ������ �� �Խñ� �ۼ����� ȸ�������� �˻��Ͽ� ��ȯ
		PointUser user=pointBoardService.removePointBoard(1);
		
		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���
		log.info(user.toString());

		//PointBoardService Ŭ������ getPointBoardList() �޼ҵ带 ȣ���Ͽ� �Խñ� ����� ��ȯ�޾� ���
		log.info(pointBoardService.getPointBoardList().toString());
	}
	*/
}