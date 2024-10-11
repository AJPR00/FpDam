package boletin_Extra;

import java.util.Scanner;

public class Ejer_2_Metodo_Fibonacci {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(fibonacci(5));

//Fibonacci 1.1.2.3.5.8.13
        sc.close();
    }


    public static int fibonacci(int i) {



        if (i == 0 || i == 1) {
            return 1;

        } else {

            return fibonacci(i-1)+ fibonacci(i-2);

        }


    }


}

