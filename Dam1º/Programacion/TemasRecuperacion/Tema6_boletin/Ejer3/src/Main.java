import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 3. Realiza un programa que acepte líneas del teclado y las añada a un fichero llamado
 * salidaEj3.txt, sin sobreescribir el contenido que ya hubiera en dicho fichero. La entrada
 * deberá terminar cuando el usuario escriba una línea que tenga únicamente la palabra “fin”.
 */
public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get("src/salidaEj3.txt");


        try {
            MiEntradaSalida.anndirTextoAppen(dir, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
