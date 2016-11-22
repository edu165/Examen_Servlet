<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
  .boton{
    text-decoration: none;
    padding: 5px;
    font-weight: 400;
    font-size: 15px;
    color:white;
    background-color: gray;
    border-radius: 6px;
    border: 2px solid medium;
  }
   .botonmin{
    text-decoration: none;
    padding: 6px;
    font-weight: 200;
    font-size: 15px;
    color:white;
    background-color: gray;
    border-radius: 4px;
    border: 2px solid medium;
    align:center;
  }
</style>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ver Listado </title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-lg-4 col-sm-6 offset-xl-6 -col-md-2" >
<table width="40%" align="center">
<tr>
<td>
<form action="verlistado" method="post">
	<input class="boton" type="submit" value="verlistado">
</form>
</td>
	<td><a class="boton"  href="Date.jsp"  >Volver</a></td>
	<td><a class="boton"  href="List.jsp"  >Listado</a></td>
	</tr>
	</table>
	</div>


<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="col-lg-4 col-sm-6 offset-xl-6 -col-md-2" >
<table border="3" width="30%" align="center">
	<thead>
		<tr>
			<td>Pais</td>
			<td>Idioma</td>
			<td>Borrar</td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${listAllUsers}">
			<tr>
				<td><c:out value="${user.pais}"/> </td>
				<td><c:out value="${user.idioma}"/> </td>
				
		
	<td><a   class="botonmin" name="userborrar" href="Delete_Warning?userborrar=${user.idioma}">Borrar Idiomas </a></td>
	
		
	</form>	</td>
		
	</form>	
	</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>










</body>
</html>