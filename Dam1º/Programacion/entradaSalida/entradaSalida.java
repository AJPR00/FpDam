package entradaSalida;

import java.util.Scanner;


public  class entradaSalida {
    public static Scanner sc = new Scanner(System.in);

    public static int leerEnetero(String texto, int num) {
        while (true) {
            try {
                System.out.println(texto + num);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
            }
        }
    }
    
   

    public static char leerChar(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.next().charAt(0);
    }

    public static int leerEnteroEnRango(int inicio, int fin) {
        int num;
        do {
            System.out.print("Introduce un número entre " + inicio + " y " + fin + ": ");
            num = sc.nextInt();
        } while (num < inicio || num > fin);
        return num;
    }

    public static boolean esNumeroEnRango(int num, int inicio, int fin) {
        return num >= inicio && num <= fin;
    }

    public static int leerEnteroEnRango(String texto, int inicio, int fin) {
        int num;
        do {
            num = leerEnetero(texto, 0);
            if (!esNumeroEnRango(num, inicio, fin)) {
                System.out.println("Error: Introduce un número entre " + inicio + " y " + fin + ".");
            }
        } while (!esNumeroEnRango(num, inicio, fin));
        return num;


    }
}
