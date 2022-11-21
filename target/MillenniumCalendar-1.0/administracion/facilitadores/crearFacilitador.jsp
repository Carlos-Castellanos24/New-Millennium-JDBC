<%-- 
    Document   : crearFacilitador
    Created on : 29 oct 2022, 13:02:03
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- validar sesion --%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
<%-- fin validar sesion --%>

<!DOCTYPE html>
<html>
    <%-- meta --%>
    <jsp:include page="../../WEB-INF/estructura/meta_admin.jsp"/>
    <%-- fin meta --%>
    <head>
        <title>CREAR FACILITADOR</title>
    </head>
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
            <form action="${pageContext.request.contextPath}/AdministradorControlador?facilitadores=crear" method="post" class="was-validated">
                <div class="form-horizontal">
                    <h4 class="text-center">Añadir  facilitador</h4>
                    <hr />

                    <div class="form-group"> 
                        <label for="nombre_facilitador" class="control-label col-md-2">Nombre del facilitador: </label>
                        <div class="col-md-6">
                                <input type="text" name="nombre_facilitador" class="form-control" onkeypress="validarFacilitador(this, 'Nombre Facilitador', 'alerta_nombre', 10)" required>
                            <p class="campos_alerta" id="alerta_nombre"></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="estudio" class="control-label col-md-2">Estudios realizados: </label>
                        <div class="col-md-8 config-textarea">
                            <textarea name="estudio" class="form-control" onkeypress="validarFacilitador(this, 'Estudio Facilitador', 'alerta_estudio', 20)" required></textarea>
                            <p class="campos_alerta" id="alerta_estudio"></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="estado_facilitador" class="control-label col-md-2">Estado del facilitador: </label>
                        <div class="col-md-9 config-select">
                            <select name="estado_facilitador" class="form-control" required>
                                <option value="">-- Selecciona un estado --</option>
                                <option value="A">Activo</option>
                                <option value="I">Inactivo</option>
                            </select>
                        </div>
                    </div>

                    <%-- Inputs hidden para nutrir la informacion de la bitacora --%>
                    <input type="hidden" name="tipo_registro" value="I">
                    <input type="hidden" name="accion" value="inserto">
                    <input type="hidden" name="nombre_tabla" value="facilitador">

                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10 text-right">
                            <input type="submit" value="Añadir nuevo facilitador" class="btn btn-default" id="envio" />
                        </div>
                    </div>
                </div>

                <div class="text-center">
                    <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=5">Volver a listar todo los facilitadores</a>
                </div>
            </form>
            </div>
            </div>
        </div>
    </body>

</html>
