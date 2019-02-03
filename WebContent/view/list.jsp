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
<title>Tareas</title>
</head>
<body>
	<div id="containerList" class="container" width="100%">
		<div>
			<table class="table table-hover text-center">
				<thead class="tableHead">
					<tr><td colspan="6"><a id="newTask" href="TaskController?opt=create"> <i class="fas fa-plus-circle"></i> Crear tarea</a><td></tr>
					<tr>
						<td>Nº</td>
						<td>Nombre</td>
						<!-- <td>Descripción</td>-->
						<td>Fecha inicio</td>
						<td>Fecha fin</td>
						<td>Realizado</td>
						<td>Ver tarea</td>
						<td>Eliminar tarea</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="task" items="${taskList}">
						<tr>
							<td><c:out value="${task.id}"></c:out></td>
							<td><c:out value="${task.name}"></c:out></td>
							<!-- <td><c:out value="${task.description}"></c:out></td>-->
							<td><c:out value="${task.start}"></c:out></td>
							<td><c:out value="${task.end}"></c:out></td>
							<c:choose>
								<c:when test="${task.done==0}">
									<td>
										<form action="TaskController" method="post">
											<input type="hidden" name="opt" value="markTask">
											<input	type="hidden" name="id" value="${task.id}"> 
											<input  type="submit" value="Realizar">
										</form>
									</td>
								</c:when>
								<c:otherwise>
									<td><i id="checkIcon" class="fas fa-check-circle"></i></td>
								</c:otherwise>
							</c:choose>
							<td><a href="TaskController?opt=show&id=<c:out value="${task.id}"></c:out>"><i id="showLink" class="fas fa-eye"></i></a></td>
							<td><a href="TaskController?opt=delete&id=<c:out value="${task.id}"></c:out>"><i id="deleteLink" class="far fa-trash-alt"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
			<div class="row form-group">
				<a class="btn btn-primary" href="TaskController?opt=home">Volver al inicio</a>			
			</div>	
		</div>	
	</div>
</body>
</html>