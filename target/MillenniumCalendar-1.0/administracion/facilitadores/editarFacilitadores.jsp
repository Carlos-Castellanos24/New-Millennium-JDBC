<%-- 
    Document   : editarFacilitadores
    Created on : 29 oct 2022, 13:02:23
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <head>
        <title>EDITAR FACILITADORES</title>
    </head>
    <body>
        <div id="viewport">
            <!-- sidebar -->
            <jsp:include page="../../WEB-INF/estructura/sidebar.jsp"/>
            <!-- fin sidebar -->

            <div class="container-fluid"> 
                <!-- nav -->
                <jsp:include page="../../WEB-INF/estructura/nav.jsp"/>
                <!-- fin nav -->
                <form action="${pageContext.request.contextPath}/AdministradorControlador?facilitadores=modificar&idFacilitador=${facilitadores.idFacilitador}" method="post" class="was-validated">

                    <div class="form-horizontal">
                        <h4 class="text-center">Editar facilitador</h4>
                        <hr />

                        <div class="form-group">
                            <label for="nombre_facilitador" class="control-label col-md-2">Nombre del facilitador: </label>
                            <div class="col-md-6">
                                <input type="text" name="nombre_facilitador" class="form-control" onkeypress="validarFacilitador(this, 'Nombre Editar', 'alerta_nombreEditar', 10)" value="${facilitadores.nombreFacilitador}" required>
                                <p class="campos_alerta" id="alerta_nombreEditar"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="estudio" class="control-label col-md-2">Estudios realizados: </label>
                            <div class="col-md-8 config-textarea">
                                <textarea name="estudio" class="form-control" onkeypress="validarFacilitador(this, 'Estudio Editar', 'alerta_estudioEditar', 20)" required>${facilitadores.estudio}</textarea>
                                <p class="campos_alerta" id="alerta_estudioEditar"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="estado_facilitador" class="control-label col-md-2">Estado del facilitador: </label>
                            <div class="col-md-9 config-select">
                                
                            <select name="estado_facilitador" id="estado_facilitador" class="form-control" required>
                                <%-- Utilizamos JSTL Core (Jsp Standard Tag Library) --%>
                                <%-- Condicionado, uso de switch  --%>
                                <c:if test="${facilitadores.estadoFacilitador != null}">
                                    <c:choose>
                                        <c:when test="${facilitadores.estadoFacilitador == 'A'}">
                                            <option value="A" selected>Activo</option>
                                            <option value="I">Inactivo</option>
                                        </c:when>

                                        <c:when test="${facilitadores.estadoFacilitador == 'I'}">
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
                        <input type="hidden" name="nombre_tabla" value="facilitador">

                        <div class="form-group">
                            <div class="col-md-offset-1 col-md-10 text-right">
                                <input type="submit" value="Actualizar cambios" class="btn btn-default" id="envio" />
                            </div>
                        </div>
                    </div>

                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/AdministradorControlador?pag=5">Volver a listar todo los facilitadores</a>
                    </div>
            </div>

    </body>
</html>
