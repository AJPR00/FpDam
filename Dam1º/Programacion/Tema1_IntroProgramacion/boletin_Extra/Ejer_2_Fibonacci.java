package boletin_Extra;

import java.util.Scanner;

public class Ejer_2_Fibonacci {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;


        do {
            System.out.print("Introduce un número positivo;");
            num = sc.nextInt();

        } while (num <= 0);


//Fibonacci 1.1.2.3.5.8.13
        sc.close();
        int numA = 0, numB = 1, numC = 0;


        for (int i = 1; i <= num; i++) {

            numC = numA + numB;
            numA = numB;
            numB = numC;

        }

        System.out.printf("Fibonacci de %d es %d", num, numC);

    }
}