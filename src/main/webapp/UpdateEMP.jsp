<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
<style type="text/css">
.parent{
border: 3px solid black;
border-radius:10px;
width: 200px;
margin-left: 550px;
margin-top: 100px;
margin-bottom:200px;
padding-top: 10px;
padding-bottom: 10px;
}
</style>
</head>
<body align="center" bgcolor="gray">
<% 
	
   ResultSet rs1=(ResultSet)session.getAttribute("1");

%>
<div class="parent">
<form action="UpdateEmployee">
<input type="text"   name="fN1" value="<%=rs1.getString(1)%>"> <br> <br>
<input type="text"   name="lN1" value="<%= rs1.getString(2)%>"> <br> <br>
<input type="text"   name="sal1" value="<%=rs1.getDouble(3)%>"> <br> <br>
<input type="text"   name="dept1" value="<%=rs1.getString(4)%>"> <br> <br>
<input type="text"   name="pos1" value="<%=rs1.getString(5)%>"> <br> <br>
<input type="email" name="email1" value="<%=rs1.getString(6)%>"> <br> <br>
<input type="text"   name="con1" value="<%=rs1.getLong(7)%>"> <br> <br>
<input type="file"   name="pic1" value="<%=rs1.getBlob(8)%>"> <br> <br>

<button>Submit</button>
</form>
</div>
</body>
</html>