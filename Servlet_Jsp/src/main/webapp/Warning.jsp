<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5;url=Paises.jsp" />
<title>Warning</title>
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
</style>
</head>
<body>
<center><h1>ESTO PUEDE SER   ELIMINADO</h1>
<form method="post" action="borrartodo">
		<input  type="hidden" value="${id}" name="idiomaborrar">
		<br>
		<input  class="boton" type="submit"  value="SI, estoy seguro">
		<a  href="List.jsp" class="boton" >NO, quiero eliminarlo</a>
	</form>	
</center>
</body>
</html>