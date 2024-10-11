package ejer6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static int contadorClientes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Integer user = 1;
        Integer user2 = 2;
        Integer user3 = 3;
        Integer user4 = 4;
        Integer user5 = 5;
        Almacen almacen1 = new Almacen();
        almacen1.getCajasDisponible()[0].getCola().add(user);
        almacen1.getCajasDisponible()[0].getCola().add(user2);
        almacen1.getCajasDisponible()[0].getCola().add(user3);
        almacen1.getCajasDisponible()[0].getCola().add(user4);
        almacen1.getCajasDisponible()[0].getCola().add(user5);


        do {
            System.out.println(menu());
            opcion = sc.nextInt();
            int numCaja;
            try {
                switch (opcion) {
                    case 1:
                        sc.nextLine();
                        System.out.println(almacen1);
                        System.out.println("Dime cual caja quieres ABRIR");
                        numCaja = sc.nextInt();
                        almacen1.abrirCaja(almacen1, numCaja);
                        System.out.println(almacen1.toString());
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Dime cual caja quieres CERRAR");
                        numCaja = sc.nextInt();
                        almacen1.cerrarCaja(almacen1, numCaja);
                        break;
                    case 3:
                        int cajaDisponible = almacen1.cajaLiviana(almacen1);
                        almacen1.getCajasDisponible()[cajaDisponible].nuevoClienteCola(almacen1.nuevoCliente());
                        System.out.println("Es usted el cliente número " + almacen1.nuevoCliente().intValue());
                        //esperando(".");
                        System.out.println(" debes de ir a la caja " + cajaDisponible);
                        break;
                    case 4:
                        System.out.println("Dime cual caja quieres atender");
                        numCaja = sc.nextInt();
                        almacen1.atenderCliente(almacen1, numCaja);
                        System.out.print("Atendiendo");
                        almacen1.esperando(".");
                        System.out.println("\nSe ha atendido al cliente con número "+almacen1.getCajasDisponible()[numCaja-1].getCola().peek());

                        break;
                }
            } catch (ExcepcionCaja e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException ex) {
                System.out.println("Opción incorrecta");
            } catch (InterruptedException e) {
                System.out.println("Cola interrumpida");
            }
        } while (opcion != 5);

        //  System.out.println(almacen1.toString());
    }

    private static String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("¿Qué deseas hacer?").append(System.lineSeparator())
                .append("1. Abrir Caja").append(System.lineSeparator())
                .append("2. Cerrar Caja").append(System.lineSeparator())
                .append("3. Nuevo Cliente").append(System.lineSeparator())
                .append("4. Atender Cliente").append(System.lineSeparator())
                .append("5. Salir").append(System.lineSeparator())
                .append("Introduce un número: ");
        return sb.toString();
    }



}
