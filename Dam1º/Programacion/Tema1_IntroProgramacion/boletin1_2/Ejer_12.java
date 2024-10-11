package boletin1_2;

/*12.Crea un programa que pregunte al usuario cuál es su superhéroe favorito entre
        Spider-Man,Iron Man y Batman.Si elige Spider-Man,imprime'¡Te encantan las
        telarañas!'. Si elige Iron Man, imprime '¡Los trajes tecnológicos son lo tuyo!'. Si elige
        Batman,imprime'¡Eres el caballero oscuro!'.Para hacerlo más desafiante,puedes añadir
        más superhéroes y respuestas asociadas*/

import java.util.Scanner;

public class Ejer_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            String heroe;


            do {
                System.out.println("Dime  cuál es su superhéroe favorito entre: Spider-Man,Iron Man y Batman: ");
                heroe = sc.nextLine();

            } while (!(heroe.equalsIgnoreCase("Spider-Man") || heroe.equalsIgnoreCase("Iron Man") || heroe.equalsIgnoreCase("Batman")));
            sc.close();
            if (heroe.equalsIgnoreCase("Spider-Man")) {

                System.out.printf("¡Te encantan las telarañas!");

            } else if (heroe.equalsIgnoreCase("Iron Man")) {

                System.out.printf("¡Los trajes tecnológicos son lo tuyo!");

            } else if (heroe.equalsIgnoreCase("Batman")) {
                System.out.printf("¡Eres el caballero oscuro!");

            }
            System.out.println("\n \n");
        } while (true);
    }


}