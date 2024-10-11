package boletin_Arrays1;

/*6. Crea un programa que compruebe si un array contiene un determinado valor. Para
        ello, puedes pedir por parámetros el tamaño del array, los elementos y luego el
        elemento a buscar, o puedes generar el array aleatorio y pedir únicamente el
        elemento a buscar.*/

import java.util.Scanner;
public class Ejer_6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] array = {"Rojo", "Negro", "Amarillo", "Azul", "Blanco", "Verde"};

        System.out.println("Dime un color para saber si lo tengo almacenado:");
        String colorIn = sc.nextLine();
        boolean stok = false;


//For mas eficiente pra buscar en ArrayS

        for (String color : array) {    // "color"  es una variable (se crea en el For) que almacena el contenido de la array a la hora de comparar el valor de "colorIn"
            if (color.equalsIgnoreCase(colorIn)) {
                stok = true;
                break;
            }
        }


      /*  for (int i = 0; i < array.length; i++) {


            if (array[i].equalsIgnoreCase(colorIn)) {
                stok = true;
                break;
            }
        }*/


        if (stok) {

            System.out.printf("El color %s Si lo tengo en almacen", colorIn);

        } else {

            System.out.printf("El color %s No lo tengo en almacen", colorIn);


        }

    }
}
