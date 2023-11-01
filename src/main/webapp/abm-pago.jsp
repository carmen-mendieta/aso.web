<%@ page language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<%@include file="menu.jsp"%>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de pagos de Socios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div class="container">
        <form action="/aso.web/pago-servlet" method="POST" class="row g-3">
            <input type="hidden" id="id-socio" name="id-socio" value=""> <br> <br>
            <input type="hidden" id="ACCION" name="ACCION" value="INSERTAR"> <br> <br>

            <div class="col-md-6">
                <label for="socio">Socio:</label>
                <select name="socio" class="form-select">
                    <c:forEach var="socio" items="${LISTASOCIOS}">
                        <option value="${socio.id}">${socio.nombres} ${socio.apellidos}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-6">
                <label for="concepto">Conceptos de Pagos:</label>
                <select name="concepto" class="form-select">
                    <c:forEach var="concepto" items="${LISTACONCEPTOS}">
                        <option value="${concepto.id}">
                            ${concepto.descripcion}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-6">
                <label for="mediopago">Medios de Pagos:</label>
                <select name="mediopago" class="form-select">
                    <c:forEach var="mediopago" items="${MEDIOSPAGOS}">
                        <option value="${mediopago.id}">
                            ${mediopago.descripcion}
                        </option>
                    </c:forEach>
                </select>
            </div>
            
               <div class="col-md-6">
                <label for="monto">Monto Cuota:</label>
               <input type="text" id="monto" placeholder="Ingrese el monto a pagar">
            </div>
            
  </form>
	  </div>
	
</body>
</html>