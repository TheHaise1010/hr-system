<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">HR System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownEmpleados" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Empleados
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownEmpleados">
                    <a class="dropdown-item" href="empleado?action=list">Ver Empleados</a>
                    <a class="dropdown-item" href="empleado?action=showCreateForm">Crear Empleado</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownDepartamentos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Departamentos
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownDepartamentos">
                    <a class="dropdown-item" href="departamento?action=list">Ver Departamentos</a>
                    <a class="dropdown-item" href="departamento?action=showCreateForm">Crear Departamento</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownContrataciones" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Contrataciones
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownContrataciones">
                    <a class="dropdown-item" href="contrataciones?action=list">Ver Contrataciones</a>
                    <a class="dropdown-item" href="contrataciones?action=showCreateForm">Crear Contratacion</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCargos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Cargos
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownCargos">
                    <a class="dropdown-item" href="cargos?action=list">Ver Cargos</a>
                    <a class="dropdown-item" href="cargos?action=showCreateForm">Crear Cargo</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownTiposContratacion" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Tipos de Contratacion
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownTiposContratacion">
                    <a class="dropdown-item" href="tiposcontratacion?action=list">Ver Tipos de Contratacion</a>
                    <a class="dropdown-item" href="tiposcontratacion?action=showCreateForm">Crear Tipo de Contratacion</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<style>
    .dropdown:hover .dropdown-menu {
        display: block;
    }
</style>