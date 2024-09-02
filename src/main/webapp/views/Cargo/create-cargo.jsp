<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Cargo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">Agregar Cargo</h2>
    <form action="${pageContext.request.contextPath}/cargo?action=${cargo != null ? 'update' : 'create'}" method="post">
        <c:if test="${cargo != null}">
            <input type="hidden" name="id" value="${cargo.idCargo}" />
        </c:if>
        <div class="form-group">
            <label for="cargo">Cargo</label>
            <input type="text" class="form-control" id="cargo" name="cargo" value="${cargo != null ? cargo.cargo : ''}" required>
            <span id="cargoError" class="text-danger"></span>
        </div>
        <div class="form-group">
            <label for="descripcionCargo">Descripción del Cargo</label>
            <textarea class="form-control" id="descripcionCargo" name="descripcionCargo" rows="3" required>${cargo != null ? cargo.descripcionCargo : ''}</textarea>
            <span id="descripcionCargoError" class="text-danger"></span>
        </div>
        <div class="form-group">
            <label for="jefatura">Jefatura</label>
            <select class="form-control" id="jefatura" name="jefatura">
                <option value="true" ${cargo != null && cargo.jefatura ? 'selected' : ''}>Sí</option>
                <option value="false" ${cargo != null && !cargo.jefatura ? 'selected' : ''}>No</option>
            </select>
            <span id="jefaturaError" class="text-danger"></span>
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

        // Validate the cargo field.
        var cargo = document.getElementById('cargo');
        var cargoError = document.getElementById('cargoError');
        if (cargo.value.trim() === '') {
            cargoError.textContent = 'El campo Cargo es obligatorio.';
            return;
        } else {
            cargoError.textContent = '';
        }

        // Validate the descripcionCargo field.
        var descripcionCargo = document.getElementById('descripcionCargo');
        var descripcionCargoError = document.getElementById('descripcionCargoError');
        if (descripcionCargo.value.trim() === '') {
            descripcionCargoError.textContent = 'El campo Descripción del Cargo es obligatorio.';
            return;
        } else {
            descripcionCargoError.textContent = '';
        }

        // Validate the jefatura field.
        var jefatura = document.getElementById('jefatura');
        var jefaturaError = document.getElementById('jefaturaError');
        if (jefatura.value.trim() === '') {
            jefaturaError.textContent = 'El campo Jefatura es obligatorio.';
            return;
        } else {
            jefaturaError.textContent = '';
        }

        // If all fields are valid, submit the form.
        event.target.submit();
    });
</script>
</body>
</html>