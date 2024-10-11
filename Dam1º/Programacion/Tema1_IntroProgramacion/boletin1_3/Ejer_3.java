package boletin1_3;

/*3. Realizar un programa que lea un número por teclado. El programa debe
        imprimir en pantalla un mensaje con “El número xx es múltiplo de 2” o un
        mensaje con “El número xx es múltiplo de 3”. Si es múltiplo de 2 y de 3
        deben aparecer los dos mensajes. Si no es múltiplo de ninguno de los dos
        el programa finaliza sin mostrar ningún mensaje.*/


import java.util.Scanner;

public class Ejer_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        do {
            System.out.println("Introduca un número positivo:");
            num = sc.nextInt();

        } while (num < 0);

        if (num % 2 == 0 && num % 3 == 0) {
            System.out.println("Es múltiplo de 2 y 3");

        } else if (num % 3 == 0) {
            System.out.println("Es múltiplo de 3");

        } else if (num % 2 == 0) {

            System.out.println("Es múltiplo de 2");
        }

    }


}