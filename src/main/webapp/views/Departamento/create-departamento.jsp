<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${departamento != null ? 'Editar' : 'Agregar'} Departamento</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">${departamento != null ? 'Editar' : 'Agregar'} Departamento</h2>
    <form action="${pageContext.request.contextPath}/departamento?action=${departamento != null ? 'update' : 'create'}" method="post">
        <c:if test="${departamento != null}">
            <input type="hidden" name="id" value="${departamento.idDepartamento}" />
        </c:if>
        <div class="form-group">
            <label for="nombreDepartamento">Nombre del Departamento</label>
            <input type="text" class="form-control" id="nombreDepartamento" name="nombreDepartamento" value="${departamento != null ? departamento.nombreDepartamento : ''}" required maxlength="25">
            <span id="nombreDepartamentoError" class="text-danger"></span>
        </div>
        <div class="form-group">
            <label for="descripcionDepartamento">Descripción del Departamento</label>
            <textarea class="form-control" id="descripcionDepartamento" name="descripcionDepartamento" required>${departamento != null ? departamento.descripcionDepartamento : ''}</textarea>
            <span id="descripcionDepartamentoError" class="text-danger"></span>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.querySelector('form').addEventListener('submit', function(event) {
        event.preventDefault();

        var nombreDepartamento = document.getElementById('nombreDepartamento');
        var nombreDepartamentoError = document.getElementById('nombreDepartamentoError');
        if (nombreDepartamento.value.trim() === '') {
            nombreDepartamentoError.textContent = 'El campo Nombre del Departamento es obligatorio.';
            return;
        } else {
            nombreDepartamentoError.textContent = '';
        }

        var descripcionDepartamento = document.getElementById('descripcionDepartamento');
        var descripcionDepartamentoError = document.getElementById('descripcionDepartamentoError');
        if (descripcionDepartamento.value.trim() === '') {
            descripcionDepartamentoError.textContent = 'El campo Descripción del Departamento es obligatorio.';
            return;
        } else {
            descripcionDepartamentoError.textContent = '';
        }

        event.target.submit();
    });
</script>
</body>
</html>
