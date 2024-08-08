<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../navbar.jsp" %>
<h2>Lista de Empleados</h2>
<a href="${pageContext.request.contextPath}/views/empleado/create-empleado.jsp" class="btn btn-success mb-2">Agregar Empleado</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>DUI</th>
        <th>Nombre</th>
        <th>Usuario</th>
        <th>Teléfono</th>
        <th>Correo</th>
        <th>Fecha Nacimiento</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="empleado" items="${empleados}">
        <tr>
            <td>${empleado.idEmpleado}</td>
            <td>${empleado.numeroDui}</td>
            <td>${empleado.nombrePersona}</td>
            <td>${empleado.usuario}</td>
            <td>${empleado.numeroTelefono}</td>
            <td>${empleado.correoInstitucional}</td>
            <td>${empleado.fechaNacimiento}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

