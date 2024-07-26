import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Usuario implements Asesoria {
    public String rut;
    public String nombre;
    public String apellido;
    public Date fechaNacimiento;

    public Usuario(String rut, String nombre, String apellido, String fechaNacimientoStr) throws ParseException {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaNacimiento = dateFormat.parse(fechaNacimientoStr);
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String analizarUsuario() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Usuario:\n" +
                "  Rut                : " + rut + "\n" +
                "  Nombre             : " + nombre + "\n" +
                "  Apellido           : " + apellido + "\n" +
                "  Fecha de Nacimiento: " + dateFormat.format(fechaNacimiento) + "\n"
                +"*******************************************************************";
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

        return "El Usuario tiene " + age + " años de edad a la fecha.";
    }
}
