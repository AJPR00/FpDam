package boletin_Arrays1;

import java.util.Scanner;

/*3. Crea un programa que pregunte cuántos elementos tendremos en un array de
        enteros. Posteriormente se preguntarán tantos números como haya indicado el
        usuario. Posteriormente, mostraremos por pantalla el mayor, el menor y la media. Si
        el número mayor o menor están repetidos, deberá indicarse cuántas veces se repite.

        Por ejemplo:

        Introduzca las posiciones que tendrá el array: 5
        Introduzca el número 1: 4
        Introduzca el número 2: -1
        Introduzca el número 3: 9
        Introduzca el número 4: 5
        Introduzca el número 5: 9
        El mayor número introducido es 9 (se repite 2 veces)
        El menor número introducido es -1
        La media de los números introducidos es: 5.2*/
public class Ejer_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Introduzca las posiciones que tendrá el array: ");
        int capacidadArrays = Integer.parseInt(sc.nextLine());

        int[] array = new int[capacidadArrays];

        int numMayor = Integer.MIN_VALUE, numMenor = Integer.MAX_VALUE, contadorMayor = 0, sumaValores = 0;

// for para rellenar array

        for (int i = 0; i <= array.length - 1; i++) {

            System.out.printf("Introduzca el número  de la posición %d : ", i + 1);
            array[i] = Integer.parseInt(sc.nextLine());

        }
//***************************************************************
        for (int i = 0; i <= array.length - 1; i++) {

            //System.out.print(array[i] + ", ");


            if (array[i] >= numMayor) {

                numMayor = array[i];

            }

            if (array[i] < numMenor) {

                numMenor = array[i];
            }

            sumaValores += array[i];

        }

        for (int i = 0; i <= array.length - 1; i++){

            if (numMayor == array[i]) {
                contadorMayor++;
            }
        }


        System.out.printf("\n El mayor número introducido es %d (se repite %d veces).", numMayor, contadorMayor);
        System.out.printf("\n El menor número introducido es %d.", numMenor);
        System.out.printf("La media de los números introducidos es:%.2f.",(double) sumaValores/array.length);


    }

}
