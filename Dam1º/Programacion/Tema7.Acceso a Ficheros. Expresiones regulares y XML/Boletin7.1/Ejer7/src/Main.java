import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    //7. Realiza un programa que muestre un menú con las siguientes opciones:

    //Todo Stream<Path> stream = Files.walk(startPath) Investigar, recorre un árbol de directorio

    public static void main(String[] args) {
        int option;
        do {
            menu();
            option = MiEntradaSalida.leerEntreDeRango("Seleccione la opción: ", 1, 6);
            switch (option) {
                case 1:
                    String dir = MiEntradaSalida.leerCadena("Deme un directorio para ver su contenido:");
                    try {
                        imprimirLista(listarContenidoDirectorio(dir));
                    } catch (NoSuchFileException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    String srcFiche = MiEntradaSalida.leerCadena("Deme un el nombre del fichero a buscar: ");
                    String dir2 = MiEntradaSalida.leerCadena("\nY ahora deme el directorio donde buscar: ");
                    try {
                        imprimirLista(buscarFicheroEnLista(listarContenidoDirectorio(dir2), srcFiche));
                    } catch (NoSuchFileException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    String srcExt = MiEntradaSalida.leerCadena("Deme extensión a buscar: ");
                    String dirExt = MiEntradaSalida.leerCadena("\nY ahora deme el directorio donde buscar: ");
                    try {
                        imprimirLista(listarFicheroConExtensionEspecifico(listarContenidoDirectorio(dirExt), srcExt));
                    } catch (NoSuchFileException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    String srcArch = MiEntradaSalida.leerCadena("Deme el nombre del archivo a buscar: ");
                    String dirArch = MiEntradaSalida.leerCadena("\nY ahora deme el directorio donde buscar: ");
                    try {
                        imprimirLista(buscarFicheroYCarpeta(listarContenidoDirectorio(dirArch), srcArch));
                    } catch (NoSuchFileException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    String srcArchRec = MiEntradaSalida.leerCadena("Deme el nombre del archivo a buscar: ");
                    String dirArchRec = MiEntradaSalida.leerCadena("\nY ahora deme el directorio donde buscar: ");
                    try {
                        Path encontrado = buscarRecursivamente(listarContenidoDirectorio(dirArchRec), srcArchRec);
                       if (encontrado != null){
                           System.out.println("Encontrado: "+ encontrado.toAbsolutePath());
                       }else {
                           System.out.println("No encontrado");
                       }
                    } catch (NoSuchFileException e) {
                        System.out.println(e.getMessage());
                    }
            }
        } while (option != 6);
    }

    /*OPTION 5 Buscar recursivamente un archivo en un directorio: Igual que el anterior, pero se
               buscará en todos los subdirectorios del mismo. Si se encuentra más de un archivo
               con el nombre buscado, se listarán todos.*/
    public static Path buscarRecursivamente(ArrayList<Path> dir, String srcArc) {


        for (int i = 0; i < dir.size(); i++) {
            Path p = dir.get(i);

            if (p.getFileName().toString().startsWith(srcArc) && Files.isRegularFile(p)) {
                return p;
            } else if (Files.isDirectory(p)) {
                try (Stream<Path> listSubDirectorio = Files.list(p)) {
                    Path pt = buscarRecursivamente(new ArrayList<>(listSubDirectorio.collect(Collectors.toList())), srcArc);
                    if (pt != null) return pt;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;

    }

    /* OPTION 4 Buscar un archivo en un directorio: Se preguntará el nombre del directorio donde
    se desea buscar y el nombre del archivo. Si se encuentra, se mostrará la ruta
    completa del archivo junto con el peso del mismo. Nota, no se considerarán directorios.*/
    private static ArrayList<Path> buscarFicheroYCarpeta(ArrayList<Path> dir, String srcExt) {
        return (ArrayList<Path>) dir.stream().filter(path -> Files.isRegularFile(path) && path.getFileName().toString().startsWith(srcExt)).collect(Collectors.toList());
    }

    /* OPTION 3 Listar archivos con cierta extensión de un directorio: Similar a los anteriores, se
                    preguntará la extensión a buscar y se realizará la búsqueda.*/
    private static ArrayList<Path> listarFicheroConExtensionEspecifico(ArrayList<Path> dir, String srcExt) {
        return (ArrayList<Path>) dir.stream()
                .filter(Files::isRegularFile)
                .filter(path -> path.getFileName().toString().endsWith("." + srcExt))
                .collect(Collectors.toList());
    }

    /*OPTION 2 Listar directorio y buscar ficheros que comiencen por una palabra: igual que el
      punto anterior, pero se pedirá además una cadena que deberá coincidir con el
      comienzo del nombre del fichero.*/
    private static ArrayList<Path> buscarFicheroEnLista(ArrayList<Path> dir, String src) {
        return (ArrayList<Path>) dir.stream().filter(path -> path.getFileName().toString().startsWith(src)).collect(Collectors.toList());
    }

    /* OPTION 1 Listar directorio: se pedirá por parámetro el nombre de un directorio y mostrará los
       archivos que contiene, indicando además cuánto pesa, en KB, cada archivo. Si el
       archivo es a su vez otro directorio, no se indicará el peso. Si el directorio introducido
       no existe, o no se dispone de permiso de lectura, se informará sobre ello.*/
    private static ArrayList<Path> listarContenidoDirectorio(String dir) throws NoSuchFileException {
        Path directorio = Paths.get(dir);

        if (!Files.exists(directorio)) {
            throw new NoSuchFileException("El directorio " + dir + " no existe.");
        }

        try (Stream<Path> pathFliujo = Files.list(directorio)) {
            //Convierto el flujo en una Lista.
            return (ArrayList<Path>) pathFliujo.collect(Collectors.toList());
        } catch (IOException d) {
            throw new RuntimeException("Error al listar el contenido del directorio: " + dir, d);
        }
    }

    //Método para ordenar e imprimir List
    private static void imprimirLista(ArrayList<Path> list) {
        list.stream().sorted((a, b) -> {
            if (Files.isRegularFile(a)) {
                return 1;
            } else if (Files.isDirectory(b)) {
                return -1;
            }
            return 0;
        }).forEach(path -> {
            try {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.getFileName() + " " + Files.size(path) / 1024 + "kb");
                } else {
                    System.out.println(path.getFileName());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }



        /*if (Files.isDirectory(directorio)) {
            try (Stream<Path> path = Files.list(directorio);){
               path.forEach(p-> {
                   try {
                       if (Files.isRegularFile(p)) {
                           System.out.println(p.getFileName() + " " + Files.size(p) / 1024 + "kb");
                       } else {
                           System.out.println(p.getFileName());
                       }
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               });
               // Exception Archivo no existe
            } catch (NoSuchFileException e) {
                System.out.println("Directorio no existe");
                // Exception acceso denegado al archivo.
            *//*}catch (AccessDeniedException e){
                System.out.println("No tienes permiso");*//*
            } catch (IOException e) {
                System.out.println("No tienes permiso");
            }

        }else {
            System.out.println("No es un directorio");
        }*/
    //Con Iterator.

            /*Iterator<Path> it = null;
            try  {
                it = Files.list(directorio).iterator();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (it.hasNext()) {
                Path rut = it.next();
                if (Files.isRegularFile(rut)) {
                    try {
                        System.out.println(rut.getFileName()+"-"+Files.size(rut)/1024+"kb");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    System.out.println(rut.getFileName());
                }
              }
              }
            */


    public static void menu() {
        System.out.println("""
                                
                1. Listar Directorio
                2. Listar Directorio y buscar carpeta que comiencen por una palabra
                3. Listar archivos con cierta extensión de un directorio
                4. Buscar un archivo en un directorio
                5. Buscar Recursivamente un archivo en un directorio
                6. Salir
                """);
    }
}
