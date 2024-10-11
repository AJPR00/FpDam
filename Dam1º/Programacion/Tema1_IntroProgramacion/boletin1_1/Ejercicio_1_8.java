package boletin1_1;


import java.util.Scanner;

/*8. Realizar un programa que solicite un conjunto de números.
        Después de introducir cada número se realizará la pregunta: "¿Desea introducir más números (S/N)".
        Si la respuesta es 'S' se solicitará otro número.
        Cuando no desee introducir más númerosebe informar cual es el menor de los números introducidos.

        NOTA: Debe comprobarse que la respuesta es 'S' o 'N' y si no lo es, volver
        a pedirla.*/
public class Ejercicio_1_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contador = 1, box = 0, num = 0;
        do {
            box = num;
            System.out.println("Introduce mínimo dos número y te digo cúal es el mas pequeño:");
            num = sc.nextInt();

            if (num <= box) {
                box = num;
            }

            contador++;

        } while (contador <= 2);

        boolean salida = true;


        do {
            System.out.println("Quieres introducir más números si o no");
            sc.nextLine();
            String respuesta = sc.nextLine();


            if (respuesta.equalsIgnoreCase("si")) {
                box = num;
                System.out.println("Introduzca otro número más");
                num = sc.nextInt();

                if (num <= box) {
                    box = num;
                }
            } else if (respuesta.equalsIgnoreCase("no")) {
                salida = false;

            } else {
                System.out.println("Respuesta no válida");
            }
        } while (salida);

        System.out.println("El número más pequeño es el " + box);


    }


}
