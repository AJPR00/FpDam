package boletin1_3;

/*1.Realizar un programa que lea un número entero por teclado e informe de si
        el número es par o impar(el cero se considera par).*/

//import java.util.Scanner;

import javax.swing.*;

public class Ejer_1 {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int num;


        do {
           /* System.out.print("Introduce un número para saber si PAR o IMPAR");
            num = sc.nextInt();*/

            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número para saber si PAR o IMPAR"));

        } while (num < 0);
        //  sc.close();

        if (num % 2 == 0) {
            System.out.println("Es PAR");
        } else {
            System.out.println("Es IMPAR");
        }


    }


}
