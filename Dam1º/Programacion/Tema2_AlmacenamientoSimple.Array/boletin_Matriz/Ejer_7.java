package boletin_Matriz;
/*7.Crea un método que reciba dos matrices,y compruebe si son exactamente iguales.*/

public class Ejer_7 {


    public static void main(String[] args) {
        int[][] matrizA = {{1, 3, 5}, {0, 2, 7}
        };

        int[][] matrizB = {{1, 3, 5}, {0, 2, 7}
        };

        System.out.println(sameMatriz(matrizA, matrizB));
    }

    public static boolean sameMatriz(int[][] mA, int[][] mB) {

        /*boolean same = true;

        if (mA.length == mB.length && mA[0].length == mB[0].length) {

            for (int i = 0; i < mA.length && same; i++) {
                for (int j = 0; j < mA[i].length && same; j++) {

                    if (mA[i][j] != mB[i][j]) {
                        same = false;
                    }
                }
            }

        } else {
            same = false;
        }
        return same;*/

        boolean same = mA.length == mB.length;

            for (int i = 0; i < mA.length && same; i++) {

                same = mA[0].length == mB[0].length;

                for (int j = 0; j < mA[i].length && same; j++) {

                    if (mA[i][j] != mB[i][j]) {
                        same = false;
                    }
                }
            }

        return same;




    }
}
