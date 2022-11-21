package dominios;

public class Categoria {
    /* Atributos */
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String estadoCategoria;
    
    /* Constructor vacio */
    public Categoria() {
    }
    
    /* Constructor solamente con el id */
    /* Por ejemplo para el Delete, se usa este */
    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    /* Este se puede utilizar cuando se hace un insert */
    public Categoria(String nombreCategoria, String descripcion, String estadoCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.estadoCategoria = estadoCategoria;
    }
    
    /* Este para el update, por ejemplo; para para mostrar tambien */
    public Categoria(int idCategoria, String nombreCategoria, String descripcion, String estadoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.estadoCategoria = estadoCategoria;
    }
    
    /* Metodos accesores */
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(String estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }
    
}
