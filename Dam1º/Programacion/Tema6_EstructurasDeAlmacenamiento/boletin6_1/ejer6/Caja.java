package ejer6;

import java.util.LinkedList;
import java.util.Queue;

public class Caja {
    private int numCaja;
    private boolean abierto;

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    private Queue<Integer> cola;



    public boolean isAbierto() {
        return abierto;
    }

    public Queue<Integer> getCola() {
        return cola;
    }

    public Caja(int numeroCaja) {
        this.abierto = false;
        this.cola = new LinkedList<>();
        this.numCaja = numeroCaja;
    }

    /**
     * Cada caja tiene su cola que es una LinkedList
     */

    public void abrir() throws ExcepcionCaja {
        if (abierto) throw new ExcepcionCaja("Caja ya esta abierta");
        this.abierto = true;
    }

    public void cerrar() throws ExcepcionCaja {
        if (!abierto) throw new ExcepcionCaja("Caja ya esta cerrada");
        if (!cola.isEmpty()) throw new ExcepcionCaja("Caja no se puede cerrar la caja, hay clientes");
        this.abierto = false;
    }

    public void nuevoClienteCola(Integer numCliente) throws ExcepcionCaja {
        if (!abierto) throw new ExcepcionCaja("Caja cerrada, no se puede añadir cliente");
        this.cola.add(numCliente);
    }

    public Integer atender() throws ExcepcionCaja {
        if (!abierto) throw new ExcepcionCaja("Caja cerrada, no hay clientes que atender");
        // .poll elimina y te devuelve el eliminado, siempre el primero de la cola(mas antiguo de la cola), si no hay nada en cola devuelve un NULL, el resultado se guarda en un objeto INTEGER en este caso
        Integer clienteAtendido = this.cola.poll();
        if (clienteAtendido == null) throw new ExcepcionCaja("No hay clientes que atender");
        return clienteAtendido;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("# Caja: ").append(numCaja);
        sb.append("\n Estado: ").append(abierto).append("\n");
        sb.append("Clientes en cola: ").append(cola.size()).append("\n\n");
        return sb.toString();
    }

}
