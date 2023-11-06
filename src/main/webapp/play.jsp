<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="es.jacaranda.db.DbRepository"%>
<%@ page import="es.jacaranda.model.Player"%>
<%@ page import="es.jacaranda.model.Play"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Juego del dado</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>


</head>
<body>

	<%@include file="menu.jsp"%>

	<%
	Player player = null;
	Play play = null;
	Boolean showDiesPlayer= false;
	Boolean showDiesMachine= false;
	Boolean showButtonNew= false;
	Boolean showButtonRole = false;
	Boolean showButtonStop = false;
	// ***************************
	// Si hay que empezar el juego
	// ***************************
	
	if (request.getParameter("start") != null && request.getParameter("name")!=null ) {
		// Hay que empezar el juego

		
		
	}// Fin del nuevo juego
	
	//************************
	// El usuario decide tirar
	//************************
    player = (Player) session.getAttribute("player");
	play = (Play) session.getAttribute("play");
	if (request.getParameter("roll") != null && player!= null && play != null) {

	}	
	
	//************************
	// El usuario decide parar
	//************************
	 if (request.getParameter("stop") != null && player!= null && play != null) {
	
		
	 }
	
	//************************
	// Hay que empezar un nuevo Juego o nueva partida
	//************************
	 if (request.getParameter("new") != null && player!= null && play != null) {
	
	}
	if (player== null && play == null){
		response.sendRedirect("error.jsp?msg=Sesión no iniciada");
		return;
	}
	if (request.getParameter("new") == null && request.getParameter("stop") == null &&
			request.getParameter("roll") == null && request.getParameter("start") == null){
		response.sendRedirect("error.jsp?msg=Opción no válida");
		return;
	}
	if (showDiesPlayer){%>
	
	}
	
    if (showDiesMachine){%>
    
    }  	
      	
    if (showButtonRole){%>
		<form>
		<div class="form-group row">
			<div class="offset-6 col-8" style="padding-top: 40px;">
				<button name="roll" type="submit" class="btn btn-primary">Tirar</button>
			</div>
		</div>
		</form>
	<%}
	if (showButtonStop){%>
		<form>
		<div class="form-group row">
			<div class="offset-6 col-8" style="padding-top: 40px;">
				<button name="stop" type="submit" class="btn btn-primary">Plantarme</button>
			</div>
		</div>
		</form>
	<%}
		
	if (showButtonNew){%>
		<div class="display-1 text-center text-primary">Jugada finalizada. Toca el botón para empezar de nuevo</div>
		<form >
			<div class="form-group row">
				<div class="offset-6 col-8" style="padding-top: 40px;">
					<button name="new" type="submit" class="btn btn-primary">Empezar otra de las 5 partidas</button>
				</div>
			</div>
		</form>

	<% }
	

	%>	
	
</body>
</html>