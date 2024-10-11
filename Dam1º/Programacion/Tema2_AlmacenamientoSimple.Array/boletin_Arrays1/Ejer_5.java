package boletin_Arrays1;

/*5. Crea un método, que acepte un parámetro “tamaño” de tipo entero, que genere un
        array de “tamaño” posiciones de números aleatorios de 0 a 1000 y lo muestre por
        pantalla.*/


import java.util.Scanner;

public class Ejer_5 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Dame el tamaño de la Array");
        int numVeces = sc.nextInt();

        int[] arrayAleatorio = generaArray(numVeces);


        for (int i = 0; i <= arrayAleatorio.length - 1; i++) {

            System.out.println(arrayAleatorio[i]);
        }

    }

    //METODO Array

    public static int[] generaArray(int tamano) {

        int[] array = new int[tamano];

        for (int i = 0; i <= array.length - 1; i++) {

            array[i] = (int) (Math.random() * 1000);
        }


        return array;
    }
}
