package boletin7_1.Ejer10.src;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main1 {
/*10. Se dispone de un fichero de texto. Todas la líneas deben cumplir el siguiente formato
● Empiezan por ‘F’ a continuación un espacio y luego un nombre de fichero que tiene
    letras (al menos 3), un punto, y la extensión de exactamente 3 letras. Las letras
    pueden ser mayúsculas o minúsculas.
    Se pide:
    Realiza un programa en Java que valide si un fichero de texto es válido. Solicitará el nombre
    del fichero e informará de si es válido o no. Además, intentará crear un archivo vacío por
    cada una de las líneas que sean correctas. Se informará de los ficheros que se han
    intentado crear con mensajes del tipo :

                “Ya existe el fichero XXXX” o
                “Se ha creado el fichero XXXX” o
                “No se pudo crear el fichero XXXX”  */


    public static void main(String[] args) {

        Path ficheroRegistro = Paths.get("Ejer10/Documents/Registro.txt");
        Path ficherOut = Paths.get("Ejer10/Documents/");
        // Pattern patron = Pattern.compile("^F\\sa-z|A-Z{3,}\\.a-z|A-Z{3}$");
        //\p{L} proporciona los caracteres de UTF-8
        Pattern patron = Pattern.compile("F\\s(\\p{L}{3,}\\.\\p{L}{3})");
        AtomicBoolean correcto = new AtomicBoolean(true);


        try (Stream<String> lineas = Files.lines(ficheroRegistro)) {

            lineas.forEach(linea -> {
                Matcher matcher = patron.matcher(linea);
                String nombreNew = matcher.group(1);

                if (matcher.matches()) {
                    try {
                        Files.createFile(ficherOut.resolve(nombreNew));
                        System.out.println("Se ha creado el fichero " + nombreNew);
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Ya existe el fichero: " + nombreNew);
                    } catch (IOException e) {
                        System.out.println("No tienes permiso para crear fichero: " + nombreNew);
                    }
                }else {
                    correcto.set(false);
                }
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (correcto.get()){
            System.out.println("Fichero correcto");

        }else {
            System.out.println("Fichero no correcto");
        }

    }
}