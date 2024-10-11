package Class.Cartas;

import Interfaces.ITransportable;
import Enum.EMateriaPrima;
import Class.Planeta;

// Se usa el DADO C para determinar el número de personas a transportar.
public class NaveTransporte extends CartaNave implements ITransportable {
    private static final int PUNTO_INICIAL_DEFENSA = 4;

    /**
     * Valor de la carta 2 de Oro.
     */
    private static final int UNIDAD_MATERIAL = 2;
    private static final EMateriaPrima TIPO_MATERIAL = EMateriaPrima.ORO;
    @Override
    public void transporta(Planeta destino, int personas) {

    }
}
