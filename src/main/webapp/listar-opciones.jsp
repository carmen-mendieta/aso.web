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
<link href="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.css" rel="stylesheet">
<body>
   <form id="grillaOpcionForm" action="/aso.web/opcion-servlet" method="GET" >
		<input type="hidden" name="ACCION" id="ACCION" value="NUEVO">
		<input type="hidden" name="ID" id="ID" value="">
	</form>
<div class="container">
		<div class="row mt-4 mb-3 justify-content-end">
			<div class="col-md-6">
					<label for="dominio" class="form-label">Dominio</label> 
					<select onchange=""
						class="form-select" aria-label="Seleccione el dominio" id="dominio"
						name="dominio">
						<c:forEach var="dominio" items="${DOMINIOS}">
								<option value="${dominio.id}" 
								${dominio.id == OPCION.dominio.id ? 'selected="selected"' : ''}>
								${dominio.descripcion}</option>
						</c:forEach>
					</select>
			</div>
			<div class="col-auto">
				<button type="button" onclick="cargarNuevo()" class="btn btn-primary">Nueva opción</button>
			</div>
		</div>
	   <table class="table"  id="tabla-opciones">
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
<!-- 			<tbody> -->
<%-- 				<c:forEach var="opcion" items="${sessionScope.OPCIONES}"> --%>
<!-- 			        <tr> -->
<%-- 				    	<th scope="row"><c:out value="${opcion.id}"></c:out></th> --%>
<%-- 				      	<td><c:out value="${opcion.codigo}"></c:out></td> --%>
<%-- 				      	<td><c:out value="${opcion.descripcion} "></c:out></td> --%>
<%-- 				      	<td><c:out value="${opcion.estado}"></c:out></td> --%>
<%-- 				      	<td><c:out value="${opcion.dominio.descripcion}"></c:out></td> --%>
<%-- 				      	<td><c:out value="${opcion.opcionPadre.descripcion}"></c:out></td> --%>
<!-- 				      	<td> -->
<!-- 				      		<div class="row"> -->
<!-- 					      	  	<div class="col-auto"> -->
<%-- 					         		<button class="btn btn-warning mb-3" onclick="editar(${opcion.id})">Editar</button> --%>
<!-- 				        		</div> -->
<!-- 				        		<div class="col-auto"> -->
<!-- 					         		<button type="button" class="btn btn-danger mb-3"  -->
<!-- 									data-bs-toggle="modal" -->
<%-- 									data-bs-id="<c:out value='${opcion.id}'></c:out>"  --%>
<!-- 									data-bs-target="#eliminarModal">Eliminar</button> -->
<!-- 				        		</div> -->
<!-- 				      		</div> -->
				      	  
<!-- 				      	</td> -->
<!-- 			    	</tr>  -->
<%-- 			   	</c:forEach> --%>
<!-- 			</tbody> -->
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
<script src="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.js"></script>
<!-- <script type="text/javascript" > -->
	
	<!-- $('#dominio').on('change',function () {
		var id = $('#dominio').val();
		console.log('Test 2', id);
		$.ajax({
			url: '/aso.web/opcion-servlet?ACCION=LISTAR&FORMATO=JSON&ID-DOMINIO=' +id,
			type: "GET",
			success: function (data) {
			//	console.log('log', data);
			//	console.table(data);
				//$('#direccionProv').val(data.direccion);
				}
			});
		}); -->
<!-- </script> -->
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
<script type="text/javascript">
	var tablaOpciones;

	var columns = [{
	    "title": "Id",
	    "data": "id"
	}, {
	    "title": "Codigo",
	    "data": "codigo"
	},{
	    "title": "Descripcion",
	    "data": "descripcion"
	},{
	    "title": "Estado",
	    "data": "estado"
	},{
	    "title": "Dominio",
	    "data": "dominio.descripcion"
	},{
	    "title": "Opcion Padre",
	    "data": "opcionPadre.descripcion"
	},{
	    "title": "Acciones",
	    "name": "Acciones", 
	    "sWidth": 30, 
	    "render": function(data,type,full,meta){
	    	var botones = "<input type=\"button\" value=\"Editar\" onclick=\"editar("
		    			+data.id+");\" class=\"btn btn-info\">";
		    botones += '<button type="button" class="btn btn-danger mb-3"'
		    			+' data-bs-toggle="modal" data-bs-id="' + data.id + '"'
						+' data-bs-target="#eliminarModal">Eliminar</button>';
			return botones;
		},
	    "bSortable": false, 
	    "bSearchable": false,
	    "data":null
	}];
	
	$(document).ready( function () {
		tablaOpciones = $('#tabla-opciones').DataTable({
			"columns": columns,
			"ajax": {"url":'/aso.web/opcion-servlet?ACCION=LISTAR&FORMATO=JSON',"dataSrc":""}
		});
	} );
	
	$('#dominio').on('change',function () {
	    var id = $('#dominio').val();
		var ajax_source = '/aso.web/opcion-servlet?ACCION=LISTAR&FORMATO=JSON&ID-DOMINIO=' +id;
		var table = $("#tabla-opciones").DataTable(); // get api instance
	    // load data using api
	    table.ajax.url(ajax_source).load();
    
	});
</script>

</html>