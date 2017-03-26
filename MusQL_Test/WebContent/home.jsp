<%@page import="java.util.List"%>
<%@page import="com.medinet.model.Etudiant"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% Collection<Etudiant> lists=(List<Etudiant>)request.getAttribute("lists"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="WEB-INF/css/style.css" >
<title>Home Page</title>
</head>
<body>

<div style="padding-bottom:40px;">
<h3>Ajouter Un Etudiant</h3>
	<form action="" method="post">
		
		Code Etudiant : <input type="text" name="code" /><br>
		Nom Etudiant : <input type="text" name="nom" /><br>
		Prenom Etudiant : <input type="text" name="prenom" /><br>
		<input type="submit" /><br>
	</form>
</div>
<% if(((Etudiant)request.getAttribute("etudiant"))!=null){ %>
<div>
	<p><%= ((Etudiant)request.getAttribute("etudiant")).getNom() %> a été bien Supprimer </p>
</div>
<%} %>
<table >
	<thead>
		<tr>
			<td>Code Etudiant</td>
			<td>Nom Etudiant</td>
			<td>Prénom Etudiant</td>
			<td>[Action]</td>
		</tr>
	</thead>
	<tbody>
	<% for(Etudiant etud:lists){ %>
		<tr>
			<td><%= etud.getCode() %></td>
			<td><%= etud.getNom() %></td>
			<td><%= etud.getPrenom() %></td>
			<td><a href="modifier?code=<%=etud.getCode()%>">Modifier</a> || <a href="delete?code=<%=etud.getCode()%>">Supprimer</a></td>
		</tr>
		<% } %>
	</tbody>
</table>
</body>
</html>