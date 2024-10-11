package boletin1_1;

import java.util.Scanner;

/*3. Realizar un programa que solicite una cantidad de números que van a introducirse por teclado.
        Después, para cada uno de ellos que indique si el número es par o impar.
        Si la cantidad de números introducida es 0 o negativa volverá a solicitarse el dato.*/


public class Ejercicio_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numVec;
        int i;

        do {
            System.out.println("Cuantos números vas introducir");
            numVec = sc.nextInt();
        }
        while (numVec <=0);


        for (i = 1; i <= numVec; i++) {
            System.out.println("Introduca en número " + i);

            i = sc.nextInt();
            sc.close();
            if (i % 2 == 0) {

                System.out.println("El número " + i + " introducido es PAR");
            } else {
                System.out.println("El número " + i + " introducido es IMPAR");

            }


        }


    }


}
