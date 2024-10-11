package boletin1_2;

/*
9.Escribe un programa que pida al usuario el número de enemigos derrotados.Si el número
        es mayor que 50,multiplica los puntos por 2.Si no,los puntos son iguales al número de
        enemigos derrotados.Imprime los puntos totales.
*/

import java.util.Scanner;

public class Ejer_9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numEn;

        do {
            System.out.print("Dime tú número de enemigos derrotados: ");
            numEn = sc.nextInt();

        } while (numEn < 0);
        sc.close();

        if (numEn > 50) {

            System.out.printf("Tienes %d puntos.0", numEn * 2);


        } else {
            System.out.printf("Tienes %d puntos.0", numEn);
        }

    }


}
