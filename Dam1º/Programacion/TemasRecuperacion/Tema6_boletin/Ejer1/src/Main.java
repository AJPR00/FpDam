import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get("src/archivo.txt");

        try {
            System.out.println(Files.lines(dir).count());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
