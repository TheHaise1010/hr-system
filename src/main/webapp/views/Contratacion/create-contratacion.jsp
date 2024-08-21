<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Contratación</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">Agregar Contratación</h2>
    <form action="${pageContext.request.contextPath}/contratacion?action=create" method="post">
        <div class="form-group">
            <label for="idDepartamento">ID Departamento</label>
            <input type="number" class="form-control" id="idDepartamento" name="idDepartamento" required>
        </div>
        <div class="form-group">
            <label for="idEmpleado">ID Empleado</label>
            <input type="number" class="form-control" id="idEmpleado" name="idEmpleado" required>
        </div>
        <div class="form-group">
            <label for="idCargo">ID Cargo</label>
            <input type="number" class="form-control" id="idCargo" name="idCargo" required>
        </div>
        <div class="form-group">
            <label for="idTipoContratacion">ID Tipo de Contratación</label>
            <input type="number" class="form-control" id="idTipoContratacion" name="idTipoContratacion" required>
        </div>
        <div class="form-group">
            <label for="fechaContratacion">Fecha de Contratación</label>
            <input type="date" class="form-control" id="fechaContratacion" name="fechaContratacion" required>
        </div>
        <div class="form-group">
            <label for="salario">Salario</label>
            <input type="number" class="form-control" id="salario" name="salario" required>
        </div>
        <div class="form-group">
            <label for="estado">Estado</label>
            <select class="form-control" id="estado" name="estado" required>
                <option value="true">Activo</option>
                <option value="false">Inactivo</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>