import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

  /*  10. Se dispone de un fichero de texto que contiene líneas que cumple el siguiente formato:

        ● Empiezan por ‘F’ a continuación un espacio y luego un nombre de fichero que tiene
          letras (al menos 3), un punto, y la extensión de exactamente 3 letras. Las letras
          pueden ser mayúsculas o minúsculas.
               Se pide:
                 Realiza un programa en Java que valide si un fichero de texto es válido. Solicitará el nombre
                 del fichero e informará de si es válido o no. Además, intentará crear un archivo vacío por
                 cada una de las líneas que sean correctas. Se informará de los ficheros que se han intentado
                 crear con mensajes del tipo:

                        “Ya existe el fichero XXXX” o
                        “Se ha creado el fichero XXXX” o
                        “No se pudo crear el fichero XXXX”*/


    public static void main(String[] args) {

        Path ficheroIn = Paths.get("D:\\Desktop\\Intellij\\Tema7_FicherosYAlmacenamiento\\Ejer10\\src\\ListasFicheros.txt");
        Path directoriosOut = Paths.get("D:\\Desktop\\Intellij\\Tema7_FicherosYAlmacenamiento\\Ejer10\\src\\FicherosNuevos\\");

        if (!Files.isRegularFile(ficheroIn)) {
            System.out.println("Fichero de entrada incompatible o no existe");
        } else {
            try (Stream<String> flujo = Files.lines(ficheroIn)) {
                flujo.filter(l -> l.matches("^F\\s\\p{L}{3,}\\.\\p{L}{3}$"))
                        .forEach(l -> {
                            Path dirNew = Paths.get(directoriosOut.resolve(l).toUri());
                            try {
                                Files.createFile(dirNew);
                                System.out.println("Creando directorio " + l);
                            } catch (FileAlreadyExistsException e) {
                                System.out.println("Ya existe el fichero: " + l);
                            } catch (IOException e) {
                                System.out.println("No tienes permiso para crear fichero: " + l);
                            }
                        });
                if (Files.readAllLines(directoriosOut).size() == Files.readAllLines(ficheroIn).size()) {
                    System.out.println("Archivo valido");
                } else {
                    System.out.println("Archivo no valido");
                }

            } catch (IOException e) {
                System.out.println("Error");;
            }
        }
    }
}