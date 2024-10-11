package boletin_Matriz;

/*10. Crea un método que compruebe si una matriz pasada por parámetro es simétrica en
        función del eje Y. Es decir, la matriz
        1 3 0 3 1
        4 2 7 2 4
        6 1 9 1 6
        0 8 8 8 0*/
public class Ejer_10 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 0, 3, 1},
                {4, 2, 7, 2, 4},
                {6, 1, 9, 1, 6},
                {0, 8, 8, 8, 0}};

        System.out.println(invertMatrizY(matrix));
    }

    public static boolean invertMatrizY(int[][] m) {

        boolean isSymmetric = true;

        for (int i = 0; i < m.length && isSymmetric; i++) {

            for (int j = 0; j < m[i].length/2 && isSymmetric; j++) {

                if (m[i][j] != m[i][m[i].length-1-j]) {
                    isSymmetric = false;
                }

            }

        }
        return isSymmetric;
    }
}