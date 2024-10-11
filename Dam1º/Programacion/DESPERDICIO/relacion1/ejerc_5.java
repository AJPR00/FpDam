package relacion1;

import java.util.Scanner;
/*5.Realizar un programa que solicite números ilimitado e imprima la media de los
        números.También debe imprimir aquellos números que son superiores a la
        media. si introduce un negativo se sale de la app */

public class ejerc_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = 0, numSum = 0, numMin =Integer.MAX_VALUE, numMax = Integer.MIN_VALUE, contador=1;


        do {

            System.out.print("Introduce números, para salir pulse -1");
            num = Integer.parseInt(sc.nextLine());
            numSum += num;

            if (num <= numMin) {
                numMin = num;
            } else {
                numMax = num;
            }

            contador++;

        } while (contador <= 0);

        System.out.println("La Media es: " + numSum / 4 + "El número máximo es" + numMax + " y el número mínimo es " + numMin);


    }
}
