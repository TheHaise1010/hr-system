<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Empleado</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">Agregar Empleado</h2>
    <form action="${pageContext.request.contextPath}/empleados?action=create" method="post">
        <div class="form-group">
            <label for="numeroDui">Número DUI</label>
            <input type="text" class="form-control" id="numeroDui" name="numeroDui" required>
        </div>
        <div class="form-group">
            <label for="nombrePersona">Nombre</label>
            <input type="text" class="form-control" id="nombrePersona" name="nombrePersona" required>
        </div>
        <div class="form-group">
            <label for="usuario">Usuario</label>
            <input type="text" class="form-control" id="usuario" name="usuario" required>
        </div>
        <div class="form-group">
            <label for="numeroTelefono">Número de Teléfono</label>
            <input type="text" class="form-control" id="numeroTelefono" name="numeroTelefono" required>
        </div>
        <div class="form-group">
            <label for="correoInstitucional">Correo Institucional</label>
            <input type="email" class="form-control" id="correoInstitucional" name="correoInstitucional" required>
        </div>
        <div class="form-group">
            <label for="fechaNacimiento">Fecha de Nacimiento</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>