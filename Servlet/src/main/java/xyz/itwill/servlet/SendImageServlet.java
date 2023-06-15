package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트 요청에 의해 이미지 파일로 응답하기 위한 서블릿
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에게 이미지 파일이 응답되도록 응답파일의 타입 변경
		// => 응답파일이 문서파일이 아니므로
		response.setContentType("image/jpeg");
		
		//응답파일을 생성하기 위한 출력스트림을 반환받아 저장
		// => 이미지 파일(이진 파일 : Binary File)을 생성하기 위해 ServletOutputStream 객체 반환
		ServletOutputStream out=response.getOutputStream();
		
		String imageFilePath=request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		//System.out.println("imageFilePath = "+imageFilePath);

		FileInputStream in=new FileInputStream(imageFilePath);
		
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		in.close();
		
	}

}
