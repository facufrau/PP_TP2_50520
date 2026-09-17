package modelo.actividades;

import modelo.actividades.Actividad;
import modelo.Estudiante;
import modelo.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupo, boolean requiereNotebook) {
        super(id, titulo, cupo);
        setRequiereNotebook(requiereNotebook);
    }

    public boolean getRequiereNotebook() {
        return this.requiereNotebook;
    }

    public void setRequiereNotebook(boolean reqNotebook) {
        this.requiereNotebook = reqNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        if (this.requiereNotebook) {
            return 3500.0;
        } else {
            return 1300.0;
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