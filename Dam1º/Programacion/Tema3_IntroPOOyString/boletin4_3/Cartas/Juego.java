package boletin4_3.Cartas;
/*1. Vamos a crear un pequeño juego de cartas (en el que en realidad no se puede jugar
        jeje). Consiste en crear la funcionalidad necesaria para crear una baraja de cartas y
        realizar algunos métodos con ella. Para ello, necesitamos algunos elementos:
        ● Carta:
        ○ palo, String
        ○ número, cadena
        ● Juego:
        ○ baraja
        ○ método mostrarBaraja. Debe imprimir las cartas que están en la baraja, en
        el orden en el que se encuentren.
        ○ método barajar. Debe barajar la baraja desordenando las cartas de la
        misma.
        ○ método repartir (numJugadores, numCartas). Debe repartir a los jugadores
        indicados (simplemente muestra por pantalla) el número de cartas que se
        indica. Si no hay cartas suficientes para repartir a todos, debe indicarse el
        error y no repartir a ninguno.
        ○ método cartasRestantes. Debe indicar cuántas cartas quedan en el mazo.*/

import java.util.Random;

public class Juego {
    private Carta[] baraja;

    public static void main(String[] args) {
        Juego j = new Juego();
        //j.muestraBaraja();

        j.barajar();
        j.barajar();
        j.muestraBaraja();

        Juego j2 = new Juego();

    }

    public Juego() {
        baraja = new Carta[Carta.palos.length * Carta.NUMERO_MAXIMO];
        int numCartas = 0;

        for (String palo : Carta.palos) {
            for (int i = Carta.NUMERO_MINIMO; i <= Carta.NUMERO_MAXIMO; i++) {
                Carta c = new Carta(palo, i);
                baraja[numCartas++] = c;
            }
        }

    }

    public void barajar() {
        Carta[] auxiliar = new Carta[Carta.palos.length * Carta.NUMERO_MAXIMO];
        Random r = new Random();
        for (int i = 0; i < this.baraja.length; i++) {
            int numAlea = r.nextInt(Carta.palos.length * Carta.NUMERO_MAXIMO);

            while (auxiliar[numAlea] != null) {
                //numAlea = (numAlea + 1) % (Carta.palos.length * Carta.NUMERO_MAXIMO);
                numAlea++;
                if (numAlea == Carta.palos.length * Carta.NUMERO_MAXIMO) {
                    numAlea = 0;
                }
            }

            auxiliar[numAlea] = baraja[i];

        }

        this.baraja = auxiliar;
    }

    public void muestraBaraja() {
        for (Carta c : this.baraja) {
            System.out.println(c);
        }
    }

}
