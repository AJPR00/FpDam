package Class.Cartas;

import Interfaces.IAtacable;
import Interfaces.IAtacador;
import Enum.EMateriaPrima;

public class NaveAtaque extends CartaNave implements IAtacador {
    private static final int PUNTO_INICIAL_DEFENSA = 7;
    private static final int PUNTO_INICIAL_PODER = 3;

    /**
     * 5 de oro;
     */
    private static final int UNIDAD_MATERIAL = 5;
    private static final EMateriaPrima TIPO_MATERIAL = EMateriaPrima.ORO;


    private int poderAtaque; // por defecto es 3

    @Override
    public void atacar(IAtacable objetivo, int dano) {

    }
}
