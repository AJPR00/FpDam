package boletin1_3;

import java.util.Scanner;

public class Ejer_2 {

    /*2. Realizar un programa que solicite dos números por teclado e imprima en
    pantalla si son iguales, el primero mayor que el segundo o el primero más
    pequeño que el segundo.*/


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean repetir;

        String entradaA, entradaB;


        do {
            System.out.print("Introduce dos número para saber si es uno mayor o iguales: ");
            entradaA = sc.nextLine();
            entradaB = sc.nextLine();

            if (entradaA.matches("\\d+") && entradaB.matches("\\d+")) {

                repetir=false;

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
