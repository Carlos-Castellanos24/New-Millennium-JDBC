package web;

import datos.*;
import dominios.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import utilidades.Hash;

@WebServlet("/PublicoControlador")
public class PublicoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Solicitamos el parametro de de la pag */
        String pag = request.getParameter("pag");

        if (pag != null)
        {
            switch (pag)
            {
                case "1":
                    this.cargarActividades(request, response);
                    break;

                case "2":
                    this.cargarCategorias(request, response);
                    break;

                case "3":
                    this.cargarFacilitadores(request, response);
                    break;

                default:
                    this.cargarActividades(request, response);
            }
        } else
        {
            this.cargarActividades(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Acciones para el login */
        String login = request.getParameter("login");
        if (login != null)
        {
            switch (login)
            {
                case "iniciar":
                    this.login(request, response);
                    break;

                default:
                    this.cargarActividades(request, response);
            }
        }
        /* fin acciones de actividades */
    }

    /* Carga y lista a todos las actividades */
    private void cargarActividades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Actividad> actividades = new ActividadDAO().Listar();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("actividades", actividades);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect("calendario.jsp");
    }

    /* Carga y lista a todos las categorias */
    private void cargarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Categoria> categorias = new CategoriaDAO().Listar();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("categorias", categorias);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect("categorias.jsp");
    }

    /* Carga y lista a todos las facilitadores */
    private void cargarFacilitadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Facilitador> facilitadores = new FacilitadorDAO().Listar();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("facilitadores", facilitadores);

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect("facilitadores.jsp");
    }

    /* Validar login e iniciamos las sesiones */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        String correoLogin = request.getParameter("correo");
        String claveLogin = request.getParameter("pw");
        
        String claveCifrada = Hash.md5(claveLogin);

        /* Creamos el objeto de Administrador (modelo) */
        Administrador login = new AdministradorDAO().login(correoLogin, claveCifrada);

        /* Validamos que el usuario exista */
        if ((int) login.getIdAdministrador() > 0)
        {
            // Creamos o recuperamos el objeto http session
            HttpSession sesionLogin = request.getSession();

            // Agregamos los parametros a la sesion
            sesionLogin.setAttribute("idAdministrador", login.getIdAdministrador());
            sesionLogin.setAttribute("nombreAdministrador", login.getNombreAdministrador());
            sesionLogin.setAttribute("apellidoAdministrador", login.getApellidoAdministrador());
            sesionLogin.setAttribute("correoLogin", login.getCorreoLogin());

            // Redireccionamos al inicio del administrador
            response.sendRedirect(request.getContextPath() + "/administracion/index.jsp");
        } else
        {
            // Redireccionamos al inicio de la calendarizacion
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }
}
