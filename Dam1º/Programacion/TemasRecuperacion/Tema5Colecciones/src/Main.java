import excepciones.TiendaException;
import modelo.Categoria;
import modelo.OutIn;
import modelo.Producto;
import modelo.Tienda;

import java.util.*;

public class Main {
    private static Tienda tienda = new Tienda("Coliseum");

    public static void main(String[] args) {
        try {
            Producto producto1 = new Producto("REPETIDOOOOOOOOO", "Galaxy S21", "Smartphone with 128GB storage", 799.99, 0);
            Producto producto2 = new Producto("Apple", "iPhone 12", "Smartphone with 64GB storage", 999.99, 30);
            Producto producto3 = new Producto("Sony", "PlayStation 5", "Next-gen gaming console", 499.99, 20);
            Producto producto4 = new Producto("LG", "OLED TV", "55 inch 4K OLED TV", 1299.99, 0);
            Producto producto5 = new Producto("Dell", "XPS 13", "13 inch laptop with Intel i7", 1199.99, 10);

            List<Categoria> listCategoria = new ArrayList<>();
       /* listCategoria.add(new Categoria("Smartphone"));
        listCategoria.add(new Categoria("TV"));

        listCategoria.add(new Categoria("CamaraFotgrafia"));*/
            listCategoria.add(new Categoria("SonidoYVideo"));
            listCategoria.add(new Categoria("Smartphone·3d"));


            tienda.addCategoria("Smartphone");
            tienda.addCategoria("CamaraFoto");
            tienda.addCategoria("Sonido");
            tienda.addCategoria("CamaraFotgrafia");
            tienda.addCategoria("TV");
            tienda.addCategoria("Smartphone·3d");
            tienda.addCategoria("SonidoYVideo");
            tienda.addProducto(producto1);
            tienda.addProducto(producto1, listCategoria);
            tienda.addProducto(producto2, listCategoria);
            tienda.addProducto(producto3, listCategoria);
            tienda.addProducto(producto4, listCategoria);
            tienda.addProducto(producto5, listCategoria);

        } catch (TiendaException e) {
            System.out.println(e.getMessage());

        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            menu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            try {
                switch (opcion) {
                    case 1:
                        String nombreCategoria = OutIn.leerCadena("Ingrese el nombre de la nueva categoría: ");
                        tienda.addCategoria(nombreCategoria);
                        System.out.println("Categoría añadida correctamente.");
                        break;

                    case 2:
                        String marca = OutIn.leerCadena("Ingrese la marca del producto: ");
                        String modelo = OutIn.leerCadena("Ingrese el modelo del producto: ");
                        double precio = OutIn.leerDouble("Ingrese el precio del producto: ");
                        String descripcion = OutIn.leerCadena("Ingrese la descripción del producto: ");
                        int stock = OutIn.leerEntero("Ingrese el stock del producto: ");
                        OutIn.limpiarBuffer();// Limpiar buffer

                        String categorias = OutIn.leerCadena("Ingrese las categorías del producto (separadas por comas): ");
                        Producto producto = new Producto(marca, modelo, descripcion, precio, stock);
                        // Se requiere una List<Categoria>, creo un array con split que mediante la clase Arrays y un flujo crear objetos mediante .map
                        tienda.addProducto(producto, Arrays.stream(categorias.split(",")).map(s -> new Categoria(s)).toList());
                        System.out.println("Producto añadido correctamente.");
                        break;

                    case 3:
                        imprimirLista(tienda.categoriasConProductosSinStock());
                        break;

                    case 4:
                        marca = OutIn.leerCadena("Ingrese la marca del producto: ");
                        modelo = OutIn.leerCadena( "Ingrese el modelo del producto: ");

                        Set<Categoria> categoriasDeProducto = tienda.categoriasDeProducto(new Producto(marca,modelo));
                        System.out.println("Categorías de producto: " + categoriasDeProducto);
                        break;

                    case 5:
                        List<Producto> productosOrdenadosPorPrecio = tienda.getTodosLosProductosOrdenadosPorPrecio();
                        System.out.println("Productos ordenados por precio: ");
                        for (Producto p : productosOrdenadosPorPrecio) {
                            System.out.println(p);
                        }
                        break;

                    case 6:
                        marca = OutIn.leerCadena("Ingrese la marca del producto: ");
                        modelo = OutIn.leerCadena( "Ingrese el modelo del producto: ");

                        tienda.eliminaProducto(new Producto(marca,modelo));
                        System.out.println("Producto eliminado correctamente.");
                        break;

                    case 7:
                        System.out.println("Productos añadidos en el último año: ");
                        for (Producto p :tienda.productosUltimoAnno()){
                            System.out.println(p);
                            System.out.println(p.getFechaIncorporacion());
                        }
                        break;
                    case 8:
                        for (Categoria c : tienda.listCategoria()) {
                            System.out.println(c.getNombre());
                        }
                        break;
                    case 9:


                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (TiendaException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void menu() {
        System.out.print("""
                            
                --- Menú de la Tienda ---
                            
                1. Añadir Categoría.
                2. Añadir Producto.
                3. Mostrar Categorías con Productos Sin Stock.
                4. Mostrar Categorías de un Producto.
                5. Mostrar Todos los Productos Ordenados por Precio.
                6. Eliminar Producto.
                7. Mostrar Productos Añadidos en el Último Año.
                8. Lista de Categoria.
                9. Listar Producto.
                0. Salir.
                Seleccione una opción:
                                
                """);
    }

    private static <T extends Object> void imprimirLista(Collection<T> lista) {

        for (T o : lista) {
            System.out.println(o.toString());
        }
    }

    private static void imprimirListaPro() {
        for (Categoria c : tienda.listCategoria()) {
            System.out.println(c.getNombre() + " :");
            for (Producto p : c.listaProducto()) {
                System.out.println(p.toString());
            }
        }
    }
}





