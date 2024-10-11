package Tema3_IntroPOOyString.boletin4_1.Ejerc_2;

import java.util.Scanner;

public class Cuenta {
    public Scanner sc = new Scanner(System.in);

    private double saldo;
    private double myWallet;

    private int movementInMoney;
    private int movemntOutMoney;

    public Cuenta() {
        menuWelcome();

    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void reitegro(double saldoRetirar) {

        if (saldoRetirar <= saldo) {
            saldo -= saldoRetirar;
            myWallet += saldoRetirar;
            movemntOutMoney++;

        } else {
            System.out.println("Saldo insuficiente para retirar");
        }
    }

    public void ingreso(double saldoIngresar) {

        saldo += saldoIngresar;
        movementInMoney++;

    }

    public void menuWelcome() {
        boolean repit = true;
        do {

            System.out.println("Introduce tu saldo inicial");

            try {
                if (sc.hasNextDouble()) {
                    saldo = sc.nextDouble();
                    repit = false;
                } else {
                    throw new ExeptionGestion();
                }

            } catch (ExeptionGestion e) {

                System.out.println("Introduzca solo dígitos");
                sc.next();
            }
        } while (repit);
    }


    public void menu() {
        int opcion;


        System.out.println("Selecione la operacion a realizar");
        System.out.println("1. Reintego");
        System.out.println("2. Ingreso");
        System.out.println("3. Consulta");
        System.out.println("4. Salir\n");


        try {
            // Consumo/Limpio el \n (el espacio) que genera "opcion=sc.nextInt()" en caso de repeticion.
            sc.nextLine();

            //Obligo a que el primer TOKEN (lo primero que se introduce) sea un DÍGITO
            if (sc.hasNextInt()) {

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Introduca el saldo a retirar");

                        if (sc.hasNextInt()) {
                            reitegro(sc.nextDouble());
                            System.out.println("Su saldo actual es de " + saldo);

                        } else {
                            System.out.println("Introduce dígitos");
                        }
                        menu();
                        break;


                    case 2:

                        if (sc.hasNextInt()) {
                            System.out.println("Introduca el saldo a ingresar");
                            ingreso(sc.nextDouble());
                            System.out.println("Su saldo actual es de " + saldo);
                        } else {
                            System.out.println("Introduce dígitos");
                        }
                        menu();
                        break;

                    case 3:
                        System.out.println(toString());
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

                                System.out.println("Gracias por su visita, su saldo actual es de " + saldo);

                            }
                        } else {
                            System.out.println("Has introducido un caracter incorrecto");
                        }


                        break;
                    default:
                        throw new ExeptionGestion();
                }


            } else {
                System.out.println("Opción Inválida");
                menu();
            }
        } catch (ExeptionGestion erroSwitch) {

            System.out.println("Opción Inválida Exception");
            menu();

        }


    }

    @Override
    public String toString() {
        return "saldo: " + saldo +
                "\nMy Wallet: " + myWallet +
                "\nNúmero de movimientos de ingresos: " + movementInMoney +
                "\nNúmero de movimientos de retiradas: " + movemntOutMoney;
    }
}
