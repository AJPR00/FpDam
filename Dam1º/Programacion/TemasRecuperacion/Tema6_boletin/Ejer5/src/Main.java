import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final String DIR_DEFAULT = "D:/Prueba";

    public static void main(String[] args) {


        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntreDeRango("introdzca una opción del 1 al 5", 1, 5);

            switch (opcion) {

                case 1:
                    System.out.println("Opcion1");
                    String nombreDirectorio = MiEntradaSalida.leerCadena("Introduzca un nombre para el directorio");
                    try {
                        crearDirectorio(nombreDirectorio);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("Opcion2");
                    String nombreFichero = MiEntradaSalida.leerCadena("Introduzca un nombre para el fichero");
                    try {
                        crearFicheroTexto(nombreFichero);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Opcion3");
                    try {
                        listarArchivos();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    String nombreC = MiEntradaSalida.leerCadena("Elija el nombre del fichero a borrar");
                    try {
                        borrarFicheroTexto(nombreC);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    System.out.println("Opcion4");
                    try(Stream<Path> flujo = Files.walk(Paths.get(DIR_DEFAULT))){
                        List<Path> opciones = flujo.filter(Files::isRegularFile).collect(Collectors.toList());  //listarArchivos();
                        System.out.println(opciones.size());
                        MiEntradaSalida.menuNumericoSelecObjeto("Seleciona la ruta",opciones);

                    } catch (IOException e) {
                        System.err.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
            }

        } while (opcion != 5);


    }

    private static void borrarFicheroTexto(String dir) throws IOException {
        Path dirPath = Paths.get(dir);

        if (Files.isRegularFile(dirPath) && MiEntradaSalida.validarPath(dirPath))
            Files.delete(dirPath);
    }

    private static void listarArchivos() throws IOException {
        Path dirPath = Paths.get(DIR_DEFAULT);
        MiEntradaSalida.listArchivo(dirPath);
    }

    private static void crearFicheroTexto(String nombreFichero) throws IOException {
        Path dir = Paths.get(DIR_DEFAULT).resolve(nombreFichero);

        if (MiEntradaSalida.validarPath(dir))
            MiEntradaSalida.validarCrearArchivo(dir);
    }

    private static void crearDirectorio(String nombreDirectorio) throws IOException {

        Path dir = Paths.get(DIR_DEFAULT).resolve(nombreDirectorio);

        MiEntradaSalida.validarCrearDirectorio(dir);
    }

    public static void menu() {

        System.out.println("\n1 Crear directorio");
        System.out.println("2 Crear fichero de texto");
        System.out.println("3 Borrar fichero");
        System.out.println("4 Mostrar ficheros de una carpeta");
        System.out.println("5 Salir");

    }
}
