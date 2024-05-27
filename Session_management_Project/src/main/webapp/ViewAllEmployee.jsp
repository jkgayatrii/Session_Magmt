<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)session.getAttribute("alist");
out.println("welcom page belongs to:"+ab.getfName());
if(al.size()==0){
	out.println("no employee details..<br>");
}else{
	Iterator<EmployeeBean>it=al.iterator();
	while(it.hasNext()){
		EmployeeBean eb=(EmployeeBean)it.next();
out.println(eb.geteId()+"&nbsp&nbsp"+eb.geteName()+"&nbsp&nbsp"+eb.geteDesg()+"&nbsp&nbsp"+eb.getbSal()+"&nbsp&nbsp"+eb.getHra()+"&nbsp&nbsp"+eb.getDa()+"&nbsp&nbsp"+eb.getTotSal()+"&nbsp&nbsp"+"<a href='edit?eid="+eb.geteId()+"'>Edit</a>"+"&nbsp&nbsp"+"<a href='delete?eid="+eb.geteId()+"'>Delete</a>"+"<br>");
	}
}

%>
<a href="Logout">Logout</a>
</body>
</html>