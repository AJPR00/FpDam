package boletin1_3;

import java.util.Scanner;

/*4. Realizar un programa que lea la edad de una persona menor a 100 años e
        informe de si es un niño (0-12 años), un adolescente (13-17), un joven (18-
        29) o un adulto*/
public class Ejer_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        do {
            System.out.println("Introduca tú edad:");
            num = sc.nextInt();

        } while (num > 100 || num < 0);

        if (num <=12) {
            System.out.println("Eres un niño");

        } else if (num <=17) {
            System.out.println("Eres un adolecente");

        }else if (num <=29) {
            System.out.println("Eres un joven");

        }else {
            System.out.println("Eres adulto");

        }

    }


}
