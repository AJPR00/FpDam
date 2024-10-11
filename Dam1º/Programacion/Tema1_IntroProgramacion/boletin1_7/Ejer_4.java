package boletin1_7;


import java.util.Scanner;

/*Realiza un programa que pregunte al usuario la hora actual (hora, minutos y
        segundos), y luego pregunte otra hora que deberá sumar a la primera, teniendo en
        cuenta el cambio de día.

        Los siguientes son salidas esperadas para las entradas:
        Introduce la hora base: 13
        Introduce los minutos base: 27
        Introduce los segundos base: 10
        ¿Cuántas horas quieres sumar?: 1
        ¿Cuántos minutos quieres sumar?: 0
        ¿Cuántos segundos quieres sumar?: 55
        La hora resultante es: 14:28:05

        Introduce la hora base: 19
        Introduce los minutos base: 0
        Introduce los segundos base: 0
        ¿Cuántas horas quieres sumar?: 5
        ¿Cuántos minutos quieres sumar?: 0
        ¿Cuántos segundos quieres sumar?: 0
        La hora resultante es: 00:00:00 (del día siguiente)*/
public class Ejer_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int horaBase, minutBase, segundBase;
        int horaSum, minutSum, segunSum;
        System.out.println("Dime la hora actual en formato 24h.");


        do {
            System.out.print("# Dame primero la hora: ");
            horaBase = Integer.parseInt(sc.nextLine());
        } while (horaBase < 0 || horaBase > 23);


        do {
            System.out.print("# Dame los minutos: ");
            minutBase = Integer.parseInt(sc.nextLine());
        } while (minutBase < 0 || minutBase > 60);

        do {
            System.out.print("# Ahora los segundos: ");
            segundBase = Integer.parseInt(sc.nextLine());
        } while (segundBase < 0 || segundBase > 60);


        System.out.printf("                    Tu hora es: %d:%d:%d 24h. \n\n", horaBase, minutBase, segundBase);

        //*****************************************************************

        System.out.print("¿Cuántas horas quieres sumar?: ");
        horaSum = Integer.parseInt(sc.nextLine());

        System.out.print("¿Cuántos minutos quieres sumar?: ");
        minutSum = Integer.parseInt(sc.nextLine());

        System.out.print("¿Cuántos segundos quieres sumar?: ");
        segunSum = Integer.parseInt(sc.nextLine());


        int segundFinal = segundBase + segunSum;
        int minutFinal = minutBase + minutSum;
        int horaFinal = horaBase + horaSum;
        int dia = 0;


        while (segundFinal > 59) {
            segundFinal -= 60;
            minutFinal++;
        }

        while (minutFinal > 59) {
            minutFinal -= 60;
            horaFinal++;
        }

        while (horaFinal > 24) {
            horaFinal -= 24;
            dia++;
        }

        if (dia >= 0) {
            System.out.printf("\n \n Se a sumado %d dias quedando con la siguiente hora %d:%d:%d 24h. ",dia, horaFinal, minutFinal, segundFinal);

        } else {
            System.out.printf("\n \n Tu hora es: %2d:%2d:%2d 24h.", horaFinal, minutFinal, segundFinal);
        }


    }

}
