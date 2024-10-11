package boletin_Matriz;

/*9. Crea un método que compruebe si una matriz pasada por parámetro es simétrica en
función del eje X. Es decir, la matriz
1 3 5 6
4 2 0 8
4 2 0 8
1 3 5 6
es simétrica en función de su eje X, porque si invirtiésemos el orden en el que leemos las
filas, la matriz se vería igual.
Pero la matriz
1 4 6
2 1 3
no es simétrica, pues no cumple dicha propiedad.*/

public class Ejer_9 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 6},
                {4, 2, 0, 8},
                {4, 2, 0, 8},
                {1, 3, 5, 6}};

        System.out.println(invertMatrizX(matrix));
    }

    public static boolean invertMatrizX(int[][] m) {

        boolean isSymmetric = true;

        for (int i = 0; i < m.length/2 && isSymmetric; i++) {

            for (int j = 0; j < m[i].length && isSymmetric; j++) {

                if (m[i][j] != m[m.length - 1-i][j]) {
                    isSymmetric = false;
                }

            }

        }
        return isSymmetric;
    }
}