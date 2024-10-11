
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
   /* 11. Se dispone de un fichero de texto con los nombres de los alumnos de una clase. Cada
    línea contiene en mayúscula el nombre y los dos apellidos de los alumnos, así como su
    curso separado por un espacio. Se desea montar una estructura de directorios de forma que
    se cree una carpeta por cada curso y dentro de ella una carpeta con cada alumno con el
    nombre Apelllido1Apellido2Nombre.Si se detecta algún error en el fichero se parará el
    proceso.*/

    public static void main(String[] args) {
        Path ficheroAlumnosDirectorios = Paths.get(".\\Ejer11\\FicheroAlumnosDirectorios.txt");
        Path alumnosDirectorios = Paths.get(".\\Ejer11\\AlumnosDirectorios\\");
        Pattern patron = Pattern.compile("^(\\p{Lu}{3,}\\s)(\\p{Lu}{3,}\\s)((\\p{Lu}{3,}\\s)(\\p{Lu}{2,}\\s)?(\\p{Lu}{2,}\\s)?)?(\\d\\p{Lu})$");


        try (Stream<String> flujoPath = Files.lines(ficheroAlumnosDirectorios)) {
            flujoPath.forEach(l -> {
                Matcher m = patron.matcher(l);

                if (m.matches()) {
                    //.trim solo quita los espacios al principio y final de la cadena.
                    String ap1ap2nombre = ((m.group(2) + m.group(3) + m.group(1)).replaceAll("\\s*", ""));
                    String curso = m.group(7);
                    Path dirAp1Ap2Nam = Paths.get("D:\\Desktop\\Intellij\\Boletin7.1\\Ejer11\\AlumnosDirectorios\\" + ap1ap2nombre);


                    try {
                        if (!Files.exists(dirAp1Ap2Nam)) {
                            Files.createDirectories(alumnosDirectorios.resolve(ap1ap2nombre).resolve(curso));
                            System.out.println("Directorio creado," + dirAp1Ap2Nam.getFileName());

                        } else {
                            System.out.println("Directorio ya existe, " + dirAp1Ap2Nam.getFileName());

                        }
                        // Path dirCurso = Files.createDirectories(dirAp1Ap2Nam.resolve(curso));

                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Ya existe el fichero");
                    } catch (IOException e) {
                        System.out.println("Directorio padre no encontrado");
                    }
                }

            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}