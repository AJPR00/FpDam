package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejer3.Class;

import java.util.Comparator;

public class ComparadorRemitente implements Comparator<Mensaje> {

    @Override
    public int compare(Mensaje remitente1, Mensaje remitente2) {
        return remitente1.getRemitente().getNombre().compareTo(remitente2.getRemitente().getNombre());
    }
}
