<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lista de Tipos de Contrataciones</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">Lista de Tipos de Contrataciones</h2>
    <c:choose>
        <c:when test="${not empty tiposContratacion}">
            <table class="table table-bordered table-hover text-center">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Tipo Contratacion</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="tipoContratacion" items="${tiposContratacion}">
                    <tr>
                        <td><c:out value="${tipoContratacion.idTipoContratacion}"/></td>
                        <td><c:out value="${tipoContratacion.tipoContratacion}"/></td>
                        <td class="d-flex justify-content-center">
                            <a href="${pageContext.request.contextPath}/tipoContratacion?action=edit&id=${tipoContratacion.idTipoContratacion}" class="btn btn-success mr-2">Editar</a>
                            <a href="${pageContext.request.contextPath}/tipoContratacion?action=delete&id=${tipoContratacion.idTipoContratacion}" class="btn btn-danger">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert">
                No hay tipos de contrataciones disponibles.
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script></body>
</html>