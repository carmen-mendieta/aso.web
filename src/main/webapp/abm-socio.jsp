<%@ page language="java"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="menu.jsp" %>
<head>
<meta charset="UTF-8">
<title>Formulario Socios</title>
</head>
<body>
 <h2>
        <font color="#000">Formulario de Socios </font>
    </h2>
    <hr color="green" size="2">
    <form action="socio-servlet" method="POST">
     <label for="nombres">Nombres:</label>
     <input type="text" id="nombres" name="nombres" required> <br> <br>

     <label for="apellidos">Apellidos</label>
     <input type="text" id="apellidos" name="apellidos" required> <br> <br>

     <label for="email">Email</label>
     <input type="email" id="email" name="email" required> <br> <br>

     <label for="nroSocio">Numero de Socio</label>
     <input type="number" id="nroSocio" name="nroSocio" required> <br> <br>

     <label for="nroCedula">Numero de Cédula</label>
    <input type="number" name="nroCedula" id="nroCedula" required> <br> <br>

    <label for="fechaIngreso">Fecha de Ingreso</label>
    <input type="datetime-local" name="fechaIngreso" id="fechaIngreso" required> <br> <br>

    <label for="estadoActual">Estado</label>
    <select name="estadoActual" id="estadoActual"> <br> <br>
        <option value="1">Activo</option>
        <option value="2">Inactivo</option>
      </select>
    <br> <br>

    <label for="fundador">Es fundador</label>
    <input type="checkbox" name="fundador" id="fundador"> <br> <br>

    <label for="usuarioCreacion">Usuario Creacion</label>
    <input type="text" name="usuarioCreacion" id="usuarioCreacion"> <br> <br>
   
    <label for="fechaCreacion">Fecha de Creacion</label> 
    <input type="datetime-local" name="fechaCreacion" id="fechaCreacion"> <br> <br>

    <label for="socioProponente">Socio Proponente</label>
    <input type="text" name="socioProponente" id="socioProponente"> <br> <br>

    <label for="tipoSocio">Tipo Socio</label>
    <input type="text" name="tipoSocio" id="tipoSocio"> <br> <br>

     <input type="submit" value="Guardar"> <br> <br>

    </form>
</body>
</html>