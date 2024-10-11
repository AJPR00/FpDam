package boletin1_2;


/*3. Escribe un programa que solicite al usuario las calificaciones de tres exámenes (tipo
        `double`). Calcula y almacena el promedio en otra variable. Luego, imprime 'Tu promedio
        es [promedio]'.*/

import java.util.Scanner;

public class Ejer_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame tus últimas 3 notas de exámenes");
        System.out.print("Primer nota de exámen: ");
        double notaUno = sc.nextDouble();
        System.out.print("Segunda nota de exámen: ");
        double notaDos = sc.nextDouble();
        System.out.print("Tercera nota de exámen: ");
        double notaTre = sc.nextDouble();
        sc.close();

        System.out.print("Tú nota media de exámenes es: " + ((notaTre + notaDos + notaUno) / 3));
    }


}
