package boletin1_2;


/*4. Pide al usuario la distancia a su destino en kilómetros (tipo `double`) y la velocidad a la
        que viajará en km/h (tipo `double`).
        Utiliza estas variables para calcular el tiempo que tardará en llegar (tipo `double`). Luego, imprime el tiempo en horas y minutos*/

import java.util.Scanner;

public class Ejer_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame su distancia y velocidad: ");
        double distancia = Double.parseDouble(sc.nextLine());

        System.out.print("Y ahora su velocidad: ");
        double velocidad = Double.parseDouble(sc.nextLine());


        System.out.printf("Tiempo de recorrido es %d minutos \n",(int) (60/(distancia/velocidad)));
        System.out.printf("Tiempo de recorrido es %d segundos",60*((int) (60/(distancia/velocidad))));

    }


}
