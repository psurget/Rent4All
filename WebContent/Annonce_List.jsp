<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.User" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste d'annonces</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>

<body>

<div id="container">
	<div class="nav">
			<a class="btn" href="ouverture.jsp">< Accueil</a>
	</div>
	

<%
	String user = request.getParameter("user");	
%>

<h3>Liste des annonces de <%= user %> </h3>
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
</div>
</body>
</html>