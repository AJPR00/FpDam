package boletin_Arrays1;
/*
7. Crea un método contieneElemento, que acepte un array de enteros y un entero a
        buscar, que realice la misma operación que el ejercicio anterior, y devuelva un valor
        booleano que indique si el array contiene el elemento o no.*/

import java.util.Scanner;

public class Ejer_7 {
    static Scanner sc = new Scanner(System.in);
    static String colorIn;
    static boolean stok = false;

    public static void main(String[] args) {

        String[] array = {"Rojo", "Negro", "Amarillo", "Azul", "Blanco", "Verde"};

        System.out.println("Dime un color para saber si lo tengo almacenado:");
        colorIn = sc.nextLine();

        contieneElemento(array, colorIn);

        if (stok){
            System.out.printf("El color %s Si lo tengo en almacen", colorIn);
        } else {
            System.out.printf("El color %s No lo tengo en almacen", colorIn);
        }
    }

    public static boolean contieneElemento(String[] array, String colorEntrdaParametro) {
//For mas eficiente pra buscar en ArrayS

        for (String color : array) {    // "color"  es una variable (se crea en el For) que almacena el contenido de la array a la hora de comparar el valor de "colorIn"
            if (color.equalsIgnoreCase(colorEntrdaParametro)) {
                stok = true;
                break;
            }
        }        return stok;
    }


}
