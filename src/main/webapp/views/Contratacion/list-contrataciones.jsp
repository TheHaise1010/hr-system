<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lista de Contrataciones</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>
<div class="container mt-5">
    <h2 class="mb-4">Lista de Contrataciones</h2>
    <c:choose>
        <c:when test="${not empty contrataciones}">
            <table class="table table-bordered table-hover text-center">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Empleado</th>
                    <th>Departamento</th>
                    <th>Cargo</th>
                    <th>Tipo contratacion</th>
                    <th>Fecha contratacion</th>
                    <th>Salario</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contratacion" items="${contrataciones}" varStatus="status">
                    <tr>
                        <td><c:out value="${contratacion.idContratacion}"/></td>
                        <td><c:out value="${empleados[status.index]}"/></td>
                        <td><c:out value="${departamentos[status.index]}"/></td>
                        <td><c:out value="${cargos[status.index]}"/></td>
                        <td><c:out value="${tiposContratacion[status.index]}"/></td>
                        <td><c:out value="${contratacion.fechaContratacion}"/></td>
                        <td><c:out value="${contratacion.salario}"/></td>
                        <td> <c:choose>
                            <c:when test="${contratacion.estado}">
                                Activo
                            </c:when>
                            <c:otherwise>
                                Inactivo
                            </c:otherwise>
                        </c:choose></td>
                        <td class="d-flex justify-content-center">
                            <a href="${pageContext.request.contextPath}/contrataciones?action=edit&id=${contratacion.idContratacion}" class="btn btn-success mr-2">Editar</a>
                            <a href="${pageContext.request.contextPath}/contrataciones?action=delete&id=${contratacion.idContratacion}" class="btn btn-danger">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert">
                No hay contrataciones disponibles.
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script></body>
</html>