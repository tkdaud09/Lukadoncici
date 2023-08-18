package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.RestBoard;
import xyz.itwill10.service.RestBoardService;

//REST ����� �����ϴ� ��û ó�� �޼ҵ尡 ���������� ����Ǵ��� Ȯ���ϱ� ���� Advanced REST
//Client ���α׷��� ��ġ�Ͽ� ��� - Restful API �׽�Ʈ ���α׷�

//@RestController : REST ����� �����ϴ� ��û ó�� �޼ҵ�(Restful API)�� ����� Controller 
//Ŭ������ Spring Bean���� ����ϴ� ������̼�
// => ��û ó�� �޼ҵ忡 @ResponseBody ������̼��� ������� �ʾƵ� ���ڿ��� ���� ó�� ����
@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestBoardController {
	private final RestBoardService restBoardService;
	
	//������ ��ȣ�� ���޹޾� RESTBAORD ���̺� ����� �Խñ� �� ������ ��ȣ�� ��µ� �Խñ�
	//����� �˻��Ͽ� JSON ������ ���ڿ��� �����ϴ� ��û ó�� �޼ҵ�
	//REST ����� �����ϴ� ��û ó�� �޼ҵ�� @RequestMapping ������̼� ��� @GetMapping,
	//@PostMapping, @PutMapping, @PatchMapping, @DeleteMapping ������̼��� ����Ͽ� �������� 
	//��û URL �ּҸ� ��û ó�� �޼ҵ�� ���� ó���ϴ� ���� ����
	// => ��û��� : GET(�˻�), POST(����), PUT(��ü ����), PATCH(�κ� ����), DELETE(����) ��
	//@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@GetMapping("/board_list")
	//Controller Ŭ������ @RestController ������̼��� ����Ͽ� Spring Bean���� ����Ͽ����Ƿ�
	//@ResponseBody ������̼��� �����ص� ���ڿ��� ���� ó�� ����
	//@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//Map ��ü�� �ڹٽ�Ʈ��Ʈ�� Object ��ü ������ ���ڿ��� ��ȯ�Ͽ� ���� ó��
		return restBoardService.getRestBoardList(pageNum);		
	}
	
	//�Խñ��� ���޹޾� RESTBOARD ���̺� �Խñ��� ���� ó���ϰ� �������� �Ϲ� ���ڿ��� �����ϴ� ��û ó�� �޼ҵ�
	// => [application/json] ������ ���ڿ��� ���޵� �Խñ��� Java ��ü�� �����޾� �Ű�������
	//�����ϱ� ���� @RequestBody ������̼� ���
	@PostMapping("/board_add")
	public String restBoardAdd(@RequestBody RestBoard restBoard) {
		//HtmlUtils.htmlEscape(String str) : �Ű������� ���޹��� ���ڿ��� ����� HTML �±� ����
		//���ڸ� ȸ�ǹ���(Escape Character)�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� - XSS ���ݿ� ���� ���
		restBoard.setContent(HtmlUtils.htmlEscape(restBoard.getContent()));
		restBoardService.addRestBoard(restBoard);
		return "success";
	}
	
	/*
	//�۹�ȣ�� ���޹޾� RESTBOARD ���̺� ����� �Խñۿ��� �ش� �۹�ȣ�� �Խñ��� �˻��Ͽ�
	//JSON ������ ���ڿ��� �����ϴ� ��û ó�� �޼ҵ�
	// => ���ǹ��ڿ�(QueryString)�� ���޵� �۹�ȣ�� �Ű������� �����޾� ���
	@GetMapping("/board_view")
	public RestBoard restBoardView(@RequestParam int idx) {
		return restBoardService.getRestBoard(idx);
	}
	*/
	
	//�۹�ȣ�� ���޹޾� RESTBOARD ���̺� ����� �Խñۿ��� �ش� �۹�ȣ�� �Խñ��� �˻��Ͽ�
	//JSON ������ ���ڿ��� �����ϴ� ��û ó�� �޼ҵ�
	// => ��û URL �ּҷ� ǥ���� �۹�ȣ�� �Ű������� �����޾� ���
	//��û URL �ּҷ� ����  ǥ���Ͽ� �����ϱ� ���ؼ��� @GetMapping ������̼��� value �Ӽ����� 
	//{�̸�} �������� ��û URL �ּҸ� ǥ�� 
	// => ��û URL �ּҷ� ǥ���� ���� �Ű������� @PathVariable ������̼��� ����Ͽ� ���ް��� ����
	//@PathVariable : ��û URL �ּҷ� ǥ���� ���� ��û ó�� �޼ҵ��� �Ű������� �����ϱ� ���� ������̼�
	// => @GetMapping ������̼��� value �Ӽ������� ������ �̸��� �Ű������� �̸��� ������ �ۼ�
	// => ���ް��� �̸��� �Ű������� �̸��� �ٸ� ��� @PathVariable ������̼ǿ� value �Ӽ���
	//����Ͽ� ��û URL �ּҷ� ǥ���Ͽ� ���޵� ���� �Ű������� ���� ����
	@GetMapping("/board_view/{idx}")
	public RestBoard restBoardView(@PathVariable int idx) {
		return restBoardService.getRestBoard(idx);
	}
	
	//�Խñ��� ���޹޾� RESTBOARD ���̺� ����� �Խñ��� �����ϰ� �������� �Ϲ� ���ڿ��� �����ϴ� ��û ó�� �޼ҵ�
	// => [application/json] ������ ���ڿ��� ���޵� �Խñ��� Java ��ü�� �����޾� �Ű�������
	//�����ϱ� ���� @RequestBody ������̼� ���	
	@PutMapping("/board_modify")
	public String restBoardModify(@RequestBody RestBoard restBoard) {
		restBoard.setContent(HtmlUtils.htmlEscape(restBoard.getContent()));
		restBoardService.modifyRestBoard(restBoard);
		return "success";
	}

	//�۹�ȣ�� ���޹޾� RESTBOARD ���̺� ����� �Խñ��� �����ϰ� �������� �Ϲ� ���ڿ��� �����ϴ� ��û ó�� �޼ҵ�
	// => ��û URL �ּҷ� ǥ���� �۹�ȣ�� �Ű������� �����޾� ���
	@DeleteMapping("/board_remove/{idx}")
	public String restBoardRemove(@PathVariable int idx) {
		restBoardService.removeBoard(idx);
		return "success";
	}

}