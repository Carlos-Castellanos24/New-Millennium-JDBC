<%-- validar sesion --%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
<%-- fin validar sesion --%>
   
<%-- Usamos la directiva: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <h4 class="text-center">Información relacionada con la bitacora</h4>
                
                <table class="table">
                    <tr>
                        <th></th>
                        <th>Tipo</th>
                        <th>Fecha y hora</th>
                        <th>Informacion</th>
                    </tr>

                    <%-- Iteramos cada elemento de la lista de clientes --%>
                    <c:forEach var="bitacora" items="${bitacoras}">
                        <tr>
                            <td>${bitacora.idRegistro}</td>
                            <td>
                                <%-- Utilizamos JSTL Core (Jsp Standard Tag Library) --%>
                                <%-- Condicionado, uso de switch  --%>
                                <c:if test="${bitacora.tipoRegistro != null}">
                                    <c:choose>
                                        <c:when test="${bitacora.tipoRegistro == 'I'}">
                                            Insert
                                        </c:when>

                                        <c:when test="${bitacora.tipoRegistro == 'U'}">
                                            Update
                                        </c:when>    

                                        <c:when test="${bitacora.tipoRegistro == 'D'}">
                                            Delete
                                        </c:when>

                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </td>
                            <td>${bitacora.fechaRegistro}</td>
                            <td>${bitacora.descripcionRegistro}</td>
                        </tr>
                    </c:forEach>
                </table>

                <!-- /.contenido pantalla -->
            </div>
        </div>
        <!-- fincontent -->
    </div>
</body>
</html>
