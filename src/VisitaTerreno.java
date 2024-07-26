public class VisitaTerreno {
    private static String idVisita;
    private String fechaVisita;
    private String hora;
    private String seccion;
    private String descripcion;
    private Cliente cliente; // Asociación con Cliente


    public VisitaTerreno(String idVisita, String fechaVisita, String hora, String seccion, String descripcion, Cliente clienteSeleccionado) {
        this.idVisita = idVisita;
        this.fechaVisita = fechaVisita;
        this.hora = hora;
        this.seccion = seccion;
        this.descripcion = descripcion;
        this.cliente = clienteSeleccionado;
    }
    public String getRutCliente() {
        return cliente.getRut(); // Devuelve el RUT del cliente asociado
    }

    public static String getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public String toString() {
        return "VisitaTerreno N° " + idVisita +
                " \nFecha Visita     = " + fechaVisita +
                " \nHora             = " + hora + '\'' +
                " \nSeccion          = " + seccion + '\'' +
                " \nDescripcion      = " + descripcion + '\''+
                " \nCliente          = " + cliente.getNombre() + " " + cliente.getApellido() +'\''+
                " \nRut Cliente      = " + cliente.getRut() + '\'' +
                " \nNúmero Contacto  = " + cliente.getTelefono() + '\'' +
                "\n*************************************************\n";
    }
}
