
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">HR System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/empleados">Empleados</a>            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/views/departamento/list-departamentos.jsp">Departamentos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/views/contratacion/list-contrataciones.jsp">Contrataciones</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/views/cargo/list-cargos.jsp">Cargos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/views/tipoContratacion/list-tipoContrataciones.jsp">Tipos de Contratacion</a>
            </li>
        </ul>
    </div>
</nav>
