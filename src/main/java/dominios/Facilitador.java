package dominios;

public class Facilitador {
    /* Atributos */
    private int idFacilitador;
    private String nombreFacilitador;
    private String estudio;
    private String estadoFacilitador;
    
    /* Constructor vacio */
    public Facilitador() {
    }
    
    /* Constructor solamente con el id */
    /* Por ejemplo para el Delete, se usa este */
    public Facilitador(int idFacilitador) {
        this.idFacilitador = idFacilitador;
    }
    
    /* Este se puede utilizar cuando se hace un insert */
    public Facilitador(String nombreFacilitador, String estudio, String estadoFacilitador) {
        this.nombreFacilitador = nombreFacilitador;
        this.estudio = estudio;
        this.estadoFacilitador = estadoFacilitador;
    }
    
    /* Este para el update, por ejemplo; para para mostrar tambien */
    public Facilitador(int idFacilitador, String nombreFacilitador, String estudio, String estadoFacilitador) {
        this.idFacilitador = idFacilitador;
        this.nombreFacilitador = nombreFacilitador;
        this.estudio = estudio;
        this.estadoFacilitador = estadoFacilitador;
    }
    
    /* Metodos accesores */
    public int getIdFacilitador() {
        return idFacilitador;
    }

    public void setIdFacilitador(int idFacilitador) {
        this.idFacilitador = idFacilitador;
    }

    public String getNombreFacilitador() {
        return nombreFacilitador;
    }

    public void setNombreFacilitador(String nombreFacilitador) {
        this.nombreFacilitador = nombreFacilitador;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getEstadoFacilitador() {
        return estadoFacilitador;
    }

    public void setEstadoFacilitador(String estadoFacilitador) {
        this.estadoFacilitador = estadoFacilitador;
    }
    
}
