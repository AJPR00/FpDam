package boletin_Matriz;
/*8. Crea un método que reciba dos matrices, que deben ser de igual tamaño, y sume el
        contenido de las posiciones en una tercera matriz, que será la que devuelva:
        | 1 2| + | 4 1| = | 5 3|
        | 4 6| | 1 0| | 5 6|*/

import java.util.Arrays;

public class Ejer_8 {

    public static void main(String[] args) {
        int[][] matrizA = {{1, 3, 5}, {0, 2, 7}};
        int[][] matrizB = {{5, 3, 2}, {0, 9, 5}};

        sumMatriz(matrizA, matrizB);

        System.out.print(Arrays.toString(matrizA[0]) +" + "+ Arrays.toString(matrizB[0]) + " = " + (Arrays.toString(sumMatriz(matrizA, matrizB)[0])));
        System.out.print(Arrays.toString(matrizA[1]) +" + "+ Arrays.toString(matrizB[1]) + " = " + (Arrays.toString(sumMatriz(matrizA, matrizB)[1])));

    }

    public static int[][] sumMatriz(int[][] mA, int[][] mB) {

        int[][] sumMatrices = new int[mA.length][mA[0].length];

        for (int i = 0; i < mA.length; i++) {
            System.out.println();
            for (int j = 0; j < mA[i].length; j++) {

                sumMatrices[i][j] = mA[i][j] + mB[i][j];


            }

        }
        return sumMatrices;
    }
}