import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Main {

    /*  5. Realizar un programa que presente el siguiente menú:

               1. Crear directorio: Se solicitará un nombre de directorio y se intentará crear en
                   eldirectorio actual. Si ya existe el fichero se mostrará un mensaje de error.
                   Semostrará un mensaje de si se ha podido crear o no correctamente.

               3. Borrar fichero de texto: Se solicitará el nombre del fichero y se borrará. Se mostrará
                   un mensaje si no se ha podido borrar.

               5. Salir.
   */


    public static void main(String[] args) {


        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntreDeRango("introdzca una opción del 1 al 5", 1, 5);

            switch (opcion) {

                case 1:
                    System.out.println("Opcion1");
                    String nombreDirectorio = MiEntradaSalida.leerCadena("Introduzca un nombre para el directorio");
                    crearDirectorio(nombreDirectorio);
                    break;
                case 2:
                    System.out.println("Opcion2");
                    String nombreFichero = MiEntradaSalida.leerCadena("Introduzca un nombre para el fichero");
                    try {
                        crearFicheroTexto(nombreFichero);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Opcion3");
                    listarArchivos();
                    String nombre = MiEntradaSalida.leerCadena("Elija el nombre del fichero a borrar");
                    borrarFicheroTexto(nombre);
                case 4:
                    System.out.println("Opcion4");
                    listarArchivos();
                    String nombreC = MiEntradaSalida.leerCadena("Elija el nombre del fichero a borrar");
                    borrarFicheroTexto(nombreC);
            }


        } while (opcion < 6 && opcion > 0);


    }

    public static void menu() {

        System.out.println("\n1 Crear directorio");
        System.out.println("2 Crear fichero de texto");
        System.out.println("3 Borrar fichero");
        System.out.println("4 Mostrar ficheros de una carpeta");
        System.out.println("5 Salir");

    }

    public static void crearDirectorio(String nombre) {
        File nomdirectorio = new File("./Ejer5/" + nombre);


        if (nomdirectorio.exists()) {
            System.out.println("Ya existe el directorio");
        } else {
            if (nomdirectorio.mkdir()) {
                System.out.println("**** Se ha creado el directorio ****");
                System.out.println(nomdirectorio.getAbsolutePath());

            } else {
                System.out.println("No se ha creado el directorio");
            }
        }
    }

    /* 2. Crear fichero de texto: Se solicitará el nombre del fichero y se
        creará un fichero de texto que contenga una cadena de caracteres solicitada por
        teclado. Siya existe un fichero con ese nombre se mostrará un mensaje de error.*/
    public static void crearFicheroTexto(String nombre) throws IOException {
        File directorio = new File("./Ejer5/" + nombre);
        boolean append = true;

        if (!directorio.exists()) {
            if (!directorio.isDirectory()) {
                append = MiEntradaSalida.leerBoleanSN("Quieres sobrescribir el contenido.");
                try (FileWriter fW = new FileWriter(directorio, !append)) {
                    String texto = MiEntradaSalida.leerCadena("Introduzca texto en el archivo: ");
                    fW.write(texto);
                } catch (IOException e) {
                    System.out.println("Error, Archivo no creado.");
                }
            } else {
                System.out.println("No se puede crear, es un directorio.");
            }
        } else {
            System.out.println("No se puede crear, directorio con el mismo nombre.");
        }
    }

    public static void borrarFicheroTexto(String nombre) {
        File path = new File("./Ejer5/" + nombre);
        if (path.exists()) {
            if (!path.isDirectory()) {
                if (path.delete()) {
                    System.out.println("El arvhivo ha sido borrado");
                } else {
                    System.out.println("No se a podido borrar el archivo");
                }
            } else {
                System.out.println(path.getName() + " no es un archivo");
            }
        } else System.out.println("La ruta no existe");
    }

    public static void listarArchivos() {
        File path = new File("./Ejer5");
        File[] listado = path.listFiles();
        Arrays.stream(listado)
                .sorted((a, b) -> {
                    if (a.isFile() && b.isDirectory()) return 1;
                    else if (b.isFile() && a.isDirectory()) {
                        return -1;
                    }return 0;
                })
                .forEach(System.out::println);
    }

 /*    4. Mostrar los ficheros que contiene una carpeta: Se solicitará el nombre de
         la carpeta y mostrará un listado ordenado por nombre con todos los ficheros
        (solos directorios) que contiene.*/
}

