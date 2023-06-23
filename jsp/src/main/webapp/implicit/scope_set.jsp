<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내장객체를 이용하여 객체를 속성값으로 저장
	// => 속성명을 이용하여 속성값을 구분 -내장객체가 다른 경우 같은 이름의 속성명 사용 가능
	// => 내장객체에 동일한 속성명이 있는 경우 기존 속성값 대신 새로운 속성값으로 변경
	// => setAttribute(arg0(속성명), arg1) : 객체를 전달받아 속성값으로 전달  
	pageContext.setAttribute("pageName", "홍길동");//page Scope 
	// => 속성값이 저장된 객체를 자기 자신만 쓸 수 있음 > 다른 JSP에서 사용 불가
	request.setAttribute("requestName", "임꺽정");//request Scope
	//자기 자신과 스레드 메소드가 요청할 때 //여러 개의 JSP 페이지에서 공유하여 사용
	//pageContextJSP request JSP문서 안에서 만들어짐 문서가 삭제하면 삭제
	session.setAttribute("sessionName", "전우치");//session Scope
	//세션은 브라우저를 닫을 때 소멸
	//세션은 클라이언트와 서버 간에 유지되는 상태 정보를 저장하는 데 사용되는 객체
	//클라이언트마다 session 다 다름 >> 클라이언트가 같은 경우에만 모든 JSP 문서에서 사용 가능
	application.setAttribute("applicationName", "일지매");//application Scope
	//application WAS를 종료하면 소멸
	//모든 경우 사용 가능
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<%
		//내장객체에 저장된 속성값을 속성명으로 구분하여 반환받아 저장
		// => 속성명에 속성값이 없는 경우 null 반환
		// => 속성값을 Object 객체로 반환하므로 반드시 명식적 객체 형변환 이용
		String pageName=(String)pageContext.getAttribute("pageName");
		String requestName=(String)request.getAttribute("requestName");
		String sessionName=(String)session.getAttribute("sessionName");
		String applicationName=(String)application.getAttribute("applicationName");
	%>
	<p>pageName = <%=pageName %></p>
	<p>requestName = <%=requestName %></p>
	<p>sessionName = <%=sessionName %></p>
	<p>applicationName = <%=applicationName %></p>
</body>
</html>