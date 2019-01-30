<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page1</title>
</head>
<body>
	jsp : java + html + css + javascript 까지 사용가능한 영역<br>
	html : html + css + javascript (.html 확장명만 잇다면 java코드는 사용할수 없다.)
	
	<%
		// <% Java 영역 >  
		String key = request.getParameter("key");
		out.println(key);
		
		List data = (List) request.getAttribute("data");
		
		if(data == null){
			data = new ArrayList();	
		}
		
		for(int i = 0; i<data.size(); i++){
			out.println(data.get(i));
		}
		
	%>
	
	<%= key %> <!-- 화면에 값 출력 ( 표현식 )  -->
	<hr>
	<%
		String scheme = request.getScheme(); 
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
	%>
	<h1>getScheme : <%= scheme %></h1>
	<h1>serverName : <%= serverName %></h1>
	<h1>serverPort : <%= serverPort %></h1>
</body>
</html>