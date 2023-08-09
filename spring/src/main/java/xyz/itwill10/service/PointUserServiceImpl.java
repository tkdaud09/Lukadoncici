package xyz.itwill10.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointUser;

@Service
@RequiredArgsConstructor
public class PointUserServiceImpl implements PointUserService {
	private final PointUserDAO pointUserDAO;

	//�Ű������� ȸ�������� ���޹޾� POINTUSER ���̺� ȸ�������� �����ϰ� ���Ե� ȸ�������� 
	//�˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public PointUser addPointUser(PointUser user) throws Exception {
		//�Ű������� ���޹��� ȸ�������� ���̵� POINTUSER ���̺� ����� ���� ȸ��������
		//���̵�� �ߺ��� ��� ������ ���� �߻� 
		if(pointUserDAO.selectPointUser(user.getId()) != null) {
			throw new Exception("�̹� ������� ���̵��Դϴ�.");
		}
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}
}