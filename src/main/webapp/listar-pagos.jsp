<%@ page language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<%@include file="menu.jsp" %>
<script type="text/javascript">
	function cargarNuevo(){
		document.getElementById("grillaPagoForm").submit();
	}
</script>
<body>
  <form id="grillaPagoForm" action="/aso.web/pago-servlet" method="GET" >
		<input type="hidden" name="ACCION" id="ACCION" value="NUEVO">
		<input type="hidden" name="ID" id="ID" value="">
	</form>
<table class="table">
  <thead>
    <tr>
    	<th scope="col">Id</th>
      	<th scope="col">Ano Cuota</th>
      	<th scope="col">Mes cuota</th>
      	<th scope="col">Monto cuota</th>
      	<th scope="col">Estado</th>
        <th scope="col">Movimientos Socios</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="pago" items="${PAGOS}">
    <tr>
    	<th scope="row"><c:out value="${pago.id}"></c:out></th>
      	<td><c:out value="${pago.anhoCuota}"></c:out></td>
      	<td><c:out value="${pago.mesCuota}"></c:out></td>
      	<td><c:out value="${pago.montoCuota}"></c:out></td>
      	<td><c:out value="${pago.estado.descripcion}"></c:out></td>
      	<td><c:out value="${pago.movimientoSocio.tipoMovimiento.descripcion}"></c:out></td>
      	<td></td>
    </tr> 
   </c:forEach>
  </tbody>
  <tfoot> 
     <tr>
      <td colspan="6" align="right">
	      <div class="col-auto">
	      	<button type="button" onclick="cargarNuevo()" class="btn btn-primary mb-3">
	      		Nuevo pago
	      	</button>
	      </div>
      </td>
    </tr>
   </tfoot>
</table>
    


</body>
</html>