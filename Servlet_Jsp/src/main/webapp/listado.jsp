<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript">
function BorrarCliente()
{
var resul = confirm('¿Desea borrar el pais seleccionado?');
if (resul = true)
{
document.edu.submit();
}
}
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ver Listado </title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-lg-4 col-sm-6 offset-xl-6 -col-md-2" >
<table>
<tr>
<td>
<form action="verlistado" method="post">
	<input type="submit" value="verlistado">
</form>
</td>
	<td><input type="button" onclick="window.location.href='datos.jsp'"  value="Volver"></td>
	<td><input type="button" onclick="window.location.href='listado.jsp'"  value="Ver Listado"></td>
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
<table border="1">
	<thead>
		<tr>
			<td>pais</td>
			<td>idioma</td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user1" items="${listAllUsers}">
			<tr>
				<td><c:out value="${user1.pais}"/> </td>
				<td><c:out value="${user1.idioma}"/> </td>
				<td>
		<form method="post" action="borrar"  onclick="BorrarCliente() "name="edu">
	<input type="hidden"  value="${user1.idioma}" name="idioma">
	
		<input type="submit"  value="Borrar Completo">
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