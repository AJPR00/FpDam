package boletin1_2;


/*2. Crea un programa que pida al usuario una temperatura en grados Celsius (tipo `double`) y
        utilice una variable adicional para convertirla a grados Fahrenheit. La fórmula para la
        conversión es `F = (C * 9/5) + 32`. Imprime ambos valores.*/

import java.util.Scanner;

public class Ejer_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dime la temperarua en Celsius: ");
        double gradosC = sc.nextDouble();


        sc.close();

        System.out.printf("%.2f Celsius son en Fahrenheit %.2f",gradosC,((gradosC * 9 / 5) + 32));
    }


}
