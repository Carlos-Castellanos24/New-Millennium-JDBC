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
    <div class="contenedor-oscuro">

        <!-- Contenedor para el Log in -->
        <form action="${pageContext.request.contextPath}/PublicoControlador?login=iniciar" method="post">
            <div class="login">
                <!-- Contenedor para el input de email y la alerta si lo requiere -->
                <div class="login-item">
                    <input type="email" name="correo" class="form-control txt-login" placeholder="correo electr�nico" required>
                </div>

                <!-- Contenedor para el input de contrase�a con TextMode="Password" y la alerta si lo requiere -->
                <div class="login-item">
                    <input type="password" name="pw" class="form-control txt-login" minlength="6" placeholder = "contrase�a" required>
                </div>
                
                <!-- Contenedor para el botor para iniciar sesi�n con el evento OnClick -->
                <div class="login-item">
                    <input type="submit" value="Iniciar sesi�n" class="btn-login" />
                </div>
                
            </div>
        </form>

    </div>
    <!-- fin contenido pagina -->

    <!-- footer -->
    <jsp:include page="WEB-INF/estructura/footer.jsp"/>
    <!-- fin footer -->
</body>
</html>