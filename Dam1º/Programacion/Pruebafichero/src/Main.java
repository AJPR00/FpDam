import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Path ruta = Paths.get("src//Matriculas.txt");
        Pattern matriculaP = Pattern.compile("\\d{4}[B-Z&&[^aeiou]]{3}.*", Pattern.CASE_INSENSITIVE);
        Pattern terminaP = Pattern.compile(".*[;:]$", Pattern.CASE_INSENSITIVE);

        try (Stream<String> lineas = Files.lines(ruta)) {
            lineas.forEach(l -> {
                System.out.printf("%d: %s\n", l.split(" ").length, l);
            });



           lineas.map(terminaP::matcher)
                    .filter(matcher -> matcher.matches())
                    .map(matcher -> matriculaP.matcher(matcher.group()))
                    .forEach(matcher -> {
                        while (matcher.find()) {
                            System.out.println(matcher.group());
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    /**
     *
     * Path fichero = Paths.get("./otro/fichero2.txt");
     *         Pattern lineaValida = Pattern.compile(".*[;:]$");
     *         Pattern matriculaValida = Pattern.compile("(\\d{4}[B-Z&&[^EIOU]]{3})", Pattern.CASE_INSENSITIVE);
     *         try (Stream<String> lineas = Files.lines(fichero)) {
     *             lineas.map(lineaValida::matcher)
     *                     .filter(Matcher::matches)
     *                     .map(m -> matriculaValida.matcher(m.group(0)))
     *                     .forEach(m -> {
     *                          while (m.find()){
     *                             System.out.println(m.group(0));
     *                         }
     *                     });
     *         } catch (IOException e) {
     *             System.out.println("Error: " + e.getMessage());
     *         }
     *
     */

    /**
     *
     *try (BufferedReader br = new BufferedReader(new FileReader("./otro/fichero2.txt"))){
     *             String linea;
     *             Pattern lineaValida = Pattern.compile(".*[;:]$");
     *             Pattern matriculaValida = Pattern.compile("(\\d{4}[B-Z&&[^EIOU]]{3})", Pattern.CASE_INSENSITIVE);
     *
     *             while ((linea = br.readLine()) != null) {
     *                 Matcher mLineaValida = lineaValida.matcher(linea);
     *
     *                 if (mLineaValida.matches()){
     *                      Matcher mMatriculaValida = matriculaValida.matcher(linea);
     *
     *                     while (mMatriculaValida.find()){
     *                         System.out.print(mMatriculaValida.group() + " ");
     *                     }
     *                     System.out.println();
     *                 }
     *             }
     *         }
     */


}
