package boletin_Arrays1;


/*9. Modifica el método anterior y acepta un parámetro “reverse”, que indique si el array
        debe devolverse ordenado de menor a mayor o al revés.*/


import java.util.Arrays;
import java.util.Scanner;

public class Ejer_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char caracterBuscar;
        char respuestaInvertir;
        boolean invertir = false;

        char[] arrayABC = {'_', '_', 'B', 'C', 'D', '_', 'F', 'G', 'H', '_', 'J', 'K', '_', 'M', 'N', 'Ñ', '_', 'P', 'Q', 'R', 'S', 'T', '_', 'V', 'W', 'X', 'Y', 'Z'};
        System.out.println(Arrays.toString(arrayABC) + "\n");// El metodo Arrays.toString() imprime el contenido de la ArrayABC como una cadena de texto.

        do {

            System.out.println("Introduce una letra del ABC para saber si tiene alguna posición asociada a ella:");
            caracterBuscar = sc.next().toUpperCase().charAt(0);   //convierte todo a mayúscula

        } while (caracterBuscar < 'A' || caracterBuscar > 'Z'); // La validación se calcula atraves de el código ASCII


        do {
            System.out.println("Quieres invertir la Array Y (Si) o N (No)?");
            respuestaInvertir = sc.next().toUpperCase().charAt(0);

            if(respuestaInvertir != 'S' && respuestaInvertir != 'N'){
                System.out.println("         \"Respuesta inválida\"");
            }
        } while (respuestaInvertir != 'S' && respuestaInvertir != 'N');


        if (respuestaInvertir == 'S') {
            invertir = true;
        }


        int posicion = posicionAbc(caracterBuscar, arrayABC, invertir);

        System.out.println(Arrays.toString(arrayABC));

        if (posicion == -1) {
            System.out.println("\nEl valor introducido no tiene asociado ninguna posición.");
        } else {
            System.out.printf("\nEl valor introducido tiene asosciado la posción \"%d\".", posicion); //   Añadir comillas en una String \" texto \"
        }

    }

    public static int posicionAbc(char abc, char[] recorrer, boolean reverse) {

        int num = -1;


        if (reverse) {
            Arrays.sort(recorrer);
        }


        for (int i = 0; i < recorrer.length; i++) {

            if (recorrer[i] == abc) {
                num = i;
                break;
            }
        }


        return num;
    }


}