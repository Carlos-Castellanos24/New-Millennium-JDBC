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
                <h4 class="text-center">Detalles acerca de la actividad</h4>
                <hr />
                <div class="cont-detalles">
                    <p><b>Identificador de la actividad:</b> ${actividad.idActividad}</p>
                    <p><b>Categoría:</b> ${actividad.nombreCategoria} - <b>Identificador de la Categoría:</b> ${actividad.idCategoria}</p>
                    <p><b>Facilitador:</b> ${actividad.nombreFacilitador} - <b>Identificador del Facilitador:</b> ${actividad.idFacilitador}</p>
                    <p><b>Actividad:</b> ${actividad.nombreActividad}</p>
                    <p><b>Fecha de inicio:</b> ${actividad.fechaInicio}</p>
                    <p><b>Fecha a culminar:</b> ${actividad.fechaFinal}</p>
                    <p><b>Días a impartir:</b> ${actividad.diasSemana}</p>
                    <p><b>Horario:</b> ${actividad.horasDias}</p>
                    <p><b>Descripción:</b> ${actividad.descripcion}</p>
                    <p><b>Estado de la actividad:</b> 
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
                    </p>

                    <p class="cont-aditoria"><b>Agregado por:</b> Puede ver el registro en la bitacora, busquelo bajo el nombre: <b>${actividad.nombreActividad}</b></p>
                    <p><b>Actualizado por:</b> Puede ver el registro en la bitacora, busquelo bajo el nombre: <b>${actividad.nombreActividad}</b></p>
                </div>
                
                <div class="text-center btn-details">
                    <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=3">Volver a listar todas las actividades</a>
                </div>
            </div> <!--  fin contenido pantalla -->
        </div> <!-- fin content -->
        
    </div>
</body>
</html>
