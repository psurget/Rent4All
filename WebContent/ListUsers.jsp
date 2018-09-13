<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>

<%
	String deptName = request.getParameter("deptName");
	int deptID = Integer.parseInt(request.getParameter("deptID"));
	List<User> Users_list = request.getParameter("liste_Users");
%>
<h1>User List for the department <%=deptName%> </h1>
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