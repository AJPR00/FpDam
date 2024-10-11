/*package boletin1_6;

import java.util.Scanner;
*//*Realizar un programa que solicite un número entero y determine el número
        de cifras que tiene dicho número.
        Ejemplo:
        Introduce un número: 124
        El número 124 tiene 3 cifras*//*

public class Ejer_3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int num;

        do {
            System.out.println("Introduce un número");
            num = Integer.parseInt(sc.nextLine());
        } while (num < 0);

        contadorCifra(num);

        System.out.println(num + " contiene "+ contadorCifra());


       *//* int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;


        do {
            System.out.println("Introduce un número entero:");
            num = Integer.parseInt(sc.nextLine());
        } while (num < 0);

        int contador=0;
        int numReal = num;
        while (num != 0) {

            num /= 10;

contador++;


        }



        System.out.printf("El número %d es de %d dígitos",numReal,contador);*//*
    }


    public static int contadorCifra(int num) {


        int contador = 0;
        int numReal = num;


        while (num != 0) {

            num /= 10;

            contador++;


        }
        return contador;
    }


}*/


















