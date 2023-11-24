<%@ page language="java" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<%@include file="menu.jsp" %>
<script type="text/javascript">
function suspender(){
		document.getElementById("ACCION").value = 'SUSPENDER';
		document.getElementById("grillaSuspensionForm").method = 'POST';
		document.getElementById("grillaSuspensionForm").submit();
	}
</script>
<link href="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.css" rel="stylesheet">
<body>
    <form id="grillaSuspensionForm" action="/aso.web/suspension-servlet" method="GET" >
    	<input type="hidden" name="ACCION" id="ACCION" value="">
    </form>
 <div class="container">
 <div class="row mt-4 mb-3 justify-content-end">
			<div class="col-md-6">
					<label for="filtro" class="form-label">Filtros</label> 
					<select onchange=""
						class="form-select" aria-label="Seleccione el dominio" id="filtro"
						name="filtro">
						<option value="TODOS" selected>Todos</option>
						<option value="ACTIVOS_EN_MORA">Activos en mora</option>
						<option value="ACTIVOS_AL_DIA">Activos al día</option>
						<option value="INACTIVOS">Inactivos</option>
					</select>
			</div>
			<div class="col-auto">
				<button type="button" onclick="cargarNuevo()" class="btn btn-primary">Nueva opción</button>
			</div>
		</div>
 	   <table class="table" id="tabla-suspensiones">
			   <thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
				    <th scope="col">Nro_Socio</th>
					<th scope="col">Nombres</th>
					<th scope="col">Apellidos</th>
					<th scope="col">Estado</th>
					<th scope="col">Acciones</th>
				</tr>
			   </thead>
	   </table>
 </div> 
</body>

<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script src="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.js"></script>

<script type="text/javascript">
	var tablaSuspensiones;

	var columns = [{
	    "title": "Id",
	    "data": "id"
	},{
	    "title": "Nro_Socio",
	    "data": "nroSocio"
	},{
	    "title": "Nombres",
	    "data": "nombres"
	},{
	    "title": "Apellidos",
	    "data": "apellidos"
	},{
	    "title": "Estado",
	    "data": "estadoActual.descripcion"
	},{
	    "title": "Acciones",
	    "name": "Acciones", 
	    "sWidth": 30, 
	   "render": function(data,type,full,meta){
        return '<button type="button" class="btn btn-danger mb-3"'
                    +' data-bs-toggle="modal" data-bs-id="' + data.id + '"'
                    +' data-bs-target="#suspenderModal">Suspender</button>';
    },
	    "bSortable": false, 
	    "bSearchable": false,
	    "data":null
	}];
	
	$(document).ready( function () {
		console.log('maria');
		tablaSuspensiones = $('#tabla-suspensiones').DataTable({
			"columns": columns,
			"ajax": {"url":'/aso.web/suspension-servlet?FORMATO=JSON',"dataSrc":""}
		});
	} );
	
	$('#filtro').on('change',function () {
	    var filtro = $('#filtro').val();
		var ajax_source = '/aso.web/suspension-servlet?FORMATO=JSON&FILTRO=' + filtro;
		var table = $("#tabla-suspensiones").DataTable(); // get api instance
	    // load data using api
	    table.ajax.url(ajax_source).load();
    
	});
	

</script>

</html>
    