package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//[*] ���Ϲ��ڸ� ����Ͽ� Spring Bean Configuration File ���� ����
// => [**] �������� 0�� �̻��� ���� ������ ǥ��
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class StudentControllerTest {
	//WebApplicationContext ��ü�� �����޾� �����ϱ� ���� �ʵ� ���� - ������ ����
	// => WebApplicationContext ��ü : SpringMVC ���α׷����� ������ �����̳� ����� �����ϱ� ���� ��ü
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc ��ü�� �����ϱ� ���� �ʵ� ����
	// => MockMvc ��ü : ��û�� ������ �������� �����ϱ� ���� ��ü
	private MockMvc mvc;
	
	//@Before : �׽�Ʈ �޼ҵ� ȣ������ ����� ����� �ۼ��� �޼ҵ忡 �����ϴ� ������̼� - �ʱ�ȭ �۾�
	@Before
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		// => MockMvcBuilder ��ü�� �����Ͽ� ��ȯ�ϱ� ���� �޼ҵ�
		//MockMvcBuilder.build() : MockMvc ��ü�� �����Ͽ� ��ȯ�ϱ� ���� �޼ҵ�
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc ��ü ����");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvcRequestBuilders.get(String url) : �Ű������� ��û URL �ּҸ� ���޹޾� GET
		//������� �����α׷��� ��û�ϴ� �޼ҵ�
		// => ��û �������� ���� ��û ���� ����(������Ʈ �޼���)�� ������ RequestBuilder ��ü�� ��ȯ
		//MockMvc.perform(Builder requestBuilder) : �������� �������� ��û�ϴ� �޼ҵ�
		// => �Ű������� ���޹��� RequestBuilder ��ü�� ����� ������ �̿��Ͽ� ������ ��û
		// => Controller Ŭ������ ��û ó�� �޼ҵ� ȣ��
		// => ��û�� ���� ó������� ����� ResultActions ��ü ��ȯ
		//ResultActions.andReturn() : ��û ó�� �޼ҵ��� �������� MvcResult ��ü�� ��ȯ�ϴ� �޼ҵ�
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		//MvcResult.getModelAndView() : ��û ó�� �޼ҵ忡 ���� ������ ModelAndView ��ü�� ��ȯ�ϴ� �޼ҵ�
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
	}
}