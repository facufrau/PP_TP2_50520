package modelo;

import java.io.Serializable;

public class Sala implements Serializable {
    private int id;
    private String nombre;

    public Sala(int id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0){
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isBlank() || nombre == null) {
            return;
        }
        this.nombre = nombre;
    }
}
