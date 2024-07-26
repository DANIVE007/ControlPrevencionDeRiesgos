import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Profesional extends Usuario implements Asesoria {
    private String titulo;
    private String fechaIngreso;

    public Profesional(String rut, String nombre, String apellido, String fechaNacimientoStr) throws ParseException {
        super(rut, nombre, apellido, fechaNacimientoStr);
    }

    public Profesional(String rut, String nombre, String apellido, String fechaNacimientoStr, String titulo, String fechaIngreso) throws ParseException {
        super(rut, nombre, apellido, fechaNacimientoStr);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Profesional:" +
                " \nRut               = " + rut + '\'' +
                " \nNombre            = " + nombre + '\'' +
                " \nApellido          = " + apellido + '\'' +
                " \nFecha Nac.        = " + dateFormat.format(fechaNacimiento) +
                " \nTitulo            = " + titulo + '\'' +
                " \nFecha Ingreso     = " + fechaIngreso + '\'' +"\n" +
                "***************************************************"+"\n";
    }

    @Override
    public String  analizarUsuario() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Profesional:\n" +
                "  Rut                : " + getRut() + "\n" +
                "  Nombre             : " + getNombre() + "\n" +
                "  Apellido           : " + getApellido() + "\n" +
                "  Fecha de Nac.      : " + dateFormat.format(getFechaNacimiento()) + "\n" +
                "  Título             : " + titulo + "\n" +
                "  Fecha de Ingreso   : " + fechaIngreso;
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

        return "El Usuario Profesional tiene " + age + " años de edad a la fecha.";
    }
}
