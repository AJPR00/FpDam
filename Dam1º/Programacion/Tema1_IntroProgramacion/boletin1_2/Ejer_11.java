package boletin1_2;
/*
 11.Diseña un programa que solicite al usuario su edad y un planeta(Tierra,Marte,Júpiter).
         Usa la siguiente información:en Marte,un año dura 1.88años terrestres,y en Júpiter,un
         año dura 11.86años terrestres.Calcula e imprime la edad del usuario en el planeta
         elegido.
*/

import java.util.Scanner;

public class Ejer_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad;
        String plant;


        do {
            System.out.println("Dime tú edad: ");
            edad = sc.nextInt();
            sc.nextLine();
            System.out.println("Y ahora un planeta de los siguientes: Tierra,Marte,Júpiter: ");
            plant = sc.nextLine();

        } while (edad < 0 || !(plant.equalsIgnoreCase("tierra") || plant.equalsIgnoreCase("marte") || plant.equalsIgnoreCase("jupiter")));
        sc.close();
        if (plant.equalsIgnoreCase("tierra")) {

            System.out.printf("Tú edad en %s es de %d", plant, edad);

        } else if (plant.equalsIgnoreCase("marte")) {

            System.out.printf("Tú edad en %s es de %.2f", plant, (double) edad / 1.88);

        } else if (plant.equalsIgnoreCase("jupiter")) {
            System.out.printf("Tú edad en %s es de %.2f", plant, (double) edad / 11.86);

        }
    }


}



