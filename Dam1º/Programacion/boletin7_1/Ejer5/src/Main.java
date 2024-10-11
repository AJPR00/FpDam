package boletin7_1.Ejer5.src;

import RecuperacionEjercicios.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /*  5. Realizar un programa que presente el siguiente menú:

               1. Crear directorio: Se solicitará un nombre de directorio y se intentará crear en
                   eldirectorio actual. Si ya existe el fichero se mostrará un mensaje de error.
                   Semostrará un mensaje de si se ha podido crear o no correctamente.
               2. Crear fichero de texto: Se solicitará el nombre del fichero y se
                   creará unfichero de texto que contenga una cadena de caracteres solicitada por
                   teclado. Siya existe un fichero con ese nombre se mostrará un mensaje de error.
               3. Borrar fichero de texto: Se solicitará el nombre del fichero y se borrará. Semostrará
                   un mensaje si no se ha podido borrar.
               4. Mostrar los ficheros que contiene una carpeta: Se solicitará el nombre de
                   lacarpeta y mostrará un listado ordenado por nombre con todos los ficheros (nolos
                                                                                           directorios) que contiene.
               5. Salir.
   */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            menu();
            System.out.println("introdzca una opción");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    crearDirectorio();
            }


        } while (opcion <= 4 && opcion > 0);


    }

    public static void menu() {

        System.out.println("1 Crear directorio");
        System.out.println("2 Crear fichero de texto");
        System.out.println("3 Borrar fichero");
        System.out.println("4 Mostrar ficheros");
        System.out.println("5 Salir");

    }

    public static void crearDirectorio() {
        System.out.println("Introduzca un nombre para el directorio");
        String nombreDirectorio = sc.nextLine().toLowerCase();
        File nomdirectorio = new File("./" + nombreDirectorio);

        if (nomdirectorio.exists()) {
            System.out.println("Ya existe el archivo");
        } else {

            if (nomdirectorio.mkdir()) {
                System.out.println("Se ha creado el directorio");
            } else {
                System.out.println("No se ha creado el directorio");


            }
        }
    }

    public static void crearFicheroTexto() throws IOException {
        System.out.println("Introduzca un nombre para el fichero");
        String nombreFichero = sc.nextLine().toLowerCase();
        File directorio = new File("./" + nombreFichero);
        boolean append = true;

        if (directorio.exists()) {
            if (directorio.isFile()) {
                append = MiEntradaSalida.leerSN("Si o no") == 'S';
            } else {
                System.out.println("No se puede crear, directorio con el mismo nombre");
                return;
            }
        }

        String cadena = MiEntradaSalida.leerCadena("");

        {
            System.out.println("Ya existe el archivo");
        }
        if (directorio.mkdir()) {
            System.out.println("Se ha creado el directorio");
        } else {
            System.out.println("No se ha creado el directorio");
        }

    }

    public static void borrarFichero() {

        String nombre = MiEntradaSalida.leerCadena("Elija el nombre del fichero a borrar");

        File directorio = new File("./" + nombre);


    }
}

