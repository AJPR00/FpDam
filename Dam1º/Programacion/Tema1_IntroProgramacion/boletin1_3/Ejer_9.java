/*package boletin1_3;


import java.util.Scanner;

*//*En un establecimiento en rebajas, hay 3 tipos de productos (A, B y C). El
        porcentaje de rebaja que se aplicará sobre el precio original del producto se
        calcula de la siguiente forma:

        ● Si el producto es de tipo A, independientemente de su precio se
        aplica un 7% de descuento.
        ● Si el producto es de tipo C o bien el precio es inferior a 500€ se
        aplicará un porcentaje del 12% de descuento.
        ● En el resto de casos se aplica un 9% de descuento*//*
public class Ejer_9 {


    final static double DESCUENTO_A=0.07;
    final static double DESCUENTO_C=0.12;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double descuento;

        System.out.println("Indica en precio del producto:");
        double precio = sc.nextDouble();

        System.out.println("Selecione el productos");
        char tipo = sc.next().charAt(0);


        if(tipo.equals{

            descuento = precio*DESCUENTO_A;
        }

    }

}*/
