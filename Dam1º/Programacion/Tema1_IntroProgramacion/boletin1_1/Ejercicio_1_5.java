package boletin1_1;

/*  5. Realizar un programa que solicite números hasta que se introduzca un número negativo.
       Cuando termine informará de cuantos números positivos se han introducido.
       En este programa el número 0 se considera positivo. Ejemplo:

        Introduce un número (negativo para terminar): 4
        Introduce un número (negativo para terminar): 8
        Introduce un número (negativo para terminar): -2
        Has introducido 2 números positivos     */


import java.util.Scanner;

public class Ejercicio_1_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contPositivos = 0,numPos;

        do {
            System.out.print("Introduce un número (Negativo para salir): ");
            numPos = sc.nextInt();

            contPositivos++;

            sc.close();
        } while (numPos >= 0);

        contPositivos--;

        System.out.print("Has introducido " + contPositivos + " número positivos");
    }
}
