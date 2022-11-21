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
        <jsp:include page="../../WEB-INF/estructura/sidebar.jsp"/>
        <!-- fin sidebar -->
        
        <!-- content -->
        <div id="content">
            <!-- nav -->
            <jsp:include page="../../WEB-INF/estructura/nav.jsp"/>
            <!-- fin nav -->
            
            <div class="container-fluid">
                
            <div class="form-horizontal">
            <h4 class="text-center">Añadir Administrador</h4>
            <hr />

            <form action="${pageContext.request.contextPath}/AdministradorControlador?usuarios=crear" method="post" class="was-validated" >
            <div class="form-group">
                <label for="nombre" class="control-label col-md-2">Nombres: </label>
                <div class="col-md-4">
                    <input type="text" name="nombre" id="nombre" class="form-control" minlength="3" maxlength="30" required onkeypress="validarAdministrador(this, 'Nombre Administrador', 'alerta_nombre', 5)">
                    <p class="campos_alerta" id="alerta_nombre">
                </div>

                <label for="apellido" class="control-label col-md-1">Apellidos: </label>
                <div class="col-md-4">
                    <input type="text" name="apellido" id="apellido" class="form-control" minlength="3" maxlength="30" required onkeypress="validarAdministrador(this, 'Apellido Administrador', 'alerta_apellido', 5)">
                    <p class="campos_alerta" id="alerta_apellido">
                </div>
            </div>

            <div class="form-group cont-agg-login">
                <div class="form-group">
                    <label for="correo" class="control-label col-md-2">Correo electrónico: </label>
                    <div class="col-md-5">
                        <input type="email" name="correo" id="correo" class="form-control" minlength="5" required onkeypress="validarCorreo()">
                        <p class="campos_alerta" id="alertaCorreo">
                    </div>
                </div>

                <div class="form-group">
                    <label for="password_admin" class="control-label col-md-2">Contraseña: </label>
                    <div class="col-md-4">
                        <input type="password" name="password_admin" id="password_admin" class="form-control" minlength="6" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password_admin_rep" class="control-label col-md-2">Repita su contraseña: </label>
                    <div class="col-md-4">
                        <input type="password" name="password_admin_rep" class="form-control" id="password_admin_rep" minlength="6" required onkeyup="validarcontrasenia()" >
                        <p class="campos_alerta" id="alertacontrasenia">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="estado" class="control-label col-md-2">Estado del administrador y login: </label>
                <div class="col-md-10 config-select">
                    <select name="estado" class="form-control" required>
                        <option value="">-- Selecciona un estado --</option>
                        <option value="A">Activo</option>
                        <option value="I">Inactivo</option>
                    </select>
                </div>
            </div>

            <%-- Inputs hidden para nutrir la informacion de la bitacora --%>
            <input type="hidden" name="tipo_registro" value="I">
            <input type="hidden" name="accion" value="inserto">
            <input type="hidden" name="nombre_tabla" value="administrador">

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10 text-right">
                    <input type="submit" value="Añadir nuevo administrador" id="envio" class="btn btn-default" />
                </div>
            </div>
            </div>
            
            </form>

            <div class="text-center">
            <a href="listadoUsuarios.jsp">Volver a listar todo los administradores</a>
            </div>
                
            </div> <!--  fin contenido pantalla -->
        </div> <!-- fin content -->
        
    </div>
            
    <script src="../../assets/js/index.js" type="text/javascript"></script>
</body>
</html>
