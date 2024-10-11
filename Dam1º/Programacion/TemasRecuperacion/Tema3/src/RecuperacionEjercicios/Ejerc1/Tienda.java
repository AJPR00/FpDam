package RecuperacionEjercicios.Ejerc1;

import java.util.ArrayList;

public class Tienda {
    private String nombre;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Compra> registroCompras;
    private ArrayList<Mascota> listaMascotas;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.listaClientes = new ArrayList<>();
        this.registroCompras = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
    }

    /**
     * En caso de que sea una salida, la mascota adquiere el valor de no disponible
     * quedando asi su registro,
     *
     * @param m
     */
    public void addMascota(Mascota m) {
        listaMascotas.add(m);
    }


    //Si selecciona la mascota , significa que la compra, La mascota pasa a no disponible
    public void addCliente(Cliente c) {
        listaClientes.add(c);
    }

    public void addCompra(Compra c) {
        registroCompras.add(c);
    }

    public Mascota selecMascota(int id) {
        return listaMascotas.get(id);
    }

    public Cliente selecCliente(int id) {
        return listaClientes.get(id);
    }

    public Compra selecCompra(int id) {
        return registroCompras.get(id);
    }

    /**
     * Si es devuelto, el valor de disponibilidad de la mascota pasa a ser true (Disponible)
     *
     * @param m
     */
    public void devolucionMascota(Mascota m, Cliente c) {
        c.devolucionMascota(m);
        m.setDisponible(true);

    }

    public void compraMascota(Mascota m, Cliente c) {
        if (listaClientes.contains(c)) {
            m.setDisponible(false);
            c.addMascota(m);
        } else {
            System.out.println("Cliente no reconocido, acceda al registro");
        }
    }

    public void listarMascotas() throws ExcepcionTiendaMascota {
        if (listaClientes.isEmpty()) throw new ExcepcionTiendaMascota("No hay mascota que mostrar");
        listaMascotas.stream().filter(Mascota::isDisponible).forEach(System.out::println);
       /* for (Mascota m : listaMascotas) {
            if (m.isDisponible()){
            System.out.println(m.toString());}
        }*/
    }

    public void listarClientes() {
        for (Cliente c : listaClientes) {
            System.out.println(c.toString());
        }
    }

    public void listarMascotaDelCliente(Cliente c) {
        c.listarMascotas();
    }

    public void listarCompras() {
        for (Compra c : registroCompras) {
            System.out.println(c.toString());
        }
    }

    public int getListaClientesSize() {
        return listaClientes.size();
    }

    public int getListaMascotasSize() {
        return listaMascotas.size();

    }

    public int getListaCompraSize() {
        return registroCompras.size();
    }
}



