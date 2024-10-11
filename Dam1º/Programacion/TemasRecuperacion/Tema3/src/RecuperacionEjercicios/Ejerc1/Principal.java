package RecuperacionEjercicios.Ejerc1;

import RecuperacionEjercicios.MiEntradaSalida;

import java.lang.ref.Cleaner;

public class Principal {

    private static Tienda t1 = new Tienda("Monster Enimel");

    public static void main(String[] args) {
        t1.addCliente(new Cliente("Antonio"));
        t1.addCliente(new Cliente("Victoria"));
        t1.addMascota(new Mascota("huecules", Especies.GATO, 5, 2.5));
        t1.addMascota(new Mascota("cirius", Especies.PERRO, 5, 2.5));
        t1.addMascota(new Mascota("Pistoli", Especies.AVE, 5, 2.5));
        int opc;

        do {
            menu();
            opc = MiEntradaSalida.leerEntreDeRango("Seleccione una opción", 1, 6);

            try {
                switch (opc) {
                    case 1:
                        comprarMascota();
                        break;
                    case 2:
                        registrarCliente();
                        break;
                    case 3:
                        listarMascotasDisponible();
                        break;
                    case 4:
                        registrarMascota();
                        break;
                    case 5:
                        devolverMascota();
                        break;
                }
            } catch (ExcepcionTiendaMascota e) {
                System.out.println(e.getMessage());
            }
        } while (!(opc == 6));
    }

    private static void registrarMascota() {
        Mascota m = new Mascota(
                MiEntradaSalida.leerCadena("Nombre de la mascota: ").toUpperCase(),
                listarTipoMascotas(),
                MiEntradaSalida.leerEntero("Edad: "),
                MiEntradaSalida.leerDouble("Precio: "));
        t1.addMascota(m);
    }

    private static void registrarCliente() {
        Cliente c = new Cliente(MiEntradaSalida.leerCadena("Introduzca el nombre del cliente: "));
        t1.addCliente(c);
    }

    private static void comprarMascota() throws ExcepcionTiendaMascota {
        if (t1.getListaMascotasSize() > 0) {// En caso deque la lista sea de tamaño 0 significa que no hay mascotas
            System.out.println("Lista de Clientes: ");
            t1.listarClientes();
            int idCliente = MiEntradaSalida.leerEntreDeRango("Introduzca el id del cliente", 1, t1.getListaClientesSize());
            Cliente cliente = t1.selecCliente(idCliente - 1);

            System.out.println("Lista de Mascotas: ");
            t1.listarMascotas();
            int idMascota = MiEntradaSalida.leerEntreDeRango("Introduzca el id de la mascota", 1, t1.getListaMascotasSize());
            Mascota mascota = t1.selecMascota(idMascota - 1);

            if (!mascota.isDisponible()) throw new ExcepcionTiendaMascota("La mascota seleccionada no esta disponible");
            Compra c1 = new Compra(cliente, mascota);
            t1.compraMascota(mascota, cliente);
            t1.addCompra(c1);
        } else {
            System.out.println("Ló siento,nos quedamos sin mascotas");
        }
    }

    private static void devolverMascota() throws ExcepcionTiendaMascota {
        if (t1.getListaCompraSize() <= 0) throw new ExcepcionTiendaMascota("No hay compras registrada");
        System.err.println("Compras:");
        t1.listarCompras();
        int idCompra = MiEntradaSalida.leerEntreDeRango("Introduzca número de tiket", 1, t1.getListaClientesSize());

       /* Compra compra = t1.selecCompra(idCompra);
        compra.getMascota().setDisponible(true);*/

        Compra compra = t1.selecCompra(idCompra);
        Mascota mascota = compra.getMascota();
        Cliente cliente = compra.getCliente();
        t1.devolucionMascota(mascota, cliente);
    }

    private static void listarMascotasDisponible() throws ExcepcionTiendaMascota {
        System.out.println("Lista de mascotas Disponibles: ");
        t1.listarMascotas();
    }

    /**
     * Lista los tipos de Mascota
     *
     * @return
     */
    private static Especies listarTipoMascotas() {

        for (int i = 0; i < Especies.values().length; i++) {
            System.out.println(i + 1 + "# " + Especies.values()[i].toString());
        }
        return Especies.values()[MiEntradaSalida.leerEntreDeRango("Selecione la especie de mascota", 1, Especies.values().length) - 1];
    }

    private static void menu() {
        System.out.println("""
                                
                1· Venta.
                2· Alta Cliente.
                3· Listar Mascotas (disponible).
                4· Alta Mascota.
                5· Devolución.               
                6· Salir.               
                """);
    }
}
