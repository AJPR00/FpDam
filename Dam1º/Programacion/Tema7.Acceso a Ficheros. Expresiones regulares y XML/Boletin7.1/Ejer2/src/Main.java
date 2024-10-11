import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        /*try (BufferedReader inArchivo = new BufferedReader(new FileReader("D:\\Desktop\\Interllij2324\\BoletinTema7_Ficheros_Y_Almacenamientos\\Ejer1\\src\\archivos\\Archivo.txt"))) {
            StringBuilder textoConcatenado = new StringBuilder();
            String linea;
            // readLine() devuelve en un String con una línea y la guarda en la variable línea, while cuenta cuantas veces se realiza la operación de guarda.
            while ((linea = inArchivo.readLine()) != null) {
                textoConcatenado.append(linea).append(" ");
            }
            System.out.println(textoConcatenado);
        } catch (IOException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }*/


        Path path = Paths.get("D:\\Desktop\\Interllij2324\\BoletinTema7_Ficheros_Y_Almacenamientos\\Ejer1\\src\\archivos\\Archivo.txt");
        try (Stream<String> lines = Files.lines(path)) {
            StringBuilder bl = new StringBuilder();
            lines.forEach(a -> bl.append(a).append(" "));
            System.out.println(bl);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}