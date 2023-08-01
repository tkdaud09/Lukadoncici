package xyz.itwill07.aop;

import java.util.List;

import lombok.Setter;

//�ٽɰ��ɸ��
public class HewonServiceImpl implements HewonService {
	@Setter
	private HewonDAO hewonDAO;
	
	@Override
	public void addHewon(Hewon hewon) {
		System.out.println("*** HewonServiceImpl Ŭ������ addHewon(Hewon hewon) �޼ҵ� ȣ�� ***");
		hewonDAO.insertHewon(hewon);
	}

	@Override
	public Hewon getHewon(int num) {
		System.out.println("*** HewonServiceImpl Ŭ������ getHewon(int num) �޼ҵ� ȣ�� ***");
		return hewonDAO.selectHewon(num);
	}

	@Override
	public List<Hewon> getHewonList() {
		System.out.println("*** HewonServiceImpl Ŭ������ getHewonList() �޼ҵ� ȣ�� ***");
		throw new RuntimeException();//������ ���� �߻�
		//return hewonDAO.selectHewonList();
	}
}