<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ca.qc.cgodin.model.Annonce"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rent4All</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>

<body>

	<div id="container">
		<div class="nav">
			<a class="btn" href="ouverture.jsp">< Accueil</a>
		</div>
		<h3 style="text-align: center;">Ouvrir une session ou créer un
			compte</h3>
		<table width="100%">
			<tr>
				<th width="50%">Ouvrir une session</th>
				<th>Créer un compte</th>
			</tr>
			<tr>
				<td width="50%">		
					<form id="login" action="" method="post">
						<table>
							<tr>
								<td>Courriel</td>
									<td>
										<input type="text" name="email">
									</td>
								</tr>
							<tr>
								<td>Mot de passe</td>
								<td>
									<input type="password" name="pswd">
								</td>
							</tr>
							<tr>
								<td>
									<input type="submit" value="Se connecter"/>
								</td>
							</tr>
						</table>
					</form>
				</td>
				<td width="50%">				
					<form id="newUser" action="http://localhost:8080/Rent4All/UserManager?AddUser">
					<table width="100%">
					<tr>
						<td>Courriel</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Mot de passe</td>
						<td><input type="password" name="pswd"></td>
					</tr>
					<tr>
						<td>Prénom</td>
						<td><input type="text" name="fname"></td>
					</tr>
					<tr>
						<td>Nom</td>
						<td><input type="text" name="lastname"></td>
					</tr>
					<tr>
						<td>Téléphone</td>
						<td><input type="text" name="phone"></td>
					</tr>
					</table>					
					</form>
					<br/>
					<input type="submit" value="S'inscrire" />	
				</td>
			</tr>
		</table>
</body>
</html>