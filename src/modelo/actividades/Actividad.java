package modelo.actividades;

import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    private int id;
    private String titulo;
    private int cupoMaximo;

    // Lista / colección para guardar inscripciones
    private List<Inscripcion> inscripciones;

    // Variable de clase
    private static final int CUPO_MINIMO;

    // Inicializador estático
    static {
        CUPO_MINIMO = 2;
        System.out.println("Se inicializó la variable CUPO MINIMO a " + CUPO_MINIMO);
    }

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        if (cupoMaximo > 0 && cupoMaximo >= CUPO_MINIMO) {
            this.cupoMaximo = cupoMaximo;
        } else {
            this.cupoMaximo = CUPO_MINIMO;
        }
        this.inscripciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            return;
        }
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupo) {
        this.cupoMaximo = (cupo < CUPO_MINIMO) ? cupo : CUPO_MINIMO;
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (inscripciones.size() >= cupoMaximo) {
            throw new CupoExcedidoException("No se puede inscribir a: "+ estudiante.getNombre() + " -- Cupo máximo alcanzado.");
        }
        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "Registrada", this, estudiante);
        inscripciones.add(inscripcion);

        return inscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void mostrarInscripciones(){
        if (inscripciones.isEmpty()) {
            System.out.println("Sin inscripciones registradas.");
        }
        System.out.println("Inscripciones :");
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("  " + inscripcion.getFecha() + " -- " + inscripcion.getEstado() + " -- " + inscripcion.getEstudiante().getNombre() + " -- (Legajo: " + inscripcion.getEstudiante().getLegajo() + ")");
        }
    }

    // Método mostrar Identificacion final
    public final void mostrarIdentificacion() {
        System.out.println("---> " + getTipo() + ": " + this.titulo + " --- id = " + this.id + " --- Cupo máximo = " + this.cupoMaximo);
    }

    // Métodos abstractos
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();
}

