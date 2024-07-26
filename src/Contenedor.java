import java.util.ArrayList;
import java.util.List;



public class Contenedor  {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Profesional> profesionales = new ArrayList<>();
    private List<Administrativo> administrativos = new ArrayList<>();
    private List<Capacitacion> capacitaciones = new ArrayList<>();
    private List<Accidente> accidentes = new ArrayList<>();
    private List<VisitaTerreno> visitas = new ArrayList<>();
    private List<Revision> revisiones = new ArrayList<>();

    // Métodos para agregar usuarios, capacitaciones, accidentes, visitas y revisiones

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        usuarios.add(cliente);
    }
    public void agregarProfesional(Profesional profesional) {
        profesionales.add(profesional);
        usuarios.add(profesional);
    }
    public void agregarAdministrativo(Administrativo administrativo) {
        administrativos.add(administrativo);
        usuarios.add(administrativo);
    }
    public Cliente buscarClientePorRut(String rut) {
        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                return cliente;
            }
        }
        return null;
    }
    public VisitaTerreno buscarVisitasPorID(String idVisita) {
        for (VisitaTerreno visitaTerreno : visitas) {
            if (VisitaTerreno.getIdVisita().equals(idVisita)) {
                return visitaTerreno;
            }
        }
        return null;
    }
    public Usuario buscarUsuarioPorRut(String rut) {
        for (Usuario usuario : usuarios) {
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }
    public void agregarCapacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
    }

    public void agregarAccidente(Accidente accidente) {
        accidentes.add(accidente);
    }

    public void agregarVisitaTerreno(VisitaTerreno visita) {
        visitas.add(visita);
    }

    public void agregarRevision(Revision revision) {
        revisiones.add(revision);
    }



    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios); // Devuelve una lista de todos los usuarios
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes); // Devuelve una copia de la lista de clientes
    }


    public List<Capacitacion> listarCapacitaciones() {
        return new ArrayList<>(capacitaciones); // Devuelve una copia de la lista de capacitaciones
    }


    public List<Accidente> listarAccidentes() {
        return new ArrayList<>(accidentes); // Devuelve una copia de la lista de accidentes
    }
    public List<VisitaTerreno> listarVisitasTerreno() {
        return new ArrayList<>(visitas); // Devuelve una copia de la lista de visitas a terreno
    }
    public List<Revision> listarRevisiones() {
        return new ArrayList<>(revisiones); // Devuelve una copia de la lista de revisiones de accidentes
    }
    public boolean eliminarUsuario(String rut) {
        // Eliminar usuarios por rut
        usuarios.removeIf(usuario -> usuario.getRut().equals(rut));
        clientes.removeIf(cliente -> cliente.getRut().equals(rut));
        profesionales.removeIf(profesional -> profesional.getRut().equals(rut));
        administrativos.removeIf(administrativo -> administrativo.getRut().equals(rut));

        return true; // Devuelve true si la eliminación fue exitosa, false si no
    }

    public String listarUsuariosxCategoria(int opcion) {
        StringBuilder usuariosStr = new StringBuilder();
        switch (opcion) {
            case 1:
                for (Cliente cliente : clientes) {
                    usuariosStr.append("Cliente: ").append(cliente.analizarUsuario()).append("\n");
                    usuariosStr.append("  Nota               : ").append(cliente.obtenerSistemaDeSalud()).append("\n");
                    usuariosStr.append(cliente.mostrarEdad()).append("\n");
                    usuariosStr.append("*************************************************************************************************************").append("\n");
                }

                break;
            case 2:
                for (Profesional profesional : profesionales) {
                    usuariosStr.append("Profesional: ").append(profesional.analizarUsuario()).append("\n");
                    usuariosStr.append("  Nota               : ").append(profesional.mostrarEdad()).append("\n");
                    usuariosStr.append("*************************************************************************************************************").append("\n");
                }
                break;
            case 3:
                for (Administrativo administrativo : administrativos) {
                    usuariosStr.append("Administrativo: ").append(administrativo.analizarUsuario()).append("\n");
                    usuariosStr.append("  Nota               : ").append(administrativo.mostrarEdad()).append("\n");
                    usuariosStr.append("*************************************************************************************************************").append("\n");
                }
                break;
            default:
                return "Categoría no válida.";
        }
        return usuariosStr.toString();
    }
}
