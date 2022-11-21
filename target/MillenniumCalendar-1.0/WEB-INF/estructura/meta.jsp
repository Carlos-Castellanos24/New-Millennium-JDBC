<% 
    String nombreArchivoCompleto= request.getServletPath();
    String nombreArchivoExtension = nombreArchivoCompleto.substring(1);

    String[] nombreArchivoLimpio = nombreArchivoExtension.split(".j");
    String nombreFinal = nombreArchivoLimpio[0].toString();
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width" />
    <title><%= nombreFinal %> - MillenniumCalendar</title>

    <!-- Estilos personalizados -->
    <link href="${pageContext.request.contextPath}/assets/css/styles.css" rel="stylesheet" />
</head>