<%@ page language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<%@include file="menu.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h2>
			<font color="#000">Formulario de Opcion</font> 
		</h2>
		<hr color="green" size="2">
		<form action="/aso.web/opcion-servlet" method="POST" class="row g-3" ><br> <br>
       <input type="hidden" id="id-opcion" name="id-opcion" value="${OPCION != null && OPCION.id != null ?
						OPCION.id : ''}"> <br> <br>
         <input type="hidden" id="ACCION" name="ACCION" value="${OPCION != null && OPCION.id != null ?
						'ACTUALIZAR' : 'INSERTAR'}"> <br> <br>
			<div class="col-md-6">
				<label for="codigo" class="form-label">Codigo: </label><input
					type="text" class="form-control" id="codigo" name="codigo"
					aria-describedby="codigoHelp" value="${OPCION.codigo != null  ? OPCION.codigo : ''}"> 
				<div id="codigoHelp" class="form-text"></div>
			</div>

			<div class="col-md-6">
				<label for="descripcion" class="form-label">Descripcion: </label> 
				<input
					type="text" class="form-control" id="descripcion"
					name="descripcion" aria-describedby="descripcionHelp" value="${OPCION.descripcion != null  ? OPCION.descripcion : ''}">
				<div id="descripcionHelp" class="form-text">
				</div>
			</div>

			<div class="col-md-6">
				<label for="estado" class="form-label">Estado: </label> 
				<input
					type="text" class="form-control" id="estado" name="estado"
					aria-describedby="estadoHelp" value="${OPCION.estado != null  ? OPCION.estado : ''}" >
				<div id="estadoHelp" class="form-text"></div>
			</div>

			<div class="col-md-6">
				<label for="dominio" class="form-label">Dominio</label> 
				<select
					class="form-select" aria-label="Seleccione el dominio" id="dominio"
					name="dominio">
					<c:forEach var="dominio" items="${DOMINIOS}">
							<option value="${dominio.id}" 
							${dominio.id == OPCION.dominio.id ? 'selected="selected"' : ''}>
							${dominio.descripcion}</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-md-6">
				<label for="opcionPadre" class="form-label">Opcion Padre</label> <select
					class="form-select" aria-label="Seleccione la opcion Padre"
					id="opcionPadre" name="opcionPadre">
					<option value="">Seleccione un padre(opcional)</option>
					<c:forEach var="opcionPadre" items="${OPCIONES}">
						<option value="${opcionPadre.id}">
							${opcionPadre.descripcion} (Dominio:${opcionPadre.dominio.descripcion}) </option>
					</c:forEach>
				</select>
			</div>

			<div class="row">
				<div class="col-md-3 mt-3">
					<button type="submit" class="btn btn-primary mb-3">Guardar</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>