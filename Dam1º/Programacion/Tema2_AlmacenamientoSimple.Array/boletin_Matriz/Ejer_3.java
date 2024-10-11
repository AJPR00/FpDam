package boletin_Matriz;
/*
3. Crea un método que reciba una matriz e imprima, en una sola línea, los elementos de la
        misma, leídos por filas:
        1 3 5 --> La salida es: 1 3 5 0 2 7
        0 2 7
*/

public class Ejer_3 {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 3, 5}, {0, 2, 7}
        };

        printLineMatriz(matriz);
    }

    public static void printLineMatriz(int[][] m) {
        System.out.print("La salida es: ");

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                System.out.print(m[i][j]);

            }
        }

    }

}
