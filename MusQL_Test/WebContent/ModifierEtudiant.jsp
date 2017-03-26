<%@page import="com.medinet.model.Etudiant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% Etudiant etudiant=(Etudiant)request.getAttribute("etudiant"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="padding-bottom:40px;">
<h3>Modifier l'étudiant</h3>
	<form action="ModifierEtudiant" method="post">
		
		Code Etudiant : <input type="text" name="code" value="<%= etudiant.getCode() %>" readOnly/><br>
		Nom Etudiant : <input type="text" name="nom" value="<%= etudiant.getNom() %>" /><br>
		Prenom Etudiant : <input type="text" name="prenom" value="<%= etudiant.getPrenom() %>" /><br>
		<input type="submit" /><br>
	</form>
</div>
</body>
</html>