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
    <h2 class="titulo">Nuestras Categorías</h2>
    <hr class="separador" />

    <!-- Contenedor para categorias -->
    <div class="contenedor-categoria">
        
        <%-- Iteramos cada elemento de la lista de categorias --%>
        <c:forEach var="categoria" items="${categorias}">
            <!-- Contenedor para una categoria -->
            <div class="categorias">
                <div class="centrar-imagen">
                    <img src="assets/img/categoria.jpg" alt="imagen_categoria" />
                </div>

                <h3>${categoria.nombreCategoria}</h3>
                <p>${categoria.descripcion}</p>
            </div>
        </c:forEach>
    </div>
    <!-- fin contenido pagina -->

    <!-- footer -->
    <jsp:include page="WEB-INF/estructura/footer.jsp"/>
    <!-- fin footer -->
</body>
</html>