package xyz.itwill07.aop;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//JavaMail ����� �����ϱ� ���� spring-context-support ���̺귯���� javax.mail ���̺귯����
//������Ʈ�� ����ǵ��� ó�� - ���̺� �̿� : pom.xml

//���� ���� ����� �����ϱ� ���� Ŭ���� - ���� ������ SMTP ���񽺸� ����Ͽ� ���� ����
// => ���� ����(Mail Server) : ������ �ۼ����ϴ� ���񽺸� �����ϴ� ��ǻ��
// => SMTP(Simple Message Transfer Protocol) ���񽺷� ������ ������ POP3(Post Office Protocol 3)
//���񽺳� IMAP(Internet Message Access Protocol) ���񽺷� ������ �޾� ����ڿ� ����
public class EmailSendBean {
	//JavaMailSender ��ü�� �����ϱ� ���� �ʵ� ����
	// => JavaMailSender ��ü : SMTP ���񽺸� �����ϴ� ������ ������ �����ϱ� ���� ��ü
	@Setter
	private JavaMailSender javaMailSender;
	
	//������ �����ϴ� �޼ҵ�
	// => ������ �޴� ����� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� ����
	// => ������ �޴� ����� �̸��� �ּҸ� ��ȯ
	public String sendEmail(String email, String subject, String content) throws Exception {
		//JavaMailSender.createMimeMessage() : MimeMessage ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//MimeMessage ��ü : ���� ���� ���� ������ �����ϱ� ���� ��ü
		MimeMessage message=javaMailSender.createMimeMessage();
		
		//MimeMessage.setSubject(String subject) : MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		message.setSubject(subject);
		
		//MimeMessage.setText(String content) : MimeMessage ��ü�� ���� ����(�Ϲݹ���)�� �����ϴ� �޼ҵ�
		//message.setText(content);
		
		//MimeMessage.setContent(Object o, String type) : MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		// => type �Ű������� ���Ϸ� ������ ������ ����(MimeType)�� �����Ͽ� ����
		message.setContent(content, "text/html; charset=utf-8");//HTML ������ ����
		
		//MimeMessage.setRecipient(RecipientType type, Address address) : MimeMessage ��ü�� 
		//������ �޴� ����� �̸��� �ּ� ���� ������ �����ϴ� �޼ҵ�
		// => RecipientType : ���� ���� ����ڸ� �����ϱ� ���� ����� ����
		// => Address : �̸��� �ּҰ� ����� Address ��ü�� ����
		//InternetAddress ��ü : �̸��� �ּҸ� �����ϱ� ���� ��ü 
		//MimeMessage.setRecipients(RecipientType type, Address[] address) : MimeMessage ��ü��
		//������ �޴� ������� �̸��� �ּ� ���� ������ �����ϴ� �޼ҵ� - �ټ��� ������� ���� ����
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		
		//JavaMailSender.send(MimeMessage message) : SMTP ���񽺸� ����Ͽ� ������ �����ϴ� �޼ҵ�
		javaMailSender.send(message);
		
		return email;
	}
}
