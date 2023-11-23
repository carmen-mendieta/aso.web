<%@ page language="java" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<%@include file="menu.jsp" %>
<script type="text/javascript">
</script>
<link href="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.css" rel="stylesheet">
<body>
    <form id="grillaSuspensionForm" action="/aso.web/suspension-servlet" method="GET" >
    </form>
 <div class="container">
 
 	   <table class="table"  id="tabla-suspensiones">
			   <thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
				    <th scope="col">Nro Socio</th>
					<th scope="col">Nombres</th>
					<th scope="col">Apellidos</th>
					<th scope="col">ESTADO</th>
				</tr>
			   </thead>
	   </table>
 </div> 
</body>

<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script src="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.js"></script>

<script type="text/javascript">
	var tablaOpciones;

	var columns = [{
	    "title": "Id",
	    "data": "id"
	},{
	    "title": "Nro_Socio",
	    "data": "nro_socio"
	},{
	    "title": "Nombres",
	    "data": "nombres"
	},{
	    "title": "Apellidos",
	    "data": "apellidos"
	},{
	    "title": "Estado",
	    "data": "socio.estadoActual.descripcion"
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
    