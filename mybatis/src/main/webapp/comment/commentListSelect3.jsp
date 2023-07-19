<%@page import="xyz.itwill.dto.MyComment3"%>
<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyComment3> commentList=MyCommentDAO.getDAO().selectCommentList3();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
table{
	border: 5px solid black;
	border-collapse: separate;
}

td{
	border: 2px solid black;
	text-align: left;
	padding: 10px;
}

.no{ width: 100px; }
.name{ width: 150px; }
.content{ width: 300px; }
.date{ width: 250px; }
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<table>
		<tr>
			<td class="no">게시글번호</td>
			<td class="name">게시글이름</td>
			<td class="content">게시글내용</td>
			<td class="date">게시글작성일</td>
		</tr>
		<% for(MyComment3 comment : commentList) { %>
		<tr>
			<td><%=comment.getNo() %></td>
			<td><%=comment.getName() %>[<%=comment.getId() %>]</td>
			<td><%=comment.getContent() %></td>
			<td><%=comment.getDate() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>