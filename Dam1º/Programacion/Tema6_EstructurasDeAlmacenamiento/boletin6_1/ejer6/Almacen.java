package ejer6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Almacen {

    private static final int NUMERO_CAJA = 3;
    private Caja[] cajasDisponible;
    private int contadorClientes;

    public Caja[] getCajasDisponible() {
        return cajasDisponible;
    }

    public Almacen() {
        //inicializa la array para almacenar los 20 objetos de cajas
        this.cajasDisponible = new Caja[NUMERO_CAJA];
        //for para crear Caja por Caja y guardándolas en la array.
        for (int i = 0; i < cajasDisponible.length; i++) {
            cajasDisponible[i] = new Caja(i + 1);
        }
        this.contadorClientes=0;
    }


    public void abrirCaja(Almacen almacen, int numCaja) throws ExcepcionCaja {
        if (numCaja < 1 || numCaja > NUMERO_CAJA) throw new ExcepcionCaja("La caja no existe");
        cajasDisponible[numCaja - 1].abrir();
    }

    public void cerrarCaja(Almacen almacen, int numCaja) throws ExcepcionCaja {
        if (numCaja < 1 || numCaja > NUMERO_CAJA) throw new ExcepcionCaja("La caja no existe");
        cajasDisponible[numCaja - 1].cerrar();

    }

   // Genero un Objeto Integer que es un usuario, a través del método cajaLiviana le paso por parámetro la caja con menos cola
    public Integer nuevoCliente() throws ExcepcionCaja {
        Integer i = contadorClientes++;
        return i;
    }


    public   int cajaLiviana(Almacen almacen) { //Todo modificar método para que solo me compare las cajas abierta
        int colaMenor = 0;
        for (int i = 0; i < cajasDisponible.length - 1; i++) {
            if (cajasDisponible[colaMenor].getCola().size() > cajasDisponible[i + 1].getCola().size()) {
                if (cajasDisponible[colaMenor = i + 1].isAbierto()){
                    colaMenor = i + 1;
                }
            }
        }
        return colaMenor;
    }

  /*  public String nuevoCliente() throws ExcepcionCaja {
        if (Stream.of(cajasDisponible).filter(c -> c.isAbierto()).count() == 0) {
            throw new ExcepcionCaja("No se admite mas clientes, cajas cerradas");
        }

        Caja c = Stream.of(cajasDisponible).filter(Caja::isAbierto).sorted((a, b) -> a.getCola().size() - b.getCola().size()).toList().get(0);

        return "Es usted el número "+ ++contadorClientes+" y deber de ir al la caja " + c.getCola().size();
    }*/

    public void atenderCliente(Almacen almacen, int numCaja) throws ExcepcionCaja {
        if (numCaja < 1 || numCaja > NUMERO_CAJA) throw new ExcepcionCaja("La caja no existe");
        cajasDisponible[numCaja - 1].atender();
    }

    public void esperando(String mensaje) throws InterruptedException {
        for (int i = 0; i <= 8; i++) {
            System.out.print(mensaje);
            Thread.sleep(500);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Cajas: \n").append(Arrays.toString(cajasDisponible).toString() + "\n");
        return sb.toString();
    }
}
