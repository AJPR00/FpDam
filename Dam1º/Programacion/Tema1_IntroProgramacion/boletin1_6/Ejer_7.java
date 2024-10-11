package boletin1_6;

import java.util.Scanner;

/*7. Realizar un programa que solicite dos números enteros mayores que 0, que
        calcule el máximo común divisor entre ellos mediante el algoritmo de
        Euclides y que muestre por pantalla el resultado.
        El algoritmo de Euclides se explica a continuación con un ejemplo:
        Supongamos que queremos calcular el m.c.d de 120 y 54

        120a : 54b = 2 y resto 12c
        54 : 12 = 4 y resto 6
        12: 6 = 2 y resto 0
        El m.c.d. de 120 y 54 es 6*/

public class Ejer_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int numA, numB, numC = 0;



        do {
            System.out.println("Introduce dos números para sacar el Máximo Divisor Común");

            numA = Integer.parseInt(sc.nextLine());
            numB = Integer.parseInt(sc.nextLine());

        } while (numA <= 0 || numB <= 0);


        comunPrimo(numA, numB);


        /*do {
            System.out.println("Introduce dos números para sacar el Máximo Divisor Común");

            numA = Integer.parseInt(sc.nextLine());
            numB = Integer.parseInt(sc.nextLine());

        } while (numA <= 0 || numB <= 0);

        if (numA > numB) {


            do {
                numC = numA % numB;
                numA = numB;
                numB = numC;
            } while (numC != 0);


            if (numC == 0) {
                System.out.printf("El máximo común divisor es %d", numA);

            }
        }*/

    }


    public static int comunPrimo(int numA, int numB) {

        int numC=0;

        if (numA > numB) {

            do {
                numC = numA % numB;
                numA = numB;
                numB = numC;
            } while (numC != 0);



        }

        if (numC == 0);


        return numC;
    }
}