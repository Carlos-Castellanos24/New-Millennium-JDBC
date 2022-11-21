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
                    <a href="${pageContext.request.contextPath}/administracion/categorias/crearCategorias.jsp">Añadir categoría</a><br />
                </p>
                <table class="table">
                    <tr>
                        <th></th>
                        <th>Categoría</th>
                        <th>Descripción</th>
                        <th>Estado</th>
                        <th></th>
                    </tr>
                    
                    <%-- Iteramos cada elemento de la lista de clientes --%>
                    <c:forEach var="categoria" items="${categorias}">
                        <tr>
                            <td>${categoria.idCategoria}</td>
                            <td>${categoria.nombreCategoria}</td>
                            <td>${categoria.descripcion}</td>
                            <td>
                                <%-- Utilizamos JSTL Core (Jsp Standard Tag Library) --%>
                                <%-- Condicionado, uso de switch  --%>
                                <c:if test="${categoria.estadoCategoria != null}">
                                    <c:choose>
                                        <c:when test="${categoria.estadoCategoria == 'A'}">
                                            Activo
                                        </c:when>

                                        <c:when test="${categoria.estadoCategoria == 'I'}">
                                            Inactivo
                                        </c:when>    

                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </td>
                            
                            <td class="config-controles">
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?categorias=informacionEditar&idCategoria=${categoria.idCategoria}"><i class="fas fa-edit"></i> Editar</a> <br />
                                <a href="${pageContext.request.contextPath}/AdministradorControlador?categorias=informacionEliminar&idCategoria=${categoria.idCategoria}&nombreCategoria=${categoria.nombreCategoria}"><i class="fas fa-trash-alt"></i> Eliminar</a> <br />
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
