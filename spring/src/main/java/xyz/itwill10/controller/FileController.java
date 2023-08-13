package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;

//������ ���޹޾� ���� ���丮�� ���ε� ó���ϱ� ���� ���
//1.commons-fileupload ���̺귯���� ������Ʈ ���� ó�� - ���̺� : pom.xml
//2.Spring Bean Configuration File(servlet-context.xml)�� ���� ���ε� ó�� ����� �����ϴ� 
//Ŭ������ Spring Bean���� ���
//3.MultipartHttpServletRequest ��ü�� ����Ͽ� [multipart/form-data] ���·� ���޵� �� �Ǵ� ������ �����޾� ó��

@Controller	
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
	//WebApplicationContext ��ü(������ �����̳�)�� �����޾� �ʵ忡 ������ ����
	private final WebApplicationContext context;
	//FileBoardService ��ü�� �����޾� �ʵ忡 ������ ����
	private final FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload1", method = RequestMethod.GET)
	public String uploadOne() {
		return "file/form_one";
	}
	
	/*
	//��û ó�� �޼ҵ忡 MultipartHttpServletRequest �������̽��� �Ű������� �����ϸ� Front
	//Controller���� MultipartHttpServletRequest ��ü�� �����޾� ��� ����
	//MultipartHttpServletRequest ��ü : [multipart/form-data] ���·� ���޵� �� �Ǵ� ������ ó���ϱ� ���� ��ü
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(MultipartHttpServletRequest request) throws IOException {
		//MultipartHttpServletRequest.getParameter(String name) : ���ް��� ���ڿ�(String ��ü)�� ��ȯ�ϴ� �޼ҵ�
		String uploaderName=request.getParameter("uploaderName");
		
		//MultipartHttpServletRequest.getFile(String name) : ���������� MultipartFile ��ü�� ��ȯ�ϴ� �޼ҵ�
		// => MultipartFile ��ü : ����ڷκ��� �ԷµǾ� ���޵� ���������� �����ϱ� ���� ��ü
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		//���޹��� ���Ͽ� ���� ���� �ۼ�
		//MultipartFile.isEmpty() : MultipartFile ��ü�� ����� ���������� ���� ��� [false]��
		//��ȯ�ϰ� ���������� �ִ� ��� [true]�� ��ȯ�ϴ� �޼ҵ�
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//MultipartFile.getContentType() : MultipartFile ��ü�� ����� ��������(MimeType)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ���� = "+uploadFile.getContentType());
		//MultipartFile.getBytes() : MultipartFile ��ü�� ����� ���������� ���õ���Ÿ(byte �迭)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ũ�� = "+uploadFile.getBytes().length);
		
		//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirectory=request.getServletContext().getRealPath("/resources/images/upload");
		System.out.println("uploadDirectory = "+uploadDirectory);
		
		//���������� ���� ���丮�� ����� ���ε� ���������� ����� File ��ü ����
		//File ��ü : �ý���(����)�� �����ϴ� ���������� �����ϱ� ���� ��ü
		//MultipartFile.getOriginalFilename() : MultipartFile ��ü�� ����� ���������� �̸��� ��ȯ�ϴ� �޼ҵ�
		String uploadFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirectory, uploadFilename);
		
		//MultipartFile..transferTo(File file) : MultipartFile ��ü�� ����� ���������� File
		//��ü�� �ý��� ����(���ε� ����)�� �����Ͽ� �����ϴ� �޼ҵ�
		uploadFile.transferTo(file);//���������� ���� ���丮�� ���� - ���ε� ó��
		
		request.setAttribute("uploaderName", uploaderName);
		request.setAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success";
	}
	*/
	
	//��û ó�� �޼ҵ��� �Ű������� ����Ͽ� ���ް� �� ���������� �����޾� ��� ����
	// => ���ް� �� ���������� �̸��� ���� �̸����� �Ű����� �ۼ�
	//������)���������� �̸��� ���� ���丮�� ����� ������ �̸��� ���� ��� �������Ϸ� ������
	//�ذ��)���������� �̸��� ���� ���͸��� ���� �����̸����� �����Ͽ� ���� ���丮�� ����
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(@RequestParam String uploaderName
			, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
		//���޹��� ���Ͽ� ���� ���� �ۼ�
		if(uploadFile.isEmpty() || !uploadFile.getContentType().equals("image/jpeg")) {
			return "file/upload_fail";
		}
		
		//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");
		
		//���������� ���� ���丮�� ����� ���ε� ���������� ����� File ��ü ����
		// => ���� ���丮�� ����� �����̸��� �ߺ����� �ʴ� �̸����� ���ǵ��� ����
		//UUID.randomUUID() : 36Byte�� ���ڿ��� ������ �ĺ��ڰ� ����� UUID ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//UUID.toString() : UUID ��ü�� ����� 36Byte�� ���ڿ��� ������ �ĺ��ڸ� ��ȯ�ϴ� �޼ҵ� 
		String uploadFilename=UUID.randomUUID().toString()+"_"+uploadFile.getOriginalFilename();
		File file=new File(uploadDirectory, uploadFilename);
		
		//���������� ���� ���丮�� ���� - ���ε� ó��
		uploadFile.transferTo(file);
		
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success_one";
	}
	
	@RequestMapping(value = "/upload2", method = RequestMethod.GET)
	public String uploadTwo() {
		return "file/form_two";
	}
	
	//���������� �������� ��� �Ű������� List �������̽��� �����Ͽ� ���������� �����  
	//MultipartFile ��ü�� ������ ����� List ��ü�� �����޾� ó��
	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public String uploadTwo(@RequestParam String uploaderName
			, @RequestParam List<MultipartFile> uploadFileList, Model model) throws IOException {
		//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");
		
		//���ε� ó���� ��� ������ �̸��� �����ϱ� ���� List ��ü ����
		List<String> filanameList=new ArrayList<String>();
		
		for(MultipartFile multipartFile : uploadFileList) {
			if(multipartFile.isEmpty() || !multipartFile.getContentType().equals("image/jpeg")) {
				return "file/upload_fail";
			}
			
			String uploadFilename=UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
			File file=new File(uploadDirectory, uploadFilename);
			
			//���������� ���� ���丮�� ���� - ���ε� ó��
			multipartFile.transferTo(file);
			
			//List ��ü�� ���ε� ó���� ���� �̸��� �߰��Ͽ� ����
			filanameList.add(uploadFilename);
		}
		
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("filanameList", filanameList);		
		
		return "file/upload_success_two";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String fileBoardWrite() {
		return "file/board_write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String fileBoardWrite(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getMultipartFile().isEmpty()) {
			return "file/board_write";
		}
		
		//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		// => �ٿ�ε� ���α׷������� ���Ͽ� ���� �����ϵ��� /WEB-INF ������ ���ε� ���� ����
		String uploadDirectory=context.getServletContext().getRealPath("/WEB-INF/upload");
		
		//����ڷκ��� �Է¹޾� ���޹��� ������ �̸��� ��ȯ�޾� Command ��ü�� �ʵ尪 ����
		String origin=fileBoard.getMultipartFile().getOriginalFilename();
		fileBoard.setOrigin(origin);
		
		//���� ���丮�� ���ε� ó���Ǿ� ����� ������ �̸��� ��ȯ�޾� Command ��ü�� �ʵ尪 ����
		// => ���� ���丮�� ����� ���� �̸��� �ߺ����� �ʵ��� ������ ���
		// => �ߺ����� �ʴ� ���������� �ý����� ���� ��¥�� �ð��� ���� ������(TimeStamp)�� ���
		String upload=System.currentTimeMillis()+"";
		fileBoard.setUpload(upload);
		
		//���� ���ε� ó��
		fileBoard.getMultipartFile().transferTo(new File(uploadDirectory, upload));
		
		//FILEBOARD ���̺� �� ����
		fileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/file/list";
	}
	
	@RequestMapping("/list")
	public String fileBoardList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/board_list";
	}

}
