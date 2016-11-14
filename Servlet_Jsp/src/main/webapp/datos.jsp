<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			
		<tr>
			<td><p>Idioma:</p></td>
			<td><input type="text" id="user" name="idioma" size="30"></td>
		</tr>
		<tr>
			
			
			
			
		<tr>
			<td colspan="2" align="right"><input type="submit" value="Enviar"></td>
		</tr>
		<tr>
		<td><input type="button" onclick="window.location.href='listado.jsp'"  value="Ver Listado"></td>
		</tr>
	</table>
</form>