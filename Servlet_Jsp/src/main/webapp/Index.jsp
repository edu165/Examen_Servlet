<%@page import="es.salesianos.repository.RepositoryLanguage"%>
<%@page import="es.salesianos.repository.RepositoryCountry"%>
<%@page import="es.salesianos.service.Service"%>
<%@page import="es.salesianos.model.Language"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,javax.servlet.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="./css/estilos.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet Eduardo</title>

</head>

<body>
	<form method="post" action="welcome">
		<table width="40%" align="center">
			<tr>
				<td colspan="2" align="center"><h2>Escriba su nombre</h2>
					<hr></td>
			</tr>
			<tr>
				<td><p>Pais:</p></td>
				<td><input type="text" id="country" name="country" size="30"></td>
			</tr>
			<tr>
				<td><p>idioma Nuevo:</p></td>
				<td><input type="text" id="Newlanguage" name="Newlanguage" size="30"></td>
			<tr>
			<tr>
				<td><p>Idioma Select:</p></td>
				<td><select name="language" id="language">
				
					<%  
						Service service = new Service();
						List<Language> listAllLanguages = service.SearchAllIlanguage(); 
						for (Language language: listAllLanguages){
						   out.println("<option value ='"+language.getLanguage()+"'>"+language.getLanguage()+"</option>");
						}
					%>
				</select>
				

				</select></td>
			<tr>
				<td colspan="2" align="right"><input class="boton"
					type="submit" value="Enviar"></td>
			</tr>
			<tr>
				<td>
				<td>
			<tr>
				<td><a class="boton" href="List.jsp">Ver listado</a></td>
			</tr>
		</table>
	</form>