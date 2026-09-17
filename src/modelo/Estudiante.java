package modelo;

import java.io.Serializable;

public class Estudiante implements Serializable{
    private String legajo;
    private String nombre;

    public Estudiante(String legajo, String nombre) {
        setLegajo(legajo);
        setNombre(nombre);
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return;
        }
        this.nombre = nombre;
    }
}
