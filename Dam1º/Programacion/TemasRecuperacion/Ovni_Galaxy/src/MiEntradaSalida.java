
import java.time.LocalDate;

import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collections;

import java.util.Scanner;

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
        System.out.println(mensaje + " S o N: ");
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

    public static <T> T leerEnum(String mensaje, T[] opciones) {
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

    public static void ordenArray(String[] array) {
        Arrays.sort(array);
    }

    public static void ordenInversoArray(String[] array) {
        Arrays.sort(array, Collections.reverseOrder());
    }

    /**
     * @param max maximo del rango
     * @param min minimo del rango
     * @return
     * @Math.random() *rango de números (mas 1 para cuenta también integré el último del rango))+ desde donde quiere que empiece a generar;
     */
    public static int numeroAleatorioRango(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}


