<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>${contratacion != null ? 'Editar' : 'Agregar'} Contratación</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">${contratacion != null ? 'Editar' : 'Agregar'} Contratación</h2>
    <c:choose>
        <c:when test="${not empty departamentos and not empty empleados and not empty cargos and not empty tiposContratacion}">
            <form id="contratacionForm" action="${pageContext.request.contextPath}/contrataciones?action=${contratacion != null ? 'update' : 'create'}"
                  method="post">
                <c:if test="${contratacion != null}">
                    <input type="hidden" name="id" value="${contratacion.idContratacion}"/>
                </c:if>

                <div class="form-group">
                    <label for="idDepartamento">Departamento</label>
                    <select class="form-control" id="idDepartamento" name="idDepartamento" required>
                        <c:forEach var="departamento" items="${departamentos}">
                            <option ${contratacion != null && contratacion.idDepartamento == departamento.idDepartamento ? 'selected' : ''} value="${departamento.idDepartamento}"><c:out value="${departamento.nombreDepartamento}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idEmpleado">Empleado</label>
                    <select class="form-control" id="idEmpleado" name="idEmpleado" required>
                        <c:forEach var="empleado" items="${empleados}">
                            <option ${contratacion != null && contratacion.idEmpleado == empleado.idEmpleado ? 'selected' : ''} value="${empleado.idEmpleado}">${empleado.nombrePersona}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idCargo">Cargo</label>
                    <select class="form-control" id="idCargo" name="idCargo" required>
                        <c:forEach var="cargo" items="${cargos}">
                            <option ${contratacion != null && contratacion.idCargo == cargo.idCargo ? 'selected' : ''} value="${cargo.idCargo}">${cargo.cargo}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idTipoContratacion">Tipo de Contratación</label>
                    <select class="form-control" id="idTipoContratacion" name="idTipoContratacion" required>
                        <c:forEach var="tipoContratacion" items="${tiposContratacion}">
                            <option ${contratacion != null && contratacion.idTipoContratacion == tipoContratacion.idTipoContratacion ? 'selected' : ''} value="${tipoContratacion.idTipoContratacion}">${tipoContratacion.tipoContratacion}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="fechaContratacion">Fecha de Contratación</label>
                    <input type="date" class="form-control" id="fechaContratacion" name="fechaContratacion"
                           value="${contratacion != null ? contratacion.fechaContratacion : ''}" required>
                    <span id="fechaError" class="error"></span>
                </div>
                <div class="form-group">
                    <label for="salario">Salario</label>
                    <input type="number" class="form-control" id="salario" name="salario"
                           value="${contratacion != null ? contratacion.salario : ''}" required>
                    <span id="salarioError" class="error"></span>
                </div>
                <div class="form-group">
                    <label for="estado">Estado</label>
                    <select class="form-control" id="estado" name="estado" required>
                        <option value="true" ${contratacion != null && contratacion.estado ? 'selected' : ''}>Activo
                        </option>
                        <option value="false" ${contratacion != null && !contratacion.estado ? 'selected' : ''}>
                            Inactivo
                        </option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </form>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert">
                No hay suficientes datos para crear una contratación.
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script>
    const form = document.getElementById('contratacionForm');
    const fechaContratacion = document.getElementById('fechaContratacion');
    const salario = document.getElementById('salario');

    const fechaError = document.getElementById('fechaError');
    const salarioError = document.getElementById('salarioError');

    form.addEventListener('submit', function (event) {
        let valid = true;

        // Validar fecha de contratación
        const today = new Date().toISOString().split('T')[0]; // Fecha actual en formato YYYY-MM-DD
        if (fechaContratacion.value > today) {
            fechaError.textContent = "La fecha de contratación no puede ser mayor que la fecha actual.";
            valid = false;
        } else {
            fechaError.textContent = "";
        }

        // Validar salario
        if (salario.value === '' || salario.value <= 0) {
            salarioError.textContent = "El salario no puede estar vacío, ser 0 o negativo.";
            valid = false;
        } else {
            salarioError.textContent = "";
        }

        // Prevenir envío si hay errores
        if (!valid) {
            event.preventDefault();
        }
    });

    // Validaciones instantáneas
    fechaContratacion.addEventListener('input', function () {
        const today = new Date().toISOString().split('T')[0];
        if (fechaContratacion.value > today) {
            fechaError.textContent = "La fecha de contratación no puede ser mayor que la fecha actual.";
        } else {
            fechaError.textContent = "";
        }
    });

    salario.addEventListener('input', function () {
        if (salario.value === '' || salario.value <= 0) {
            salarioError.textContent = "El salario no puede estar vacío, ser 0 o negativo.";
        } else {
            salarioError.textContent = "";
        }
    });
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
