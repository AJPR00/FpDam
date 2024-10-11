package boletin7_1.Ejer11.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main2 {
  /*
    11. Se dispone de un fichero de texto con los nombres de los alumnos de una clase. Cada
    línea contiene en mayúscula el nombre y los dos apellidos de los alumnos, así como su
    curso separado por un espacio. Se desea montar una estructura de directorios de forma que
    se cree una carpeta por cada curso y dentro de ella una carpeta con cada alumno con el
    nombre Apelllido1Apellido2Nombre. Si se detecta algún error en el fichero se parará el proceso*/


    public static void main(String[] args) {

        Path fichero = Paths.get("Ejer11/Documents/Alumnos.txt");
        String ficheroAlumno = "Ejer11/Documents/Alumnos";
        Pattern patron = Pattern.compile("(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s([^\\\\/:\"*?<>|\\n]{2,})");

        try (Stream<String> linas = Files.lines(fichero)) {
            linas.map(l->patron.matcher(l))
                    .filter(l-> l.matches())
                    .forEach(matcher -> {
                        String nombreAlumno = matcher.group(2)+matcher.group(3)+matcher.group(1);
                        try {
                            Files.createDirectory(Path.of(ficheroAlumno,matcher.group(4),nombreAlumno));
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    });

        } catch (IOException e) {
            System.out.println("Fichero no encuentra");
        }


    }
}