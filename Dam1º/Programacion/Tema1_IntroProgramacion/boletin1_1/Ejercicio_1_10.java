package boletin1_1;

import java.util.Scanner;

public class Ejercicio_1_10 {


   /* 10. Realizar un programa que solicite un número entero positivo o cero y calcule su
    factorial.
    Diseñar el programa de forma que si algún dato es incorrecto vuelva a
    solicitarse.

    Factorial (0)=1
    Factorial (1)=1
    Factorial (N)=N* (N-1)* (N-2)* …......1*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long num;



        do {
            System.out.println("Introduce un número positivo para calcular su factorial:");

            num = sc.nextInt();

        } while (num < 0);
        sc.close();


        long contador = 1;
        long resultado = 1;

        do {

            resultado *= contador; // *= es igual a  resultado =resultado * contador

            contador++;

        } while (contador <= num);

        System.out.printf("El factorial de %d es: %d", num, resultado);


    }

}
