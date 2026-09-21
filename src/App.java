import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.Sala;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Curso;
import modelo.actividades.Taller;
import modelo.certificacion.Certificable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Creamos lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        // a-creamos estudiantes
        estudiantes.add(new Estudiante("12345", "Lionel Messi"));
        estudiantes.add(new Estudiante("33221", "Luis Scola"));
        estudiantes.add(new Estudiante("45632", "Luciana Aymar"));
        estudiantes.add(new Estudiante("19876|", "Paula Pareto"));
        estudiantes.add(new Estudiante("47651", "Emanuel Ginobili"));

        // b-creamos eventos varios
        EventoUniversitario evento1 = new EventoUniversitario(1500.0, false, "Evento de Linux y Software Libre");
        EventoUniversitario evento2 = new EventoUniversitario(123.123, true, "Olimpiadas de ciencia");
        EventoUniversitario evento3 = new EventoUniversitario(3333.0, false, "Jornadas de Educacion");
        EventoUniversitario evento4 = new EventoUniversitario(2300.0, true, "Congreso de Estudiantes");


        // c-Creamos y asignamos sala al evento creado
        Sala sala17 = new Sala(1, "Aula 17-18 2do piso");
        Sala auditorio = new Sala(2, "Auditorio");
        Sala laboratorio = new Sala(3, "Laboratorio LISUN");
        evento1.asignarSala(sala17);
        evento2.asignarSala(auditorio);
        evento3.asignarSala(laboratorio);

        // d-Creamos en cada evento actividades
        evento1.crearActividad(1, "Que es Linux?", 12, "charla");
        evento1.crearActividad(2, "Instalando Linux en Cloud", 20, "taller");
        evento1.crearActividad(3, "Usando la consola y programación en bash", 2, "taller");
        evento1.crearActividad(4, "Curso de uso de AWS y EC2", 15, "curso");
        evento1.crearActividad(4, "Curso de Docker básico", 30, "curso");
        evento1.crearActividad(4, "Charla de Azure y GCP", 10, "charla");

        // e-Inscribimos estudiantes en cada actividad
        // En charla
        try {
            evento1.getActividades().get(0).inscribir(estudiantes.get(0));
            evento1.getActividades().get(0).inscribir(estudiantes.get(2));
            evento1.getActividades().get(0).inscribir(estudiantes.get(4));
        }
        catch (CupoExcedidoException e) {
                System.out.println("ERROR al inscribir: "+ e.getMessage());
            }
        
            // En taller1
        try {
            evento1.getActividades().get(1).inscribir(estudiantes.get(1));
            evento1.getActividades().get(1).inscribir(estudiantes.get(3));
            evento1.getActividades().get(1).inscribir(estudiantes.get(2));
        }
        catch (CupoExcedidoException e) {
            System.out.println("ERROR al inscribir: "+ e.getMessage());
        }

            // En taller2
        try {
            evento1.getActividades().get(2).inscribir(estudiantes.get(1));
            evento1.getActividades().get(2).inscribir(estudiantes.get(3));
            evento1.getActividades().get(2).inscribir(estudiantes.get(4));
        }
        catch (CupoExcedidoException e) {
            System.out.println("ERROR al inscribir: "+ e.getMessage());
        }

        try {
            for (Estudiante estudiante : estudiantes) {
                evento1.getActividades().get(3).inscribir(estudiante);
            }
        } catch (CupoExcedidoException e) {
            System.out.println("ERROR al inscribir: " + e.getMessage());
        }

        // f,g-Mostramos datos de evento y actividades
        evento1.mostrarDatos();
        EventoUniversitario.mostrarEventosTotales();

        // h-Persistir el evento
        try {
            System.out.println("---- Guardando el evento con id: " + evento1.getId() + " ----");
            evento1.persistirEvento();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("-!-!-!-!- No se pudo guardar el evento con id: " + evento1.getId()
            + " ----\n\n Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("-!-!-!-!- No se pudo guardar el evento con id: " + evento1.getId()
                    + " ----\n\n Error: ");
            e.printStackTrace();
        }

        // i-Recuperar el evento
        try {
            EventoUniversitario eventoRecuperado = evento1.recuperarEvento(evento1.getId());
            System.out.println("---- Recuperado el evento con id: " + evento1.getId() + " ----");
            System.out.println("---- INICIO DATOS RECUPERADOS ----");
            eventoRecuperado.mostrarDatos();
            System.out.println("---- FIN DATOS RECUPERADOS ----");

        } catch (ClassNotFoundException e) {
            System.out.println("No pudo recuperarse el objeto especificado error: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("-!-!-!-!- No se pudo recuperar el objeto de evento especificado. Error");
            e.printStackTrace();
        }

        // j-Emisión de certificados
        for (Actividad actividad: evento1.getActividades()) {
            if (actividad instanceof Certificable certificable) {
                System.out.println("Certificados generados para la actividad: " + actividad.getTitulo());
                for (Inscripcion inscripcion: actividad.getInscripciones()) {
                    String certificado = certificable.generarCertificado(inscripcion.getEstudiante());
                    System.out.println(certificado);
                }
            }
        }

        // k-filtrado de actividades y uso de wildcards / parametros
        System.out.println("\n\n----- Uso de filtro para la lista de actividades -----");
        List<Taller> talleresCreados = evento1.filtrarActividadesPorTipo(Taller.class);
        List<Curso> cursosCreados = evento1.filtrarActividadesPorTipo(Curso.class);
        List<Charla> charlasCreados = evento1.filtrarActividadesPorTipo(Charla.class);

        System.out.println("Charlas: " + charlasCreados.size());
        System.out.println("Talleres: " + talleresCreados.size());
        System.out.println("Cursos: " + cursosCreados.size());

        System.out.println("Costo talleres: $" + evento1.calcularCostoMateriales(talleresCreados));
        System.out.println("Costo cursos: $" + evento1.calcularCostoMateriales(cursosCreados));
        System.out.println("Costo Charlas: $" + evento1.calcularCostoMateriales(charlasCreados));

        System.out.println("Costo total: $" + evento1.calcularCostoMateriales(evento1.getActividades()));



    }
}