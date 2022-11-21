<%-- Usamos la directiva: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <!-- Contenedor de fondo oscuro -->
    <div class="contenedor-oscuro">

    <h2 class="titulo-ivt">Conoce a los formadores de New Millenium</h2>

        <!-- Contenedor para la informacion del facilitador -->
        <div class="formato-facilitador">
            <%-- Iteramos cada elemento de la lista de clientes --%>
            <c:forEach var="facilitador" items="${facilitadores}">
                <div class="facilitador">
                    <img src="assets/img/facilitador.jpg" alt="facilitador_imagen" />
                    <div class="desc-facilitador">
                    <h4>${facilitador.nombreFacilitador}</h4>
                    <p>${facilitador.estudio}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- fin contenido pagina -->

    <!-- footer -->
    <jsp:include page="WEB-INF/estructura/footer.jsp"/>
    <!-- fin footer -->
</body>
</html>