package boletin1_6;
/*5. Realizar un programa que solicite un número e informe de si es o no primo.
        Un número es primo si entre sus divisores sólo está él mismo y el número
        1.*/
import java.util.Scanner;

public class Ejer_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce un número para saber si es primo:");
        int num = sc.nextInt();

        for (int i =2; i<=num/2;i++){

            if (num%i==0){
                System.out.println("No es primo");
                break;
            }else  {
                System.out.println("Es primo");
                break;
            }

        }

    }

}
