<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Juego del dado</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div style="padding-top: 80px;">
<div class="display-1 text-center text-primary">Introduzca un nombre, si el nombre no está en nuestra lista se creará</div>
</div>
<form action="play.jsp">
  <div class="form-group row">
    <label for="name" class="offset-4 col-form-label" style="padding-top: 40px;">Nombre</label> 
    <div class="offset-4 col-4">
      <input id="name" name="name" type="text" class="form-control" required="required">
    </div>
  </div> 
  <div class="form-group row">
    <div class="offset-6 col-8" style="padding-top:40px;">
      <button name="start" type="submit" class="btn btn-primary">Empezar</button>
    </div>
  </div>
</form>
</body>
</html>