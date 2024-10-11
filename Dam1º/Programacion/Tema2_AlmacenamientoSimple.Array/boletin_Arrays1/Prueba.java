package boletin_Arrays1;

import java.util.Arrays;
import java.util.Random;

public class Prueba {
    Random aleatorio = new Random();
    public static void main(String[] args) {

       /* int[] arrayA = {1, 2, 5, 3, 5, 4, 8};

        int contador = 0;

        // Crear un nuevo array para almacenar elementos únicos
        int[] arrayB = new int[arrayA.length];

        // Iterar sobre el arrayA para encontrar elementos únicos
        for (int i = 0; i < arrayA.length; i++) {
            boolean duplicado = false;

            // Comprobar si el elemento ya existe en arrayB
            for (int j = 0; j < contador; j++) {
                if (arrayA[i] == arrayB[j]) {
                    duplicado = true;
                    break;
                }
            }

            // Si no es un duplicado, agregarlo a arrayB y aumentar el contador
            if (!duplicado) {
                arrayB[contador] = arrayA[i];
                contador++;
            }
        }

        // Crear un nuevo array con el tamaño exacto de elementos únicos
        int[] arraySinDuplicados = Arrays.copyOf(arrayB, contador);

        // Mostrar los resultados
        System.out.println("Array original: " + Arrays.toString(arrayA));
        System.out.println("Array sin duplicados: " + contador);
    }*/
        /*char[][] matriz = new char[4][4];

        for (int i = (int)(Math.random()*4); i < matriz.length; i++) {
            for (int j =(int)(Math.random()*4); i < matriz[i].length; j++) {

                
                matriz[i][j] = (char)('A'+(int)(Math.random()*(4*4)/2));
            }

        }*/
final int TAM=4;
        char[][] matriz = new char[4][4];
        Random rand = new Random();
char letraFinal= 'A'+((4*4)/2-1);
       /* for (char letra = 'A'; letra <= letraFinal ; letra++) {
            for (int i = 0; i < 2; i++) {

                boolean asignado = false;

                while (!asignado) {

                    int fila = (int) (Math.random() * TAM);
                    int columna = (int) (Math.random() * TAM);

                    if (matriz[fila][columna] == 0) {
                        matriz[fila][columna] = letra;
                        asignado = true;
                    }
                }
            }
        }*/

        // Imprimir la matriz resultante
        for (char[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }


}
