package boletin1_1;

import java.util.Scanner;

public class Ejercicio_1_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Introduce una número:");

        int numTab = sc.nextInt();
        int i;

        System.out.println("*** Tu tabla del " + numTab + " ***");

        for(i=1; i<=10;i++){

            int result= i*numTab;
            System.out.println( numTab + " * "+ i + " = " + result);


        }


    }

}
