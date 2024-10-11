package ejer7;

import java.util.Comparator;

public class OrdenDuracion implements Comparator<Receta> {
    @Override
    public int compare(Receta o1, Receta o2) {
        return o1.getTiempo()-o2.getTiempo();
    }


}
