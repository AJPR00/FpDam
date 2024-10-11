package boletin1_6;


/*2. Realizar un programa que solicite dos números, base y exponente, enteros
        positivos (incluido el 0), y que calcule la potencia (base elevado a
        exponente) a través de productos. Si los datos son incorrectos deberán
        volverse a solicitar.*/

import java.util.Scanner;

public class Ejer_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int exp;
        int base;
        int resultado = 1;

        System.out.println("Introduce dos número positivos,");            System.out.print("Introduce la base:");
        base = Integer.parseInt(sc.nextLine());

        System.out.print("Introduce exponente:");
        exp = Integer.parseInt(sc.nextLine());


        do {

        } while (base<=0 && exp<=0);


        if (base == 0) {
            System.out.println("El resultado da 0");
        } else if (exp == 0) {
            System.out.println("El resultado da 1");

        } else {

            for (int i = 1; i <= exp; i++) {

                resultado *= base;

            }

            System.out.print("El resultado es: "+resultado);
        }
    }
}


