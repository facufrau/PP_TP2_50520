package modelo;

import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Taller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    // Clases relacionadas
    private Sala sala;
    private List<Actividad> actividades;

    // Variables de clase
    private static int cantidadEventos;

    // Inicializador estático
    static {
        cantidadEventos = 0;
        System.out.println("Cantidad de eventos inicializado a: " + cantidadEventos);
    }

    public EventoUniversitario(double costoBase, boolean gratuito, String titulo) {
        cantidadEventos++;
        setCostoBase(costoBase);
        setGratuito(gratuito);
        this.id = String.valueOf(cantidadEventos);
        setTitulo(titulo);

        this.actividades = new ArrayList<>();
    }

    public EventoUniversitario(EventoUniversitario otro) {
        cantidadEventos++;
        setCostoBase(otro.costoBase);
        setGratuito(otro.gratuito);
        this.id = String.valueOf(cantidadEventos);
        setTitulo(otro.titulo);
    }

    // Get-Set Titulo
    public void setTitulo(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            this.titulo = nombre;
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getId() {
        return this.id;
    }

    // Get-Set Costo Base
    public void setCostoBase(double costoBase) {
        if (costoBase >= 0) {
            this.costoBase = costoBase;
        }
    }

    public double getCostoBase() {
        return this.costoBase;
    }

    // Get-Set gratuito
    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public boolean getGratuito() {
        return gratuito;
    }

    public Sala getSala() {
        return sala;
    }

    // Mostrar Datos
    public void mostrarDatos() {
        System.out.println("______________________________________________________________________________________________");
        System.out.println("ID="+ this.id);
        System.out.println("Título=" + this.titulo);
        System.out.println("Es gratuito=" + this.gratuito);
        System.out.println("Costo Base=" + String.format("%.2f", this.costoBase));
        System.out.println("Costo Estimado=" + String.format("%.2f", calcularCostoestimado()));
        String salaNombre = this.sala.getNombre();
        if (!salaNombre.isBlank() && salaNombre != null){
            System.out.println("modelo.Sala Asignada= " + salaNombre);
        }

        System.out.println("Actividades:");
        System.out.println("____________");
        for (Actividad actividad : actividades) {
            System.out.println("- " + actividad.getTitulo() + " (id=" + actividad.getId() + ")" + " - Cupo máximo: " + actividad.getCupoMaximo());
            actividad.mostrarInscripciones();
        }
        System.out.println("______________________________________________________________________________________________");

    }

    public static void mostrarEventosTotales() {
        System.out.println("**********************\nEventos Totales: "+ getCantidadEventos() + "\n**********************");
    }

    // Get Cantidad de eventos
    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    // Calcular costo estimado
    public double calcularCostoestimado() {
        if (this.gratuito) {
            return 0.0;
        }

        double costoEstimado = costoBase;
        for (Actividad actividad : actividades) {
            costoEstimado += actividad.calcularCostoMateriales();
        }
        return costoEstimado * 1.21;
    }

    // Metodo asignar sala
    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    // Metodo crear modelo.actividades.Actividad
    public void crearActividad(int idnum, String titulo, int cupo, String tipo) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Se creará la actividad ---> " + tipo);

        switch (tipo) {
            case "charla":
                System.out.println("Ingrese el disertante: ");
                String disertante = reader.nextLine();
                Actividad charla = new Charla(idnum, titulo, cupo, disertante);
                this.actividades.add(charla);
                break;
            case "taller":
                System.out.println("El taller " + titulo + " requiere notebook? si/no ?");
                String reqNotebookRespuesta = reader.nextLine().trim().toLowerCase();
                boolean requiereNotebook = false;
                if (reqNotebookRespuesta.startsWith("s")) {
                    requiereNotebook = true;
                }
                Actividad taller = new Taller(idnum, titulo, cupo, requiereNotebook);
                this.actividades.add(taller);
                break;
            default:
                System.out.println("ERROR: modelo.actividades.Actividad no válida");
        }
    }

    // Retornar la lista de las actividades disponibles
    public List<Actividad> getActividades() {
        // Permite modificarlas desde afuera ya que devuelve la lista completa
        return actividades;
    }

}
