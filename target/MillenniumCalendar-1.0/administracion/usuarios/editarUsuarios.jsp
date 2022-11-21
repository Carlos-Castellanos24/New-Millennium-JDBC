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
             
            <div class="form-horizontal">
            <h4 class="text-center">Editar Administrador</h4>
            <hr />

            
            <form action="${pageContext.request.contextPath}/AdministradorControlador?usuarios=modificar&idAdministrador=${administrador.idAdministrador}&idLogin=${administrador.idLogin}" method="post" class="was-validated" >
                <div class="form-group">
                    <label for="nombre" class="control-label col-md-2">Nombres: </label>
                    <div class="col-md-4">
                        <input type="text" name="nombre" id="nombre" class="form-control" minlength="5" maxlength="30" required value="${administrador.nombreAdministrador}" required onkeypress="validarAdministrador(this, 'Nombre Administrador', 'alerta_nombre', 5)">
                        <p class="campos_alerta" id="alerta_nombre">
                    </div>

                    <label for="apellido" class="control-label col-md-1">Apellidos: </label>
                    <div class="col-md-4">
                        <input type="text" name="apellido" id="apellido" class="form-control" minlength="5" maxlength="30" required value="${administrador.apellidoAdministrador}" required onkeypress="validarAdministrador(this, 'Apellido Administrador', 'alerta_apellido', 5)">
                        <p class="campos_alerta" id="alerta_apellido">
                    </div>
                </div>

                <div class="form-group">
                    <label for="correo" class="control-label col-md-2">Correo electrónico: </label>
                    <div class="col-md-5">
                        <input type="email" name="correo" id="correo" class="form-control" minlength="5" required value="${administrador.correoLogin}" required onkeypress="validarCorreo()">
                        <p class="campos_alerta" id="alertaCorreo">
                    </div>
                </div>

                <div class="form-group">
                    <label for="estado" class="control-label col-md-2">Estado del administrador y login: </label>
                    <div class="col-md-10 config-select">
                        <select name="estado" id= "estado_administrador" class="form-control" required>
                            <option value="" selected>-- Selecciona un estado --</option>
                                <%-- Utilizamos JSTL Core (Jsp Standard Tag Library) --%>
                                <%-- Condicionado, uso de switch  --%>
                                <c:if test="${administrador.estadoAdministrador != null}">
                                    <c:choose>
                                        <c:when test="${administrador.estadoAdministrador == 'A'}">
                                            <option value="A" selected>Activo</option>
                                            <option value="I">Inactivo</option>
                                        </c:when>

                                        <c:when test="${administrador.estadoAdministrador == 'I'}">
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
                <input type="hidden" name="nombre_tabla" value="administrador">

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10 text-right">
                        <input type="submit" value="Actualizar cambios" class="btn btn-default" id="envio" />
                    </div>
                </div>
                </form>  
            </div>   
        <div class="text-center">
            <a href="listadoUsuarios.jsp">Volver a listar todo los administradores</a>
        </div>

    </div>
            
    <script src="../../assets/js/index.js" type="text/javascript"></script>
</body>
</html>
