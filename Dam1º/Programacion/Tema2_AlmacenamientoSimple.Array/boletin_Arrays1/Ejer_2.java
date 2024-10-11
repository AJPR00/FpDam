package boletin_Arrays1;

/*2. Crea un programa que detecte cuántos números negativos hay en un array de
        enteros.*/

public class Ejer_2 {

    public static void main(String[] args) {

        int[] array = new int[100];
        int contadorNegativo = 0;

        for (int i = 0; i <= array.length - 1; i++) {

            array[i] = (int) (Math.random() * 100) - 50;

            if (array[i] < 0) {

                contadorNegativo++;

            }
        }
        System.out.printf("La Array contiene %d números negativos", contadorNegativo);
    }
}