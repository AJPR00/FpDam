package Tema6_EstructurasDeAlmacenamiento.ejrc1;

import java.util.Objects;

public class Alumno {
    private String dni;
    private String Nombre;

    public Alumno(String dni, String nombre) {
        this.dni = dni;
        Nombre = nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(dni, alumno.dni) && Objects.equals(Nombre, alumno.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, Nombre);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
