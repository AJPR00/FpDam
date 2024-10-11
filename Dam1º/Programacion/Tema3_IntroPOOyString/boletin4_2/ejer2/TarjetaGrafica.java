package Tema3_IntroPOOyString.boletin4_2.ejer2;

public class TarjetaGrafica {
    private String marca;
    private String modelo;
    private int numNucleos;
    private int capacidadGB;
    private float velocidadGhz;

    public TarjetaGrafica(String marca, String modelo, int numNucleos, int capacidadGB, float velocidadGhz) {
        this.marca = marca;
        this.modelo = modelo;
        this.numNucleos = numNucleos;
        this.capacidadGB = capacidadGB;
        this.velocidadGhz = velocidadGhz;
    }

    @Override
    public String toString() {
        return marca + modelo;
    }
}

