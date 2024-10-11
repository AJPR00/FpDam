package boletin1_6;

import java.util.Scanner;

/*
4. Se desea realizar un programa que implemente un juego que consiste en
        acertar un número secreto. El ordenador deberá generar aleatoriamente un
        número secreto entre 1 y 100 y el jugador tratará de acertarlo.
        Cada vez que el jugador introduzca un número, se comprobará si es el
        número secreto, en cuyo caso termina el juego. Si no lo es, se informará
        que el número introducido es mayor o menor que el número secreto. El
        programa termina cuando acierta el número (gana) o cuando agota el
        número de intentos ( en nuestro caso 5) sin acertar el número , en cuyo
        caso pierde.
        Si es número no estuviese en el rango de 1-100, debe mostrar un mensaje
        “El numero debe estar entre 1 y 100” y también debe contarse como un
        fallo.
        NOTA: Se proporciona la forma de crear un número secreto en Java*/

public class Ejer_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        final int NUMERO_MAXIMO = 100;
        final int NUMEROS_INTENTOS = 5;
        int random = (int) (Math.random() * NUMERO_MAXIMO) + 1;
        int num;


        System.out.println("Introduce un número entre 0 y 100 e intenta acertar el número oculto:");

        System.out.println(random);


        for (int i = (NUMEROS_INTENTOS - 1); i >= 0; i -= 1) {


            System.out.println("Introduce un número entre 0 y 100 e intenta acertar el número oculto:");


            do {

                num = Integer.parseInt(sc.nextLine());

                if (num < 0 || num > 100) {

                    System.out.println("El numero debe estar entre 1 y 100");
                }

            } while (num < 0 || num > 100);


            if (num == random) {

                System.out.println("Has acertado !!");
                break;

            } else {

                if (num > random) {
                    System.out.println("El número oculto es menor");

                } else {
                    System.out.println("El número oculto es mayor");
                }


                System.out.printf(" \n                     Te queda %d intentos \n ", i);
            }


            if (i == 0) {
                System.out.println("Perdiste!!");
            }
        }
    }
}


