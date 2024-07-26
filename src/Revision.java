public class Revision {
    private int idRevision;
    private String nombreRevision;
    private String detalleRevision;
    private String estado;
    private String fechaRevision;
    private VisitaTerreno visitaTerreno;

  //Constructores ; Vacío y lleno


    public Revision(String idRevision, String nombreRevision, String detalleRevision, String estado, String fechaRevision, VisitaTerreno visitaSeleccionada) {
        this.idRevision = Integer.parseInt(idRevision);
        this.nombreRevision = nombreRevision;
        this.detalleRevision = detalleRevision;
        this.estado = estado;
        this.fechaRevision = fechaRevision;
        this.visitaTerreno = visitaSeleccionada;
    }
    //Getters y Setters

    public String getIdVisita() {
        return visitaTerreno.getIdVisita();
    }


    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public String getNombreRevision() {
        return nombreRevision;
    }

    public void setNombreRevision(String nombreRevision) {
        this.nombreRevision = nombreRevision;
    }

    public String getDetalleRevision() {
        return detalleRevision;
    }

    public void setDetalleRevision(String detalleRevision) {
        this.detalleRevision = detalleRevision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public VisitaTerreno getVisitaTerreno() {
        return visitaTerreno;
    }

    public void setVisitaTerreno(VisitaTerreno visitaTerreno) {
        this.visitaTerreno = visitaTerreno;
    }

    @Override
    public String toString() {
        return "Revision N° " +idRevision +
                "\nNombre Revisión    = " + nombreRevision + '\'' +
                "\nDetalle Revisión   = " + detalleRevision + '\'' +
                "\nEstado             = " + estado + '\'' +
                "\nFecha Revisión     = " + fechaRevision + '\'' +
                "\nDeriva de Visita N°= " + visitaTerreno.getIdVisita() +
                "\n**********************************************************\n";
    }
}
