package boletin1_2;

/*6. Pregunta al usuario el tipo de vehículo que está usando en un juego de carreras (coche,
        moto, camión). Si es un coche, su velocidad es de 120 km/h; si es una moto, 90 km/h; y si
        es un camión, 80 km/h. Imprime la velocidad.*/

import java.util.Scanner;

public class Ejer_6_if_else {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el tipo de vehículo que usas: camión, coche o moto.");

        String vehiculo = sc.nextLine();


        if (vehiculo.equalsIgnoreCase("coche")) {
            System.out.println("Al ser un coche su velocidad máxima es de 120 km/h");

        } else if (vehiculo.equalsIgnoreCase("camión")) {
            System.out.println("Al ser un camión su velocidad máxima es de 80 km/h");

        } else if (vehiculo.equalsIgnoreCase("moto")) {
            System.out.println("Al ser un moto su velocidad máxima es de 90 km/h");

        } else {

            System.out.println("Desconozco su  velocidad máxima");


        }
    }
}
