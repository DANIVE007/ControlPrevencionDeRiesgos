import java.util.Date;

public class Accidente {
    private String id;
    private String dia;
    private String hora;
    private String lugar;
    private Integer cantAfectados;
    private String clasificacion;
    private String origen;
    private String consecuencias;
    private Cliente cliente; // Asociación con Cliente

    public Accidente(String id, String dia, String hora, String lugar, Integer cantAfectados, String clasificacion, String origen, String consecuencias, Cliente cliente) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.cantAfectados = cantAfectados;
        this.clasificacion = clasificacion;
        this.origen = origen;
        this.consecuencias = consecuencias;
        this.cliente = cliente;
    }

    // GETTER Y SETTERS

    public String getRutCliente() {
        return cliente.getRut(); // Devuelve el RUT del cliente asociado
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getCantAfectados() {
        return cantAfectados;
    }

    public void setCantAfectados(Integer cantAfectados) {
        this.cantAfectados = cantAfectados;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        this.consecuencias = consecuencias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Accidente N° " + id + '\'' +
                " \nDia              = " + dia + '\'' +
                " \nHora             = " + hora + '\'' +
                " \nLugar            = " + lugar + '\'' +
                " \nCant. Afectados  = " + cantAfectados +
                " \nClasificacion    = " + clasificacion + '\'' +
                " \nOrigen           = " + origen + '\'' +
                " \nConsecuencias    = " + consecuencias + '\'' +
                " \nInvestigador     = " + cliente.getNombre() + " " +cliente.getApellido() +
                " \nRut Cliente      = " + cliente.getRut() + '\'' +
                " \nNúmero Contacto  = " + cliente.getTelefono() + '\'' +
                " \n****************************************************\n";
    }

}