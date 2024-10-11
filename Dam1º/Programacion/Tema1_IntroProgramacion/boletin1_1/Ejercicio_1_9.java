package boletin1_1;

/*
9. Realizar un programa que lea un número entero positivo y averigüe si es perfecto. Un
        número es perfecto cuando es igual a la suma de sus divisores excepto él mismo.
        Diseñar el programa de forma que si algún dato es incorrecto vuelva a solicitarse.
        Ejemplos:
        El número 6 es perfecto porque es igual que 1+2+3=6
        El número 8 no es perfecto porque 1+2+4=7
*/

public class Ejercicio_1_9 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {

            if (esPerfecto(i)){
            //System.out.println(esPerfecto(i));

                System.out.println("El número "+i+" es perfecto");}
        }

    }

    private static boolean esPerfecto(int num) {

        int suma = 0;

        for (int i = 1; i <= num / 2; i++)
            if (num % i == 0) {

                suma += i;
            }

        return suma == num;

    }

}



