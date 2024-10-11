package Tema1_IntroProgramacion.boletin1_7;


/*1. Realizar un programa que, dado un número introducido por el usuario, calcule su
        número a la inversa. Es decir, dada la entrada: 123456, el programa debe devolver
        654321. Para este programa, no se deben utilizar métodos de la clase String,
        Integer, o arrays; sólo deben utilizarse operaciones matemáticas. Ten en cuenta solo
        valores positivos.*/

import java.util.Scanner;

public class Ejer_1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introdice un número para invertir");
        int num = sc.nextInt();

        System.out.println(invertirNumero(num));


       /* int numBoxInver = 0;
        while (num != 0) {

            numBoxInver = numBoxInver * 10 + num % 10;
            num /= 10;
        }

        System.out.println(numBoxInver);*/

    }

// Con Métodos**********************
    public static int invertirNumero(int num){

        int numBoxInver = 0;
        while (num != 0) {

            numBoxInver = numBoxInver * 10 + num % 10;
            num /= 10;
        }

        return numBoxInver;
    }



}




