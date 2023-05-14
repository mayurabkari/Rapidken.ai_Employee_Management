<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employee Details</title>
</head>
<body>

<center><h1>Employee Details</h1></center>
<%
ResultSet rs=(ResultSet)session.getAttribute("employeetlist");
%>



<%while(rs.next()){%>
<table cellpadding="10px" align="center" border="2">
<th>first_name</th>
<th>last_name</th>
<th>salary</th>
<th>department</th>
<th>position</th>
<th>email</th>
<th>contact_no</th>
<th>picture</th>

 <tr>
 <td> <%= rs.getString(1) %> </td>
 <td> <%= rs.getString(2)%> </td>
 <td> <%= rs.getDouble(3) %> </td>
 <td> <%= rs.getString(4) %> </td>
 <td> <%= rs.getString(5) %> </td>
 <td> <%= rs.getString(6) %> </td>
 <td> <%= rs.getLong(7) %> </td>
 <td> <%= rs.getBlob(8) %> </td>
 <td> <%= rs.getInt(9) %> </td>
 <td> <a href="editEmployee?id=<%=rs.getInt(9)%> "> edit </a>&nbsp; <a href="deleteEmployee?id=<%=rs.getInt(9)%> ">delete</a>  </td>
 </tr>
 </table><% }

%>
</body>
</html>