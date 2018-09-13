<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ca.qc.cgodin.model.*" %>
	<%@ page import="java.util.*, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	html, body{
		width: 100%;
		height: 100%;
		margin: 10px;
		padding: 10px;
	}
	
</style>
<title>Rent4All</title>
</head>
<header></header>
<nav style='height: 50px; background-color: rgb(20,0,220);'>
	<button onclick="login">Login</button>
</nav>
<body>

<%
	List<Annonce> ann_list = null;
	DBManager db = new DBManager();
	ann_list = db.getAnnonceList();
%>
<h1>Toutes les dernières annonces</h1>

	<table border='1'>
  <%
 	for(Annonce a : ann_list){
  %>
		<tr>
			<td><%=a.getTitre()%></td>
			<td><%=a.getDescription()%></td>
			<td><%=a.getAmount()%></td>
		</tr>
  <%
 	}
  %>
	</table>
</body>
<footer></footer>

</html>