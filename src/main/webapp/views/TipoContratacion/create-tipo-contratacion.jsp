<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${tipoContratacion != null ? 'Editar' : 'Agregar'} Tipo de Contratación</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">${tipoContratacion != null ? 'Editar' : 'Agregar'} Tipo de Contratación</h2>
    <form action="${pageContext.request.contextPath}/tipoContratacion?action=${tipoContratacion != null ? 'update' : 'create'}" method="post">
        <c:if test="${tipoContratacion != null}">
            <input type="hidden" name="id" value="${tipoContratacion.idTipoContratacion}" />
        </c:if>
        <div class="form-group">
            <label for="tipoContratacion">Nombre del Tipo de Contratación</label>
            <input type="text" class="form-control" id="tipoContratacion" name="tipoContratacion" value="${tipoContratacion != null ? tipoContratacion.tipoContratacion : ''}" required>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
