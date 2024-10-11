package ejer7;

import java.util.Objects;

public class Ingrediente {
    private String nombre;
    private double cantidad;

    public Ingrediente(String ingredientes, double cantidad) {
        this.nombre = ingredientes;
        this.cantidad = cantidad;
    }


    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String ingredientes) {
        this.nombre = ingredientes;
    }

    public void addCanidad(double cantidad) {
          this.cantidad += cantidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(nombre);
        sb.append(" cantidad: ").append(cantidad);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingrediente that)) return false;
        return Double.compare(cantidad, that.cantidad) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantidad);
    }
}
