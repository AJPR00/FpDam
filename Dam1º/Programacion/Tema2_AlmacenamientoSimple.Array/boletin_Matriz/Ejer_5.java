package boletin_Matriz;


/*5. Crea un método que reciba una matriz e imprima, en una sola línea, los elementos de la
        misma, pero leídos por columnas:

        1 3 5 --> La salida es: 1 0 3 2 5 7
        0 2 7*/
public class Ejer_5 {


    public static void main(String[] args) {
        int[][] matriz = {
                {1, 3, 5},
                {0, 2, 7}
        };

        printLineMatriz(matriz);
    }

    public static void printLineMatriz(int[][] m) {
        System.out.print("La salida es: ");

        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {

                System.out.print(m[j][i]);

            }
        }
    }
}

