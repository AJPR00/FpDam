package relacion1;
/*8.Realizar un programa que lea por teclado dos marcaciones de un reloj
        digital(horas,minutos,segundos)comprendidas entre las 0:0:0 y las
        23:59:59e informe cual de ellas es mayor.
        Ejemplo:
        Hora 1:12:35:37
        Hora 2:12:38:36
        “Hora 2es mayor”*/

import java.util.Scanner;

public class ejer_8 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce dos marcaciones de un reloj digital(horas,minutos,segundos)comprendidas entre las 0:0:0 y las 23:59:59e");

        boolean hora = true;

        int hora1, minuto1, segundo1, hora2, minuto2, segundo2;

        do {
            System.out.println("  Primero hora:   ");

            System.out.print("\nHora:  \n");
            hora1 = sc.nextInt();
        } while (hora1 > 24 || hora1 < 0);
        do {
            System.out.print("Minutos:  \n");
            minuto1 = sc.nextInt();
        } while (hora1 > 24 || hora1 < 0);
        do {
            System.out.print("Segundos:  \n");
            segundo1 = sc.nextInt();
        } while (hora1 > 24 || hora1 < 0);


        System.out.println("  Segunda hora:  ");
        do {
            System.out.print("\nHora:  \n");
            hora2 = sc.nextInt();
        } while (hora1 > 24 || hora1 < 0);
        do {
            System.out.print("Minutos:  \n");
            minuto2 = sc.nextInt();
        } while (hora1 > 24 || hora1 < 0);
        do {
            System.out.print("Segundos:  \n");
            segundo2 = sc.nextInt();
        } while (hora1 > 24 || hora1 < 0);

        if (hora1 > hora2) {

        } else if (hora2 > hora1) {
            hora = false;

        } else if (minuto1 > minuto2) {

        } else if (minuto2 > minuto1) {
            hora = false;

        } else if (segundo1 > segundo2) {

        } else if (segundo2 > segundo1) {
            hora = false;

        }
        if (hora == true) {
            System.out.printf("Es la mayor %d:%d:%d", hora1, minuto1, segundo1);
        } else if (hora == false) {
            System.out.printf("Es la mayor %d:%d:%d", hora2, minuto2, segundo2);

        }

    }
}
