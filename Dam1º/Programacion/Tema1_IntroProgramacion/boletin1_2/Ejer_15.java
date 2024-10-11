package boletin1_2;

import java.util.Scanner;

public class Ejer_15 {
   /* 5. Pide al usuario las longitudes de los tres lados de un triángulo. Utiliza un `switch` y la
    palabra clave `yield` para asignar una cadena describiendo el tipo de triángulo (equilátero (todos lados iguales),
    isósceles (dos lados iguales) o escaleno (todos diferentes)) a una variable. Luego, imprime la cadena. */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame la lonjitud de los lados del un triángulo en cm");
        System.out.println("Primero lado: ");
        double ladoUno = sc.nextDouble();
        System.out.println("Segundo lado: ");
        double ladoDos = sc.nextDouble();
        System.out.println("Tercer lado: ");
        double ladoTre = sc.nextDouble();

        String opcion = null;

        if (ladoTre == ladoDos && ladoTre == ladoUno) {
            opcion = "Triangulo";
        }


        String defini = switch (opcion) {
                case "Triangulo":
                   yield "Es un triangulo";
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        };

        System.out.println(defini);
    }
}