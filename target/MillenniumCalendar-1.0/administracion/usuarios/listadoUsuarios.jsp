<%-- validar sesion --%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
<%-- fin validar sesion --%>

<%-- Usamos la directiva: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <%-- meta --%>
    <jsp:include page="../../WEB-INF/estructura/meta_admin.jsp"/>
    <%-- fin meta --%>
<body>
    
    <div id="viewport">

        <!-- sidebar -->
        <jsp:include page="../../WEB-INF/estructura/sidebar.jsp"/>
        <!-- fin sidebar -->
        
        <!-- content -->
        <div id="content">
            <!-- nav -->
            <jsp:include page="../../WEB-INF/estructura/nav.jsp"/>
            <!-- fin nav -->
            
            <div class="container-fluid">
                <!-- Contenido pantalla -->
                <p class="cont-btn-add">
                    <a href="${pageContext.request.contextPath}/administracion/usuarios/crearUsuarios.jsp" class="btn-add">Añadir administrador</a><br />
                </p>
                <table class="table">
                    <tr>
                        <th></th>
                        <th>Nombre Completo</th>
                        <th>Email - Login</th>
                        <th>Estado</th>
                        <th></th>
                    </tr>

                    <c:forEach var="administrador" items="${administradores}">
                        <tr>
                            <td>${administrador.idAdministrador}</td>
                            <td>${administrador.nombreAdministrador} ${administrador.apellidoAdministrador}</td>
                            <td>${administrador.correoLogin}</td>
                            <td>
                                <%-- Utilizamos JSTL Core (Jsp Standard Tag Library) --%>
                                <%-- Condicionado, uso de switch  --%>
                                <c:if test="${administrador.estadoLogin != null}">
                                    <c:choose>
                                        <c:when test="${administrador.estadoLogin == 'A'}">
                                            Activo
                                        </c:when>

                                        <c:when test="${administrador.estadoLogin == 'I'}">
                                            Inactivo
                                        </c:when>    

                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </td>
                            <td class="config-controles">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?administradores=informacionEditar&idAdministrador=${administrador.idAdministrador}"><i class="fas fa-edit"></i> Editar</a> <br />
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?administradores=informacionEliminar&idAdministrador=${administrador.idAdministrador}&nombre=${administrador.nombreAdministrador} ${administrador.apellidoAdministrador}"><i class="fas fa-trash-alt"></i> Eliminar</a>
                            </td>
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
