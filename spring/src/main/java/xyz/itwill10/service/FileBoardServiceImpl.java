package xyz.itwill10.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.FileBoardDAO;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.util.Pager;

@Service
@RequiredArgsConstructor
public class FileBoardServiceImpl implements FileBoardService {
	private final FileBoardDAO fileBoardDAO;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeFileBoard(int idx) {
		/*
		if(fileBoardDAO.selectFileBoard(idx) == null) {
			throw new Exception();
		}
		*/
		fileBoardDAO.deleteFileBoard(idx);
	}

	@Override
	public FileBoard getFileBoard(int idx) {
		return fileBoardDAO.selectFileBoard(idx);
	}

	/*
	@Override
	public List<FileBoard> getFileBoardList() {
		return fileBoardDAO.selectFileBoardList();
	}
	*/
	
	//�Ű������� ��û ������ ��ȣ�� ���޹޾� �Խñ� ����� ����� ��ü�� ������ ��ȣ ���� ��ü��
	//Map ��ü�� ��Ʈ���� �߰��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public Map<String, Object> getFileBoardList(int pageNum) {
		//FILEBOARD ���̺� ����� ��� �Խñ��� ������ �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		int totalBoard=fileBoardDAO.selectFileBoardCount();
		int pageSize=5;//�ϳ��� �������� ��µ� �Խñ��� ���� ����
		int blockSize=5;//�ϳ��� ���� ��µ� �������� ���� ����
		
		//Pager Ŭ������ ��ü�� �����Ͽ� ���� - ������ �Ű������� ����¡ ó�� ���� ���� ����
		// => Pager ��ü : ����¡ ó�� ���� ���� ����� ��ü
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		//FileBoardDAO Ŭ������ selectFileBoardList() �޼ҵ带 ȣ���ϱ� ���� �Ű������� �����Ͽ�
		//����� Map ��ü(���� ���ȣ, ���� ���ȣ) ����
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		List<FileBoard> fileBoardList=fileBoardDAO.selectFileBoardList(pageMap);
		
		//Controller Ŭ������ ��ȯ�Ǵ� ������� �����ϱ� ���� Map ��ü(���� ���ȣ, ���� ���ȣ) ����
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pager", pager);
		resultMap.put("fileBoardList", fileBoardList);
		
		return resultMap;
	}
}