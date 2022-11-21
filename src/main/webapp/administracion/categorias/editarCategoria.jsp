<%-- 
    Document   : editarCategoria
    Created on : 28 oct. 2022, 16:21:44
    Author     : rolle
--%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
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
                <form action="${pageContext.request.contextPath}/AdministradorControlador?categorias=modificar&idCategoria=${categoria.idCategoria}" method="post" class="was-validated">
                    <div class="form-horizontal">
                        <h4 class="text-center">Editar categoría</h4>
                        <hr />                        
                        <div class="form-group">
                            <label for="nombre_categoria" class="control-label col-md-2">Nombre de la categoría: </label>
                            <div class="col-md-4">
                                <input type="text" name="nombre_categoria" class="form-control" minlength="5" value="${categoria.nombreCategoria}" onkeypress="validarCategoria(this, 'Nombre editar', 'alerta_nombreEditar', 10)" required>
                                <p class="campos_alerta" id="alerta_nombreEditar"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion" class="control-label col-md-2">Descripción de la categoría: </label>
                            <div class="col-md-8 config-textarea">
                                <textarea name="descripcion" class="form-control" onkeypress="validarCategoria(this, 'Estudio Editar', 'alerta_descripEdit', 15)" required>${categoria.descripcion}</textarea>
                                <p class="campos_alerta" id="alerta_descripEdit"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="estado_categoria" class="control-label col-md-2">Estado de la categoría: </label>
                            <div class="col-md-9 config-select">
                                <select name="estado_categoria" id="estado_actividad" class="form-control" required style="width: 100%;">                                
                                <c:if test="${categoria.estadoCategoria != null}">
                                    <c:choose>
                                        <c:when test="${categoria.estadoCategoria == 'A'}">
                                            <option value="A" selected>Activo</option>
                                            <option value="I">Inactivo</option>
                                        </c:when>

                                        <c:when test="${categoria.estadoCategoria == 'I'}">
                                            <option value="A">Activo</option>
                                            <option value="I" selected>Inactivo</option>
                                        </c:when>    

                                        <c:otherwise>
                                            <option value="">-- Selecciona un estado --</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </select>
                            </div>
                        </div>
                        <%-- Inputs hidden para nutrir la informacion de la bitacora --%>
                        <input type="hidden" name="tipo_registro" value="U">
                        <input type="hidden" name="accion" value="actualizo">
                        <input type="hidden" name="nombre_tabla" value="categoria">
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-10 text-right">
                                <input type="submit" value="Actualizar cambios" class="btn btn-default" />
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="text-center">
                <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=4">Volver a listar todas las categorias</a>
            </div>

            </div>
        </div>

    </body>
</html>
