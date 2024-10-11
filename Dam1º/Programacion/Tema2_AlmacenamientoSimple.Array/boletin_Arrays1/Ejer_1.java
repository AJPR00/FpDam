package boletin_Arrays1;
/*1. Crea un programa que sume todas las posiciones pares de un array de enteros.*/
public class Ejer_1 {

    public static void main(String[] args) {

        int[] posicionesPares = new int[50];


        for (int i = 0; i <= posicionesPares.length - 1; i++) {     // posicionesPares.length"-1" para escribir sobre el bloque de 0-99, 100 casillas.

            posicionesPares[i] = i + 1;                             //+1 para que empiece desde el 1

            if (posicionesPares[i] % 2 == 0) {
                System.out.println(posicionesPares[i]);
            }
        }

    }
}
