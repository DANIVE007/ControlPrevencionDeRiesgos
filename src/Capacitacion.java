public class Capacitacion {
    private String idCapacitacion;
    private String dia;
    private String fechaCapacitación;
    private String horaCapacitacion;
    private String lugarCapacitacion;
    private String duracionCapacitacion;
    private int asistentesCapacitacion;
    private Cliente clienteSeleccionado;

    public Capacitacion() {
    }

    public Capacitacion(String idCapacitacion, String dia, String fechaCapacitación, String horaCapacitacion, String lugarCapacitacion, String duracionCapacitacion, int asistentesCapacitacion, Cliente clienteSeleccionado) {
        this.idCapacitacion = idCapacitacion;
        this.dia = dia;
        this.fechaCapacitación = fechaCapacitación;
        this.horaCapacitacion = horaCapacitacion;
        this.lugarCapacitacion = lugarCapacitacion;
        this.duracionCapacitacion = duracionCapacitacion;
        this.asistentesCapacitacion = asistentesCapacitacion;
        this.clienteSeleccionado = clienteSeleccionado;
    }

    //getter y setters

    public String getRutCliente() {
        return clienteSeleccionado.getRut(); // Devuelve el RUT del cliente asociado
    }

    public String getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(String idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFechaCapacitación() {
        return fechaCapacitación;
    }

    public void setFechaCapacitación(String fechaCapacitación) {
        this.fechaCapacitación = fechaCapacitación;
    }

    public String getHoraCapacitacion() {
        return horaCapacitacion;
    }

    public void setHoraCapacitacion(String horaCapacitacion) {
        this.horaCapacitacion = horaCapacitacion;
    }

    public String getLugarCapacitacion() {
        return lugarCapacitacion;
    }

    public void setLugarCapacitacion(String lugarCapacitacion) {
        this.lugarCapacitacion = lugarCapacitacion;
    }

    public String getDuracionCapacitacion() {
        return duracionCapacitacion;
    }

    public void setDuracionCapacitacion(String duracionCapacitacion) {
        this.duracionCapacitacion = duracionCapacitacion;
    }

    public int getAsistentesCapacitacion() {
        return asistentesCapacitacion;
    }

    public void setAsistentesCapacitacion(int asistentesCapacitacion) {
        this.asistentesCapacitacion = asistentesCapacitacion;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    @Override
    public String toString() {
        return "Capacitacion N° " + idCapacitacion + '\'' +
                " \nFecha            = " + fechaCapacitación + '\'' +
                " \nDia              = " + dia + '\'' +
                " \nHora             = " + horaCapacitacion + '\'' +
                " \nLugar            = " + lugarCapacitacion + '\'' +
                " \nDuracion         = " + duracionCapacitacion + '\'' +
                " \nAsistentes       = " + asistentesCapacitacion +
                " \nCliente a Cargo  = " + clienteSeleccionado.getNombre() +" " +clienteSeleccionado.getApellido() +'\'' +
                " \nTelefono Contac. = " + clienteSeleccionado.getTelefono()+'\'' +
                " \nMensaje          = "+mostrarDetalle()+'\'' +
                " \n***************************************************************************************\n";
    }

    public String mostrarDetalle() {
        String[] partesDuracion = duracionCapacitacion.split(":");
        int horas = Integer.parseInt(partesDuracion[0]);
        int minutos = Integer.parseInt(partesDuracion[1]);

        String tiempo;
        if (horas == 1 && minutos == 0) {
            tiempo = "hora";
        } else if (horas > 1 && minutos == 0) {
            tiempo = "horas";
        } else if (horas == 1 && minutos >1 && minutos <=59) {
            tiempo = "hora y minutos";
        } else if (horas < 1 && minutos ==1 ) {
            tiempo = "horas y minuto";
        } else if (horas < 1 && minutos <1 ) {
            tiempo = "horas y minutos";
        } else {
            tiempo = "minutos";
        }

        return "La capacitación será en " + lugarCapacitacion + " a las " + horaCapacitacion + " del día " + dia + " y \n                   su duración será de " + duracionCapacitacion + " " + tiempo;
    }


}
