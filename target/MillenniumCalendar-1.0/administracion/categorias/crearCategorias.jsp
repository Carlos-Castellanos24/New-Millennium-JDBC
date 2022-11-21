<%-- 
    Document   : crearCategorias
    Created on : 28 oct. 2022, 01:36:06
    Author     : rolle
--%>

<%-- validar sesion --%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
<%-- fin validar sesion --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- meta --%>
    <jsp:include page="../../WEB-INF/estructura/meta_admin.jsp"/>
    <%-- fin meta --%>
    
    <body>
        <div id="viewport">
            <!-- sidebar -->
            <jsp:include page="../../WEB-INF/estructura/sidebar.jsp" />
            <!-- fin sidebar -->
            <!-- content -->
            <div id="content">
                <!-- nav -->
                <jsp:include page="../../WEB-INF/estructura/nav.jsp" /> 
                <!-- fin nav -->
                <div class="container-fluid">
                    <form action="${pageContext.request.contextPath}/AdministradorControlador?categorias=crear" method="post" class="was-validated">                    
                        <div class="form-horizontal">
                            <h4 class="text-center">Añadir categoría</h4>
                            <hr />
                            <!-- formulario -->
                            <div class="form-group">
                                <label for="nombre_categoria" class="control-label col-md-2">Nombre de la categoría: </label>
                                <div class="col-md-6">
                                    <input type="text" name="nombre_categoria" class="form-control" minlength="5" onkeypress="validarCategoria(this, 'Nombre categoria', 'alerta_nombre', 10)" required>
                                    <p class="campos_alerta" id="alerta_nombre"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="descripcion" class="control-label col-md-2">Descripción de la categoría: </label>
                                <div class="col-md-8 config-textarea">
                                    <textarea name="descripcion" class="form-control" required onkeypress="validarCategoria(this, 'Descripcion categoria', 'alerta_descrip', 15)"> </textarea>
                                    <p class="campos_alerta" id="alerta_descrip"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="estado_categoria" class="control-label col-md-2">Estado de la categoría: </label>
                                <div class="col-md-9 text-center config-select">
                                    <select name="estado_categoria" class="form-control" required>
                                        <option value="">-- Selecciona un estado --</option>
                                        <option value="A">Activo</option>
                                        <option value="I">Inactivo</option>
                                    </select>
                                </div>
                            </div>
                            <!-- fin formulario -->
                            <%-- Inputs hidden para nutrir la informacion de la bitacora --%>
                            <input type="hidden" name="tipo_registro" value="I">
                            <input type="hidden" name="accion" value="inserto">
                            <input type="hidden" name="nombre_tabla" value="categoria">

                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10 text-right">
                                    <input type="submit" value="Añadir nueva categoria" class="btn btn-default" />
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
