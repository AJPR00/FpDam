/*
package boletin_4_1.Ejer_1;

import java.util.Scanner;

*/
/*

1. Crear una clase Rectangulo con los atributos longitud y ancho, cada uno con un
        valor predeterminado igual a 1.
        -Proporcionar los métodos set y get para los atributos longitud y ancho respectivamente.
        -El método set debe verificar que longitud y ancho contengan números reales mayores que cero y menores que
         20. Además, proporcionar métodos que calculen el perímetro y el área del
         rectángulo.
       - Escribir un método main que solicite los datos de un rectángulo y muestre cual es
        su área y su perímetro. Probar a introducir un dato incorrecto (mayor o igual que
        20).

        *//*

public class Rectangulo {
    private double longitud;
    private double ancho;

    public Rectangulo() {
        this.longitud=1;
        this.ancho=1;

    }

    // pulsando ALT+Insert podemos auto generar el codigo de setter y getter de cada atributo.
    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {

        if (ancho > 0 && ancho < 20) {
            this.ancho = ancho;
        }else {

            System.out.println("Error, el ancho debe de estar entre 0 y 20");
        }
    }

    public double getLongitud() {

        return this.longitud;
    }

    public void setLongitud(double longitud) {

        if (longitud > 0 && longitud < 20) {
            this.longitud = longitud;
        }else {

            System.out.println("Error, la longitud debe de estar entre 0 y 20");
        }
    }


    public double calcularPerimetro() {

        return 2 * (ancho + longitud);
    }


    public double calcularArea() {

        return ancho * longitud;
    }

    @Override
    public String toString() {
        return "Rectangulo tiene la  longitud=" + longitud + ", y el ancho=" + ancho;
    }
}
*/
