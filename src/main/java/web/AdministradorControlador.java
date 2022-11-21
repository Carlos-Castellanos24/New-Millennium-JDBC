package web;

import datos.*;
import dominios.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import utilidades.Hash;

@WebServlet("/AdministradorControlador")
public class AdministradorControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        /* Solicitamos el parametro de de la pag */
        String pag = request.getParameter("pag");
        String actividades = request.getParameter("actividades");
        String categorias = request.getParameter("categorias");
        String facilitadores = request.getParameter("facilitadores");
        String usuarios = request.getParameter("administradores");
        String login = request.getParameter("login");
        
        if (pag != null || actividades != null || facilitadores != null || categorias != null || usuarios != null || login != null)
        {
            if (pag != null)
            {
                switch(pag)
                {
                    /* Vista general de bienvenida */
                    case "1":
                        response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
                        break;

                    /* Listado de los usuarios */
                    case "2":
                        this.cargarUsuarios(request, response);
                        break; 

                    /* Listado de las actividades */
                    case "3":
                        this.cargarActividadesDetalles(request, response);
                        break; 

                    /* Listado de las categorias */
                    case "4":
                        this.cargarCategorias(request, response);
                        break; 

                    /* Listado de los facilitadores */
                    case "5":
                        this.cargarFacilitadores(request, response);
                        break; 

                    /* Listado general de la bitacora */
                    case "6":
                        this.cargarBitacora(request, response);
                        break; 

                    default:
                        response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
                }
            }
            /* fin parametro de pag */

            /* Acciones por get para actividades */
            if (actividades != null)
            {
                switch (actividades)
                {
                    case "desplegar":
                        this.cargarSelects(request, response);
                        break;
                    case "informacionEditar":
                        this.editarActividad(request, response);
                        break;
                    case "informacionDetalles":
                        this.cargarActividadesCompleto(request, response);
                        break;
                    case "informacionEliminar":
                        this.EliminarActividad(request, response);
                        break;
                    default:
                        response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
                }
            }
            /* fin Acciones por get para actividades */
            
            /* Acciones por get para categorias */
            if (categorias != null) {
                switch (categorias) {
                    case "informacionEditar":
                        this.editarCategoria(request, response);
                        break;
                    case "informacionEliminar":
                        this.EliminarCategoria(request, response);
                        break;
                    default:
                        response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
                }
            }
            /* fin Acciones por get para categorias */
            
            /* Acciones por get para facilitadores */
            if (facilitadores != null)
            {
                switch (facilitadores)
                {
                    case "informacionEditar":
                        this.editarFacilitador(request, response);
                        break;
                    case "informacionEliminar":
                        this.EliminarFacilitador(request, response);
                        break;
                    default:
                        this.cargarFacilitadores(request, response);
                }
            }
            /* fin Acciones por get para facilitadores */
            
            /* Acciones por get para usuarios */
            if (usuarios != null)
            {
                switch (usuarios)
                {
                    case "informacionEditar":
                        this.editarUsuarios(request, response);
                        break;
                    case "informacionEliminar":
                        this.EliminarUsuario(request, response);
                        break;
                    default:
                        response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
                }
            }
            /* fin Acciones por get para actividades */
            
            /* unica accion del login */
            if (login != null)
            {
                switch (login)
                {
                    case "salir":
                        this.salirLogin(request, response);
                        break;

                    default:
                        response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
                }
            }
            /* fin accion de login */
            
        } else
        {
            response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Acciones de actividades */
        String actividades = request.getParameter("actividades");
        if (actividades != null)
        {
            switch (actividades)
            {
                case "crear":
                    this.insertarActividad(request, response);
                    break;

                case "modificar":
                    this.modificarActividad(request, response);
                    break;
                    
                default:
                    this.cargarActividadesDetalles(request, response);
            }
        }
        /* fin acciones de actividades */
        
        /* Acciones de categorias */
        String categorias = request.getParameter("categorias");
        if (categorias != null) {
            switch (categorias) {
                case "crear":
                    this.insertarCategoria(request, response);
                    break;

                case "modificar":
                    this.modificarCategoria(request, response);
                    break;

                default:
                 this.cargarCategorias(request, response);
            }
        }
        /* fin acciones de categorias */
        
        /* Acciones de facilitadores */
        String facilitadores = request.getParameter("facilitadores");
        if (facilitadores != null)
        {
            switch (facilitadores)
            {
                case "crear":
                    this.insertarFacilitador(request, response);
                    break;

                case "modificar":
                    this.modificarFacilitador(request, response);
                    break;
                    
                default:
                    this.cargarFacilitadores(request, response);
            }
        }
        /* fin acciones de facilitadores */
        
        /* Acciones de usuarios */
        String usuarios = request.getParameter("usuarios");
        if (usuarios != null)
        {
            switch (usuarios)
            {
                case "crear":
                    this.insertarUsuarios(request, response);
                    break;

                case "modificar":
                    this.modificarUsuarios(request, response);
                    break;
                    
                default:
                    this.cargarUsuarios(request, response);
            }
        }
        /* fin acciones de usuarios */        
    }
    
    /* ----------------------------------------- */
    /* Metodos para las acciones de Actividades */
    /* Carga y lista a todos las actividades */
    private void cargarActividadesDetalles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Actividad> actividades = new ActividadDAO().ListarDetalles();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("actividades", actividades);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/actividades/listadoActividades.jsp");
    }

    /* Cargar las categorias y los facilitadores para insertar una actividad */
    private void cargarSelects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Facilitador> facilitadores = new FacilitadorDAO().Listar();
        List<Categoria> categorias = new CategoriaDAO().Listar();
        
        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("facilitadores", facilitadores);
        sesion.setAttribute("categorias", categorias);
        
        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/actividades/crearActividades.jsp");
    }
    
    /* Metodo para insertar una actividad */
    private void insertarActividad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));
        int idFacilitador = Integer.parseInt(request.getParameter("id_facilitador"));
        String nombreActividad = request.getParameter("nombre_actividad");
        String fechaInicio = request.getParameter("fecha_inicio");
        String fechaFinal = request.getParameter("fecha_final");
        String diasSemana = request.getParameter("dias");
        String horasDias = request.getParameter("horario");
        String descripcion = request.getParameter("descripcion");
        String estadoActividad = request.getParameter("estado_actividad");
        
        /* Creamos el objeto de cliente (modelo) */
        Actividad actividad = new Actividad(idCategoria, idFacilitador, nombreActividad, fechaInicio, fechaFinal, diasSemana, horasDias, descripcion, estadoActividad);
        
        /* Insertamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new ActividadDAO().insertar(actividad);
        
        /* Configuramos e insertamos a la bitacora */
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombreActividad);
        
        /* Insertar informacion en la tabla administrador_actividad */
        HttpSession sesionLogin = request.getSession();
        Integer idAdministradorSesion = (Integer) sesionLogin.getAttribute("idAdministrador");
        int ultimaActividad = new ActividadDAO().obtenerUltimaActividad();
        new ActividadDAO().insertarAdministradorActividad(idAdministradorSesion, ultimaActividad);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarActividadesDetalles(request, response);
        }

    }
    
    /* Cargamos los datos de la informacion que se editara */
    private void editarActividad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos el idActividad
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        List<Facilitador> facilitadores = new FacilitadorDAO().Listar();
        List<Categoria> categorias = new CategoriaDAO().Listar();
        
        Actividad actividad = new ActividadDAO().encontrar(new Actividad(idActividad));
        
        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("actividad", actividad);
        sesion.setAttribute("facilitadores", facilitadores);
        sesion.setAttribute("categorias", categorias);
        
        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/actividades/editarActividades.jsp");
    }
    
    /* Metodo para modificar una categoria */
    private void modificarActividad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));
        int idFacilitador = Integer.parseInt(request.getParameter("id_facilitador"));
        String nombreActividad = request.getParameter("nombre_actividad");
        String fechaInicio = request.getParameter("fecha_inicio");
        String fechaFinal = request.getParameter("fecha_final");
        String diasSemana = request.getParameter("dias");
        String horasDias = request.getParameter("horario");
        String descripcion = request.getParameter("descripcion");
        String estadoActividad = request.getParameter("estado_actividad");

        /* Creamos el objeto de cliente (modelo) */
        Actividad actividad = new Actividad(idActividad, idCategoria, idFacilitador, nombreActividad, fechaInicio, fechaFinal, diasSemana, horasDias, descripcion, estadoActividad);

        /* Modificamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new ActividadDAO().actualizar(actividad);
        
        /* Configuramos e insertamos a la bitacora */
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombreActividad);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarActividadesDetalles(request, response);
        }

    }
    
    /* Metodo para listar en la pagina de detalles */
    private void cargarActividadesCompleto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        
        /* Recupera los clientes y lo comparte */
        Actividad actividad = new ActividadDAO().detalles(new Actividad(idActividad));

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("actividad", actividad);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/actividades/detallesActividades.jsp");
    }
    
    /* Metodo para eliminar una actividad */
    private void EliminarActividad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /* Recuperamos los valores del formulario */
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        String nombreActividad = request.getParameter("nombreActividad");
        
        /* Creamos el objeto de cliente (modelo) */
        Actividad actividad = new Actividad(idActividad);

        /* Modificamos en la base de datos */
         /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new ActividadDAO().eliminar(actividad);

        /* Configuramos e insertamos a la bitacora */
        this.insertarBitacora(request, "D", "inhabilito", "actividad", nombreActividad);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarActividadesDetalles(request, response);
        }
    }
    /* Fin de metodos Actividades  */
    
    /* ----------------------------------------- */
    /* Metodos para las acciones de categorias */
    private void cargarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Categoria> categorias = new CategoriaDAO().listarCompleto();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("categorias", categorias);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/categorias/listadoCategorias.jsp");
    }

    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre_categoria = request.getParameter("nombre_categoria");
        String descripcion = request.getParameter("descripcion");
        String estado_categoria = request.getParameter("estado_categoria");
        Categoria categoria = new Categoria(nombre_categoria, descripcion, estado_categoria);

        int registroModificado = new CategoriaDAO().insertar(categoria);

        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombre_categoria);

        if (registroModificado > 0) {
            this.cargarCategorias(request, response);
        }
    }
  
    private void editarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));  
        
        Categoria categoria = new CategoriaDAO().encontrar(new Categoria(idCategoria));
        
        HttpSession sesion = request.getSession();

        sesion.setAttribute("categoria", categoria);
        
        response.sendRedirect(request.getContextPath() + "/administracion/categorias/editarCategoria.jsp");
    }

    private void modificarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String nombre_categoria = request.getParameter("nombre_categoria");
        String descripcion = request.getParameter("descripcion");
        String estado_categoria = request.getParameter("estado_categoria");

        Categoria categoria = new Categoria(idCategoria,nombre_categoria, descripcion, estado_categoria);
        int registroModificado = new CategoriaDAO().actualizar(categoria);
        
        
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombre_categoria);
       
        if (registroModificado > 0) {
            this.cargarCategorias(request, response);
        }

    }
    
    private void EliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String nombre_categoria = request.getParameter("nombreCategoria");
        
        Categoria categoria = new Categoria(idCategoria);
        
        int registroModificado = new CategoriaDAO().eliminar(categoria);

        /* Configuramos e insertamos a la bitacora */
        this.insertarBitacora(request, "D", "inhabilito", "actividad", nombre_categoria);

        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0) {
            this.cargarCategorias(request, response);
        } 
    }
    /* Fin de metodos categorias  */
    
    /* ----------------------------------------- */
    /* Metodos para las acciones de facilitadores */
    private void cargarFacilitadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Facilitador> facilitadores = new FacilitadorDAO().listarCompleto();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("facilitadores", facilitadores);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/facilitadores/listadoFacilitadores.jsp");
    }
    
    /* Metodo para insertar una facilitador */
    private void insertarFacilitador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        String nombreFacilitador = request.getParameter("nombre_facilitador");
        String estudio = request.getParameter("estudio");
        String estadoFacilitador = request.getParameter("estado_facilitador");
        
        /* Creamos el objeto de cliente (modelo) */
        Facilitador facilitador = new Facilitador(nombreFacilitador, estudio, estadoFacilitador);
        
        /* Insertamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new FacilitadorDAO().insertar(facilitador);
        
        /* Configuramos e insertamos a la bitacora */
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombreFacilitador);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarFacilitadores(request, response);
        }
        
    }
    
    /* Cargamos los datos de la informacion que se editara */
    private void editarFacilitador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos el idFacilitador
        int idFacilitador = Integer.parseInt(request.getParameter("idFacilitador"));
        
        /* Creamos el objeto de cliente (modelo) */
        Facilitador facilitadores = new FacilitadorDAO().encontrar(new Facilitador(idFacilitador));
        
        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("facilitadores", facilitadores);
        
        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/facilitadores/editarFacilitadores.jsp");
    }
    
    /* Metodo para modificar una categoria */
    private void modificarFacilitador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        int idFacilitador = Integer.parseInt(request.getParameter("idFacilitador"));
        
        String nombreFacilitador = request.getParameter("nombre_facilitador");
        String estudio = request.getParameter("estudio");
        String estadoFacilitador= request.getParameter("estado_facilitador");

        /* Creamos el objeto de cliente (modelo) */
        Facilitador facilitador = new Facilitador(idFacilitador, nombreFacilitador, estudio, estadoFacilitador);

        /* Modificamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new FacilitadorDAO().actualizar(facilitador);

        /* Configuramos e insertamos a la bitacora */
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");

        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombreFacilitador);

        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0) {
           this.cargarFacilitadores(request, response);
        }

    }
    
    /* Metodo para eliminar una actividad */
    private void EliminarFacilitador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Recuperamos los valores del formulario */
        int idFacilitador = Integer.parseInt(request.getParameter("idFacilitador"));
        String nombreFacilitador = request.getParameter("nombreFacilitador");

        /* Creamos el objeto de cliente (modelo) */
        Facilitador facilitador = new Facilitador(idFacilitador);

        /* Modificamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new FacilitadorDAO().eliminar(facilitador);

        /* Configuramos e insertamos a la bitacora */
        this.insertarBitacora(request, "D", "inhabilito", "facilitador", nombreFacilitador);

        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0) {
            this.cargarFacilitadores(request, response);
        }
    }
    /* Fin de metodos facilitadores  */
    
    /* ----------------------------------------- */
    /* Metodos para las acciones de usuarios */
    private void cargarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Administrador> administradores = new AdministradorDAO().Listar();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("administradores", administradores);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/usuarios/listadoUsuarios.jsp");
    }
    
    /* Metodo para insertar un usuario */
    private void insertarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        String nombreAdministrador = request.getParameter("nombre");
        String apellidoAdministrador = request.getParameter("apellido");
        String correoAdministrador = request.getParameter("correo");
        String pwAdministrador = request.getParameter("password_admin");
        String estadoAdministrador = request.getParameter("estado");
        String claveCifrada = Hash.md5(pwAdministrador);
        
        /* Creamos el objeto de administrador */
        Administrador administrador = new Administrador(nombreAdministrador, apellidoAdministrador, estadoAdministrador);
        
        /* Insertamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new AdministradorDAO().insertarAdministrador(administrador);
        
        int ultimoAdministrador = new AdministradorDAO().obtenerUltimoAdmin();
        
        Administrador login = new Administrador(ultimoAdministrador, correoAdministrador,claveCifrada, estadoAdministrador);
        
        new AdministradorDAO().insertarLogin(login);
        
        /* Configuramos e insertamos a la bitacora */
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombreAdministrador + " " + apellidoAdministrador);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarUsuarios(request, response);
        }

    }
    
    public void editarUsuarios(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //recuperamos el idAdministrador
        int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
        
        Administrador usuario = new AdministradorDAO().encontrar(new Administrador(idAdministrador));
        
        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("administrador",usuario);
        
        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/usuarios/editarUsuarios.jsp");
    }
    
    public void modificarUsuarios(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        /* Recuperamos los valores del formulario */
        int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
        int idLogin = Integer.parseInt(request.getParameter("idLogin"));
        String nombreAdministrador = request.getParameter("nombre");
        String apellidoAdministrador = request.getParameter("apellido");
        String correoLogin = request.getParameter("correo");
        String estadoAdministrador = request.getParameter("estado");
        
        /* Creamos el objeto de cliente (modelo) */
        Administrador administrador = new Administrador(idAdministrador,nombreAdministrador,apellidoAdministrador,estadoAdministrador, correoLogin);

        /* Modificamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new AdministradorDAO().actualizarAdministrador(administrador);
        
        Administrador login = new Administrador(idLogin,idAdministrador,correoLogin,estadoAdministrador);
        new AdministradorDAO().actualizarLogin(login);
        
        /* Configuramos e insertamos a la bitacora */
        String tipoRegistro = request.getParameter("tipo_registro");
        String accion = request.getParameter("accion");
        String nombreTabla = request.getParameter("nombre_tabla");
        
        this.insertarBitacora(request, tipoRegistro, accion, nombreTabla, nombreAdministrador + " " + apellidoAdministrador);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0 )
        {
            this.cargarUsuarios(request, response);
        }

    }
    
    private void EliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /* Recuperamos los valores del formulario */
        int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
        String nombreAdministrador = request.getParameter("nombre");
        
        /* Creamos el objeto de cliente (modelo) */
        Administrador administrador = new Administrador(idAdministrador);

        /* Modificamos en la base de datos */
         /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new AdministradorDAO().eliminarAdministrador(administrador);

        /* Configuramos e insertamos a la bitacora */
        this.insertarBitacora(request, "D", "inhabilito", "administardor", nombreAdministrador);
        
        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarUsuarios(request, response);
        }
    }
    /* Fin de metodos usuarios  */
    
    /* Unico metodo del login */
    private void salirLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesionLogin = request.getSession();
        sesionLogin.invalidate();
        
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    /* fin metodo del login */
    
    /* ----------------------------------------- */
    /* Metodos para las acciones de bitacora */
    /* Carga y lista a todos las actividades */
    private void cargarBitacora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Bitacora> bitacoras = new BitacoraDAO().Listar();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("bitacoras", bitacoras);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect(request.getContextPath() + "/administracion/informacion.jsp");
    }
    
    /* Inserta los datos a bitacora */
    private void insertarBitacora(HttpServletRequest request, String tipoRegistro, String accion, String nombreTabla, String nombreDato) {
        /* Obtenemos la descripcion de esta bitacora */
        
        /* Obtenemos los datos de la sesion */
        HttpSession sesionLogin = request.getSession();
        Integer idAdministradorSesion = (Integer) sesionLogin.getAttribute("idAdministrador");
        String nombreAdministradorSesion = (String) sesionLogin.getAttribute("nombreAdministrador") + " " + (String) sesionLogin.getAttribute("apellidoAdministrador");

        // Para ingresar los datos por la sesion, podemos usar estas dos lineas
        String descripcionBitacora = new BitacoraDAO().descripcionBitacora(nombreAdministradorSesion, accion, nombreTabla, nombreDato);
        Bitacora bitacora = new Bitacora(idAdministradorSesion, tipoRegistro, descripcionBitacora);
        
        // Si se quiere enviar quemado
        // String descripcionBitacora = new BitacoraDAO().descripcionBitacora("Melissa Alexandra", accion, nombreTabla, nombreDato);
        // Bitacora bitacora = new Bitacora(1, tipoRegistro, descripcionBitacora);    
            
        new BitacoraDAO().insertar(bitacora);
    }
    /* Fin de metodos bitacora  */
}
