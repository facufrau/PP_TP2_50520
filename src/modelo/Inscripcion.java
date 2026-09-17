package modelo;

import modelo.Estudiante;
import modelo.actividades.Actividad;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable{
    private LocalDate fecha;
    private String estado;
    private Actividad actividad;
    private Estudiante estudiante;

    public Inscripcion(LocalDate fecha, String estado, Actividad actividad, Estudiante estudiante) {
        setFecha(fecha);
        setEstado(estado);
        this.actividad = actividad;
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void confirmar() {
        this.estado = "Confirmada";
    }
}