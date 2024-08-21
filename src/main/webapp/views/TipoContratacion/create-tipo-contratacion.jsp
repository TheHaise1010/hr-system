<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Tipo de Contratación</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">Agregar Tipo de Contratación</h2>
    <form action="${pageContext.request.contextPath}/tipoContratacion?action=create" method="post">
        <div class="form-group">
            <label for="nombreTipoContratacion">Nombre del Tipo de Contratación</label>
            <input type="text" class="form-control" id="nombreTipoContratacion" name="nombreTipoContratacion" required>
        </div>
        <div class="form-group">
            <label for="descripcionTipoContratacion">Descripción del Tipo de Contratación</label>
            <textarea class="form-control" id="descripcionTipoContratacion" name="descripcionTipoContratacion" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>