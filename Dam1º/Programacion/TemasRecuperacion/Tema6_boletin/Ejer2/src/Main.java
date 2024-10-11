import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get("src/archivo.txt");
        StringBuilder sb= new StringBuilder();

        try {
            Files.lines(dir).forEach(l->sb.append(l+" "));
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
