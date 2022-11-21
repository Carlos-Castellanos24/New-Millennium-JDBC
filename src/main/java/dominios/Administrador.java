package dominios;

public class Administrador {

    /* Atributos */
    private int idAdministrador;
    private String nombreAdministrador;
    private String apellidoAdministrador;
    private String estadoAdministrador;

    /* Atributos de la tabla relacionada con el administrador */
    /* Atributos del login */
    private int idLogin;
    private String correoLogin;
    private String claveLogin;
    private String estadoLogin;
    
    /* Constructor vacio */
    public Administrador() {
    }
    
    /* Constructor solamente con el id */
    /* Por ejemplo para el Delete, se usa este */
    public Administrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Administrador(int idAdministrador,String nombreAdministrador,String apellidoAdministrador,String estadoAdministrador, String correoLogin){
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.estadoAdministrador = estadoAdministrador;
    }
    /* Este se puede utilizar cuando se hace un insert */
    public Administrador(String nombreAdministrador, String apellidoAdministrador, String estadoAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.estadoAdministrador = estadoAdministrador;
    }

    /* Contructor utilizado para el insertar en el login */
    public Administrador(int idAdministrador, String correoLogin, String claveLogin, String estadoLogin) {
        this.idAdministrador = idAdministrador;
        this.claveLogin = claveLogin;
        this.estadoLogin = estadoLogin;
        this.correoLogin = correoLogin;
    }
    
    
    /* Contructor utilizado para editar usuario*/
    public Administrador(int idAdministrador, int idLogin, String correoLogin, String estadoLogin) {
        this.idAdministrador = idAdministrador;
        this.idLogin = idLogin;
        this.correoLogin = correoLogin;
        this.estadoLogin = estadoLogin;
    }
  
    
    /* Contructor utilizado para editar usuario*/
    public Administrador(int idLogin,int idAdministrador, String nombreAdministrador,String apellidoAdministrador, String correoLogin, String estadoAdministrador) {
        this.idLogin = idLogin;
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.correoLogin = correoLogin;
        this.estadoAdministrador = estadoAdministrador;
       
    }
    
    
    /* Contructor utilizado para el login */
    public Administrador(int idAdministrador, String nombreAdministrador, String apellidoAdministrador, String correoLogin, int validar) {
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.correoLogin = correoLogin;
    }

    /* Este para el update, por ejemplo; para para mostrar tambien */
    public Administrador(int idAdministrador, String nombreAdministrador, String apellidoAdministrador, String estadoAdministrador, String correoLogin, String estadoLogin) {
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.estadoAdministrador = estadoAdministrador;
        this.correoLogin = correoLogin;
        this.estadoLogin = estadoLogin;
    }
    
    /* Metodos accesores */
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getEstadoAdministrador() {
        return estadoAdministrador;
    }

    public void setEstadoAdministrador(String estadoAdministrador) {
        this.estadoAdministrador = estadoAdministrador;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getCorreoLogin() {
        return correoLogin;
    }

    public void setCorreoLogin(String correoLogin) {
        this.correoLogin = correoLogin;
    }

    public String getClaveLogin() {
        return claveLogin;
    }

    public void setClaveLogin(String claveLogin) {
        this.claveLogin = claveLogin;
    }

    public String getEstadoLogin() {
        return estadoLogin;
    }

    public void setEstadoLogin(String estadoLogin) {
        this.estadoLogin = estadoLogin;
    }
    
    
}
