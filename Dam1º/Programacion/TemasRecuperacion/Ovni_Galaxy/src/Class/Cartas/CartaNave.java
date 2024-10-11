package Class.Cartas;

import Interfaces.IAtacable;

public class CartaNave extends Carta implements IAtacable {
    //Número definido de carta de naves para el juego;
    private static int numCartaDisponible;
    private int puntoDefensa;

    @Override
    public int getPuntoDefensa() {
        return this.puntoDefensa;
    }

    @Override
    public void serAtacado(int dano) {
        // restar dano a la vida

    }
}
