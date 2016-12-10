<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warning</title>

</head>
<body>
	<center>
		<h1>ESTO PUEDE SER ELIMINADO</h1>
		<form method="post" action="delete">
			<input type="hidden" value="${id}" name="countryDelete"> <br>
			<input class="boton" type="submit" value="SI"> <input
				class="boton" type="button"
				onclick="window.location.href='Index.jsp'" value="No">
		</form>
	</center>
</body>
</html>