<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String AdUserName=request.getParameter("aname");
%>
<body bgcolor=#D4E6F1 text=#A93226><center>
 <h1>welcome to admin home panel</h1>
 <!--  <form action = "MainServlet" method="post">
 <input type="button" name="addemp" value="Add Employee" /></form>-->
 <a href = "newEmployee.html">NewEmployee</a>
 </center></body>

</html>