<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" 	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet" 	href="./styles/css/styles.css">
<title>Ver tarea</title>
</head>
<body>
	<div class="container">
		<div class="subcontainer">
			<c:set var="t" value="${task}"></c:set>
			<div class="text-center">
				<h1><c:out value="${task.name}"></c:out></h1>
			</div>
			<div>
				<!-- div class="form-group">
					Nombre <input type="text" name="name" value="${t.name}" disabled> 				
				</div>-->
				<div class="form-group">
					Descripción <input type="text" class="form-control" name="description" value="${t.description}" disabled> 				
				</div>
				<div class="form-group">
					Fecha inicio <input type="text" class="form-control" name="start" value="${t.start}" disabled> 				
				</div>
				<div class="form-group">
					Fecha fin <input type="text" class="form-control" name="end" value="${t.end}" disabled>				
				</div>
				<div class="form-group">				
					Realizada
					<c:choose>
						<c:when test="${task.done==0}">
							<input type="text" class="form-control" name="done" value="No" disabled>
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control" name="done" value="Sí" disabled>
						</c:otherwise>				
					</c:choose>			
				</div>
				<div class="row form-group">
					<a class="btn btn-primary" href="TaskController?opt=list">Volver a la lista</a>			
				</div>		
			</div>	
		</div>
	</div>

	
	
		
		
	

</body>
</html>