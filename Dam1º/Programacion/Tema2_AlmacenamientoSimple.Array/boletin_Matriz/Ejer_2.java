package boletin_Matriz;
/*2. Crea un método que sume todas las posiciones de una matriz y devuelva dicho número.*/


public class Ejer_2 {


    public static void main(String[] args) {

        int[][] matriz = {{1, 3, 4}, {2, 5, 4}, {-2, 4, 5}
        };

        System.out.println(sumAllMatriz(matriz));

    }

    public static int sumAllMatriz(int[][] mSum) {

        int sum=0;
        for (int i = 0; i < mSum.length; i++) {
            for (int j = 0; j < mSum.length; j++) {

            sum+=mSum[i][j];

            }
        }

        return sum;
    }
}