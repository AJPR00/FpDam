import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejer1 {

   /* Ejercicio 1. 4,75 puntos. Escribir un programa en Java que lea dos directorios por teclado y haga lo siguiente:

        ● Debe validar que las rutas escritas sean directorios y que tengan permiso de lectura el primero y de escritura el segundo.
        ● Debe copiar en el segundo directorio aquellos ficheros del primero que cumplan los siguientes criterios:
                    ○ El fichero debe pesar más de 1024 bytes.
                    ○ Debe ser un fichero regular.
                    ○ La extensión del archivo debe ser".txt".
                    ○ La primera palabra del fichero debe ser “COPIAR” (sin importar mayúsculas o minúsculas).

        ● No se debe entrar en subdirectorios, si los hubiera.
        ● Para copiar dos ficheros, puede usar el método copy de la clase Files, del paquete java.nio
        ● Puedes pasar un File a un Path con el método toPath().*/

    public static void main(String[] args) {

        Path pathOrigen = Paths.get(MiEntradaSalida.leerCadena("Introduzca una ruta para el origen:"));
        Path pathDestino = Paths.get(MiEntradaSalida.leerCadena("Introduzca una ruta para el destino:"));

        if (!Files.isDirectory(pathOrigen)){
            System.out.println("No es un directorio");

        }
        if (!Files.isDirectory(pathDestino)){
            System.out.println("No es un directorio");

        }


    }
}