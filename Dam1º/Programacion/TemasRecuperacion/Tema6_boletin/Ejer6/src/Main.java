import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Path dir = Paths.get("D:\\Prueba\\a\\a.txt");
        Pattern pattern = Pattern.compile("\\s+");
        AtomicInteger c = new AtomicInteger();
        if (MiEntradaSalida.validarPath(dir))
            try (Stream<String> lines = Files.lines(dir)) {
                System.out.println(lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                        .count());

            } catch (IOException e) {
                throw new RuntimeException("Error al leer el archivo", e);
            }
    }
}
