package RecuperacionEjercicios.Ejerc2;

import java.util.Objects;

public class Producto {
    private EProductos tipoProducto;
    private String nombre;
    private int stock;
    private double precio;

    public Producto(EProductos tipoProducto, String nombre, int stock, double precio) {
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        try {
            setStock(stock);
        } catch (ExceptionGranja e) {
            System.out.println(e.getMessage());
        }
        this.precio = precio;
    }

    public void setStock(int stock) throws ExceptionGranja {
        if (stock >= 0) {
            this.stock+=+stock;
        } else {
            throw new ExceptionGranja("El Stock no puede estar en negativo, el stock es de: " + this.stock);
        }
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public EProductos getTipoProducto() {
        return tipoProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return tipoProducto == producto.tipoProducto && Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoProducto, nombre);
    }

    @Override
    public String toString() {
        return tipoProducto + ":" +
                nombre + ":" +
                stock + ":" +
                precio;
    }
}
