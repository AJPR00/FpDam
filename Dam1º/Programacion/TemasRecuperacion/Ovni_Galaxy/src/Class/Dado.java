package Class;

import Interfaces.ILanzable;

public class Dado implements ILanzable {
    private final int NUM_MIN_CARAS = 4;
    private int numCara;
    private int min;

    public Dado(int numCara, int min) {
        this.numCara = numCara;
        this.min = min;
    }

    @Override
    public int lanzar() {
        /*int caraValor = 0;
        for (int i = 0; i < NUM_MIN_CARAS; i++) {
            caraValor = (int) (Math.random() * max - min + 1) + min;
        }
        return caraValor;*/
        return (int) (Math.random() * ((numCara+min) - min) + min);
    }

    @Override
    public int getMin() {
        return this.min;
    }


    @Override
    public int getMax() {
        return numCara+min-1;
    }
}
