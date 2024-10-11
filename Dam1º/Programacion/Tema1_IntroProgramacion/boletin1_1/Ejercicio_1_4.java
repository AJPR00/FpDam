package boletin1_1;

import java.util.Scanner;


/*Realizar un programa que lea un número estrictamente positivo N y muestre la suma de
los N primeros números.Diseña el programa de forma que si N es incorrecto vuelva a
solicitarse.Ejemplo:

        Introduce un número positivo:4
        La suma de los 4 primeros números es:10*/

public class Ejercicio_1_4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        do {
            System.out.print("Introduce un número positivo: "); // Añado el do_while para crear un bucle que solicite un número positivo
            num = sc.nextInt();
        }
        while (num < 1);

        sc.close();

        int suma = 0;
        int i = 0;

        while (i < num) {
            suma = suma + (num - i);
            i++;
        }

        System.out.println("La suma de fragmentación del " + num + " es de " + suma);

    }
}
