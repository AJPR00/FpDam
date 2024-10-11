package boletin1_1;

import java.util.Scanner;

public class Bucle_do_while_contrasen {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String contrasena;

        do {
            System.out.println("Introduce una contraseña de al menos 8 caracteres");
            contrasena = sc.nextLine();

            // Obtener la longitud de la contraseña
            int longitud = contrasena.length();

            if (longitud < 8) {
                System.out.println("La contraseña debe tener al menos 8 caracteres.");
            }

        } while (contrasena.length() < 8);

        System.out.println("Has introducido una contraseña correcta.");
        sc.close();
    }
}