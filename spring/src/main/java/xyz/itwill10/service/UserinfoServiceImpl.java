package xyz.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.UserinfoDAO;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

//����ڷκ��� �Է¹޾� ���޵� ���ڿ�(��й�ȣ)�� ��ȣȭ ó���ϴ� ���
//1.jbcrypt ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.BCrypt.hashpw(String password, String salt) �޼ҵ带 ȣ���Ͽ� ���ڿ�(��й�ȣ)�� ��ȣȭ ó��
// => �Ű������� ��ȣȭ ó���� ���ڿ��� ÷������ ���޹޾� ��ȣȭ ó�� - ÷������ ���� ��й�ȣ�� �ٸ��� ��ȣȭ ó��
// => BCrypt Ŭ���� : �ܹ��� ��ȣȭ ����� BlowFish �˰����� ������� ����� ��ȣȭ ó�� Ŭ����
// => BCrypt.gensalt(int log_bounds) : �Ű������� ÷����(Salt - String)�� ���̸� ���޹޾� 
//÷������ �����Ͽ� ��ȯ�ϴ� �޼ҵ� - �Ű������� ���̸� �������� ������ �ڵ����� [10]���� ����
//3.BCrypt.checkpw(String plaintext, String hashed) �޼ҵ�� ��ȣȭ�� ��й�ȣ�� ���Ͽ� �������� ��ȯ�޾� ó�� 
// => �Ű������� �Ϲ� ���ڿ��� ��ȣȭ�� ���ڿ��� ���޹޾� ���Ͽ� �ٸ� ��� [false]�� ��ȯ�ϰ�
//���� ��� [true]�� ��ȯ�ϴ� �޼ҵ�

@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUserinfo(Userinfo userinfo) throws ExistsUserinfoException {
		//�Ű������� ���޹��� ȸ�������� ���̵� ���� ȸ�������� ���̵�� �ߺ��� ���
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) != null) {
			//���ܸ� ��Ȯ�ϱ� �����ϰ� ����ó���� �ʿ��� ���� �����ϱ� ���� ���� ������ ���� 
			//Ŭ������ ����Ͽ� �������� ���� �߻�
			throw new ExistsUserinfoException("�̹� ������� ���̵� �Է� �Ͽ����ϴ�.", userinfo);
		}
		
		//�Ű������� ���޹��� ȸ�������� ��й�ȣ�� ��ȣȭ ó���Ͽ� �ʵ尪���� �ٽ� ����
		String hashedPassword=BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt());
		userinfo.setPassword(hashedPassword);
		
		userinfoDAO.insertUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		//�Ű������� ���޹��� ȸ�������� ���̵�� ���� ȸ�������� �˻��Ͽ� �˻������ ���� ���
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) == null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		
		//�Ű������� ���޹��� ȸ�������� ��й�ȣ�� ������ ��� ��й�ȣ�� ��ȣȭ ó���Ͽ� �ʵ尪���� ����
		if(userinfo.getPassword() != null && !userinfo.getPassword().equals("")) {
			String hashedPassword=BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt());
			userinfo.setPassword(hashedPassword);			
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		//�Ű������� ���޹��� ���̵�� ���� ȸ�������� �˻��Ͽ� �˻������ ���� ���
		if(userinfoDAO.selectUserinfo(userid) == null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}	
		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		//�Ű������� ���޹��� ���̵�� ���� ȸ�������� �˻��Ͽ� �˻������ ��ȯ�޾� ����
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		
		//�˻��� ȸ�������� ���� ���
		if(userinfo == null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}

	//�Ű������� ȸ������(���̵�� ��й�ȣ)�� ���޹޾� ���� ó���ϱ� ���� �޼ҵ�
	// => ���� ���н� ���� �߻��ϰ� ���� ������ ���� �̹߻�
	// => ���� ������ �α��ε� ȸ�������� �˻��Ͽ� ��ȯ - ���ǿ� ���� ���� ������ ����
	@Override
	public Userinfo loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		//�Ű������� ���޹��� ȸ�������� ���̵�� ���� ȸ�������� �˻��Ͽ� �˻������ ��ȯ�޾� ����
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());

		//�˻��� ȸ�������� ���� ��� - ���̵� ���� ����
		if(authUserinfo == null) {
			throw new LoginAuthFailException("���̵��� ȸ�������� �������� �ʽ��ϴ�.", userinfo.getUserid());
		}
		
		//�Ű������� ���޹��� ȸ�������� ��й�ȣ�� �˻��� ȸ�������� ��й�ȣ�� ���Ͽ�
		//���� ���� ��� - ��й�ȣ ���� ����
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {
			throw new LoginAuthFailException("���̵� ���ų� ��й�ȣ�� ���� �ʽ��ϴ�.", userinfo.getUserid());
		}
		
		//�Ű������� ���޹��� ȸ�������� ���̵�� �˻��� ȸ������ ��ȯ 
		return authUserinfo;
	}
}