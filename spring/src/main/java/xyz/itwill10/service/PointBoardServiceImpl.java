package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.PointBoardDAO;
import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;

@Service
@RequiredArgsConstructor
public class PointBoardServiceImpl implements PointBoardService {
	private final PointUserDAO pointUserDAO;
	private final PointBoardDAO pointBoardDAO;
	
	//�Ű������� �Խñ��� ���޹޾� POINTBOARD ���̺� �Խñ۷� �����ϰ� �Խñ� �ۼ��ڿ� ����
	//ȸ�������� POINTUSER ���̺��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => POINTUSER ���̺� ����� ȸ������ �� �Խñ� �ۼ��ڿ� ���� ȸ�������� ����Ʈ�� �����ǵ��� ���� ó��
	//@Transactional : Transactional ��ü�� ���� Ʈ������ ó�� ����� �����ޱ� ���� ������̼�
	//rollbackFor �Ӽ� : ���� Ŭ����(Class ��ü)�� �Ӽ������� ���� - ���ܰ� �߻��Ǹ� �ѹ� ó��
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PointUser addPointBoard(PointBoard board) throws Exception {
		pointBoardDAO.insertPointBoard(board);//�Խñ� ����
		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���� ��� ������ ���� �߻�
		// => ���ܰ� �߻��� ��� �ϴܿ� �ۼ��� ����� ������� �ʰ� �޼ҵ� ���� ����
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new Exception("�Խñ� �ۼ��ڰ� �������� �ʽ��ϴ�.");
		}
		 
		pointUserDAO.updatePlusPointUser(board.getWriter());//ȸ�������� ����Ʈ ����
		
		return pointUserDAO.selectPointUser(board.getWriter());//ȸ�������� �˻��Ͽ� ��ȯ
	}

	//�Ű������� �۹�ȣ�� ���޹޾� POINTBOARD ���̺� ����� �Խñ��� �����ϰ� �Խñ� �ۼ��ڿ�
	//���� ȸ�������� POINTUSER ���̺��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => POINTUSER ���̺� ����� ȸ������ �� �Խñ� �ۼ��ڿ� ���� ȸ�������� ����Ʈ�� ���ҵǵ��� ���� ó��
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PointUser removePointBoard(int idx) throws Exception {
		PointBoard board=pointBoardDAO.selectPointBoard(idx);//�Խñ� �˻�
		//�۹�ȣ�� ���� �Խñ��� �˻����� ���� ��� ������ ���� �߻� 
		if(board == null) {
			throw new Exception("�Խñ��� �������� �ʽ��ϴ�.");
		}
		
		pointBoardDAO.deletePointBoard(idx);//�Խñ� ����
		
		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���� ��� ������ ���� �߻�
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new Exception("�Խñ� �ۼ��ڰ� �������� �ʽ��ϴ�.");
		}
		
		pointUserDAO.updateMinusPointUser(board.getWriter());//ȸ�������� ����Ʈ ����
		
		return pointUserDAO.selectPointUser(board.getWriter());//ȸ�������� �˻��Ͽ� ��ȯ
	}

	//POINTBOARD ���̺� ����� ��� �Խñ��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}