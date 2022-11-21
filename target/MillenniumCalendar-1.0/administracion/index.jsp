<%-- validar sesion --%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
<%-- fin validar sesion --%>

<!DOCTYPE html>
<html>
    <%-- meta --%>
    <head>
        <meta name="viewport" content="width=device-width" />
        <title>Administración - MillenniumCalendar</title>
        <!-- Estilos personalizados -->
        <link href="../assets/css/styles_administracion.css" rel="stylesheet" type="text/css"/>

        <!-- Estilos externos -->
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css' />
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css' />

        <!-- Kits de iconos -->
        <script src="https://kit.fontawesome.com/d21a3be417.js"></script>
    </head>
    <%-- fin meta --%>
    <body>

        <div id="viewport">

            <!-- sidebar -->
            <div id="sidebar">
                <header>
                    <img class="logo-sidebar" src="../assets/img/new-millenium-logo.png" />
                </header>
                <ul class="nav">
                    <li><a href="${pageContext.request.contextPath}/AdministradorControlador?pag=1"><i class="fas fa-home"></i>Inicio</a></li>
                    <li><a href="${pageContext.request.contextPath}/AdministradorControlador?pag=2"><i class="fas fa-user-shield"></i>Usuarios</a></li>
                    <li><a href="${pageContext.request.contextPath}/AdministradorControlador?pag=3"><i class="fas fa-paperclip"></i>Actividades</a></li>
                    <li><a href="${pageContext.request.contextPath}/AdministradorControlador?pag=4"><i class="fas fa-cogs"></i>Categorías</a></li>
                    <li><a href="${pageContext.request.contextPath}/AdministradorControlador?pag=5"><i class="fas fa-chalkboard-teacher"></i>Facilitadores</a></li>
                    <li><a href="${pageContext.request.contextPath}/AdministradorControlador?pag=6"><i class="fas fa-info-circle"></i>Bitácora</a></li>
                </ul>
            </div>
            <!-- fin sidebar -->

            <!-- content -->
            <div id="content">
                <!-- nav -->
                <jsp:include page="../WEB-INF/estructura/nav.jsp"/>
                <!-- fin nav -->

                <div class="container-fluid">
                    <!-- Contenido pantalla -->

                    <!-- Contenedor para el administrador -->
                    <div class="contenido-administrador">
                        <!-- Mensaje de bienvenida -->

                        <h1>¡Hola <%= session.getAttribute("nombreAdministrador") %>!</h1>
                        <p>Administra los datos para el calendario de New Millennium</p>

                        <!-- Contenedor para las cajas de enlaces -->
                        <div class="inicio-items">
                            <!-- Caja de enlace para usuarios -->
                            <div class="inicio-item item-1">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=2" class="enlace-item">
                                    <div class="icono-item"><i class="fas fa-user-shield"></i></div>
                                    <div class="texto-item">Usuarios</div>
                                </a>
                            </div>

                            <!-- Caja de enlace para actividades -->
                            <div class="inicio-item item-2">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=3" class="enlace-item">
                                    <div class="icono-item"><i class="fas fa-paperclip"></i></div>
                                    <div class="texto-item">Actividades</div>
                                </a>
                            </div>

                            <!-- Caja de enlace para categorias -->
                            <div class="inicio-item item-3">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=4" class="enlace-item">
                                    <div class="icono-item"><i class="fas fa-cogs"></i></div>
                                    <div class="texto-item">Categorías</div>
                                </a>
                            </div>

                            <!-- Caja de enlace para facilitadores -->
                            <div class="inicio-item item-4">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=5" class="enlace-item">
                                    <div class="icono-item"><i class="fas fa-chalkboard-teacher"></i></div>
                                    <div class="texto-item">Facilitadores</div>
                                </a>
                            </div>
                        </div>
                    </div>

                    <!-- fin contenido pantalla -->
                </div>
            </div>
            <!-- fincontent -->
        </div>
    </body>
</html>
