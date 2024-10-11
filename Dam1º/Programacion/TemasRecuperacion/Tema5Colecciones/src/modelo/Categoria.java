package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Categoria {
    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.productos = new HashSet<>();
    }

    public void addProducto(Producto p) {
        this.productos.add(p);
    }

    public boolean delProducto(Producto p) {
        return productos.remove(p);
    }


    public Set<Producto> productoSinStock() {
        return productos.stream().filter(producto -> !producto.isStock()).collect(Collectors.toSet());
    }

    public boolean productoIsCategoria(Producto p) {
        return productos.contains(p);
    }

    public Set<Producto> listaProducto() {
        return new HashSet<>(this.productos);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {

        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
