<%@ page language="java" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<%@include file="menu.jsp" %>
<body>
	<div class="container">
		<div class="row mt-4 mb-3 justify-content-end">
			<div class="col-auto">
				<button class="btn btn-primary">Nueva opción</button>
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
				</tr>
			</thead>
			<tbody>
				<c:forEach var="opcion" items="${sessionScope.OPCIONES}">
			        <tr>
				    	<th scope="row"><c:out value="${opcion.id}"></c:out></th>
				      	<td><c:out value="${opcion.codigo}"></c:out></td>
				      	<td><c:out value="${opcion.descripcion} "></c:out></td>
				      	<td><c:out value="${opcion.estado}"></c:out></td>
				      	<td><c:out value="${opcion.dominio}"></c:out></td>
				      	<td></td>
			    	</tr> 
			   	</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>