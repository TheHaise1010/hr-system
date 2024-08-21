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
    <form action="${pageContext.request.contextPath}/cargos?action=create" method="post">
        <div class="form-group">
            <label for="cargo">Cargo</label>
            <input type="text" class="form-control" id="cargo" name="cargo" required>
        </div>
        <div class="form-group">
            <label for="descripcionCargo">Descripcion del Cargo</label>
            <textarea class="form-control" id="descripcionCargo" name="descripcionCargo" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="jefatura">Jefatura</label>
            <select class="form-control" id="jefatura" name="jefatura">
                <option value="true">Sí</option>
                <option value="false">No</option>
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