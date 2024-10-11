package Class.Cartas;

import Interfaces.ITransportador;
import Class.Planeta;
import java.util.HashMap;
import Enum.EMateriaPrima;

// Usa el DADO A para establecer el número de material a transportar.
public class NaveCarga extends CartaNave implements ITransportador {
    private static final int PUNTO_INICIAL_DEFENSA = 4;
    /**
     * Valor de la carta 3 de Oro.
     */
    private static final int UNIDAD_MATERIAL = 3;
    private static final EMateriaPrima TIPO_MATERIAL = EMateriaPrima.ORO;

    @Override
    public void transportar(Planeta destino, HashMap cargamento) {

    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public int getPrecio() {
        return 0;
    }
}
