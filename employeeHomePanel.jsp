<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String empUserName=request.getParameter("ename");
%>
<body bgcolor=#D4E6F1    text=#A93226  ><center>
 <h1>welcome to Employee home panel</h1>
 
 
  <a href = "createAccount.html">Create_Account_for_Customer</a><br><br>
  <a href = "reportGenerations.html">Report_Generations</a><br><br>
  <a href = "deposit.html">Deposit</a><br><br>
  <a href = "withdrawl.html">Withdrawl</a><br><br>
  <a href = "transfer.html">Transfer</a><br><br>
  <a href = "issuechequebook.html">Issue_Chequebook</a>
 </body>

</html>