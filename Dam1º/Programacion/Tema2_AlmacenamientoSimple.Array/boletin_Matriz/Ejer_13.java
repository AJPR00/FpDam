
package boletin_Matriz;
/*13.
        1 2 3 4 5     4 7 5 0 5
        6 7 8 9 0     5 6 4 9 4
        3 2 1 4 5 --> 8 8 1 8 3
        9 5 8 6 7     9 5 2 7 2
        0 9 8 5 4     0 9 3 6 1 */

public class Ejer_13 {

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {3, 2, 1, 4, 5},
                {9, 5, 8, 6, 7},
                {0, 9, 8, 5, 4}};


        int[][] resultado = downRightTopLeftMirror(matriz);

        if (isSquare(matriz)) {
            System.out.println("Es cuadrada!");

            for (int i = 0; i < matriz.length; i++) {
                System.out.println();
                for (int j = 0; j < matriz[i].length; j++) {

                    System.out.print(resultado[i][j]);;

                }
            }

        } else {
            System.out.println("No es cuadrada!");
        }

    }

    public static boolean isSquare(int[][] m) {

        boolean yesSquare = true;

        for (int i = 0; i < m.length && yesSquare; i++) {

            yesSquare = m.length == m[i].length;
        }
        return yesSquare;
    }

    public static int[][] downRightTopLeftMirror(int[][] m) {

        int[][] invertMatriz = new int[m.length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                invertMatriz[i][j] = m[m.length - 1-j][m.length-1-i];

            }
        }
        return invertMatriz;
    }
}
