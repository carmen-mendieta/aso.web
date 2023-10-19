<%@ page language="java" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<%@include file="menu.jsp" %>
<script type="text/javascript">
	function cargarNuevo(){
		document.getElementById("grillaSocioForm").submit();
	}
</script>
<body>
	<form id="grillaSocioForm" action="/aso.web/socio-servlet" method="GET" >
		<input type="hidden" name="ACCION" id="ACCION" value="NUEVO">
		<input type="hidden" name="ID" id="ID" value="">
	</form>

<table class="table">
  <thead>
    <tr>
    	<th scope="col">Id</th>
      	<th scope="col">Nro Socio</th>
      	<th scope="col">Nombre y Apellido</th>
      	<th scope="col">Estado</th>
    	<th scope="col">Ult Cuota Pag</th>
        <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="socio" items="${SOCIOS}">
    <tr>
    	<th scope="row"><c:out value="${socio.id}"></c:out></th>
      	<td><c:out value="${socio.nroSocio}"></c:out></td>
      	<td><c:out value="${socio.nombres} ${socio.apellidos}"></c:out></td>
      	<td><c:out value="${socio.estadoActual.descripcion}"></c:out></td>
      	<td></td>
      	<td></td>
    </tr> 
   </c:forEach>
  </tbody>
  <tfoot> 
     <tr>
      <td colspan="6" align="right">
	      <div class="col-auto">
	      	<button type="button" onclick="cargarNuevo()" class="btn bt-primary mb-3">
	      		Nuevo socio
	      	</button>
	      </div>
      </td>
    </tr>
   </tfoot>
</table>
</body>
</html>