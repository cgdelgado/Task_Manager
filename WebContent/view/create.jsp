<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" 	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet" 	href="./styles/css/styles.css">
<link rel="stylesheet" 	href="./styles/css/tcal.css">
<script src="./styles/js/validate.js"></script>
<script src="./styles/js/tcal.js"></script>
<title>Crear tarea</title>
</head>
<body>
	<div class="container">
		<div class="subcontainer">
			<div class="text-center">
				<h1>Nueva tarea</h1>
			</div>
			<form action="TaskController" method="post" onsubmit = "return validate()">
				<input type="hidden" name="opt" value="add">		
				<div class="form-group">				
					Nombre <input class="form-control" type="text" id="name" name="name" required>
				</div>
				<div class="form-group">
					Descripción <input class="form-control" type="text" id="description" name="description">				
				</div>
				<div class="form-group">
					Fecha inicio <input class="form-control tcal" type="text" id="start" name="start">				
				</div>
				<div class="form-group">
					Fecha fin <input class="form-control tcal" type=text id="end" name="end">					
				</div>
				<div class="row form-group">
					<input type="submit" class="btn btn-primary" value="Guardar">					
					<a class="btn btn-primary" href="TaskController?opt=list">Volver a la lista</a>
				</div>
			</form>
		</div>
	
	</div>	
</body>
</html>