<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트가 JSP 문서를 요청하면 WAS 프로그램은 JSP 문서를 해석하여 JSP 문서에 대한
서블릿 클래스를 생성하고 컴파일하여 객체를 생성한 후 요청 처리 메소드를 호출해 클라이언트 
요청에 대한 처리와 실행결과를 저장한 파일을 생성하여 클라이언트에게 전달하여 응답 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>Hello, JSP!!!</h1>
	<hr>
	<!-- HTML 주석 : 주석문이 클라이언트에게 전달 - 소스보기 가능 -->
	<%--JSP 주석 : 주석문이 클라이언트에게 미전달 - 소스보기 불가능 --%>
	<p>JSP(Java Server Page) : 서블릿보다 쉽게 웹프로그램을 작성하기 위한 기술
	- 스크립트 요소(Script Element), 지시어(Directive), 표준 액션 태그(Standard Action Tag)</p>
	
</body>
</html>