package modelo;

import excepciones.TiendaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tienda {
    private String nombre;
    private Set<Categoria> categorias;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.categorias = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una nueva categoría. En caso de que exista, lanza una excepción
     * <p>
     * ● addCategoria (0.5 puntos): Añade una nueva categoría. En caso de que
     * exista, lanza una excepción
     *
     * @param nombre
     * @throws TiendaException
     */
    public void addCategoria(String nombre) throws TiendaException {

        if (!categorias.add(new Categoria(nombre)))
            throw new TiendaException("Categoria ya existe");
    }

    /**
     * Añade un producto a una lista de categorías. Se añadirá a aquellas categorías en las que todavía no exista. En
     * aquellas donde ya exista, no se hará nada.
     *
     * @param p
     * @param categorias ● addProducto (1 punto): Añade un producto a una lista de categorías. Se
     *                   añadirá a aquellas categorías en las que todavía no exista. En aquellas donde
     *                   ya exista, no se hará nada. Si alguna de las categorías pasadas no existe, se
     *                   debe lanzar una excepción sin meter el producto en ninguna de las demás
     *                   categorías donde pueda existir.
     *                   ● categoriasConProductosSinStock
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {

        for (Categoria c : categorias) {
            if (!this.categorias.contains(c))
                throw new TiendaException("Hay categorías inexistente");
        }

        for (Categoria c : this.categorias) {
            if (categorias.contains(c) && !c.productoIsCategoria(p))
                c.addProducto(p);
        }

    } public void addProducto(Producto p) throws TiendaException {

        for (Categoria c : categorias) {
           c.addProducto(p);
        }


    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     *
     * @return
     */
    public Set<Categoria> categoriasConProductosSinStock() {
        return categorias.stream().filter(categoria -> categoria.productoSinStock().size() > 0).collect(Collectors.toSet());
    }

    /**
     * Devuelve un conjunto con las categorías a las que pertenece un producto determinado
     *
     * @param p
     * @return
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {
        return categorias.stream().filter(categoria -> categoria.productoIsCategoria(p)).collect(Collectors.toSet());
    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     *
     * @return
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio() {
        return categorias.stream().flatMap(categoria -> categoria.listaProducto().stream()).distinct().sorted((o1,o2)->Double.compare(o1.getPrecio(), o2.getPrecio())).collect(Collectors.toList());
    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     *
     * @param p
     * @return true si el producto aparecía en alguna categoría
     */
    public boolean eliminaProducto(Producto p) {
        // anyMatch devuelve un true con que solo alla un solo true, allMatch todos tienen que ser true para que devuelva true, solo un false devuelve false
        return categorias.stream().anyMatch(categoria -> categoria.delProducto(p));
    }

    /**
     * Devuelve un conjunto con aquellos productos que han sido añadido en el último año (a partir de la fecha actual)
     *
     * @return
     */
    public Set<Producto> productosUltimoAnno() {
        return categorias.stream().flatMap(categoria -> categoria.listaProducto().stream().filter(producto -> LocalDate.now().minusYears(1).isBefore(producto.getFechaIncorporacion()))).collect(Collectors.toSet());

    }

    public List<Categoria> listCategoria() {
        return new ArrayList<>(this.categorias);
    }
}
