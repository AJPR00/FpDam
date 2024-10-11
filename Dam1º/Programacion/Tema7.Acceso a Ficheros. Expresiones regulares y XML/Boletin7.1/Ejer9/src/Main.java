import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    /*9. Realizar un programa que solicite un nombre de un fichero de texto. El fichero contiene
    en el nombre del modelo de coche, un espacio y su matrícula. El programa debe crear otro
    fichero de texto llamado “MatriculasCorrectas.txt” donde sólo aparezcan las
    matriculas con formato actual, una por línea. Las matrículas en formato actual están
    formadas por 4 dígitos, un guión ‘-’ y 3 letras mayúsculas*/

    public static void main(String[] args) {

        Path inMatriculas = Paths.get("D:\\Desktop\\Intellij\\Tema7_FicherosYAlmacenamiento\\Ejer9\\Matriculas.txt");
        Path outMatriculasCorrectas = Paths.get("D:\\Desktop\\Intellij\\Tema7_FicherosYAlmacenamiento\\Ejer9\\MatriculasCorrectas.txt");


        try (BufferedReader bf = Files.newBufferedReader(inMatriculas);
             BufferedWriter br = Files.newBufferedWriter(outMatriculasCorrectas);) {
           /* List listaMatriculasCorrectas = bf.lines().filter(c -> c.matches("^(\\p{L}{2,})\\s(\\p{L}{2,}\\s)?\\d{4}-\\p{Lu}{3}$")).toList();
            Files.write(outMatriculasCorrectas, listaMatriculasCorrectas, StandardOpenOption.CREATE);*/
            bf.lines().filter(c -> c.matches("^(\\p{L}{2,})\\s(\\p{L}{2,}\\s)?\\d{4}-\\p{Lu}{3}$")).forEach(l-> {
                try {
                    br.write(l+"\n");
                } catch (IOException e) {
                    System.out.println("Error, al procesar los archivo");
                }
            });


        } catch (IOException e) {
            System.out.println("se ha producido una excepción de E/S"+e.getMessage());        }
    }
}