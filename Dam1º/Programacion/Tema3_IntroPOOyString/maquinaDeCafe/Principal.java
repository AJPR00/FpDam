package Tema3_IntroPOOyString.maquinaDeCafe;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        MaquinaDeCafe maquinaOne = new MaquinaDeCafe();

        int opcionEscogida = 0;

        do {
            try {
                mostrarMenu();
                opcionEscogida = sc.nextInt();
                double creditoIn = 0, devolucion;

                if (opcionEscogida >= 1 && opcionEscogida <= 6) {
                    if (opcionEscogida <= 3) {
                        System.out.print("   Cuánto vas a introducir? ");
                        creditoIn = sc.nextDouble();
                    }

                    switch (opcionEscogida) {
                        // café
                        case 1:
                            devolucion = creditoIn - MaquinaDeCafe.PRECIO_CAFE;
                            if (devolucion >= 0 && devolucion <= maquinaOne.getMonedero()) {
                                if (maquinaOne.servirCafe()) {
                                    creditoIn -= devolucion;
                                    System.out.print("\n\nPreparando.");
                                    maquinaOne.cargando();
                                    System.out.println("\nProducto servido, Recoja su cambio de " + devolucion + "€\n\nGracias.");
                                } else {
                                    System.out.println("Producto no disponible");
                                }
                            } else {
                                System.out.println("Introduzca importe exacto");
                            }
                            break;
                        // Leche
                        case 2:
                            devolucion = creditoIn - MaquinaDeCafe.PRECIO_LECHE;
                            if (devolucion >= 0 && devolucion <= maquinaOne.getMonedero()) {
                                if (maquinaOne.servirLeche()) {
                                    creditoIn -= devolucion;
                                    System.out.print("\n\nPreparando.");
                                    maquinaOne.cargando();
                                    System.out.println("\nProducto servido, Recoja su cambio de " + devolucion + "€\n\nGracias.");
                                } else {
                                    System.out.println("Producto no disponible");
                                }
                            } else {
                                System.out.println("Introduzca importe exacto");
                            }
                            break;
                        // Café con leche
                        case 3:
                            devolucion = creditoIn - MaquinaDeCafe.PRECIO_CAFE_CON_LECHE;
                            if (devolucion >= 0 && devolucion <= maquinaOne.getMonedero()) {
                                if (maquinaOne.servirCafeConLeche()) {
                                    creditoIn -= devolucion;
                                    System.out.print("\n\nPreparando.");
                                    maquinaOne.cargando();
                                    System.out.println("\nProducto servido, Recoja su cambio de " + devolucion + "€\n\nGracias.");
                                } else {
                                    System.out.println("Producto no disponible");
                                }
                            } else {
                                System.out.println("Introduzca importe exacto");
                            }
                            break;
                        case 4:
                            maquinaOne.consultarEstado();
                            break;
                        case 5:
                            maquinaOne.vaciarMonedero();
                            break;
                        case 6:
                            break;
                        default:
                            throw new ExceptionMaquinaCafe();
                    }
                } else {
                    throw new ExceptionMaquinaCafe();
                }
            } catch (ExceptionMaquinaCafe e) {
                System.out.println(e.errorDigitoIn());
            }
        } while (opcionEscogida != 6);
    }

    public static void mostrarMenu() {
        System.out.print("\n\nBienvenido a la máquina de café.\n\n" +
                "   1. Servir café " + MaquinaDeCafe.PRECIO_CAFE + " €.\n" +
                "   2. Servir leche " + MaquinaDeCafe.PRECIO_LECHE + " €.\n" +
                "   3. Servir café con leche " + MaquinaDeCafe.PRECIO_CAFE_CON_LECHE + " €\n" +
                "   4. Consultar estado de la máquina.\n" +
                "   5. Recoger monedero.\n" +
                "   6. Apagar y salir.\n" +
                "   Elija una opción: ");
    }
}
