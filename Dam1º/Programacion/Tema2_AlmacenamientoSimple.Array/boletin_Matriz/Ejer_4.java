package boletin_Matriz;
/*
4. Crea un método que reciba una matriz e imprima, en una sola línea, los elementos de la
        misma, leídos por filas, empezando por los últimos índices:
        1 3 5 --> La salida es: 7 2 0 5 3 1
        0 2 7
*/

public class Ejer_4 {

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 3, 5}, {0, 2, 7}
        };

        printLineMatriz(matriz);
    }

    public static void printLineMatriz(int[][] m) {
        System.out.print("La salida es: ");

        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = m[i].length - 1; j >= 0; j--) {

                System.out.print(m[i][j]);

            }
        }
    }
}