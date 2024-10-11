
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
            numeroLeido = Integer.parseInt(sc.nextLine());

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

        int num;
        System.out.println(mensaje);
        num = Integer.parseInt(sc.nextLine());
        return num;
    }


    //************************************************************************************

    public static int leerPositivo(String mensaje, int num) {


        System.out.println(mensaje);

        int numeroLeido;

        do {
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
        System.out.println(mensaje + ":");
        String cadena = null;
        do {
            cadena = sc.nextLine();
        } while (cadena.isEmpty());

        return cadena;
    }
}