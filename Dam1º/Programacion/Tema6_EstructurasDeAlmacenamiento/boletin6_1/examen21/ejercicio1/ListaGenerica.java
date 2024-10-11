
package examen21.ejercicio1;

import java.util.LinkedList;
import java.util.List;


public class ListaGenerica<T extends Comparable<? super T>> {

    private LinkedList<T> lista;

    public ListaGenerica() {
        lista = new LinkedList<T>();
    }

    public void annadirElemento(T elemento) {
        lista.add(elemento);
    }

   /* public ListaGenerica<T> listaHastaElemento(T elementoBuscado) {

        ListaGenerica<T> nuevaLista = new ListaGenerica<>();
        boolean encontrado = false;
        for (T elemento : lista) {
            if (elemento.equals(elementoBuscado)) {
                encontrado = true;
            }
            nuevaLista.annadirElemento(elemento);
            break;
        }
        if (!encontrado) {
            return null;
        }
        return nuevaLista;
    }*/

    public ListaGenerica<T> listaHastaElemento2(T elementoBuscado) {

        ListaGenerica<T> nuevaLista = new ListaGenerica<>();
        nuevaLista.annadirElemento(elementoBuscado);
        for (T elemento : lista) {
            if (elemento.equals(elementoBuscado)) {
                return nuevaLista;
            }
        }
            return null;

    }

    public ListaGenerica<T> elemetosMenores(T elementoBuscado) {

        ListaGenerica<T> menores = new ListaGenerica<>();
        menores.annadirElemento(elementoBuscado);
        for (T elemento : lista) {
            if (elemento.compareTo(elementoBuscado)<0) {
                menores.annadirElemento(elementoBuscado);
            }
        }
        
            return menores.lista.isEmpty() ? null : menores;

    }

    @Override
    public String toString() {
        return "ListaGenerica=" + lista;
    }


}

