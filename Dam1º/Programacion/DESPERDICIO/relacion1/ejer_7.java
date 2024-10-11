/*
package Relacion1;

*/
/*Realizar un programa que lea el estado civil de una persona(S-Soltero,CCasado,V-Viudo y D-Divorciado)y su edad.Después debe mostrar por
        pantalla el porcentaje de retención que debe aplicársele de acuerdo con las
        siguientes reglas:


         A los solteros o divorciados menores de 35años,un 12%

         Todas las personas mayores de 50años,un8.5%

         A los viudos o casados menores de 35años,un11.3%

         Al resto de casos se le aplica un10.5%*//*


import java.util.Scanner;

public class ejer_7 {

    static final double RETENCION_A = 12;
    static final double RETENCION_B = 8.5;
    static final double RETENCION_C = 11.3;
    static final double RETENCION_E = 10.5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String estado;
        int edad;
        do {
            System.out.println("Tu estado civil: (S-Soltero,CCasado,V-Viudo y D-Divorciado)");

            estado = sc.nextLine();


            System.out.println("Dime tu edad: ");
            edad = sc.nextInt();

        }while (estado.)
        sc.close();

        if (edad < 35) {

            if (estado.equalsIgnoreCase("soltero") || estado.equalsIgnoreCase("s") || estado.equalsIgnoreCase("d") || estado.equalsIgnoreCase("Divorciado")) {

                System.out.println("Eres solteros o divorciados menores de 35 años,un " + RETENCION_A);
            } else {
                System.out.println("Eres viudos o casados menores de 35años,un " + RETENCION_C);
            }
        } else if (edad > 50) {
            System.out.println("Eres mayores de 50años,un " + RETENCION_B);

        } else {
            System.out.println("Se Tte aplica un " + RETENCION_E);
        }


    }
}
*/
