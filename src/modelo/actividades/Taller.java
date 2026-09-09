package modelo.actividades;

import modelo.actividades.Actividad;

public class Taller extends Actividad {
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
            return 5000.0;
        } else {
            return 2000.0;
        }
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}