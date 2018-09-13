<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rent4All - Nouvelle Session</title>
</head>
<body>
<div>
	<h4>Ouvrir une session</h4>
	<form id="login" action="login.jsp">
		<label for="user">Utilisateur</label>
		<input type="text" name="user"><br/>
		<label for="pswd">Mot de passe</label>
		<input type="password" name="pswd"><br/><br/>
		
		<input type="submit" value="Ouvrir une session"/>
	</form>
	</div>
	<div>
		<h4>S'inscrire</h4>
		<form id="newUser" action="newUser">
		<label for="email">Courriel</label>
		<input type="text" name="email"><br/>
		<label for="pswd">Mot de passe</label>
		<input type="password" name="pswd"><br/>
		<label for="fname">Prénom</label>
		<input type="text" name="fname"><br/>
		<label for="lastname">Nom</label>
		<input type="text" name="lastname"><br/>
		<label for="phone">Téléphone</label>
		<input type="text" name="phone"><br/><br/>
		
		<input type="submit" value="S'inscrire"/>
		</form>
	</div>
</body>
</html>