import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    /* 4. Realiza el ejercicio anterior pero utilizando clases del paquete java.nio.*/

    public static void main(String[] args) {

        Path salida = Paths.get("./src/salidaEj3.tx");
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String linea;
            while (!(linea = entrada.readLine()).equals("fin")) {
                Files.writeString(salida,linea, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}