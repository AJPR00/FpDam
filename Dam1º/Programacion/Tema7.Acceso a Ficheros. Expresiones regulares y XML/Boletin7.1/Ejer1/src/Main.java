import java.io.*;

public class Main {
    public static void main(String[] args) {

        // FileReader fr = null; no hace falta por que se inicializa con referencia de inArchivo
        int numLineas = 0;
        try (BufferedReader inArchivo = new BufferedReader(new FileReader(".\\Boletin7.1\\Ejer1\\src\\archivos\\Archivo.txt"))) {
            String linea;
            // readLine() devuelve en un String con una línea y la guarda en la variable línea, while cuenta cuantas veces se realiza la operación de guarda.
            while ((linea = inArchivo.readLine()) != null) {
                numLineas++;
            }
            System.out.println("Número de líneas: " + numLineas);

        } catch (IOException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());

            // printStackTrace imprime desde donde proviene el error
            e.printStackTrace();
        }

        //NIO
       /* Path path = Paths.get(".\\Resources\\Fichero.txt");
        try (Stream<String> lines = Files.lines(path)) {
            try (Stream<String> lines = Files.lines(path)) {
                StringBuilder info = new StringBuilder();
                lines.forEach(a -> info.append(a).append(" "));
                System.out.println(info);
            } catch (IOException e) {
                throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
        }*/
    }
}
