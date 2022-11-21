<%-- validar sesion --%>
<%
    // Recuperamos el objeto http session
    HttpSession sesionLogin = request.getSession();

    // Validamos que exista la sesion
    Integer idAdministradorSesion = (Integer) sesionLogin.getAttribute("idAdministrador");

    /*
        Puede utilizar las sesiones con la varibale de la siguiente forma:

        String nombreAdministradorSesion = (String) session.getAttribute("nombreAdministrador");
        String apellidoAdministradorSesion = (String) session.getAttribute("apellidoAdministrador");
        String correoLoginSesion = (String) session.getAttribute("correoLogin");
     */

    if (idAdministradorSesion == null)
    {
        // La sesion no existe, los enviamos al inicio
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
<%-- fin validar sesion --%>