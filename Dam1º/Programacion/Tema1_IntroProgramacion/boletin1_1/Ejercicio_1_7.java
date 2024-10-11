package boletin1_1;


/*7.  Realizar un programa que solicite una cantidad de números que van a pedirse por
        teclado.
        Una vez que solicite todos ellos debe informar de cual es la media de los
        números.
        Diseñar el programa de forma que si la cantidad es incorrecta vuelva a
        solicitarse.*/


import java.util.Scanner;

public class Ejercicio_1_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la cantidad de número a introduccir: ");

        int numVec = sc.nextInt();


        int i = 0, box = 0;

        do {
            System.out.print("Intruce los números: ");
            int num = sc.nextInt();

             if (num > 0) {

                 box += num;

                   i++;

             } else {
                  System.out.println("Introduce un número positivo");
                  i--;
              }


        } while (i < numVec);

        System.out.println("La media de los números introducido es de " + ((double)box / i));
    }


}

