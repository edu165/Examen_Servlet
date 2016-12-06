<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5;url=Paises.jsp" />
<title>Warning</title>

</head>
<body>
	<center>
		<h1>ESTO PUEDE SER ELIMINADO</h1>
		<form method="post" action="delete">
			<input type="hidden" value="${id}" name="countryDelete"> <br>
			<input class="boton" type="submit" value="SI, estoy seguro">
			<a class="boton" href="List.jsp">NO, quiero eliminarlo</a>
		</form>
	</center>
</body>
</html>