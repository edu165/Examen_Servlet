<%@page import="es.salesianos.repository.Repository"%>
<%@page import="es.salesianos.model.Idiomas"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,javax.servlet.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<form method="post" action="welcome">
	<table width="40%" align="center">
		<tr>
			<td colspan="2" align="center"><h2>Escriba su nombre</h2><hr></td>
		</tr>
		<tr>
			<td><p>Pais:</p></td>
			<td><input type="text" id="user" name="pais" size="30"></td>
		</tr>
		<tr>
			<td><p>idioma Nuevo:</p></td>
			<td><input type="text" id="idioma2" name="idioma2" size="30"></td>
		<tr>
			
		<tr>
<td><p>Idioma Select:</p></td>
			<td>
				<select name="idioma" id="idioma">
					<%  List<Idiomas> listAllIdiomas = new ArrayList<Idiomas>();
						listAllIdiomas = Repository.SearchAll_Idiomas(); 
						for (int i=0;i<listAllIdiomas.size();i++){
						   out.println("<option value ='"+listAllIdiomas.get(i).getIdioma()+"'>"+listAllIdiomas.get(i).getIdioma()+"</option>");
						}
					%>
				</select>
			</td>
			
			
			
			
		<tr>
			<td colspan="2" align="right"><input type="submit" value="Enviar"></td>
		</tr>
		<tr>
		<td><td>
		<tr>
		<td><input type="button" onclick="window.location.href='listado.jsp'"  value="Ver Listado"></td>
		</tr>
	</table>
</form>