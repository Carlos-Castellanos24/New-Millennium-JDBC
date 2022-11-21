package dominios;

public class Bitacora {
    /* Atributos */
    private int idRegistro;
    private int idAdministrador;
    private String tipoRegistro;
    private String fechaRegistro;
    private String descripcionRegistro;
    
    /* Constructor personalizados */
    public Bitacora() {
    }
    
    /* Este se puede utilizar cuando se hace un insert */
    public Bitacora(int idAdministrador, String tipoRegistro, String descripcionRegistro) {
        this.idAdministrador = idAdministrador;
        this.tipoRegistro = tipoRegistro;
        this.descripcionRegistro = descripcionRegistro;
    }
    
    /* Este para el update, por ejemplo; para para mostrar tambien */
    public Bitacora(int idRegistro, int idAdministrador, String tipoRegistro, String fechaRegistro, String descripcionRegistro) {
        this.idRegistro = idRegistro;
        this.idAdministrador = idAdministrador;
        this.tipoRegistro = tipoRegistro;
        this.fechaRegistro = fechaRegistro;
        this.descripcionRegistro = descripcionRegistro;
    }
    
    /* Metodos accesores */
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcionRegistro() {
        return descripcionRegistro;
    }

    public void setDescripcionRegistro(String descripcionRegistro) {
        this.descripcionRegistro = descripcionRegistro;
    }
    
}
