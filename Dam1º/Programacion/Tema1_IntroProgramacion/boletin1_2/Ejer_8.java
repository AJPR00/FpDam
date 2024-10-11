package boletin1_2;

/*8.Crea un programa que verifique si un jugador tiene acceso a una misión especial.
        Pregunta al usuario su nivel y el número de misiones completadas.Si el nivel es mayor
        que 10y ha completado más de 20misiones,imprime'Tienes acceso a la misión especial'.
        De lo contrario,imprime'No cumples los requisitos para la misión especial'.*/


import java.util.Scanner;

public class Ejer_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numMIs;
        int numNiv;
        do {
            System.out.print("Para tener acceso a la misión dime tú nivel:");
            numNiv = sc.nextInt();
            System.out.print("Ahora dime tú misiones completadas:");
            numMIs = sc.nextInt();

        }while (numNiv<0 && numMIs<0);


        if (numNiv > 10 && numMIs > 20) {
            System.out.println("Tienes acceso a la misión especial.");
        } else {
            System.out.println("No cumples con los riquisitos para la misión especial.");
        }

    }


}
