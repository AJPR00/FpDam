package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc1;

import Tema3_IntroPOOyString.boletin4_1.Ejerc_2.ExeptionGestion;

import java.util.Scanner;

public class MenuCuenaCredito extends CuentaCredito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaCredito cuenta = new CuentaCredito();
        int opcion;
        menu();
        try {
            // Consumo/Limpio el \n (el espacio) que genera "opcion=sc.nextInt()" en caso de repeticion.
            //Obligo a que el primer TOKEN (lo primero que se introduce) sea un DÍGITO
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduca el saldo a ingresar");
                        if (sc.hasNextInt()) {
                            cuenta.ingresar(sc.nextDouble());
                            System.out.println("Su saldo actual es de " + cuenta.getSaldo());
                        } else {
                            System.out.println("Introduce dígitos");
                        }
                        menu();
                        break;
                    case 2:
                        if (sc.hasNextInt()) {
                            System.out.println("Introduca el saldo a retirar");
                            cuenta.retirar(sc.nextDouble());
                            System.out.println("Su saldo actual es de " + cuenta.getSaldo());
                        } else {
                            System.out.println("Introduce dígitos");
                        }
                        menu();
                        break;
                    case 3:
                        System.out.println(cuenta.toString());
                        menu();
                        break;
                    case 4:
                        System.out.println("Deseas realizar otra operación, S o N para salir ?");
                        char sN = Character.toUpperCase(sc.next().charAt(0));
                        if (sN == 'S' || sN == 'N') {
                            if (sN == 'S') {
                                menu();
                                System.out.println("S");
                            } else if (sN == 'N') {
                                System.out.println("Gracias por su visita, su saldo actual es de " + cuenta.getSaldo());
                            }
                        } else {
                            System.out.println("Has introducido un caracter incorrecto");
                        }
                        break;
                    default:
                        throw new CuentaException("Opcion erronea");
                }

            } else {
                System.out.println("Opción Inválida");
                menu();
            }
        } catch (CuentaException e) {
            System.out.println("Opción Inválida Exception");
            menu();
        }
    }

    public static void menu() {
        System.out.println("Bienvenido a su cuenta, seleccione la operacion a realizar");
        System.out.println("1. Ingresar dinero");
        System.out.println("2. Sacar dinero");
        System.out.println("3. Consulta saldo y crédito");
        System.out.println("4. Salir\n");
    }
}
