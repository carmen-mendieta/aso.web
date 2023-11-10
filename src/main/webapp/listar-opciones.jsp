<%@ page language="java" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<%@include file="menu.jsp" %>
<script type="text/javascript">
	function cargarNuevo(){
		document.getElementById("grillaOpcionForm").submit();
	}
	
	function eliminar(){
		document.getElementById("ACCION").value = 'ELIMINAR';
		document.getElementById("grillaOpcionForm").method = 'POST';
		document.getElementById("grillaOpcionForm").submit();
	}
	function editar(id){
		document.getElementById("ACCION").value = 'EDITAR';
		document.getElementById("ID").value = id;
		document.getElementById("grillaOpcionForm").method = 'POST';
		document.getElementById("grillaOpcionForm").submit();
	}
	
</script>
</script>
<body>
   <form id="grillaOpcionForm" action="/aso.web/opcion-servlet" method="GET" >
		<input type="hidden" name="ACCION" id="ACCION" value="NUEVO">
		<input type="hidden" name="ID" id="ID" value="">
	</form>
<div class="container">
		<div class="row mt-4 mb-3 justify-content-end">
			<div class="col-auto">
				<button type="button" onclick="cargarNuevo()" class="btn btn-primary">Nueva opción</button>
			</div>
		</div>
	   <table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">CODIGO</th>
					<th scope="col">DESCRIPCION</th>
					<th scope="col">ESTADO</th>
					<th scope="col">DOMINIO</th>
					<th scope="col">PADRE</th>
					<th scope="col">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="opcion" items="${sessionScope.OPCIONES}">
			        <tr>
				    	<th scope="row"><c:out value="${opcion.id}"></c:out></th>
				      	<td><c:out value="${opcion.codigo}"></c:out></td>
				      	<td><c:out value="${opcion.descripcion} "></c:out></td>
				      	<td><c:out value="${opcion.estado}"></c:out></td>
				      	<td><c:out value="${opcion.dominio.descripcion}"></c:out></td>
				      	<td><c:out value="${opcion.opcionPadre.descripcion}"></c:out></td>
				      	<td>
				      		<div class="row">
					      	  	<div class="col-auto">
					         		<button class="btn btn-warning mb-3" onclick="editar(${opcion.id})">Editar</button>
				        		</div>
				        		<div class="col-auto">
					         		<button type="button" class="btn btn-danger mb-3" 
									data-bs-toggle="modal"
									data-bs-id="<c:out value='${opcion.id}'></c:out>" 
									data-bs-target="#eliminarModal">Eliminar</button>
				        		</div>
				      		</div>
				      	  
				      	</td>
			    	</tr> 
			   	</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="modal fade" id="eliminarModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Eliminacion de registros</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p id="parrafoTexto">¿Estas seguro que desea eliminar el registro?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-danger" onclick="eliminar()">Eliminar</button>
      </div>
    </div>
  </div>
</div>
	
</body>
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" >



</script>

<script>
	const deleteModal = document.getElementById('eliminarModal');
	if (deleteModal) {
	  deleteModal.addEventListener('show.bs.modal', event => {
	    const button = event.relatedTarget;
	    const idToDelete = button.getAttribute('data-bs-id');
	    const parrafoTexto = deleteModal.querySelector('#parrafoTexto')
		document.getElementById("ID").value = idToDelete; 
	    parrafoTexto.textContent = `¿Está seguro de querer eliminar el registro de ID ` + button.getAttribute('data-bs-id') + `?`
	  })
	}
</script>
</html>