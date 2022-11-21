<%-- Usamos la directiva: --%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <%-- meta --%>
    <jsp:include page="WEB-INF/estructura/meta.jsp"/>
    <%-- fin meta --%>
<body>

    <!-- header -->
    <jsp:include page="WEB-INF/estructura/header.jsp"/>
    <!-- fin header -->
    
    <!-- contenido pagina -->
    <h2 class="titulo">Calendarización de actividades para que estés informado de New Millenium</h2>
    <hr class="separador" />
      
    <!-- contenedor para curso -->
    <%-- Iteramos cada elemento de la lista de clientes --%>
    <c:forEach var="actividad" items="${actividades}">
        <div class="curso">
            <article class="imagen-categoria">
                <div class="img-curso-contenedor">
                    <img class="img-curso" src="assets/img/curso-img.png" />
                </div>
                <p class="categoria">Categoría de la actividad: ${actividad.nombreCategoria}</p>
            </article>

            <article class="informacion-general">
                <p class="nombre-actividad">${actividad.nombreActividad}</p>

                <div class="informacion-facilitador">
                    <div class="img-facilitador-contenedor">
                        <img class="img-facilitador" src="assets/img/persona.png" /><span class="nombre-facilitador"><span class="formt-facilitador">${actividad.nombreFacilitador}</span></span>
                    </div>
                    
                    <%-- Configuramos la salida de fechas para el usuario --%>
                    <c:set var="fechaInicio" value="${actividad.fechaInicio}"/>
                    <c:set var="fechaFinal" value="${actividad.fechaFinal}"/>
                    <%
                        String fechaInicial = (String)pageContext.getAttribute("fechaInicio");
                        String fechaOut = (String)pageContext.getAttribute("fechaFinal");
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        
                        Date inicio = new Date();
                        Date fin = new Date();
                        
                        try {
                            inicio = format.parse(fechaInicial);
                            fin = format.parse(fechaOut);
                        }
                        catch (ParseException e) {
                            e.printStackTrace();
                        }
                    %>
                    <p>Fecha de inicio: <fmt:formatDate value="<%= inicio %>" type = "both" pattern = "EEEE',' dd 'de' MMMM 'del' yyyy" /></p>
                    <p>Fecha a finalizar: <fmt:formatDate value="<%= fin %>" type = "both" pattern = "EEEE',' dd 'de' MMMM 'del' yyyy" /></p>
                    <p>Días: ${actividad.diasSemana}<span class="duracion-actividad">Horario: ${actividad.horasDias}</span></p>
                    <p>Descripción: ${actividad.descripcion}</p>
                </div>

            </article>
        </div>
    </c:forEach>
    <!-- fin contenido pagina -->

    <!-- footer -->
    <jsp:include page="WEB-INF/estructura/footer.jsp"/>
    <!-- fin footer -->
</body>
</html>
