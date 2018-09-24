<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.User" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>
</head>
<body>

<%
	String deptName = request.getParameter("deptName");
	int deptID = Integer.parseInt(request.getParameter("deptID"));
	
		
%>
<h1>Liste des utilisateurs<%= deptName =%> </h1>
            <% 
				String queryParams = "deptID=" + deptID;
			    queryParams +="&deptName=" + deptName;
			%>
<p><a href="Ex3AddUserServlet?<%=queryParams%>">Add New User</a></p>

	<table border=1>
  <%
 	for(User u : Users_list){
  %>
		<tr>
			<td><%=u.getLastName() %></td>		
		</tr>
  <%
 	}
  %>
	</table>

</body>
</html>