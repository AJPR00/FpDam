package boletin_Arrays1;

import java.util.Arrays;
import java.util.Scanner;

/*8. Crea un método que devuelva la posición que ocupa un valor dentro de un array, o
        -1 si el array no contiene ese valor*/
public class Ejer_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        char[] array = {'_', '_', 'B', 'C', 'D', '_', 'F', 'G', 'H', '_', 'J', 'K', '_', 'M', 'N', 'Ñ', '_', 'P', 'Q', 'R', 'S', 'T', '_', 'V', 'W', 'X', 'Y', 'Z' };
        System.out.println(Arrays.toString(array) + "\n");
        char caracterBuscar;


        System.out.println("Introduce una letra del ABC para saber si tiene alguna posición asociada a ella");
        caracterBuscar = sc.next().toUpperCase().charAt(0);   //convierte todo a mayúscula


        int posicion = posicionAbc(caracterBuscar, array);






       /* while (true) {
            System.out.print("Introduce una letra del ABC para saber si tiene alguna posición asociada a ella: ");
            String input = sc.next().toUpperCase(); // Convierte a mayúsculas

            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') {
                caracterBuscar = input.charAt(0);
                break; // Sale del bucle si la entrada es válida
            } else {
                System.out.println("Entrada no válida. Por favor, introduce una letra del ABC.");
            }
        }
        */


        if (posicion == -1) {

            System.out.println("El valor introducido no tiene asociado ninguna posición");
        } else {
            System.out.printf("El valor introducido tiene asosciado la posción %d", posicion);
        }

    }

    public static int posicionAbc(char abc, char[] recorrer) {

        int num = -1;

        for (int i = 0; i < recorrer.length; i++) {

            if (recorrer[i] == abc) {
                num = i;
                break;
            }
        }

        return num;
    }


}
