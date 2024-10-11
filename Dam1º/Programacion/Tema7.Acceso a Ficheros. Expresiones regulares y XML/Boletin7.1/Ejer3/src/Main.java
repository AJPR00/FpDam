import java.io.*;


public class Main {

   /* 3. Realiza un programa que acepte líneas del teclado y las añada a un fichero llamado
    salidaEj3.txt, sin sobreescribir el contenido que ya hubiera en dicho fichero. La entrada
    deberá terminar cuando el usuario escriba una línea que tenga únicamente la palabra “fin”.*/

    public static void main(String[] args) {

        /**
         * Creamos el BufferedReader para almacenar temporalmente el flujo que abrimos con InputStreamReader(System.in).
         * Para una salida creamos un objeto con PrintWriter que nos proporciona un buffer que se alimenta
         * de un flujo FileWriter("./Ejer3/salidaEj3.txt",true(bolean nos permite no sobrescribir)), FileWriter si no encuentra el fichero lo crea.
         * */

        try (BufferedReader bF = new BufferedReader(new InputStreamReader(System.in),10);
             PrintWriter pW = new PrintWriter(new FileWriter("Ejer3/salidaEj3.txt", true),true);
        ) {
            String linea;
            while (!(linea = bF.readLine()).equalsIgnoreCase("fin")) {
                pW.println(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}