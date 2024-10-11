import jdk.dynalink.StandardOperation;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main4 {

    /* 9. Realizar un programa que solicite un nombre de un fichero de texto. El fichero contiene
     en el nombre del modelo de coche, un espacio y su matrícula. El programa debe crear otro
     fichero de texto llamado “MatriculasCorrectas.txt” donde sólo aparezcan las
     matriculas con formato actual, una por línea. Las matrículas en formato actual están
     formadas por 4 dígitos, un guión ‘-’ y 3 letras mayúsculas.
 */
    public static void main(String[] args) {

        Path rutaMatriculaIn = Paths.get("./Ejer9/Matriculas.txt");
        Path rutaMatriculaOut = Paths.get("./Ejer9/MatriculasCorrectas.txt");

        Pattern p = Pattern.compile("(\\p{L}+)\\s(\\d{4})-([A-Z&&[^AEIOU]]{3})");

        try (BufferedWriter br = Files.newBufferedWriter(rutaMatriculaOut, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
             Stream<String> lineas = Files.lines(rutaMatriculaIn);) {

            lineas.map(p::matcher)
                    .filter(Matcher::matches)
                    .forEach(matcher -> {
                        try {
                            br.write(matcher.group(2));
                        } catch (IOException e) {
                            System.out.println("Ha ocurrido un error");
                        }
                    });

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error1");
        }


    }
}