package Class;

import Class.Cartas.ConstEcudoProtector;
import Class.Cartas.ConstMina;
import Interfaces.IAtacable;

public class Planeta implements IAtacable {
    private final int NUM_MAX_MINAS = 10;
    private String nombre;
    private ConstMina[] minas;
    private int piedra, hierro, combustible, habitante;
    private ConstEcudoProtector escudo;
    private Jugador ocupa;


    public Planeta(String nombre) {
        this.nombre = nombre;
        this.piedra = 5;
        this.hierro = 4;
        this.combustible = 2;
        this.habitante = 30;
        this.minas = new ConstMina[NUM_MAX_MINAS];
    }

    public int getPiedra() {
        return piedra;
    }

    public void construir() {
      /*  ○ Para poder construir en un planeta que no está conquistado por tí (ni por
        nadie más), necesitas mover al menos a una persona.*/
    }

    public boolean isConquistado() {
        return ocupa != null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planeta: ");
        sb.append(nombre);
        if (isConquistado())
            sb.append(", conquistado por ").append(ocupa.getNombre());
        sb.append("\nCaracterísticas: ");
        sb.append("\nHabitante: ").append(habitante);
        sb.append("\nCombustible: ").append(combustible);
        sb.append("\nPiedra: ").append(piedra);
        sb.append("\nHierro: ").append(hierro);
        if (minas.length != 0) {
            sb.append("\nMinas: ");
            for (int i = 0; i < minas.length; i++) {
                sb.append("\n# " + minas[i].toString());
            }
        }
        return sb.toString();
    }

    @Override
    public int getPuntoDefensa() {
        return 0;
    }

    @Override
    public void serAtacado(int dano) {

        /*Al ser atacado, en el caso de que cuente con un escudo protector,
        tiene una probabilidad determinada de evitar cualquier daño: si se
        saca el número más alto del dado o el más bajo, se esquivará el ataque.
        Para ello se utilizará el DADO B.

            ● Si un escudo es atacado y sus puntos de defensa llegan a 0, el planeta se
                 considerará conquistado por el jugador atacante, y todos sus habitantes y minas
                 pasarán a formar parte del jugador atacante.
            ● Si el planeta es atacado y no posee escudo, se considerará conquistado.
            ● No es posible atacar un planeta que no esté conquistado por otro jugador.*/


    }
}


