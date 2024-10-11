package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejer3.Class;

import java.util.Comparator;

public class ComparadorFecha implements Comparator<Mensaje> {

    @Override
    public int compare(Mensaje fecha1, Mensaje fecha2) {
        return fecha1.compareTo(fecha2);
    }
}
