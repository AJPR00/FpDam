import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MiEntradaSalida {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero comprendido entre el minimo y en  el máximo
     *
     * @param min valor mínimo
     * @param max valor máximo
     * @return
     */
//************************************************************************************
    public static int leerEntreDeRango(String mensaje, int min, int max) {
        /*if (min >= max) {
            //Todo: Hacer cuadno conozcamos las exepciones
        }*/

        System.out.println(mensaje);
        int numeroLeido;
        do {
            try {
                numeroLeido = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                numeroLeido = -1;
            }

            if (numeroLeido < min || numeroLeido > max) {
                System.out.printf("Por Favor, introduce un valor entre %d y %d: ", min, max);
            }

        } while (numeroLeido < min || numeroLeido > max);
        return numeroLeido;
    }
//************************************************************************************


    public static void cerrarSc() {

        sc.close();
    }


    public static int leerEntero(String mensaje) {
        int num = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                valido = true;
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                sc.next(); // Vacia el buffer del Escanner en caso de ser incorrecta la entrada.
            }
        }
        return num;
    }

    public static double leerDouble(String mensaje) {
        double num = 0;
        boolean valido = false;


        while (!valido) {
            System.out.println(mensaje);
            try {
                num = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Inserte un valor decimal");
            }
        }
        /*double num = 0.0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensaje);
            if (sc.hasNextDouble() || sc.hasNextInt()) {
                num = sc.nextDouble();
                valido = true;
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número decimal.");
                sc.next(); // Vacia el buffer del Escanner
            }
        }*/
        return num;
    }

    public static int leerPositivo(String mensaje) {
        int numeroLeido;

        do {
            System.out.println(mensaje);
            numeroLeido = Integer.parseInt(sc.nextLine());
            if (numeroLeido < 0) {
                System.out.printf("Por Favor, introduce un valor positivo: ");
            }
        } while (numeroLeido < 0);

        return numeroLeido;
    }

    public static char leerSN(String mensaje) {
        System.out.println(mensaje + ": ");
        char sn;

        do {
            sn = sc.nextLine().toUpperCase().charAt(0);
        } while (sn != 'S' && sn != 'N');

        return sn;
    }

    public static boolean leerBoleanSN(String mensaje) {
        System.out.println(mensaje + "  (s/n): ");
        char sn;

        do {
            sn = sc.nextLine().toUpperCase().charAt(0);
        } while (sn != 'S' && sn != 'N');

        return sn == 'S';
    }


    public static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        String cadena = null;

        do {
            cadena = sc.nextLine();
        } while (cadena.isEmpty());

        return cadena;
    }

    public static LocalDate leerFecha(String mensaje) {
        LocalDate f = null;
        boolean fValida = false;

        while (!fValida) {
            System.out.print(mensaje);
            int dia = leerEntreDeRango("\n Deme el dia: ", 1, 30);
            int mes = leerEntreDeRango("Deme el mes: ", 1, 12);
            int anno = leerEntreDeRango("Deme el año: ", 1900, 2100);
            try {
                f = LocalDate.of(anno, mes, dia);
                fValida = true;
            } catch (DateTimeParseException | IllegalArgumentException e) {
                System.out.println("Fecha inválida, por favor intente nuevamente.");
            }
        }
        return f;
    }
    //************************************************************************************

    /**
     * Calcula la edad basada en la fecha de nacimiento.
     *
     * @param fNacimiento La fecha de nacimiento
     * @return La edad calculada en años
     */
    public static int calcularEdad(LocalDate fNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fNacimiento, fechaActual).getYears();
    }

    /**
     * Redondea un número a un número específico de posiciones decimales.
     *
     * @param num        El número que queremos redondear.
     * @param numDecimal El número de posiciones decimales.
     * @return El número redondeado a las posiciones decimales especificadas.
     * @throws IllegalArgumentException si numDecimal es negativo.
     *                                  <p>
     *                                  Este método utiliza Math.pow() para mover el punto decimal de num hacia la derecha
     *                                  y luego redondea el valor resultante usando Math.round(). Finalmente, se mueve
     *                                  el punto decimal de vuelta a la izquierda para obtener el número redondeado.
     *                                  <p>
     *                                  ojo! Tambien se puede realizar el redondeo como String en la salida (System.out.printf("%.2f",num) o String.format con println)
     */
    public static double redondeoDecimal(double num, int numDecimal) {
        if (numDecimal < 0) {
            throw new IllegalArgumentException("El número de decimales no puede ser negativo.");
        }

        long factor = (long) Math.pow(10, numDecimal);
        num = num * factor;
        long numRedondeado = Math.round(num);
        return (double) numRedondeado / factor;
    }

    public static Object listarEnum(Object[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + 1 + "# " + array[i]);
        }
        return array[MiEntradaSalida.leerEntreDeRango("Selecione una option", 1, array.length) - 1];
    }

    public static String leerOpciones(String mensaje, String[] opciones) {
        int opcionElegida;

        do {
            System.out.println(mensaje);
            for (int i = 0; i < opciones.length; i++) {
                System.out.printf("  · %d. %s \n", i + 1, opciones[i]);
            }
            opcionElegida = leerEntero("Selección");
        } while (opcionElegida <= 0 || opcionElegida > opciones.length);

        return opciones[opcionElegida - 1];
    }

    /**
     * Método que proporciona menu numérico que permite seleccionar objetos de una lista
     *
     * @param mensaje
     * @param opciones Lista para seleccionar objetos
     * @param <T>      Lista genérica
     * @return
     */
    public static <T> T menuNumericoSelecObjeto(String mensaje, List<T> opciones) {
        int opcionElegida;

        do {
            System.out.println(mensaje);
            for (int i = 0; i < opciones.size(); i++) {
                System.out.printf("  · %d. %s \n", i + 1, opciones.get(i));
            }
            opcionElegida = leerEntero("Selección");
        } while (opcionElegida <= 0 || opcionElegida > opciones.size());

        return opciones.get(opcionElegida - 1);
    }

    public static void ordenArray(String[] array) {
        Arrays.sort(array);
    }

    public static void ordenInversoArray(String[] array) {
        Arrays.sort(array, Collections.reverseOrder());
    }

    public static int numeroAleatorioRango(int max, int min) {
        return (int) (Math.random() * max - min + 1) + min;
    }


    /**
     * // Ordenar por precio y luego por nombre en caso de empate
     * productos.sort(Comparator.comparing(Producto::getPrecio)
     * .thenComparing(Producto::getNombre));
     * <p>
     * // Ordenar por precio descendente usando Comparator.comparing
     * productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
     * <p>
     * public double mediaEdad() throws LigaException {
     * return todosLosJugadores().stream().mapToInt(Jugador::calculaEdad).average().orElseThrow(()-> new LigaException("Sin edad media"));
     */

    public static void serializarObjeto(Object o, Path path) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(o);
            System.out.println("Producto serializado y guardado en " + path);
        } catch (IOException e) {
            System.err.println("Error al serializar el producto: " + e.getMessage());
        }
    }

    public static Object deserializarProducto(Path path) {
        Object o = null;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            o = (Object) in.readObject();
            System.out.println("Producto deserializado desde " + path);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el producto: " + e.getMessage());
        }
        return o;
    }

    public static boolean validarPath(Path path) {
        if (path == null) {
            System.err.println("El directorio es null.");
            return false;
        }

        if (path.toString().isEmpty()) {
            System.err.println("El directorio está vacío.");
            return false;
        }

        if (!Files.exists(path)) {
            System.err.println("El directorio no existe: " + path);
            return false;
        }

        if (!Files.isReadable(path)) {
            System.err.println("No tienes permiso de lectura para el directorio: " + path);
            return false;
        }

        if (!Files.isWritable(path)) {
            System.err.println("No tienes permiso de escritura para el directorio: " + path);
            return false;
        }

        return true;
    }

    /**
     * Busca en el directorio el archivo pasado por patron.
     *
     * @param startDir     directorio donde empezar a buscar.
     * @param regexPattern el String que se le pasa al Pattern
     * @return
     */
    public static List<Path> buscarFiceroConRegex(Path startDir, String regexPattern) {
        List<Path> listaDir = new ArrayList<>();

        try {
            Pattern patron = Pattern.compile(regexPattern);

            try (Stream<Path> paths = Files.walk(startDir)) {
                paths.filter(Files::isRegularFile)
                        .forEach(file -> {
                            Matcher matcher = patron.matcher(file.getFileName().toString());
                            while (matcher.matches()) {
                                listaDir.add(file);
                            }
                        });
            }
        } catch (IOException e) {
            System.err.println("Error durante la búsqueda: " + e.getMessage());
        }
        return listaDir;
    }

    /**
     * Agrega una cadena al final de un archivo.
     *
     * @param dir       La ruta del archivo.
     * @param contenido El contenido que se agregará al final del archivo.
     * @throws IOException Si ocurre un error de E/S.
     * @metodo contenido.getBytes(), convierte String en bytes a un estándar específico.
     */
    public static void anndirTextoAppen(Path dir, String contenido) throws IOException {

        boolean valida = true;
        try {
            do {
                if (validarPath(dir)) {
                    String texto = leerCadena("Introduzca el nuevo texto");
                    if (!Files.readAllLines(dir).isEmpty()) {
                        if (leerBoleanSN("Quieres sobrescribir, S o N"))
                            //Files.write(dir,MiEntradaSalida.leerCadena("Introduzca nuevo texto").getBytes(StandardCharsets.UTF_8)),StandardOpenOption.APPEND);
                            Files.write(dir, texto.getBytes(StandardCharsets.UTF_8));
                    }
                    Files.write(dir, texto.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

                }
                if (valida) {
                    validarCrearArchivo(dir);
                    valida = false;
                }

            } while (leerBoleanSN("Quieres volver a escribir"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Contenido agregado al archivo: " + dir.toAbsolutePath());
    }

    /**
     * Valida si un archivo existe y, en caso de que no exista, solicita al usuario si desea crearlo.
     *
     * @param dirArchivo La ruta del archivo.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void validarCrearArchivo(Path dirArchivo) throws IOException {

        if (Files.exists(dirArchivo)) {
            System.out.println("El archivo ya existe: " + dirArchivo.toAbsolutePath());
        } else {
            System.out.println("El archivo no existe: " + dirArchivo.toAbsolutePath());

            if (leerBoleanSN("¿Desea crear el archivo? (s/n): ")) {
                try {
                    Files.createFile(dirArchivo);
                    System.out.println("Archivo creado exitosamente: " + dirArchivo.toAbsolutePath());
                } catch (IOException e) {
                    System.err.println("Error al crear el archivo: " + e.getMessage());
                    throw e;
                }
            } else {
                System.out.println("El archivo no ha sido creado.");
            }
        }
    }

    /**
     * Validar si un directorio existe y, en caso de que no exista, solicita al usuario si desea crearlo.
     *
     * @param dir La ruta del directorio.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void validarCrearDirectorio(Path dir) throws IOException {

        if (validarPath(dir) && Files.isDirectory(dir)) {
            System.out.println("El directorio ya existe: " + dir.toAbsolutePath());
        } else {
            System.out.println("El directorio no existe: " + dir.toAbsolutePath());
            if (leerBoleanSN("¿Desea crear el directorio? (s/n): ")) {
                try {
                    Files.createDirectories(dir);
                    System.out.println("Directorio creado exitosamente: " + dir.toAbsolutePath());
                } catch (IOException e) {
                    System.err.println("Error al crear el directorio: " + e.getMessage());
                    throw e;
                }
            } else {
                System.out.println("El directorio no ha sido creado.");
            }
        }
    }

    /**
     * Lista todos los ficheros en un directorio dado.
     *
     * @param directorio La ruta del directorio.
     * @throws IOException Si ocurre un error de E/S.
     * @DirectoryStream<Path> flujo = Files.newDirectoryStream(directorio) crea un flujo con los Path.
     */
    public static void listArchivosRegulas(Path directorio) throws IOException {

        if (validarPath(directorio) && Files.isDirectory(directorio)) {
            try (DirectoryStream<Path> flujo = Files.newDirectoryStream(directorio)) {
                for (Path p : flujo) {
                    if (Files.isRegularFile(p))
                        System.out.printf("[F] %s, Tamaño: %d kb. \n", p.getFileName(), Files.size(p) / 1024);
                }
            } catch (IOException e) {
                System.err.println("Error al listar los ficheros: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio: " + directorio.toAbsolutePath());
        }
    }

    /**
     * Lista todos los ficheros y directorios en un directorio dado.
     *
     * @param dir La ruta del directorio.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void listArchivosDirectorios(Path dir) throws IOException {
        if (Files.exists(dir) && Files.isDirectory(dir)) {
            try (DirectoryStream<Path> flujoPath = Files.newDirectoryStream(dir)) {
                for (Path p : flujoPath) {
                    if (Files.isDirectory(p)) {
                        System.out.printf("[D] %s, Tamaño: %d kb. \n", p.getFileName(), Files.size(p) / 1024);
                    } else if (Files.isRegularFile(p)) {
                        System.out.printf("[F] %s, Tamaño: %d kb. \n", p.getFileName(), Files.size(p) / 1024);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al listar los ficheros y directorios: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio: " + dir.toAbsolutePath());
        }
    }

    /**
     * Convierte una lista de archivos en un array de Path.
     *
     * @param lista La lista de archivos.
     * @return Un array de Path.
     */
    public static Path[] convertListToArray(List<Path> lista) {
        return lista.toArray(new Path[0]);
    }

    /**
     * Procesa un archivo para encontrar líneas que coinciden con un patrón de terminación
     * y busca patrones de matrículas en esas líneas.
     *
     * @param rutaArchivo La ruta del archivo a procesar.
     * @param regexA      El patrón para filtrar líneas que terminan con un determinado carácter.
     * @param regexB      El patrón para buscar matrículas en las líneas filtradas.
     */
    public static List<Path> procesarArchivo(Path rutaArchivo, Pattern regexA, Pattern regexB) {
        List<Path> listPath = new ArrayList<>();

        try (Stream<String> lineas = Files.lines(rutaArchivo)) {
            lineas.map(s -> regexA.matcher(s))
                    .filter(matcher -> matcher.matches())
                    .map(matcherFiltrado -> regexB.matcher(matcherFiltrado.group()))
                    .forEach(matcher -> {
                        while (matcher.find()) {
                            listPath.add(Paths.get(matcher.group()));
                        }
                    });


        } catch (UnsupportedOperationException e) {
            System.err.println("Error al crear el directorio: Operación no soportada en ");
        } catch (FileAlreadyExistsException e) {
            System.err.println("Error al crear el directorio: Ya existe ");
        } catch (SecurityException e) {
            System.err.println("Error al crear el directorio: Permiso denegado en ");
        } catch (IOException e) {
            System.err.println("Error al crear el directorio: Error de E/S en ");
        }

        return listPath;

    }

    /**
     * import java.io.IOException;
     * import java.nio.file.*;
     * import java.nio.file.attribute.BasicFileAttributes;
     * import java.util.ArrayList;
     * import java.util.Comparator;
     * import java.util.List;
     *
     * public class OrdenarPorTamaño {
     *
     *     public static void main(String[] args) {
     *         Path dir = Paths.get("D:\\Prueba");
     *         try {
     *             List<Path> sortedPaths = getPathsSortedBySize(dir);
     *             sortedPaths.forEach(path -> {
     *                 try {
     *                     System.out.printf("%s: %d bytes%n", path, Files.size(path));
     *                 } catch (IOException e) {
     *                     System.err.println("Error al obtener el tamaño de " + path);
     *                 }
     *             });
     *         } catch (IOException e) {
     *             System.err.println("Error al listar el directorio: " + e.getMessage());
     *         }
     *     }
     *
     *     public static List<Path> getPathsSortedBySize(Path dir) throws IOException {
     *         List<Path> paths = new ArrayList<>();
     *
     *         // Recorrer el directorio y sus subdirectorios
     *         Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
     *             @Override
     *             public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
     *                 paths.add(file);
     *                 return FileVisitResult.CONTINUE;
     *             }
     *
     *             @Override
     *             public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
     *                 paths.add(dir);
     *                 return FileVisitResult.CONTINUE;
     *             }
     *         });
     *
     *         // Ordenar los archivos y directorios por tamaño
     *         paths.sort(new Comparator<Path>() {
     *             @Override
     *             public int compare(Path p1, Path p2) {
     *                 try {
     *                     long size1 = Files.size(p1);
     *                     long size2 = Files.size(p2);
     *                     return Long.compare(size1, size2);
     *                 } catch (IOException e) {
     *                     throw new RuntimeException(e);
     *                 }
     *             }
     *         });
     *
     *         return paths;
     *     }
     * }
     */
}
