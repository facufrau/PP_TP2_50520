package modelo.actividades;

import modelo.Estudiante;
import modelo.certificacion.Certificable;

import java.io.Serializable;

public class Curso extends Actividad implements Certificable {

    private int nivel;

    public Curso(int id, String titulo, int cupo, int nivel) {
        super(id, titulo, cupo);
        setNivel(nivel);
    }

    public void setNivel (int nivel) {
        this.nivel = nivel;
    }

    public int getNivel () {
        return this.nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        if (this.nivel < 1) {
            return 0.0;
        } else if (this.nivel < 3) {
            return 1250.0;
        } else {
            return 2500.0;
        }
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "- - - - - - - - - Certificado de asistencia a " + this.getClass().getSimpleName() + "- - - - - - - - - \n"
                + "El estudiante : " + estudiante.getNombre() + ". Con legajo n°: " + estudiante.getLegajo() +
                " asistió al evento de con el título de: " + this.getTitulo()
                + "\n\n\n --- Certificado emitido por: " + ENTIDAD_EMISORA + "---" ;
    }
}
