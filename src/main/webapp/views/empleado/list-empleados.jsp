<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lista de Empleados</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">Lista de Empleados</h2>
    <c:choose>
        <c:when test="${not empty empleados}">
            <table class="table table-bordered table-hover text-center">
                <thead class="thead-dark">
                <tr>
                    <th>DUI</th>
                    <th>Nombre</th>
                    <th>Numero telefono</th>
                    <th>Correo institucional</th>
                    <th>Fecha nacimiento</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="empleado" items="${empleados}">
                    <tr>
                        <td><c:out value="${empleado.numeroDui}"/></td>
                        <td><c:out value="${empleado.nombrePersona}"/></td>
                        <td><c:out value="${empleado.numeroTelefono}"/></td>
                        <td><c:out value="${empleado.correoInstitucional}"/></td>
                        <td><c:out value="${empleado.fechaNacimiento}"/></td>
                        <td class="d-flex justify-content-center">
                            <button class="btn btn-success mr-2">Editar</button>
                            <button class="btn btn-danger">Borrar</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert">
                No hay empleados disponibles.
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script></body>
</html>