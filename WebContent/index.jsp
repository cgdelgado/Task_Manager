<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" 	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet" 	href="./styles/css/styles.css">
<title>Gestor personal de tareas</title>
</head>
<body>
	<div class="container" id="indexContainer" width="100%">
		<div>
			<h1>Gestor de Tareas Personales</h1>
		</div>
		<div>
			<h1 id="welcomeTxt">BIENVENID<i id="iconSmile" class="far fa-smile-beam"></i></h1>
		</div>
		<div id="question">
			<h2>¿Qué desea hacer?</h2>
		</div>		
		<div>
			<a class="indexlink" href="TaskController?opt=create"> Crear tarea</a>
			<a class="indexlink" href="TaskController?opt=list"> Ver tareas</a>	
		</div>
	</div>
</body>
</html>