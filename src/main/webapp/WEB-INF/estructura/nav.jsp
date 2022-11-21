<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-right">
            <li><a><i class="fa fa-user-circle-o" aria-hidden="true"></i> <%= session.getAttribute("nombreAdministrador") %> <%= session.getAttribute("apellidoAdministrador") %> - <i class="fa fa-envelope-o" aria-hidden="true"></i> <b><%= session.getAttribute("correoLogin") %></b></a></li>
            <li class="cerrar-usuario"><a href="${pageContext.request.contextPath}/AdministradorControlador?login=salir"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a></li>
        </ul>
    </div>
</nav>