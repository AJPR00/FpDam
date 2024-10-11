import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        Path dir1 = Paths.get(".\\src\\Archivo.txt");
        Path dir2 = Paths.get(".\\src\\carpeta\\salida.txt");
        Path dir3 = Paths.get("D:out\\production\\Tema6_Ficheros");


        try (Stream<String> texto = Files.lines(dir1, StandardCharsets.UTF_8);
             Stream<Path> list = Files.list(dir3);
             Stream<Path> list2 = Files.walk(dir3)) {
            Path directorioAZ= Paths.get("D:out\\");
            for (int i =65;i<=90;i++){
                String nom= String.valueOf((char)i);
                System.out.println(nom);
                Files.createDirectory(directorioAZ.resolve(Paths.get(nom)));
                // Files.delete(directorioAZ.resolve(Paths.get(nom)));
            }


            /**
             *  Me guarda  un texto remplazando los puntos por puntos y salto de linea
             *
             *  Files.write(dir2, Files.readAllLines(dir1).stream().map(s -> s.replaceAll("\\.", ".\n")).toList(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
             */


            list.forEach(path -> System.out.println(path.toString()));
            System.out.println("lista2");
            list2.forEach(path -> System.out.println(path.toString()));


            System.out.println(Files.size(dir1));
            System.out.println(Files.size(dir2));
        } catch (UnsupportedOperationException e) {
            System.err.println("Error al crear el directorio: Operación no soportada en ");
        } catch (FileAlreadyExistsException e) {
            System.err.println("Error al crear el directorio: Ya existe ");
        } catch (SecurityException e) {
            System.err.println("Error al crear el directorio: Permiso denegado en ");
        } catch (IOException e) {
            System.err.println("Error al crear el directorio: Error de E/S en ");
        }

    }
}

