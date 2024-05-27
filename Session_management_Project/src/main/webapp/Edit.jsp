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
EmployeeBean eb=(EmployeeBean)request.getAttribute("ebean");
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("page belongs to:"+ab.getfName());
%>
<form action="update" method="post">
<input type="hidden" name="eid" value=<%=eb.geteId()%>>
bSal:<input type="text" name="bSal" value=<%=eb.getbSal() %>><br>
Hra(1-100):<input type="text" name="hra" value=<%=eb.getHra() %>><br>
Da(1-100):<input type="text" name="da" value=<%=eb.getDa() %>><br>
<input type="submit" value="UpdateEmployee">
</form>


</body>
</html>