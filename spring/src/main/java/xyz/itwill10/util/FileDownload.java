package xyz.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//���� �ٿ�ε� ����� �����ϱ� ���� Ŭ����
// => BeanNameVeiwResolver ��ü�� ���� ����Ǵ� Ŭ����
// => Spring Bean Configuration File(servlet-context.xml)�� Spring Bean���� ���
//BeanNameVeiwResolver ��ü�� ���� ����� Ŭ������ �ݵ�� AbstractView Ŭ������ ��ӹ޾� �ۼ�
// => renderMergedOutputModel() �޼ҵ带 �������̵� �����Ͽ� ���� ó���� �ʿ��� ��� �ۼ� 
public class FileDownload extends AbstractView {
	public FileDownload() {
		//AbstractView.setContentType(String contentType) : AbstractView ��ü�� ����� Ŭ���̾�Ʈ��
		//���� ��������(MimeType)�� �����ϴ� �޼ҵ�
		setContentType("application/download; utf-8");
	}
	
	//BeanNameVeiwResolver ��ü�� ���� �ڵ� ȣ��Ǵ� �޼ҵ� - ���� �޼ҵ�
	// => model �Ű��������� ��û ó�� �޼ҵ忡�� ������ �Ӽ����� ��Ʈ���� ����� Map ��ü�� �����޾� ���
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//��û ó�� �޼ҵ忡�� ������ �Ӽ���(�ٿ�ε� ���� ���� ����)�� ��ü�� ��ȯ�޾� ����
		String uploadDirectory=(String)model.get("uploadDirectory");
		String originalFilename=(String)model.get("originalFilename");
		String uploadFilename=(String)model.get("uploadFilename");
		
		//���� ���丮�� ����� ���ε� ���Ͽ� ���� File ��ü ����
		File file=new File(uploadDirectory, uploadFilename);
		
		//Ŭ���̾�Ʈ���� ������ �����Ͽ� �����ϱ� ���� ��������(MomeType)�� Ŭ���̾�Ʈ���� ����
		// => AbstractView.getContentType() : AbstractView ��ü�� ����� Ŭ���̾�Ʈ�� ���� 
		//��������(MimeType)�� ��ȯ�ϴ� �޼ҵ�
		response.setContentType(getContentType());
		//Ŭ���̾�Ʈ���� ����� ������ ũ�⸦ Ŭ���̾�Ʈ���� ����
		// => response.setContentLengthLong(long length) : Ŭ���̾�Ʈ���� ������ ũ�⸦ �����ϴ� �޼ҵ� 
		response.setContentLengthLong(file.length());
		//Ŭ���̾�Ʈ�� ����� ���ϸ��� Ŭ���̾�Ʈ���� ����
		// => ���޵� ������ �̸��� �ѱ��� ������ ��� �η�ȭ ó���Ͽ� ����
		originalFilename=URLEncoder.encode(originalFilename, "utf-8");
		response.setHeader("Content-Disposition", "attachement;filename=\""+originalFilename+"\";");
		
		//������ Ŭ���̾�Ʈ���� �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		OutputStream out=response.getOutputStream();
		
		//���� ���丮�� ����� ���ε� ������ �б� ���� �Է½�Ʈ���� �����Ͽ� ����
		InputStream in=new FileInputStream(file);
		
		//FileCopyUtils.copy(InputStream in, OutputStream out) : �Է½�Ʈ������ ���õ���Ÿ��
		//�о� ��½�Ʈ������ �����Ͽ� �����ϴ� �޼ҵ� - ����
		FileCopyUtils.copy(in, out);//�ٿ�ε� ó��
		
		in.close();
	}

}

