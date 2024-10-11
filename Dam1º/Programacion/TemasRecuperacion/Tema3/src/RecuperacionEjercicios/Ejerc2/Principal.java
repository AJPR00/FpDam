package RecuperacionEjercicios.Ejerc2;

import RecuperacionEjercicios.MiEntradaSalida;

public class Principal {

    private static Granja granja = new Granja("Granja tito Leonardo Da Vinci");

    public static void main(String[] args) {
        int opc;
        do {
            menu();
            opc = MiEntradaSalida.leerEntreDeRango("Seleccione una opción", 1, 6);

            try {
                switch (opc) {
                    case 1:

                        VenderProducto();
                        break;
                    case 2:
                        registrarProducto();
                        break;
                    case 3:
                        registrarAnimal();
                        break;
                    case 4:
                        listarProducto();
                        break;
                    case 5:
                        chequearSaludAnimal();
                        break;
                    case 6:
                        alimentarAnimal();
                        break;
                }
            } catch (ExceptionGranja e) {
                System.out.println(e.getMessage());
            }
        } while (!(opc == 7));

    }

    private static void alimentarAnimal() throws ExceptionGranja {
        int id = MiEntradaSalida.leerEntero("Introduzca el id del animal alimentar");
        granja.alimentarAnimal(id);
    }

    private static void chequearSaludAnimal() throws ExceptionGranja {
        int id = MiEntradaSalida.leerEntero("Introduzca el id del animal revisar su salud");
        granja.analizarEstadoSaludAnimal(id);
    }

    private static void listarProducto() throws ExceptionGranja {
        if (granja.listarProductosDisponibles().isEmpty()) throw new ExceptionGranja("No hay producto disponible");
        granja.listarProductosDisponibles().stream().forEach(System.out::println);
    }

    private static void registrarAnimal() throws ExceptionGranja {
        Animal a = new Animal((EEspecies) MiEntradaSalida.listarEnum(EEspecies.values()),
                MiEntradaSalida.leerFecha("Introduzca la fecha de nacimeinto"));
        granja.addAnimal(a);
    }

    private static void registrarProducto() throws ExceptionGranja {
        Producto p = new Producto((EProductos) MiEntradaSalida.listarEnum(EProductos.values()),
                MiEntradaSalida.leerCadena("Introduzca un nombre: "),
                MiEntradaSalida.leerEntero("Deme la cantidad de stock a registrar: "),
                MiEntradaSalida.leerDouble("Deme el precio del producto: "));
        granja.addProducto(p);
    }

    private static void VenderProducto() throws ExceptionGranja {
        listarProducto();
        EProductos tipoProducto = (EProductos) MiEntradaSalida.listarEnum(EProductos.values());
        String nombre = MiEntradaSalida.leerCadena("Deme el nombre del producto: ");
        Producto p = granja.extraerProducto(nombre, tipoProducto);
        int cantidad = MiEntradaSalida.leerEntero("Deme la cantidad a comprar: ");
        granja.addTransacion(p, cantidad);
    }

    private static void menu() {
        System.out.println("""
                                
                1· Venta producto.
                2· Registrar producto.
                3· Registrar Animal.
                4· Lista de productos en stock.
                5· Salud animal.               
                6· Alimentar animal.               
                7· Salir.               
                """);
    }
}
