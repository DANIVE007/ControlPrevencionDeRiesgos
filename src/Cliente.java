import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cliente extends Usuario implements Asesoria {
    private String telefono;
    private String afpElegida;
    private String sistemaSalud;
    private String direccion;
    private String comuna;


    public Cliente(String rut, String nombre, String apellido, String fechaNacimientoStr) throws ParseException {
        super(rut, nombre, apellido, fechaNacimientoStr);
    }

    public Cliente(String rut, String nombre, String apellido, String fechaNacimientoStr, String telefono, String afpElegida, String sistemaSalud, String direccion, String comuna) throws ParseException {
        super(rut, nombre, apellido, fechaNacimientoStr);
        this.telefono = telefono;
        this.afpElegida = afpElegida;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
    }


// Getters y Setters


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfpElegida() {
        return afpElegida;
    }

    public void setAfpElegida(String afpElegida) {
        this.afpElegida = afpElegida;
    }

    public String getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(String sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }



    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Cliente:" +
                " \nRut              = " + getRut() + '\'' +
                " \nNombre           = " + getNombre() + '\'' +
                " \nApellido         = " + getApellido() + '\'' +
                " \nFecha Nacimiento = " + dateFormat.format(getFechaNacimiento()) +
                " \nTelefono         = " + telefono + '\'' +
                " \nAFP              = " + afpElegida + '\'' +
                " \nSistema Salud    = " + sistemaSalud + '\'' +
                " \nDireccion        = " + direccion + '\'' +
                " \nComuna           = " + comuna + '\'' +
                " \nComentario: " + obtenerSistemaDeSalud() +'\'' +
                "\n***************************************************"+"\n";
    }

    @Override
    public String  analizarUsuario() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Cliente:\n" +
                "  Rut                : " + getRut() + "\n" +
                "  Nombre             : " + getNombre() + "\n" +
                "  Apellido           : " + getApellido() + "\n" +
                "  Fecha de Nac.      : " + dateFormat.format(getFechaNacimiento()) + "\n" +
                "  Teléfono           : " + telefono + "\n" +
                "  Dirección          : " + direccion + "\n" +
                "  Comuna             : " + comuna + "\n"+
                "  Comentario         : " + obtenerNombre() + "\n";

    }

    // Validar formato de fecha
    public static boolean validarFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try {
            Date date = formato.parse(fecha);
            return fecha.equals(formato.format(date));
        } catch (ParseException e) {
            return false;
        }
    }
    public String obtenerNombre(){
        return "El Nombre del cliente es " +getNombre() + " " + getApellido();
    }
    public String obtenerSistemaDeSalud(){
        return "El Cliente " +getNombre() + " " + getApellido() +" "+"tiene "+ sistemaSalud + " como sistema de Salud.";
    }
    public  String mostrarEdad() {
        // Obtiene la fecha actual
        Calendar today = Calendar.getInstance();
        // Obtiene la fecha de nacimiento
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(fechaNacimiento);

        // Calcula la edad
        int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        // Ajusta la edad si el cumpleaños aún no ha pasado este año
        if (today.get(Calendar.MONTH) + 1 < birthDate.get(Calendar.MONTH) + 1 ||
                (today.get(Calendar.MONTH) + 1 == birthDate.get(Calendar.MONTH) + 1 &&
                        today.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return "                       El Usuario Cliente tiene " + age + " años de edad a la fecha.";
    }
}
