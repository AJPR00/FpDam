import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



    /*  7. Realiza un programa que muestre un menú con las siguientes opciones:
              1. Listar directorio: se pedirá por parámetro el nombre de un directorio y mostrará los
                 archivos que contiene, indicando además cuánto pesa, en KB, cada archivo. Si el
                 archivo es a su vez otro directorio, no se indicará el peso. Si el directorio introducido
                 no existe, o no se dispone de permiso de lectura, se informará sobre ello.
              2. Listar directorio y buscar ficheros que comiencen por una palabra: igual que el
                 punto anterior, pero se pedirá además una cadena que deberá coincidir con el
                 comienzo del nombre del fichero.
              3. Listar archivos con cierta extensión de un directorio: Similar a los anteriores, se
                 preguntará la extensión a buscar y se realizará la búsqueda.
              4. Buscar un archivo en un directorio: Se preguntará el nombre del directorio donde
                 se desea buscar y el nombre del archivo. Si se encuentra, se mostrará la ruta
                 completa del archivo junto con el peso del mismo. Nota, no se considerarán
                 directorios.
              5. Buscar recursivamente un archivo en un directorio: Igual que el anterior, pero se
                 buscará en todos los subdirectorios del mismo. Si se encuentra más de un archivo
                 con el nombre buscado, se listarán todos.
              6. Salir*/


    public class Princial {
        public static void main(String[] args) {
            int option;
            do {
                mostrarMenu();
                option = MiEntradaSalida.leerEntreDeRango("Seleccione", 1, 6);
                switch (option) {
                    case 1:
                        mostrarContenidosCarpeta();
                        break;
                    case 2:
                        listarFicherosEnCarpeta();
                        break;
                    case 3:
                        buscarFicheroConExtensionEnCarpeta();
                        break;
                    case 4:
                        buscarFicheroEnCarpeta();
                        break;
                    case 5:
                        buscarRecursivoArchivoDesdeDirectorio(
                                getValidDirectorio(),
                                MiEntradaSalida.leerCadena("Introduzca el nombre del fichero a buscar")
                        ).forEach(a -> {
                            System.out.print(a.toAbsolutePath());
                            try {
                                System.out.println(" (" + Files.size(a) / 1024.0 + " KB)");
                            } catch (IOException e) {
                                System.out.println(" (Peso no detectado)");
                            }
                        });
                }
            } while (option != 6);
        }

        private static void mostrarContenidosCarpeta() {
            Path directorio = getValidDirectorio();

            System.out.println("Ficheros dentro de la carpeta " + directorio.getFileName() + ":");
            try (Stream<Path> directorios = Files.list(directorio)) {
                directorios.forEach(a -> {
                            if (Files.isRegularFile(a)) {
                                try {
                                    System.out.println(a.getFileName() + " (" + Files.size(a) / 1024.0 + " KB)");
                                } catch (IOException e) {
                                    System.out.println(a.getFileName() + " (Peso no detectado)");
                                }
                            } else if (Files.isDirectory(a)) {
                                System.out.println(a.getFileName() + " (Directorio)");
                            } else {
                                System.out.println(a.getFileName() + " (Otro)");
                            }
                        }
                );
            } catch (NotDirectoryException e) {
                System.out.println("Directorio no encontrado");
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Sin permisos suficientes para leer el directorio");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private static void listarFicherosEnCarpeta() {
            Path directorio = getValidDirectorio();
            String nombre = MiEntradaSalida.leerCadena("Introoduzca el nombre del fichero");

            System.out.println("Ficheros dentro de la carpeta " + directorio.getFileName() + " que empiezan con " + nombre + ":");
            try (Stream<Path> directorios = Files.list(directorio)) {
                directorios.filter(Files::isRegularFile).forEach(System.out::println);
            } catch (NotDirectoryException e) {
                System.out.println("Directorio no encontrado");
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Sin permisos suficientes para leer el directorio");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private static void listarFicherosEnCarpetaIO() {
            File directorio = getValidDirectorio().toFile();
            String nombre = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero");

            File[] archivosPasanFiltro = directorio.listFiles((dir, name) -> dir.getName().startsWith(nombre));
            //No es necesario ya que getValidDirectorio() se asegura de que sea un directorio
            if (archivosPasanFiltro == null) return;

            System.out.println("Estos son los ficheros dentro de la carpeta " +
                    directorio.getName() + " que empiezan por " + nombre + ":");
            for (File archivo : archivosPasanFiltro) {
                System.out.print("  · ");
                if (archivo.isDirectory()) {
                    System.out.println(archivo.getName() + " (Directorio)");
                } else if (archivo.isFile()) {
                    System.out.println(archivo.getName() + " (" + archivo.length() / 1024.0 + " KB)");
                } else {
                    System.out.println(archivo.getName() + " (Otro)");
                }
            }
        }

        private static void buscarFicheroConExtensionEnCarpeta() {
            Path directorio = getValidDirectorio();
            String extension = MiEntradaSalida.leerCadena("Introduzca la extención del archivo (sin punto)");

            try (Stream<Path> contenidos = Files.list(directorio)) {
                contenidos.filter(Files::isRegularFile)
                        .filter(a -> a.toString().endsWith("." + extension))
                        .forEach(a -> {
                            System.out.print("· " + a.getFileName());
                            try {
                                System.out.println(" (" + Files.size(a) / 1024.0 + " KB)");
                            } catch (IOException e) {
                                System.out.println(" (Peso no detectado)");
                            }
                        });
            } catch (NotDirectoryException e) {
                System.out.println("Directorio no encontrado");
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Sin permisos suficientes para leer el directorio");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private static void buscarFicheroConExtensionEnCarpetaIO() {
            String extension = MiEntradaSalida.leerCadena("Introduzca la extensión del fichero (sin punto)");
            File[] files = getValidDirectorio().toFile().listFiles((dir, name) -> name.endsWith("." + extension));
            if (files == null) return;

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName() + " (" + file.length() / 1024.0 + " KB)");
                }
            }
        }

        private static void buscarFicheroEnCarpeta() {
            Path directorio = getValidDirectorio();
            String nombre = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero");

            try (Stream<Path> ficheros = Files.list(directorio)) {
                ficheros.filter(a -> a.endsWith(nombre))
                        .filter(Files::isRegularFile)
                        .forEach(a -> {
                            System.out.print("  · " + a.getFileName());
                            try {
                                System.out.println(" (" + Files.size(a) / 1024.0 + " KB)");
                            } catch (SecurityException e) {
                                System.out.println("No se tienen permisos para entrar en este archivo");
                            } catch (IOException e) {
                                System.out.println(" (Peso no detectado)");
                            }
                        });
            /*
            ficheros.filter(a -> a.getFileName().toString().equals(nombre))
                    .filter(Files::isRegularFile)
                    .forEach(a -> {
                        System.out.print("  · " + a.getFileName());
                        try {
                            System.out.println(" (" + Files.size(a) / 1024.0 + " KB)");
                        } catch (IOException e) {
                            System.out.println(" (Peso no detectado)");
                        }
                    });
            */
            } catch (NotDirectoryException e) {
                System.out.println("Directorio no encontrado");
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Sin permisos suficientes para leer el directorio");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private static List<Path> buscarRecursivoArchivoDesdeDirectorio(Path directorio, String nombre) {
            try (Stream<Path> ficheros = Files.list(directorio)) {
                return ficheros.sorted((a, b) -> {
                    if (Files.isRegularFile(a) && Files.isDirectory(b)) {
                        return -1;
                    } else if (Files.isRegularFile(b) && Files.isDirectory(a)) {
                        return 1;
                    }
                    return a.toString().compareTo(b.toString());
                }).flatMap(a -> {
                    if (Files.isDirectory(a)) {
                        return buscarRecursivoArchivoDesdeDirectorio(a, nombre).stream();
                    } else if (a.endsWith(Paths.get(nombre))) {
                        return Stream.of(a);
                    }
                    return Stream.empty();
                }).toList();
            /*
            ficheros.filter(a -> a.getFileName().toString().equals(nombre))
                    .filter(Files::isRegularFile)
                    .forEach(a -> {
                        System.out.print("  · " + a.getFileName());
                        try {
                            System.out.println(" (" + Files.size(a) / 1024.0 + " KB)");
                        } catch (IOException e) {
                            System.out.println(" (Peso no detectado)");
                        }
                    });
            */
            } catch (NotDirectoryException e) {
                System.out.println("Directorio no encontrado");
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Sin permisos suficientes para leer el directorio");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return new ArrayList<>();
        }//TODO: Files.WalkFileTree

        private static Path getValidDirectorio() {
            String name = MiEntradaSalida.leerCadena("Introduzca el nombre del directorio a mostrar");
            Path outPath = Paths.get(".\\Resources\\" + name);

            while (!Files.isDirectory(outPath)) {
                System.out.println("El nombre del directorio " + name + " no existe");
                name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el directorio a mostrar");
                outPath = Paths.get(".\\Resources\\" + name);
            }

            return outPath;
        }

        private static void mostrarMenu() {
            System.out.println("""
                                
                1. Listar Directorio
                2. Listar Directorio y buscar ficheros que comiencen por una palabra
                3. Listar archivos con cierta extensión de un directorio
                4. Buscar un archivo en un directorio
                5. Buscar Recursivamente un archivo en un directorio
                6. Salir""");
        }
    }