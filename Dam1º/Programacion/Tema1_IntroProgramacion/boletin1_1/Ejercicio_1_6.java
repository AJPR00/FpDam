package boletin1_1;


/*     Realizar un programa que lea dos números enteros cualesquiera numeroA y numeroB,
       y calcule el producto los números mediante sumas, es decir, sin usar el operador *.*/

import java.util.Scanner;

public class Ejercicio_1_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce dos números para múltiplicar:");

        int numA = sc.nextInt();
        int numB = sc.nextInt();

        sc.close();

        if (numA < numB) {
                                                    // if para hacer mas eficiente el código.
            int numC = numB;
            numB = numA;
            numA = numC;

        }

        int resul = 0;

        for (int i = 1; i <= numB; i++) {

            resul += numA;
        }

        System.out.print("El resultado de la múltiplicacion es: " + resul);

    }


}
