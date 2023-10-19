<%@ page language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<%@include file="menu.jsp" %>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de datos de  Socios</title>

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

 <h2>
        <font color="#000">Formulario de Socios </font>
    </h2>
    <hr color="green" size="2">
    <form action="/socio-servlet" method="POST" class="row g-3" >
       <input type="hidden" id="id-socio" name="id-socio" value=""> <br> <br>
       <input type="hidden" id="ACCION" name="ACCION" value="INSERTAR"> <br> <br>
       <div class="col-md-6">
            <label for="nombres" class="form-label">Nombres: </label>
             <input type="text" class="form-control" id="nombres" name="nombres" aria-describedby="nombresHelp" >
             <div id="nombresHelp" class="form-text" >
              No compartimos tus nombres con nadie. 
             </div> 
       </div>
        <div class="col-md-6">   
            <label for="apellidos"   class="form-label" >Apellidos</label>
           <input type="text" class="form-control" id="apellidos" name="apellidos"aria-describedby="apellidosHelp" >
            <div id="apellidosHelp" class="form-text" >
              No compartimos tus nombres con nadie. 
             </div> 
          </div>
       
      	<div class="col-md-6">   
               
	            <label for="apellidos"   class="form-label" >Apellidos</label>
	           	<input type="text" class="form-control" id="apellidos" name="apellidos"aria-describedby="apellidosHelp" >
	            <div id="apellidosHelp" class="form-text" >
	              No compartimos tus nombres con nadie. 
	       		</div> 
	       	
            </div>
            
            
   		<div class="col-md-6">
   		   <label for="email"   class="form-label" >Correo Electronico</label>
	           	<input type="email" class="form-control" id="email"  name="email" aria-describedby="emailHelp" placeholder="formato@gmail.com">
	            <div id="emailHelp" class="form-text" >
	              No compartimos tu direccion de correo con nadie. 
	       		</div> 
   		</div>

     <div class="col-md-6">
       <label for="nroSocio"  class="form-label"   >Numero de Socio</label>
       <input type="number" class="form-control" id="nroSocio" name="nroSocio" required> <br> <br>
    </div>
    
      <div class="col-md-6">
        <label for="nroCedula" class="form-label" >Numero de Cédula</label>
        <input type="number" class="form-control" name="nroCedula" id="nroCedula" required> <br> <br>
      </div>
      
        <div class="col-md-6" >
    <label for="fechaIngreso" class="form-label"  >Fecha de Ingreso</label>
    <input type="datetime-local" class="form-control" name="fechaIngreso" id="fechaIngreso" required> <br> <br>
     </div>
  
  	<div class="col-md-6">
 		<label for="estadoActual" class="form-label">Estado Actual</label>
      <select class="form-select" aria-label="Seleccione el estado actual" name="estadoActual" id="estadoActual">
	  	<c:forEach var="estadoSocio" items="${ESTADOS_SOCIOS}">
	   		<option value="${estadoSocio.id}">${estadoSocio.descripcion}</option>
	    </c:forEach>
      </select> 
  	</div>
  
	<div class="col-md-12" form-check>
		<input type="checkbox" class="form-check-input" name="fundador" id="fundador">
		<label class="form-check-label" for="fundador">Socio fundador</label>		
	</div>
	
    <!-- <label for="usuarioCreacion">Usuario Creacion</label>
    <input type="text" name="usuarioCreacion" id="usuarioCreacion"> <br> <br>
   
    <label for="fechaCreacion">Fecha de Creacion</label> 
    <input type="datetime-local" name="fechaCreacion" id="fechaCreacion"> <br> <br>-->
    
     <div class="col-md-12" >
	    <label for="socioProponente" class="form-label"  >Socio Proponente</label>
	     <select class="form-select" aria-label="Seleccione socio proponente" id="socioProponente" name="socioProponente">
	     <c:forEach var="socioProp" items="${SOCIOS}">
	   		<option value="${socioProp.id}">${socioProp.nombres} ${socioProp.apellidos}</option>
	    </c:forEach>
	     </select>
    </div>
    
     <div class="col-md-6" >
	    <label for="tipoSocio" class="form-label">Tipo Socio</label>
	     <select class="form-select" aria-label="Seleccione tipo de socio" id="tipoSocio" name="tipoSocio">
	     <c:forEach var="tipoSocio" items="${TIPOS_SOCIOS}">
	   		<option value="${tipoSocio.id}">${tipoSocio.descripcion}</option>
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