package boletin1_6;
/*6. Realizar un programa que lea el número de alumnos que hay en una clase.
        A continuación debe leer la nota de cada uno de ellos en un examen y nos
        debe informar del número de suspensos y aprobados, así como los
        porcentajes.*/

import java.util.Scanner;

public class Ejer_6 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double notaAlum;
        int numAlum=0;
        int alumnAprobados = 0, alumnSuspensos = 0;


        do {
            System.out.println("Dime el número de alumnos que hay en una clase: ");

            if (sc.hasNextInt()) { //hasNextInt() verifica que la entrada por teclado sea un INT, si es correcto devuelve un TRUE
                numAlum = Integer.parseInt(sc.nextLine());

            }else{
                System.out.println("\n Error, vuelva a introducir el número de alumnos.");
                sc.next(); // Limpia la entrada del anterior sc.next...
            }


        } while (numAlum < 1);


        for (int i = 1; i <= numAlum; i++) {
            do {
                System.out.printf("Ahora dime la nota del %dº alumno (del 0 al 10):", i);
                notaAlum = Double.parseDouble(sc.nextLine());


                if (notaAlum < 0 || notaAlum > 10) {
                    System.out.println("\nError, vuelva a introducir la nota en el rango especificado.");
                }

            } while (notaAlum < 0 || notaAlum > 10);


            if (notaAlum >= 5) {

                alumnAprobados++;

            } else {

                alumnSuspensos++;
            }

        }


        System.out.printf("\nNúmero de Aprobados: %d que corresponde al %.2f%% \nNúmero de Suspensos: %d que corresponde al %.2f%%\n ", alumnAprobados, (double) alumnAprobados * (100 / numAlum), alumnSuspensos, (double) alumnSuspensos * (100 / numAlum));

    }
}
