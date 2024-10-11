package boletin_Matriz;

/*1. Crea un método que compruebe si en una matriz hay algún valor negativo, y devuelva un
        valor booleano*/


public class Ejer_1 {

    public static void main(String[] args) {

        int[][] matriz = {{1, 3, 4}, {2, 5, 4}, {-2, 4, 5}
        };

        System.out.println(thereIsNegative(matriz));


    }

    public static boolean thereIsNegative(int[][] mNegativo) {

        boolean exitLoop = true;
        for (int i = 0; i < mNegativo.length && exitLoop; i++) {
            for (int j = 0; j < mNegativo.length && exitLoop; j++) {

                if (mNegativo[i][j] < 0) {
                    exitLoop = false;
                }
            }
        }

        return (!exitLoop);
    }
}
