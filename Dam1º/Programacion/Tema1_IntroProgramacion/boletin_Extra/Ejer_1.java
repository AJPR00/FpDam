package boletin_Extra;

import java.util.Scanner;

public class Ejer_1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce dos número");

        int resulA = 0, resulB = 0;
        int numA = sc.nextInt();
        int numB = sc.nextInt();

        sc.close();

        boolean primosEntreSi = true;

        for (int i = 2; i < numA && i < numB && primosEntreSi; i++) {


            if (numA % i == 0 && numB % i == 0) {

                System.out.println("No son divisor ");
                primosEntreSi = false;

            }

        }
        if (primosEntreSi) {

            System.out.println("Son Primos");
        }
    }

}





