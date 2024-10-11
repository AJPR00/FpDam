package modelo;

import excepciones.TiendaException;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
    private String marca;
    private String modelo;
    private String descripcion;
    private double precio;
    private LocalDate fechaIncorporacion;
    private int stock;

    public Producto(String marca, String modelo, String descripcion, double precio, int stock) throws TiendaException {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaIncorporacion = LocalDate.now();
        setStock(stock);
    }

    public Producto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void setStock(int stock) throws TiendaException {
        if (stock < 0)
            throw new TiendaException("El Stock no puede se número negativos");
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public boolean isStock() {
        return stock>0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(marca, producto.marca) && Objects.equals(modelo, producto.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }

    @Override
    public String toString() {

        return modelo;
    }
}
