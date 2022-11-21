package dominios;

/**
 *
 * @author Fernando Cuatro
 */
public class Actividad {
    /* Atributos */
    private int idActividad;
    private int idCategoria;
    private int idFacilitador;
    private String nombreActividad;
    private String fechaInicio;
    private String fechaFinal;
    private String diasSemana;
    private String horasDias;
    private String descripcion;
    private String estadoActividad;
    
    /* Atributos relacionados con otras tablas */
    private String nombreCategoria;
    private String nombreFacilitador;
    
    /* Contructor vacio */
    public Actividad() {
    }
    
    /* Constructor solamente con el id */
    /* Por ejemplo para el Delete, se usa este */
    public Actividad(int idActividad) {
        this.idActividad = idActividad;
    }
    
    /* Este se puede utilizar cuando se hace un insert */
    public Actividad(int idCategoria, int idFacilitador, String nombreActividad, String fechaInicio, String fechaFinal, String diasSemana, String horasDias, String descripcion, String estadoActividad) {
        this.idCategoria = idCategoria;
        this.idFacilitador = idFacilitador;
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasSemana = diasSemana;
        this.horasDias = horasDias;
        this.descripcion = descripcion;
        this.estadoActividad = estadoActividad;
    }
    
    /* Este para el update, por ejemplo; para para mostrar tambien */
    public Actividad(int idActividad, int idCategoria, int idFacilitador, String nombreActividad, String fechaInicio, String fechaFinal, String diasSemana, String horasDias, String descripcion, String estadoActividad) {
        this.idActividad = idActividad;
        this.idCategoria = idCategoria;
        this.idFacilitador = idFacilitador;
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasSemana = diasSemana;
        this.horasDias = horasDias;
        this.descripcion = descripcion;
        this.estadoActividad = estadoActividad;
    }
    
    /* Constructor para la vista general de las actividades */
    public Actividad(String nombreActividad, String fechaInicio, String fechaFinal, String diasSemana, String horasDias, String descripcion, String nombreCategoria, String nombreFacilitador) {
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasSemana = diasSemana;
        this.horasDias = horasDias;
        this.descripcion = descripcion;
        this.nombreCategoria = nombreCategoria;
        this.nombreFacilitador = nombreFacilitador;
    }
    
    /* Constructor para la vista general de las actividades detallado y completo */
    public Actividad(int idActividad, int idCategoria, int idFacilitador, String nombreActividad, String fechaInicio, String fechaFinal, String diasSemana, String horasDias, String descripcion, String estadoActividad, String nombreCategoria, String nombreFacilitador) {
        this.idActividad = idActividad;
        this.idCategoria = idCategoria;
        this.idFacilitador = idFacilitador;
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasSemana = diasSemana;
        this.horasDias = horasDias;
        this.descripcion = descripcion;
        this.estadoActividad = estadoActividad;
        this.nombreCategoria = nombreCategoria;
        this.nombreFacilitador = nombreFacilitador;
    }
    
    /* Metodos accesores */
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdFacilitador() {
        return idFacilitador;
    }

    public void setIdFacilitador(int idFacilitador) {
        this.idFacilitador = idFacilitador;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getHorasDias() {
        return horasDias;
    }

    public void setHorasDias(String horasDias) {
        this.horasDias = horasDias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(String estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreFacilitador() {
        return nombreFacilitador;
    }

    public void setNombreFacilitador(String nombreFacilitador) {
        this.nombreFacilitador = nombreFacilitador;
    }
    
    

}
