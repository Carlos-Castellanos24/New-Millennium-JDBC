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
                    <a href="${pageContext.request.contextPath}/AdministradorControlador?actividades=desplegar" class="btn-add">Añadir una nueva actividad</a><br />
                </p>

                <table class="table">
                    <tr>
                        <th>Categoría</th>
                        <th>Facilitador</th>
                        <th>Actividad</th>
                        <th>Inicio / Fin</th>
                        <th>Días</th>
                        <th>Estado</th>
                        <th></th>
                    </tr>
                    <c:forEach var="actividad" items="${actividades}">
                        <tr>
                            <td>${actividad.nombreCategoria}</td>
                            <td>${actividad.nombreFacilitador}</td>
                            <td>${actividad.nombreActividad}</td>
                            <td>${actividad.fechaInicio} - ${actividad.fechaFinal}</td>
                            <td>${actividad.diasSemana}</td>
                            <td>
                                <%-- Utilizamos JSTL Core (Jsp Standard Tag Library) --%>
                                <%-- Condicionado, uso de switch  --%>
                                <c:if test="${actividad.estadoActividad != null}">
                                    <c:choose>
                                        <c:when test="${actividad.estadoActividad == 'A'}">
                                            Activo
                                        </c:when>

                                        <c:when test="${actividad.estadoActividad == 'I'}">
                                            Inactivo
                                        </c:when>    

                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </td>
                            <td class="config-controles">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?actividades=informacionEditar&idActividad=${actividad.idActividad}"><i class="fas fa-edit"></i> Editar</a> <br />
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?actividades=informacionDetalles&idActividad=${actividad.idActividad}"><i class="fas fa-plus-circle"></i> Detalles</a> <br />
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?actividades=informacionEliminar&idActividad=${actividad.idActividad}&nombreActividad=${actividad.nombreActividad}"><i class="fas fa-trash-alt"></i> Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div> <!-- fin contenido pantalla -->
        </div> <!-- fin content -->
    </div>
</body>
</html>
