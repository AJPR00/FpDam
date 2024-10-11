import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    /* 8. Realizar un programa que solicite un nombre de un fichero de texto e informe de si
          cumple con el formato que se indica. Cada línea debe contener:
                  ● El nombre y dos apellidos, cada uno con dos caracteres alfabéticos
                    como mínimo. Estarán separadas por un espacio
                  ● A continuación su edad (1-99), separada por un espacio*/
    public static void main(String[] args) {

        //String nombreFicheroAnalizar = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero analizar: ");

        Path fichero = Paths.get("D:\\Desktop\\Intellij\\Tema7_FicherosYAlmacenamiento\\Ejer8\\NombresAnalizar.txt");
        Pattern patron = Pattern.compile("^(\\p{L}{2,}\\s){2}(\\p{L}{2,}\\s)?\\d{1,2}$");

        try (Stream<String> linea = Files.lines(fichero);
             Stream<String> lineaPrint = Files.lines(fichero)){

            /**
             * El método allMatch devuelve true si TODOS los elementos en el flujo cumplen con la condición.
             * Si al menos un elemento no cumple con la condición, devuelve false
             *
             * @linea.map(l->patron.matcher(l)), crea MATCHER a partir del patron con cada línea extraída del flujo.
             *@allMatch(matcher->matcher.matches()), A cada MATCHER se le aplica el método matches()
             * y allMatch devuelve si todos pasa TRUE y solo uno salta devuelve false.
             */

            if (linea.map(l-> patron.matcher(l)).allMatch(matcher -> matcher.matches())){
                System.out.println("**** Válido! ****");
                lineaPrint.forEach(System.out::println);
            }else{
                System.out.println("**** Rechazado! ****");
                lineaPrint.forEach(l-> System.out.println(l));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}