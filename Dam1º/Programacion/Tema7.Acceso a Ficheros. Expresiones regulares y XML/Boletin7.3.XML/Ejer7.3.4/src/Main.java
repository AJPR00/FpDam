import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

/*1. Expresiones regulares dado el fichero quijote.txt:
            ● Encuentra cuántas veces aparece la palabra razón (con o sin tilde)
            ● Cuenta cuántas tildes (sin tener en cuenta mayúsculas o minúsculas) o eñes hay en
              el texto.
            ● Modifica el fichero para eliminar los números que aparecen tras algunas palabras,
              pues eran referencias en el texto original.
            ● Crea un fichero nuevo donde cada palabra del texto original empiece por
              mayúsculas. Es decir: En Un Lugar De La Mancha ….
            ● Busca e imprime por pantalla aquellas palabras que tengan más de 8 letras.
            ● Busca aquellas frases que tengan menos de 15 palabras.*/


    public static void main(String[] args) {


        Path texto = Paths.get(".\\Boletin7.3.XML\\Ejer7.3.4\\quijote.txt");
        Path textoQuijoteSinNumero = Paths.get(".\\Boletin7.3.XML\\Ejer7.3.4\\quijoteSinNumero.txt");
        Path textoPrimeroMatyuscula = Paths.get(".\\Boletin7.3.XML\\Ejer7.3.4\\quijotePrimeraMayuscula.txt");

        // Usando expresión regular para buscar "razón" con o sin tilde (insensible a mayúsculas y minúsculas)
        //  Pattern patter = Pattern.compile("(?i)raz[oó]n");
        Pattern patternSinAcento = Pattern.compile("\\braz[o]n\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Pattern patternConAcento = Pattern.compile("\\braz[ó]n\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        int contadorSin = 0;
        int contadorCon = 0;
        int contadorCarSec = 0;
        int contadorElim = 0;

        try (BufferedReader bR = Files.newBufferedReader(texto);
             PrintWriter pW = new PrintWriter(Files.newBufferedWriter(textoQuijoteSinNumero));
             PrintWriter pWa = new PrintWriter(Files.newBufferedWriter(textoPrimeroMatyuscula));

        ) {

            String linea;
            while ((linea = bR.readLine()) != null) {
                Matcher sin = patternSinAcento.matcher(linea);
                Matcher con = patternConAcento.matcher(linea);

                while (sin.find()) {
                    contadorSin++;
                }
                while (con.find()) {
                    contadorCon++;
                }
                /*   String linea;
            while ((linea = bR.readLine()) != null) {
                String[] lineas = linea.split("\\s|\\.");
                for (String l : lineas) {
                    if (l.equalsIgnoreCase("razón")) contadorCon++;
                    if (l.equalsIgnoreCase("razon")) contadorSin++;
                }

            }*/

                /* ● Cuenta cuántas tildes (sin tener en cuenta mayúsculas o minúsculas) o eñes hay en
                el texto.*/
                Pattern patterCaracterSpeciales = Pattern.compile("\\b[óéíúáñ]\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
                Matcher carSpe = patterCaracterSpeciales.matcher(linea);

                while (carSpe.find()) {
                    contadorCarSec++;
                }
                
                /*● Modifica el fichero para eliminar los números que aparecen tras algunas palabras,
                pues eran referencias en el texto original.*/

                Pattern patterEliminarNumero = Pattern.compile("(\\p{L})\\d+");
                Matcher matcherEliminarNUmero = patterEliminarNumero.matcher(linea);

                pW.println(matcherEliminarNUmero.replaceAll("$1"));

                /*● Crea un fichero nuevo donde cada palabra del texto original empiece por
                mayúsculas. Es decir: En Un Lugar De La Mancha ….*/

                Pattern patterPrimeraMay = Pattern.compile("\\b(\\p{L})(\\p{L}*)\\d*\\b");
                Matcher matcherPrimeraMay = patterPrimeraMay.matcher(linea);

                pWa.println(matcherPrimeraMay.replaceAll(matchResult -> {
                    return matchResult.group(1).toUpperCase()+matchResult.group(2);
                }));


               /* ● Busca e imprime por pantalla aquellas palabras que tengan más de 8 letras.*/

                Pattern patterOchoLetras = Pattern.compile("\\p{L}{8,}");
                Matcher matcherOchoMas = patterOchoLetras.matcher(linea);

                while (matcherOchoMas.find()){
                    System.out.println(matcherOchoMas.group());
                }


               /* ● Busca aquellas frases que tengan menos de 15 palabras.*/
                Pattern patterPalabras = Pattern.compile("\\p{L}+");
                Matcher matcherPalabras = patterPalabras.matcher(linea);

               if (matcherPalabras.results().count() > 15){
                   System.out.println(linea);
               }

            }

        } catch (IOException e) {
            System.err.println("Error de E/S al abrir el archivo" + e.getMessage());
        }

        System.out.println("Palabras encontras con acentos: " + contadorCon);
        System.out.println("Palabras encontras Sin acentos: " + contadorSin);
        System.out.println("Palabras encontras con eñe y  acentos: " + contadorCarSec);
        System.out.println("Palabras encontras y eliminadas: " + contadorElim);


    }
}
