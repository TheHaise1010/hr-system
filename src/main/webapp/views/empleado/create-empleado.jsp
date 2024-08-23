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
    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>
    <form action="${pageContext.request.contextPath}/empleado?action=create" method="post">
        <div class="form-group">
            <label for="numeroDui">Número DUI</label>
            <input type="text" class="form-control" id="numeroDui" name="numeroDui" required maxlength="10">
            <span id="numeroDuiError" class="text-danger"></span>
        </div>
        <div class="form-group">
            <label for="nombrePersona">Nombre y apellido</label>
            <input type="text" class="form-control" id="nombrePersona" name="nombrePersona" required maxlength="30">
            <span id="nombrePersonaError" class="text-danger"></span>
        </div>
        <div class="form-group">
            <label for="usuario">Usuario</label>
            <input type="text" class="form-control" id="usuario" name="usuario" required maxlength="15">
            <span id="usuarioError" class="text-danger"></span>
        </div>
        <div class="form-group">
            <label for="numeroTelefono">Número de Teléfono</label>
            <input type="text" class="form-control" id="numeroTelefono" name="numeroTelefono" required maxlength="9">
            <span id="numeroTelefonoError" class="text-danger"></span>
        </div>
        <!--
        <div class="form-group">
            <label for="correoInstitucional">Correo Institucional</label>
            <input type="email" class="form-control" id="correoInstitucional" name="correoInstitucional" required>
            <span id="correoInstitucionalError" class="text-danger"></span>
        </div>
        -->
        <div class="form-group">
            <label for="fechaNacimiento">Fecha de Nacimiento</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
            <span id="fechaNacimientoError" class="text-danger"></span>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.querySelector('form').addEventListener('submit', function(event) {
        // Prevent the form from being submitted if it's not valid.
        event.preventDefault();

        // Validate the numeroDui field.
        var numeroDui = document.getElementById('numeroDui');
        var numeroDuiError = document.getElementById('numeroDuiError');
        if (numeroDui.value.trim() === '') {
            numeroDuiError.textContent = 'El campo Número DUI es obligatorio.';
            return;
        } else if (!/^\d{8}-\d{1}$/.test(numeroDui.value)) {
            numeroDuiError.textContent = 'El campo Número DUI debe contener exactamente 8 dígitos, un guion y luego otro dígito.';
            return;
        } else {
            numeroDuiError.textContent = '';
        }

        // Validate the nombrePersona field.
        var nombrePersona = document.getElementById('nombrePersona');
        var nombrePersonaError = document.getElementById('nombrePersonaError');
        if (nombrePersona.value.trim() === '') {
            nombrePersonaError.textContent = 'El campo Nombre es obligatorio.';
            return;
        } else {
            nombrePersonaError.textContent = '';
        }

        // Validate the usuario field.
        var usuario = document.getElementById('usuario');
        var usuarioError = document.getElementById('usuarioError');
        if (usuario.value.trim() === '') {
            usuarioError.textContent = 'El campo Usuario es obligatorio.';
            return;
        } else {
            usuarioError.textContent = '';
        }

        // Validate the numeroTelefono field.
        var numeroTelefono = document.getElementById('numeroTelefono');
        var numeroTelefonoError = document.getElementById('numeroTelefonoError');
        if (numeroTelefono.value.trim() === '') {
            numeroTelefonoError.textContent = 'El campo Número de Teléfono es obligatorio.';
            return;
        } else if (!/^\d{4}-\d{4}$/.test(numeroTelefono.value)) {
            numeroTelefonoError.textContent = 'El campo Número de Teléfono debe contener exactamente 4 dígitos, un guion y luego otros 4 dígitos.';
            return;
        } else {
            numeroTelefonoError.textContent = '';
        }
        // Validate the fechaNacimiento field.
        var fechaNacimiento = document.getElementById('fechaNacimiento');
        var fechaNacimientoError = document.getElementById('fechaNacimientoError');
        if (fechaNacimiento.value.trim() === '') {
            fechaNacimientoError.textContent = 'El campo Fecha de Nacimiento es obligatorio.';
            return;
        } else {
            var fechaNacimientoDate = new Date(fechaNacimiento.value);
            var fechaMinima = new Date();
            fechaMinima.setFullYear(fechaMinima.getFullYear() - 18);
            if (fechaNacimientoDate > fechaMinima) {
                fechaNacimientoError.textContent = 'Debes tener al menos 18 años.';
                return;
            } else {
                fechaNacimientoError.textContent = '';
            }
        }

        // If all fields are valid, submit the form.
        event.target.submit();
    });
</script>
</body>
</html>