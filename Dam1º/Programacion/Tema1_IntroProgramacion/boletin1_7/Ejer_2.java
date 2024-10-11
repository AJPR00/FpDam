package Tema1_IntroProgramacion.boletin1_7;

import java.util.Scanner;

public class Ejer_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número para saber si es capicúa");
        int num = sc.nextInt();

        if (num == Ejer_1.invertirNumero(num)) {
            System.out.println("Es capicúa");
        } else {
            System.out.println("No es capicúa");
        }

        System.out.println(Ejer_1.invertirNumero(num));

    }


}
