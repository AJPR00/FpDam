import java.io.IOException;

public class EscuchaProceso {

    public static void main(String[] args) {

        if (args.length <= 0) {
            System.out.println("Debe indicarse el proceso a escuchar.");
            System.exit(1);
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(args);
            Process p = pb.start();

            while (p.isAlive()) {
                System.out.println("El proceso se esta ejecutando.");
                System.out.print("Escuchando");
                for (int i = 0; i < 6; i++) {
                    Thread.sleep(500);
                    System.out.println(".");
                }
            }
            System.out.println("El proceso terminado.");

        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }

    }


}
