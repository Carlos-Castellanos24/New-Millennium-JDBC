<%-- validar sesion --%>
<%@include file="/WEB-INF/estructura/validarSesion.jsp" %>
<%-- fin validar sesion --%>

<%-- Usamos la directiva: --%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%-- Usamos la directiva: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // Formateamos la feca actual para poder usarla como minumo para los input date
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fechaMinima = dateFormat.format(Calendar.getInstance().getTime());    
%>

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
                <form action="${pageContext.request.contextPath}/AdministradorControlador?actividades=crear" method="post" class="was-validated">
                    
                    <div class="form-horizontal">
                        <h4 class="text-center">Añadir actividad</h4>
                        <hr />

                        <div class="form-group">
                            <label for="id_categoria" class="control-label col-md-2">Categoría: </label>
                            <div class="col-md-4">
                                <select name="id_categoria" id="id_categoria" class="form-control" required>
                                    <c:forEach var="categoria" items="${categorias}">
                                        <option value="${categoria.idCategoria}">${categoria.nombreCategoria}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <label for="id_facilitador" class="control-label col-md-2">Facilitadores: </label>
                            <div class="col-md-4">
                                <select name="id_facilitador" id="id_facilitador" class="form-control" required>
                                    <c:forEach var="facilitador" items="${facilitadores}">
                                        <option value="${facilitador.idFacilitador}">${facilitador.nombreFacilitador}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    <div class="form-group">
                        <label for="nombre_actividad" class="control-label col-md-2">Actividad: </label>
                        <div class="col-md-10">
                            <input type="text" name="nombre_actividad" class="form-control" minlength="5" maxlength="30" onkeypress="validarActividad(this,'Nombre actividad', 'alerta_nombre', 5)" required>
                            <p class="campos_alerta" id="alerta_nombre">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label for="fecha_inicio" class="control-label col-md-2">Inicio: </label>
                        <div class="col-md-2">
                            <input type="date" name="fecha_inicio" class="form-control" min="<%= fechaMinima %>" required>
                        </div>

                        <label for="fecha_final" class="control-label col-md-1">Fin: </label>
                        <div class="col-md-2">
                            <input type="date" name="fecha_final" class="form-control" min="<%= fechaMinima %>" required>
                        </div>

                        <label for="dias" class="control-label col-md-2">Días: </label>
                        <div class="col-md-3">
                            <input type="text" name="dias" class="form-control" placeholder = "Lunes - Miercoles" minlength="5" onkeypress="validarActividad(this,'Dias', 'alerta_dias', 10)" required>
                            <p class="campos_alerta" id="alerta_dias">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label for="horario" class="control-label col-md-2">Horario: </label>
                        <div class="col-md-2">
                            <input type="text" name="horario" class="form-control" minlength="5" placeholder = "00:00 - 00:00" onkeypress="validarActividad(this,'Horas', 'alerta_horas', 10)" required>
                            <p class="campos_alerta" id="alerta_horas">
                        </div>

                        <label for="estado_actividad" class="control-label col-md-1">Estado: </label>
                        <div class="col-md-7 config-select">
                            <select name="estado_actividad" id="estado_actividad" class="form-control" required style="width: 100%;">
                                <option value="">-- Selecciona un estado --</option>
                                <option value="A">Activo</option>
                                <option value="I">Inactivo</option>
                            </select>
                        </div>
                        
                    </div>
                     
                    <div class="form-group">
                        <label for="descripcion" class="control-label col-md-2">Descripción: </label>
                        <div class="col-md-10 config-textarea">
                            <textarea name="descripcion" id="descripcion" class="form-control" minlength="5" onkeypress="validarActividad(this, 'Descripcion', 'alerta_descripcion', 10)" required></textarea>
                            <p class="campos_alerta" id="alerta_descripcion">
                        </div>
                    </div>
                       
                    <%-- Inputs hidden para nutrir la informacion de la bitacora --%>
                    <input type="hidden" name="tipo_registro" value="I">
                    <input type="hidden" name="accion" value="inserto">
                    <input type="hidden" name="nombre_tabla" value="actividad">
                    
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10 text-right">
                            <input type="submit" value="Añadir nueva actividad" class="btn btn-default" id="envio" />
                        </div>
                    </div>

                    </div>
                </form>

                
                <div class="text-center btn-details">
                    <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=3">Volver a listar todas las actividades</a>
                </div>
            </div> <!--  fin contenido pantalla -->
        </div> <!-- fin content -->
        
    </div>
</body>
</html>
