package ejerciciosExtrasMetodos;

import java.util.Scanner;

public class Bol1_1_10 {


    /* 10. Realizar un programa que solicite un número entero positivo o cero y calcule su
     factorial.
     Diseñar el programa de forma que si algún dato es incorrecto vuelva a
     solicitarse.

     Factorial (0)=1
     Factorial (1)=1
     Factorial (N)=N* (N-1)* (N-2)* …......1*/

    // **********************************************************************************************
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("introduce un numero :");

        int num = sc.nextInt();

        System.out.print(factorial(num));

    }

    // **********************************************************************************************


    public static int factorial(int a) {

        if (a == 0 || a == 1) {
            return 1;
        }

        return a * factorial(a - 1);
    }

}




