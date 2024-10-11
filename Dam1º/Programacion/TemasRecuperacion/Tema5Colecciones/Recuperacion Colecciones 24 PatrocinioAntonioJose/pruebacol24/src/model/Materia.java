package model;

import exceptions.CursoException;

import java.util.Objects;

public class Materia {
    private String nombre;
    private boolean obligatoria;

    public Materia(String nombre, boolean obligatoria) throws CursoException {
        setNombre(nombre);
        this.obligatoria = obligatoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean isObligatoria() {
        return this.obligatoria;
    }

    public void setNombre(String nombre) throws CursoException {
        if (nombre.isEmpty())
            throw new CursoException("El nombre no puede estar vacío");
        this.nombre=nombre;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(nombre, materia.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre + " " + (obligatoria ? "Obligatoria" : "Optativa");
    }
}
