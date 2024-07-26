import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Administrativo extends Usuario implements Asesoria {
    private String cargo;
    private String anosExperiencia;

    public Administrativo(String rut, String nombre, String apellido, String fechaNacimientoStr) throws ParseException {
        super(rut, nombre, apellido, fechaNacimientoStr);
    }

    public Administrativo(String rut, String nombre, String apellido, String fechaNacimientoStr, String cargo, String anosExperiencia) throws ParseException {
        super(rut, nombre, apellido, fechaNacimientoStr);
        this.cargo = cargo;
        this.anosExperiencia = anosExperiencia;
    }

    // Getters y Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(String aniosExperiencia) {
        this.anosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Administrativo:" +
                " \nRut              = " + rut + '\'' +
                " \nNombre           = " + nombre + '\'' +
                " \nApellido         = " + apellido + '\'' +
                " \nFecha Nac.       = " + dateFormat.format(fechaNacimiento) +
                " \nArea             = " + cargo + '\'' +
                " \nExperiencia prev = " + anosExperiencia +"\n" +
                "***************************************************"+"\n";
    }

    @Override
    public String analizarUsuario() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Administrativo:\n" +
                "  Rut                : " + getRut() + "\n" +
                "  Nombre             : " + getNombre() + "\n" +
                "  Apellido           : " + getApellido() + "\n" +
                "  Fecha de Nac.      : " + dateFormat.format(getFechaNacimiento()) + "\n" +
                "  Cargo              : " + cargo + "\n" +
                "  Años de Exp.       : " + anosExperiencia;
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

        return "El Usuario Administrativo tiene " + age + " años de edad a la fecha.";
    }
}
