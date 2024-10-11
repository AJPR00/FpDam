package boletin1_2;


/*1. Escribe un programa que declare y asigne valores a tres variables: tu nombre (tipo
        `String`), tu edad (tipo `int`), y tu altura (tipo `double`). Luego, imprime estos valores en
        una oración que diga 'Mi nombre es [nombre], tengo [edad] años y mido [altura] metros'.

****** printf  *****

%c character
%d decimal (integer) number (base 10)
%e exponential floating-point number
%f floating-point number
%i integer (base 10)
%o octal number (base 8)
%s String
%u unsigned decimal (integer) number
%x number in hexadecimal (base 16)
%t formats date/time
%% print a percent sign
\% print a percent sign


        */

import java.util.Scanner;

public class Ejer_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tú Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Tú edad: ");
        int edad = sc.nextInt();

        System.out.print("Tú altura: ");
        double altura = sc.nextDouble();

        sc.close();

        System.out.printf("Mi nombre es %s, tengo %d años y mido %2f metros", nombre, edad, altura);


    }
}
