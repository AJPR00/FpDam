package RecuperacionEjercicios.Ejerc2;

import java.util.*;

public class Granja {
    private String nombre;
    private ArrayList<Animal> listaAnimales;
    private Set<Producto> listaProductos;
    private ArrayList<Transacion> registroTransaciones;

    public Granja(String nombre) {
        this.nombre = nombre;
        this.listaAnimales = new ArrayList<>();
        this.listaProductos = new HashSet<>();
        this.registroTransaciones = new ArrayList<>();
    }

    public void addAnimal(Animal a) throws ExceptionGranja {
        if (!listaAnimales.contains(a)) {
            listaAnimales.add(a);
            System.out.println("Registrado animal con el id: " + a.getId());
        } else {
            throw new ExceptionGranja("Animal con id: " + a.getId() + " ya registrado");
        }
    }

    public void delAnimal(int id) throws ExceptionGranja {
        if (listaAnimales.removeIf(animal -> animal.getId() == id)) {
            System.out.println("Eliminado el id: " + id);
        } else {
            throw new ExceptionGranja("Animal con id: " + id + " no exíste");
        }
    }

    public void alimentarAnimal(int id) throws ExceptionGranja {
        //Me genera un optional, a causa de que dem devuelva un null el flujo.
        Optional<Animal> aOPtion = listaAnimales.stream().filter(animal -> animal.getId() == id).findFirst();
        if (aOPtion.isPresent()) { //si, optional tiene valor...
            Animal a = aOPtion.get();
            a.registrarAlimentacion();
        } else {
            throw new ExceptionGranja("Animal con id: " + id + " no existe");
        }
    }

    public void analizarEstadoSaludAnimal(int id) throws ExceptionGranja {
        Optional<Animal> aOPtion = listaAnimales.stream().filter(animal -> animal.getId() == id).findFirst();
        if (aOPtion.isPresent()) { //si, optional tiene valor...
            Animal a = aOPtion.get();
            a.registrarComporbacionSalud();
        } else {
            throw new ExceptionGranja("Animal con id: " + id + " no existe");
        }
    }

    public void addProducto(Producto p) throws ExceptionGranja {
        if (!listaProductos.contains(p)) {
            listaProductos.add(p);
            System.out.println("Producto añadido.");
        } else {
            throw new ExceptionGranja("El producto " + p.getNombre() + " ya existe");
        }
    }

    public void addTransacion(Producto p, int cantidad) throws ExceptionGranja {
        if (!listaProductos.contains(p)) throw new ExceptionGranja("El producto no encontrado");
        subtractStockProducto(p, cantidad);// en caso de que la cantidad sea mayor al stock el método lanza una Exception
        registroTransaciones.add(new Transacion(p, cantidad));
        System.out.println("Transición registrada.");
    }

    public void sumStockProducto(Producto p, int cantidad) throws ExceptionGranja {
        if (listaProductos.contains(p)) {
            p.setStock(cantidad);
        } else {
            throw new ExceptionGranja("El producto no existe, debes crear lo antes");
        }
    }

    public boolean subtractStockProducto(Producto p, int cantidad) throws ExceptionGranja {
        boolean realizado = false;
        if (!listaProductos.contains(p)) throw new ExceptionGranja("El producto no existe, debes crear lo antes");
        if (cantidad > p.getStock()) throw new ExceptionGranja("No tenemos suficiente stock " + p.getStock());
        p.setStock(p.getStock() - cantidad);
        return realizado = true;
    }

    public List<Producto> listarProductosDisponibles() {
       return listaProductos.stream().filter(producto -> producto.getStock() > 0).toList();
    }
    public List<Producto> listarProductos() {
       return listaProductos.stream().toList();
    }

    public void listarAnimales() {
        listaAnimales.stream().forEach(System.out::println);
    }

    public Producto extraerProducto(String nombre, EProductos tipo) throws ExceptionGranja {
        Optional<Producto> oPcional = listaProductos.stream().filter(producto -> producto.getNombre().equalsIgnoreCase(nombre) && producto.getTipoProducto().equals(tipo)).findFirst();

        if (oPcional.isEmpty()) throw new ExceptionGranja("No tenenemos el producto");
        return oPcional.get();
    }

   /* public String[] productosDisponibles(){
        return (String[]) listaProductos.stream().filter(producto -> producto.getStock()>0).map(producto -> producto.getNombre()).toArray();
    }*/
}
