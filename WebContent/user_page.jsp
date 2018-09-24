<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de profil</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>

<body>

<div id="container">
	<div class="nav">
		<a class="btn" href="ouverture.jsp">Retour Accueil</a>
		<a class="btn" href="CloseSession.jsp">Fermer session</a>
	</div>
	
<h3>Vos annonces</h3>

<% 	
	String userID = request.getParameter("UserID");
    ArrayList<Annonce> ann_list = new ArrayList<Annonce>();
    String req="Select * FROM Annonce"  ;
    if (userID!=null) 
    	req+="WHERE UserID='"+ userID + "'";
%>
<button id="addAnn" onclick="AddAnnonceServlet">Ajouter une annonce</button>
<br/>
	<table border="1">
  <%
 	for(Annonce a : ann_list){
  %>
		<tr>
			<td>
				<img width="50px" src="#"/>
			</td>
			<td>
				<h4>
					<%=a.getTitre() %>
				</h4>
				<p>
					<%=a.getDescription() %>
				</p>
			</td>
			<td>
				<% double amnt= a.getAmount();
					String.format("%,2f$", amnt);
				%>
			</td>
		</tr>
  <%
 	}
  %>
	</table>
</div>
</body>
</html>