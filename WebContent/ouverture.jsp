<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="ca.qc.cgodin.model.Annonce" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rent4All - Bienvenue</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
<div id="container">
<div class="nav">
	<a class="btn" href="login.jsp">Se connecter</a>
</div>
<h3>Toutes les dernieres annonces</h3>
<%
	ArrayList<Annonce> ann_list = new ArrayList<Annonce>();
%>
<p></p>

	<table border='1'>
  <%
 	for(Annonce a : ann_list){
  %>
		<tr>
			<td><img width="100px" height="50px" src=""/></td>
			<td><%= a.getTitre() %></td>
			<td><%= a.getDescription() %></td>
			<td><%=a.getAmount() %></td>
		</tr>
  <%
 	}
  %>
	</table>
</div>
</body>
<footer></footer>

</html>