package boletin1_3;

/*10. Realizar un programa que lea un carácter y dos números enteros por
        teclado. Si el carácter leído es un operador aritmético, calcular la operación
        correspondiente, si es cualquier otro debe mostrar un error*/

import java.util.Scanner;
public class Ejer_10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean repetir;

        String entradaA, entradaB;


        do {
            System.out.print("Introduce un operador aritmético y dos número:");


            entradaA = sc.nextLine();
            entradaB = sc.nextLine();

            if (entradaA.matches("\\d+") && entradaB.matches("\\d+")) {

                repetir = false;

            } else {
                System.out.println("Introduca solo dígitos numericos. o_O");
                repetir = true;
            }
        } while (repetir);


        int numA = Integer.parseInt(entradaA);
        int numB = Integer.parseInt(entradaB);


        if (numA > numB) {
            System.out.print(numA + " es mayor que " + numB);

        } else if (numA < numB) {

            System.out.print(numA + " es menor que " + numB);

        } else {
            System.out.print(numA + " y " + numB + " son igules.");
        }


    }

}