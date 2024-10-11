package boletin_Arrays1;


/*10. Crea un array que devuelva un nuevo array donde se hayan eliminado los elementos
        duplicados del primero.*/


import java.util.Arrays;

public class Ejer_10 {
    public static void main(String[] args) {


        int tamanoArrayNew = 0;

        //int[] arrayA = {1,1,1,2,2,1,1};
        int[] arrayOriginal = new int[10];
        int[] arrayIntermediario = new int[arrayOriginal.length];


// for para rellenar array con números aleatrorios.
        for (int i = 0; i < arrayOriginal.length; i++) {

            arrayOriginal[i] = (int) (Math.random() * 10);

        }


// for para recorrer y comparar  los datos almacenado.
        for (int i = 0; i < arrayOriginal.length; i++) {
            boolean guardar = false;
            for (int j = 0; j < i; j++) {           // j<i para que el primer número de la array se guarde, la primera comprobación es un FASLE (0<0) de modo no realiza el bucle.

                if (arrayOriginal[i] == arrayIntermediario[j]) {
                    guardar = true;
                    break;

                }

            }

            if (!guardar) {
                arrayIntermediario[tamanoArrayNew] = arrayOriginal[i];
                tamanoArrayNew++;

            }

        }

        int[] arraySinRepetidos = new int[tamanoArrayNew]; // Creamos la array a esta altura del código para que pueda obtener el valos del tamaño.

        for (int i = 0; i < arraySinRepetidos.length; i++) {

            arraySinRepetidos[i] = arrayIntermediario[i];

        }


        System.out.println(Arrays.toString(arrayOriginal));
        System.out.println(Arrays.toString(arrayIntermediario));
        System.out.println(Arrays.toString(arraySinRepetidos));


    }
}


