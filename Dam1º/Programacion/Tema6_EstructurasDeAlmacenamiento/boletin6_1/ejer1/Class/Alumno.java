package ejer1.Class;


import java.util.Objects;

public class Alumno {
    private String nombre,dni;

   public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " con Dni: " + dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }
}
