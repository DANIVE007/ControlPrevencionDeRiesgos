import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Contenedor contenedor = new Contenedor();

    public static void main(String[] args) throws ParseException {
        boolean salir = false;

        while (!salir) {
            System.out.println("********* MENU PRINCIPAL *********");
            System.out.println("1.  Ingresar Cliente");
            System.out.println("2.  Ingresar Profesional");
            System.out.println("3.  Ingresar Administrativo");
            System.out.println("4.  Ingresar Capacitación");
            System.out.println("5.  Ingreso de Accidentes");
            System.out.println("6.  Ingresar Visita a Terreno");
            System.out.println("7.  Ingresar Revisión");
            System.out.println("8.  Listar Revisión");
            System.out.println("9.  Listar Usuarios");
            System.out.println("10. Listar Usuarios por Categoría");
            System.out.println("11. Listar Capacitación");
            System.out.println("12. Listar Accidentes");
            System.out.println("13. Listar Visitas a Terreno");
            System.out.println("14. Eliminar Usuario");
            System.out.println("15. Salir");
            System.out.println("**********************************");

            int opcion = 0;
            boolean opcionValida = false;
            while (!opcionValida) {
                System.out.print("   Seleccione una opción -> ");
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    opcionValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    scanner.next(); // Consume la entrada incorrecta
                }
            }

            switch (opcion) {
                case 1:
                    ingresarCliente();
                    break;
                case 2:
                    ingresarProfesional();
                    break;
                case 3:
                    ingresarAdministrativo();
                    break;
                case 4:
                    ingresarCapacitacion();
                    break;
                case 5:
                    ingresarAccidente();
                    break;
                case 6:
                    ingresarVisitaTerreno();
                    break;
                case 7:
                    ingresarRevision();
                    break;
                case 8:
                    listarRevision();
                    break;
                case 9:
                    listarUsuarios();
                    break;
                case 10:
                    listarPorCategoria();
                    break;
                case 11:
                    listarCapacitaciones();
                    break;
                case 12:
                    listarAccidentes();
                    break;
                case 13:
                    listarVisitasTerreno();
                    break;
                case 14:
                    eliminarUsuario();
                    break;
                case 15:
                    salir = confirmarSalida();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
                    pausar();
            }
        }
    }

    private static void ingresarCliente() throws ParseException {
        String run;
        String rutRegex = "^(\\d{1,2})\\.(\\d{3})\\.(\\d{3})[-]([\\dKk])$";
        Pattern pattern = Pattern.compile(rutRegex);

        while (true) {
            System.out.print("Ingrese RUN 99.999.999:X ");
            run = scanner.nextLine();
            Matcher matcher = pattern.matcher(run);

            // Verificar si el RUT cumple con el formato
            if (matcher.matches()) {
                String numero = matcher.group(1) + matcher.group(2) + matcher.group(3); // Número sin puntos
                int rutNumero;
                try {
                    rutNumero = Integer.parseInt(numero);
                } catch (NumberFormatException e) {
                    rutNumero = -1; // Si no se puede convertir, es un valor inválido
                }

                // Verificar si el número es menor que 99.999.999
                if (rutNumero >= 100000000) {
                    System.out.println("El número del RUT es demasiado alto.");
                } else {
                    System.out.println("El RUT es válido.");
                    break; // Sale del bucle si el RUT es válido
                }
            } else {
                System.out.println("El formato del RUT es inválido.");
            }
        }

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        // Verificar longitud del nombre
        while (nombre.length() < 10 || nombre.length() > 50) {
            System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();
        }
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        while (apellido.length() < 5 || apellido.length() > 50) {
            System.out.println("El Apellido debe tener entre 5 y 50 caracteres.");
            System.out.print("Ingrese apellido: ");
            apellido = scanner.nextLine();
        }
        String fechaNacimiento;
        while (true) {
            System.out.print("Ingrese fecha de nacimiento DD/MM/YYYY: ");
            fechaNacimiento = scanner.nextLine();
            if (Cliente.validarFecha(fechaNacimiento)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }
        System.out.print("Ingrese telefono: ");
        String telefono;
        while (true) {
            System.out.print("Ingrese teléfono (obligatorio): ");
            telefono = scanner.nextLine();
            if (!telefono.trim().isEmpty()) {
                break; // Sale del bucle si el teléfono no está vacío
            } else {
                System.out.println("El teléfono es obligatorio. Por favor, ingréselo.");
            }
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;
        String opcionAFP = ""; // Variable para almacenar el nombre de la AFP
        String apfElegida; // Variable para almacenar el nombre de la AFP al final

        while (true) {
            System.out.print("Seleccione AFP: 1.Provida 2.Cuprum 3.Modelo 4.Habitat 5.Capital 6.Plan Vital 7.Uno ");
            String input = scanner.nextLine();

            try {
                opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1:
                        opcionAFP = "Provida";
                        break;
                    case 2:
                        opcionAFP = "Cuprum";
                        break;
                    case 3:
                        opcionAFP = "Modelo";
                        break;
                    case 4:
                        opcionAFP = "Habitat";
                        break;
                    case 5:
                        opcionAFP = "Capital";
                        break;
                    case 6:
                        opcionAFP = "Plan Vital";
                        break;
                    case 7:
                        opcionAFP = "Uno";
                        break;
                    default:
                        System.out.println("Selección inválida. Por favor, ingrese un número entre 1 y 7.");
                        continue; // Vuelve a pedir la entrada si la opción no es válida
                }
                break; // Sale del bucle si la opción es válida
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }

        // Registrar el nombre de la AFP en la variable apfelegida
        apfElegida = opcionAFP;


        String sistemaSalud = ""; // Variable para almacenar el nombre del sistema de salud

        while (true) {
            System.out.print("Ingrese Sistema de Salud: 1. Fonasa ó 2. Isapre ");
            String input = scanner.nextLine();

            try {
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1:
                        sistemaSalud = "Fonasa";
                        break;
                    case 2:
                        sistemaSalud = "Isapre";
                        break;
                    default:
                        System.out.println("Selección inválida. Por favor, ingrese 1 o 2.");
                        continue; // Vuelve a pedir la entrada si la opción no es válida
                }
                break; // Sale del bucle si la opción es válida
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }


        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();
        // Validar que la dirección no exceda los 70 caracteres
        while (direccion.length() > 70) {
            System.out.println("La dirección no puede tener más de 70 caracteres. Por favor, intente nuevamente.");
            System.out.print("Ingrese dirección: ");
            direccion = scanner.nextLine();
        }

        System.out.print("Ingrese Comuna: ");
        String comuna = scanner.nextLine();

        // Validar que la comuna no exceda los 50 caracteres
        while (comuna.length() > 50) {
            System.out.println("La comuna no puede tener más de 50 caracteres. Por favor, intente nuevamente.");
            System.out.print("Ingrese comuna: ");
            direccion = scanner.nextLine();
        }


        Cliente cliente = new Cliente(run, nombre, apellido, fechaNacimiento, telefono,apfElegida,sistemaSalud, direccion, comuna);
        contenedor.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente.");
        pausar();
    }

    private static void ingresarProfesional() throws ParseException {
        String run;
        String rutRegex = "^(\\d{1,2})\\.(\\d{3})\\.(\\d{3})[-]([\\dKk])$";
        Pattern pattern = Pattern.compile(rutRegex);

        while (true) {
            System.out.print("Ingrese RUN 99.999.999:X ");
            run = scanner.nextLine();
            Matcher matcher = pattern.matcher(run);

            // Verificar si el RUT cumple con el formato
            if (matcher.matches()) {
                String numero = matcher.group(1) + matcher.group(2) + matcher.group(3); // Número sin puntos
                int rutNumero;
                try {
                    rutNumero = Integer.parseInt(numero);
                } catch (NumberFormatException e) {
                    rutNumero = -1; // Si no se puede convertir, es un valor inválido
                }

                // Verificar si el número es menor que 99.999.999
                if (rutNumero >= 100000000) {
                    System.out.println("El número del RUT es demasiado alto.");
                } else {
                    System.out.println("El RUT es válido.");
                    break; // Sale del bucle si el RUT es válido
                }
            } else {
                System.out.println("El formato del RUT es inválido.");
            }
        }
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        // Verificar longitud del nombre
        while (nombre.length() < 10 || nombre.length() > 50) {
            System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();
        }
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        while (apellido.length() < 5 || apellido.length() > 50) {
            System.out.println("El Apellido debe tener entre 5 y 50 caracteres.");
            System.out.print("Ingrese apellido: ");
            apellido = scanner.nextLine();
        }
        String fechaNacimiento;
        while (true) {
            System.out.print("Ingrese fecha de nacimiento DD/MM/YYYY: ");
            fechaNacimiento = scanner.nextLine();
            if (Profesional.validarFecha(fechaNacimiento)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }
        String titulo;

        while (true) {
            System.out.print("Ingrese título (10-50 letras): ");
            titulo = scanner.nextLine();

            // Validar que el título no sea vacío, tenga entre 10 y 50 caracteres y solo contenga letras
            if (titulo.length() < 10 || titulo.length() > 50) {
                System.out.println("El título es OBLIGATORIO y debe tener entre 10 y 50 caracteres.");
                continue;
            }

            if (!titulo.matches("[a-z A-Z]+")) {
                System.out.println("El título debe contener solo letras.");
                continue;
            }

            break; // Sale del bucle si el título es válido
        }


        String fechaIngreso;
        while (true) {
            System.out.print("Ingrese fecha de Ingreso DD/MM/YYYY: ");
            fechaIngreso = scanner.nextLine();
            if (Profesional.validarFecha(fechaIngreso)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }
        Profesional profesional = new Profesional(run, nombre, apellido, fechaNacimiento,titulo, fechaIngreso);
        contenedor.agregarProfesional(profesional);
        System.out.println("Profesional agregado exitosamente.");
        pausar();
    }

    private static void ingresarAdministrativo() throws ParseException {
        String run;
        String rutRegex = "^(\\d{1,2})\\.(\\d{3})\\.(\\d{3})[-]([\\dKk])$";
        Pattern pattern = Pattern.compile(rutRegex);

        while (true) {
            System.out.print("Ingrese RUN 99.999.999:X ");
            run = scanner.nextLine();
            Matcher matcher = pattern.matcher(run);

            // Verificar si el RUT cumple con el formato
            if (matcher.matches()) {
                String numero = matcher.group(1) + matcher.group(2) + matcher.group(3); // Número sin puntos
                int rutNumero;
                try {
                    rutNumero = Integer.parseInt(numero);
                } catch (NumberFormatException e) {
                    rutNumero = -1; // Si no se puede convertir, es un valor inválido
                }

                // Verificar si el número es menor que 99.999.999
                if (rutNumero >= 100000000) {
                    System.out.println("El número del RUT es demasiado alto.");
                } else {
                    System.out.println("El RUT es válido.");
                    break; // Sale del bucle si el RUT es válido
                }
            } else {
                System.out.println("El formato del RUT es inválido.");
            }
        }
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        // Verificar longitud del nombre
        while (nombre.length() < 10 || nombre.length() > 50) {
            System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();
        }
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        while (apellido.length() < 5 || apellido.length() > 50) {
            System.out.println("El Apellido debe tener entre 5 y 50 caracteres.");
            System.out.print("Ingrese apellido: ");
            apellido = scanner.nextLine();
        }
        String fechaNacimiento;
        while (true) {
            System.out.print("Ingrese fecha de nacimiento DD/MM/YYYY: ");
            fechaNacimiento = scanner.nextLine();
            if (Administrativo.validarFecha(fechaNacimiento)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }
        String cargo;

        while (true) {
            System.out.print("Ingrese Area (5-20 caracteres): ");
            cargo = scanner.nextLine();

            // Validar que el cargo no sea vacío, tenga entre 5 y 20 caracteres
            if (cargo.length() < 5 || cargo.length() > 20) {
                System.out.println("El área debe tener entre 5 y 20 caracteres.");
                continue;
            }

            if (cargo.trim().isEmpty()) {
                System.out.println("El área no puede estar vacío.");
                continue;
            }

            break; // Sale del bucle si el cargo es válido
        }
        String anosExperiencia;

        System.out.print("Ingrese información de experiencia (máximo 100 caracteres): ");
        anosExperiencia = scanner.nextLine();

        // Validar longitud máxima
        if (anosExperiencia.length() > 100) {
            anosExperiencia = anosExperiencia.substring(0, 100); // maximo 100 caracteres
            System.out.println("La información debe ser de máximo 100 caracteres.");
        }
        Administrativo administrativo = new Administrativo(run, nombre, apellido, fechaNacimiento, cargo, anosExperiencia);
        contenedor.agregarAdministrativo(administrativo);
        System.out.println("Administrativo agregado exitosamente.");
        pausar();
    }

    private static void ingresarCapacitacion() {
        List<Cliente> clientes = contenedor.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Primero ingrese algun CLiente Previamente.");
            pausar();
            return;
        }

        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Rut:" + cliente.getRut() + " - " + "Nombre:" + cliente.getNombre() + " " + cliente.getApellido());
        }

        System.out.print("Ingrese RUT del cliente para asociar la capacitación: ");
        String rutCliente = scanner.nextLine();
        Cliente clienteSeleccionado = contenedor.buscarClientePorRut(rutCliente); // Método para buscar por RUT

        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            pausar();
            return;
        }

        String idCapacitacion;
        while (true) {
            System.out.print("Ingrese identificador de capacitación: ");
            idCapacitacion = scanner.nextLine();

            if (!idCapacitacion.trim().isEmpty()) {
                break; // Salir del bucle si la entrada no está vacía
            } else {
                System.out.println("El identificador de capacitación es obligatorio. Por favor, ingrese un valor.");
            }
        }


        String dia = null;

        while (true) {
            System.out.print("Ingrese día de la capacitación: 1. Lunes 2. Martes 3. Miércoles 4. Jueves 5. Viernes 6. Sábado 7. Domingo ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    dia = "Lunes";
                    break;
                case "2":
                    dia = "Martes";
                    break;
                case "3":
                    dia = "Miércoles";
                    break;
                case "4":
                    dia = "Jueves";
                    break;
                case "5":
                    dia = "Viernes";
                    break;
                case "6":
                    dia = "Sábado";
                    break;
                case "7":
                    dia = "Domingo";
                    break;
                default:
                    System.out.println("Valor ingresado no válido, vuelva a ingresar el valor.");
                    continue; // Vuelve a pedir la entrada si el valor no es válido
            }
            break; // Sale del bucle si el valor es válido
        }
        String fechaCapacitacion;
        while (true) {
            System.out.print("Ingrese fecha de la Capacitación DD/MM/YYYY: ");
            fechaCapacitacion = scanner.nextLine();
            if (Profesional.validarFecha(fechaCapacitacion)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }

        String horaCapacitacion;
        while (true) {
            System.out.print("Ingrese hora de la capictacion (HH:mm): ");
            horaCapacitacion = scanner.nextLine();
            if (horaCapacitacion.matches("\\d{2}:\\d{2}")) {
                break;
            } else {
                System.out.println("Formato de hora inválido. Debe ser HH:mm. Inténtelo de nuevo.");
            }
        }
        String lugarCapacitacion;
        while (true) {
            System.out.print("Ingrese el lugar de la Capacitación (10-50 caracteres): ");
            lugarCapacitacion = scanner.nextLine();

            if (lugarCapacitacion.length() >= 10 && lugarCapacitacion.length() <= 50) {
                break; // Salir del bucle si el input es válido
            } else {
                System.out.println("Error: El lugar de la capacitación debe tener entre 10 y 50 caracteres. Inténtelo de nuevo.");
            }
        }
        // Validar hora
        String duracionCapacitacion;
        while (true) {
            System.out.print("Ingrese duracion de la capacitacion (HH:mm): ");
            duracionCapacitacion = scanner.nextLine();
            if (duracionCapacitacion.matches("\\d{2}:\\d{2}")) {
                break;
            } else {
                System.out.println("Formato de hora inválido. Debe ser HH:mm. Inténtelo de nuevo.");
            }
        }


        int asistentesCapacitacion;

        while (true) {
            System.out.print("Ingrese cantidad de asistentes (1-1000): ");
            String input = scanner.nextLine();

            try {
                asistentesCapacitacion = Integer.parseInt(input);
                if (asistentesCapacitacion >= 1 && asistentesCapacitacion <= 1000) {
                    break; // La entrada es válida, salir del bucle
                } else {
                    System.out.println("Cantidad fuera del rango permitido. Debe ser entre 1 y 1000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }

        Capacitacion capacitacion;
        capacitacion = new Capacitacion(idCapacitacion,dia,fechaCapacitacion,horaCapacitacion,lugarCapacitacion,duracionCapacitacion,asistentesCapacitacion, clienteSeleccionado);
        contenedor.agregarCapacitacion(capacitacion);
        System.out.println("Capacitación agregada exitosamente.");
        pausar();
    }


    private static void ingresarRevision() {
        List<VisitaTerreno> visitas = contenedor.listarVisitasTerreno();
        if (visitas.isEmpty()) {
            System.out.println("Primero ingrese alguna Visita a Terreno.");
            pausar();
            return;
        }

        System.out.println("Lista de Visitas:");
        for (VisitaTerreno visitaTerreno : visitas) {
            System.out.println("ID Visita    :" + VisitaTerreno.getIdVisita()  +
                    "\nDescripcion  :" + visitaTerreno.getDescripcion()+
                    "\nFecha Visita :" + visitaTerreno.getFechaVisita()+
                    "\n**********************************************************");
        }

        System.out.print("Ingrese Id de la visita en Terreno para asociar la Revision: ");
        String idVisitaRevision = scanner.nextLine();
        VisitaTerreno visitaSeleccionada = contenedor.buscarVisitasPorID(idVisitaRevision); // Método para buscar por id

        if (visitaSeleccionada == null) {
            System.out.println("Visita a Terreno no encontrado.");
            pausar();
            return;
        }

        String idRevision;
        while (true) {
            System.out.print("Ingrese identificador de la Revisión: ");
            idRevision = scanner.nextLine();

            if (!idRevision.trim().isEmpty()) {
                break; // Salir del bucle si la entrada no está vacía
            } else {
                System.out.println("El identificador de Revisión es obligatorio. Por favor, ingrese un valor.");
            }
        }
        String nombreRevision;
        while (true) {
            System.out.print("Ingrese el Nombre de la Revisión: ");
            nombreRevision = scanner.nextLine();

            if (nombreRevision.length() >= 10 && nombreRevision.length() <= 50) {
                break; // Salir del bucle si el input es válido
            } else {
                System.out.println("Error: El nombre de la revisión debe tener entre 10 y 50 caracteres. Inténtelo de nuevo.");
            }
        }
        String detallesRevision;
        while (true) {
            System.out.print("Ingrese los detalles a revisar: ");
            detallesRevision = scanner.nextLine();

            if (detallesRevision.length() >= 1 && detallesRevision.length() <= 100) {
                break; // Salir del bucle si el input es válido
            } else {
                System.out.println("Error: Los detalles a ingresar de la revisión debe tener entre 1 y 100 caracteres. Inténtelo de nuevo.");
            }
        }
        String estado = null;

        while (true) {
            System.out.print("Ingrese el Estado de la Revisión: 1.Sin Problemas 2.Con Observaciones 3.No se Aprueba");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    estado = "Sin Problemas";
                    break;
                case "2":
                    estado = "Con Observaciones";
                    break;
                case "3":
                    estado = "No se aprueba";
                    break;

                default:
                    System.out.println("Valor ingresado no válido, vuelva a ingresar el valor.");
                    continue; // Vuelve a pedir la entrada si el valor no es válido
            }
            break; // Sale del bucle si el valor es válido
        }
        String fechaRevision;
        while (true) {
            System.out.print("Ingrese fecha de la Revisión DD/MM/YYYY: ");
            fechaRevision = scanner.nextLine();
            if (Profesional.validarFecha(fechaRevision)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }


        Revision revision;
        revision = new Revision(idRevision,nombreRevision,detallesRevision,estado,fechaRevision,visitaSeleccionada);
        contenedor.agregarRevision(revision);
        System.out.println("Revisión agregada exitosamente.");
        pausar();
    }

    private static void eliminarUsuario() {
        List<Usuario> usuarios = contenedor.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Primero ingrese algun Usuario Previamente.");
            pausar();
            return;
        }

        System.out.println("Lista de Usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println("Rut:" + usuario.getRut() + " - " + "Nombre:" + usuario.getNombre() + " " + usuario.getApellido());
        }

        System.out.print("Ingrese RUT del Usuario a Eliminar: ");
        String rutUsuario = scanner.nextLine();
        Usuario usuarioSeleccionado = contenedor.buscarUsuarioPorRut(rutUsuario); // Método para buscar por RUT

        if (usuarioSeleccionado == null) {
            System.out.println("Usuario no encontrado.");
            pausar();
            return;
        }

            System.out.println("Está seguro de eliminar el usuario? 1.Sí , 2.No");
            int confirmacion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            if (confirmacion == 1) {
                boolean resultado = contenedor.eliminarUsuario(rutUsuario);
                if (resultado) {
                    System.out.println("Usuario eliminado exitosamente.");
                    pausar();
                } else {
                    System.out.println("Usuario no encontrado.");
                    pausar();
                }
            } else {
                System.out.println("Operación cancelada.");
                pausar();
            }
        }
    private static void listarRevision(){
        List<Revision> revisiones = contenedor.listarRevisiones();
        if (revisiones.isEmpty()) {
            System.out.println("NO HAY REVISIONES INGRESADAS PARA LISTAR");
            pausar();
        } else {
            System.out.println(revisiones);
            pausar();
        }

    }
    private static void listarUsuarios() {
        List<Usuario> usuarios = contenedor.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("NO HAY USUARIOS INGRESADOS PARA LISTAR");
            pausar();
        } else {
            System.out.println(usuarios);
            pausar();
        }
    }

    private static void listarPorCategoria() {
        System.out.println("1. Listar Clientes");
        System.out.println("2. Listar Profesionales");
        System.out.println("3. Listar Administrativos");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String resultado = contenedor.listarUsuariosxCategoria(opcion);
        if (resultado.isEmpty()) {
            System.out.println("No hay usuarios en la categoría seleccionada.");
            pausar();
        } else {
            System.out.println(resultado);
            pausar();
        }
    }


    private static void listarCapacitaciones() {
        List<Capacitacion> capacitaciones = contenedor.listarCapacitaciones();
        if (capacitaciones.isEmpty()) {
            System.out.println("NO HAY CAPACITACIONES INGRESADAS PARA LISTAR");
            pausar();

        } else {
            System.out.println(capacitaciones);
            pausar();

        }

    }
    private static void listarVisitasTerreno() {
        List<VisitaTerreno> visitas = contenedor.listarVisitasTerreno();
        if (visitas.isEmpty()) {
            System.out.println("NO HAY VISITAS INGRESADAS PARA LISTAR");
            pausar();

        } else {
            System.out.println(visitas);
            pausar();

        }

    }
    private static void listarAccidentes() {
        List<Accidente> accidentes = contenedor.listarAccidentes();
        if (accidentes.isEmpty()) {
            System.out.println("NO HAY ACCIDENTES INGRESADOS PARA LISTAR");
            pausar();
        } else {
            System.out.println(accidentes);
            pausar();
        }
    }
    private static void ingresarAccidente() {
        // Mostrar la lista de clientes
        List<Cliente> clientes = contenedor.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            pausar();
            return;
        }

        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getRut() + " - " + cliente.getNombre() + " " + cliente.getApellido());
        }

        // Pedir el RUT del cliente
        System.out.print("Ingrese el RUT del cliente para asociar el accidente: ");
        String rutCliente = scanner.nextLine();
        Cliente clienteSeleccionado = contenedor.buscarClientePorRut(rutCliente);

        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        // Ingreso de datos del accidente
        String id;
        String dia;
        String horaAccidente;
        String lugarAccidente;
        int cantidadPersonas;
        String clasificacion = "";
        String origenAccidente;
        String descripcionConsecuencias;



        while (true) {
            System.out.print("Ingrese ID del accidente: ");
            id = scanner.nextLine();

            if (!id.trim().isEmpty()) {
                break; // Sale del bucle si el valor no está vacío
            } else {
                System.out.println("El ID del accidente es obligatorio. Por favor, ingrese un valor.");
            }
        }

        // Validar fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print("Ingrese fecha del accidente (dd/MM/yyyy): ");
            String fechaStr = scanner.nextLine();
            try {
                Date fecha = dateFormat.parse(fechaStr);
                dia = fechaStr; // Guardamos el String directamente
                break;
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Inténtelo de nuevo.");
            }
        }

        // Validar hora
        while (true) {
            System.out.print("Ingrese hora del accidente (HH:mm): ");
            horaAccidente = scanner.nextLine();
            if (horaAccidente.matches("\\d{2}:\\d{2}")) {
                break;
            } else {
                System.out.println("Formato de hora inválido. Debe ser HH:mm. Inténtelo de nuevo.");
            }
        }

        while (true) {
            System.out.print("Ingrese el lugar del accidente (mínimo 10 caracteres y máximo 50): ");
            lugarAccidente = scanner.nextLine();

            if (!lugarAccidente.trim().isEmpty() && lugarAccidente.length() >= 10 && lugarAccidente.length() <= 50) {
                break; // Sale del bucle si el valor no está vacío y cumple con la longitud requerida
            } else {
                if (lugarAccidente.trim().isEmpty()) {
                    System.out.println("El lugar del accidente es obligatorio. Por favor, ingrese un valor.");
                } else if (lugarAccidente.length() < 10) {
                    System.out.println("El lugar del accidente debe tener al menos 10 caracteres. Por favor, intente nuevamente.");
                } else {
                    System.out.println("El lugar del accidente debe tener un máximo de 50 caracteres. Por favor, intente nuevamente.");
                }
            }
        }

        // Validar cantidad de personas afectadas
        while (true) {
            System.out.print("Ingrese la cantidad de personas afectadas: ");
            try {
                cantidadPersonas = scanner.nextInt();
                scanner.nextLine(); // Consume el newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido. Inténtelo de nuevo.");
                scanner.next(); // Limpia el buffer
            }
        }

        // Validar clasificación
        while (true) {
            System.out.println("Seleccione clasificación:");
            System.out.println("1. Leve");
            System.out.println("2. Grave");
            System.out.println("3. Fatal");
            System.out.print("Opción: ");
            int opcionClasificacion = scanner.nextInt();
            scanner.nextLine(); // Consume el newline
            if (opcionClasificacion >= 1 && opcionClasificacion <= 3) {
                switch (opcionClasificacion) {
                    case 1:
                        clasificacion = "Leve";
                        break;
                    case 2:
                        clasificacion = "Grave";
                        break;
                    case 3:
                        clasificacion = "Fatal";
                        break;
                }
                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        while (true) {
            System.out.print("Ingrese el origen del accidente (máximo 100 caracteres): ");
            origenAccidente = scanner.nextLine();

            if (!origenAccidente.trim().isEmpty() && origenAccidente.length() <= 100) {
                break; // Sale del bucle si el valor no está vacío y no excede los 100 caracteres
            } else {
                if (origenAccidente.trim().isEmpty()) {
                    System.out.println("El origen del accidente es obligatorio. Por favor, ingrese un valor.");
                } else {
                    System.out.println("El origen del accidente debe tener un máximo de 100 caracteres. Por favor, intente nuevamente.");
                }
            }
        }



        while (true) {
            System.out.print("Ingrese una descripción breve de las consecuencias (máximo 100 caracteres): ");
            descripcionConsecuencias = scanner.nextLine();

            if (!descripcionConsecuencias.trim().isEmpty() && descripcionConsecuencias.length() <= 100) {
                break; // Sale del bucle si el valor no está vacío y no excede los 100 caracteres
            } else {
                if (descripcionConsecuencias.trim().isEmpty()) {
                    System.out.println("La descripción de las consecuencias es obligatoria. Por favor, ingrese un valor.");
                } else {
                    System.out.println("La descripción de las consecuencias debe tener un máximo de 100 caracteres. Por favor, intente nuevamente.");
                }
            }
        }
        // Crear el objeto Accidente
        Accidente accidente = new Accidente(id, dia, horaAccidente, lugarAccidente, cantidadPersonas, clasificacion, origenAccidente, descripcionConsecuencias, clienteSeleccionado);

        // Agregar el accidente al contenedor
        contenedor.agregarAccidente(accidente);

        // Mensaje de éxito
        System.out.println("Accidente ingresado exitosamente.");

        // Pausar y esperar a que el usuario presione una tecla para volver al menú principal
        System.out.println("Presione Enter para volver al menú principal...");
        scanner.nextLine();
    }

    private static void ingresarVisitaTerreno() {
        // Mostrar la lista de clientes
        List<Cliente> clientes = contenedor.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            pausar();
            return;
        }

        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getRut() + " - " + cliente.getNombre() + " " + cliente.getApellido());
        }

        // Pedir el RUT del cliente
        System.out.print("Ingrese el RUT del cliente para asociar la visita a terreno: ");
        String rutCliente = scanner.nextLine();
        Cliente clienteSeleccionado = contenedor.buscarClientePorRut(rutCliente);

        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            pausar();
            return;
        }
        // Ingreso de datos del accidente
        String idVisita;
        String fechaVisita;
        String hora;
        String seccion;
        String descripcion;


        // Ingreso de datos de la visita a terreno
        while (true) {
            System.out.print("Ingrese número de visita: ");
            idVisita = scanner.nextLine();

            if (!idVisita.trim().isEmpty()) {
                break; // Sale del bucle si el valor no está vacío
            } else {
                System.out.println("El número de visita es obligatorio. Por favor, ingrese un valor.");
            }
        }
        // Validar ingrso de Fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print("Ingrese fecha de visita DD/MM/YYYY: ");
            fechaVisita = scanner.nextLine();
            if (Cliente.validarFecha(fechaVisita)) {
                break;
            } else {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }
        // Validar hora
        while (true) {
            System.out.print("Ingrese hora de la visita (HH:mm): ");
            hora = scanner.nextLine();
            if (hora.matches("\\d{2}:\\d{2}")) {
                break;
            } else {
                System.out.println("Formato de hora inválido. Debe ser HH:mm. Inténtelo de nuevo.");
            }
        }
        while (true) {
            System.out.print("Ingrese el Lugar: ");
            seccion = scanner.nextLine();

            if (seccion.trim().isEmpty()) {
                System.out.println("El lugar es obligatorio. Por favor, ingrese un valor.");
            } else if (seccion.length() < 10 || seccion.length() > 50) {
                System.out.println("El lugar debe tener entre 10 y 50 caracteres. Por favor, ingrese un valor válido.");
            } else {
                break; // Sale del bucle si el valor cumple con las condiciones
            }
        }
        while (true) {
            System.out.print("Ingrese una descripción de la visita: ");
            descripcion = scanner.nextLine();

            if (descripcion.trim().isEmpty()) {
                System.out.println("La descripción de la visita es obligatoria. Por favor, ingrese un valor.");
            } else if (descripcion.length() > 100) {
                System.out.println("La descripción de la visita no debe exceder los 100 caracteres. Por favor, ingrese un valor válido.");
            } else {
                break; // Sale del bucle si el valor cumple con las condiciones
            }
        }

        // Crear el objeto VisitaTerreno
        VisitaTerreno visita = new VisitaTerreno(idVisita,fechaVisita,hora,seccion,descripcion,clienteSeleccionado);

        // Agregar la visita al contenedor
        contenedor.agregarVisitaTerreno(visita);

        // Mensaje de éxito
        System.out.println("Visita a terreno registrada correctamente.");
        pausar();
    }

    private static void pausar() {
        System.out.print("Presione una tecla para continuar...");
        scanner.nextLine();
    }

    private static boolean confirmarSalida() {
        System.out.print("¿Está seguro de que desea salir? (S/N): ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
}
