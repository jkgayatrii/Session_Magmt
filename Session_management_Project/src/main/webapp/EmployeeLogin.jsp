<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
EmployeeBean eb=(EmployeeBean)session.getAttribute("ebb");
String msg=(String)request.getAttribute("msg");
out.println(msg+"&nbsp&nbsp"+eb.geteId()+"<br");

%>
</body>
</html>