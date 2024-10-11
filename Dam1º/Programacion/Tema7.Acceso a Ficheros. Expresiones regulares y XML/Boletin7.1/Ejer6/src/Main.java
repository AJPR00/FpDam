import javax.crypto.spec.PSource;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
/*    6. Realiza un programa que pida por parámetro el nombre de un directorio y muestre los
    archivos que contiene, indicando además cuánto pesa, en KB, cada archivo. Si el archivo es
    a su vez otro directorio, no se indicará el peso*/


    public static void main(String[] args) {

        String dir = MiEntradaSalida.leerCadena("Deme el nombre de un directorio a mostrar su contenido");
        File path = new File(dir);

        if (path.isDirectory()) {
            List<File> listArcvhivo = Arrays.asList(path.listFiles());

            if (!listArcvhivo.isEmpty()) {
               listArcvhivo.forEach(a -> {
                    if (a.isFile()) {
                        System.out.println(a.getName() + "-" + a.length() / 1024 + "kb.");
                    } else {
                        System.out.println(a.getName());
                    }
                });
            }
        } else {
            System.out.println("No es un directorio.");
        }
    }
}