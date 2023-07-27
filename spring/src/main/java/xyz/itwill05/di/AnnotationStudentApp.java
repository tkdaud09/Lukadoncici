package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationStudentApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-4_diAnnotation.xml");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//StudentService service=context.getBean("annotationStudentServiceImpl", StudentService.class);
		StudentService service=context.getBean("studentService", StudentService.class);
		service.addStudent(null);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();			
	}
}