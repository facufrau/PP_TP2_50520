package modelo.actividades;

import modelo.actividades.Actividad;

public class Charla extends Actividad {
    private String disertante;

    public Charla(int id, String titulo, int cupo, String disertante) {
        super(id, titulo, cupo);
        setDisertante(disertante);
    }

    public String getDisertante() {
        return this.disertante;
    }

    public void setDisertante(String disertante) {
        if (disertante == null || disertante.isBlank()) {
            return;
        }
        this.disertante = disertante;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0.0;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
