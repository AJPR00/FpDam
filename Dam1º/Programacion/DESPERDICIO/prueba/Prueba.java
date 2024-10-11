package prueba;

import java.util.Scanner;

public class Prueba {

  public static   Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

       solicitarDatos();
        System.out.println();

    }

    public static void solicitarDatos() {
        System.out.println("Introduce tu nombre");
        String nombre= sc.nextLine();

        System.out.println("Introduce tu Apellido");
        String apellido = sc.nextLine();
    }
}
