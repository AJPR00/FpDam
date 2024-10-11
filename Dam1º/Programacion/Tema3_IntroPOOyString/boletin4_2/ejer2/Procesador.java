package Tema3_IntroPOOyString.boletin4_2.ejer2;

public class Procesador {
    private String marca;
    private String modelo;
    private String socket;
    private int numNucleos;
    private float velocidadGhz;

    public Procesador(String marca, String modelo, String socket, int numNucleos, float velocidadGhz) {
        this.marca = marca;
        this.modelo = modelo;
        this.socket = socket;
        this.numNucleos = numNucleos;
        this.velocidadGhz = velocidadGhz;
    }

    public String getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return marca + "socket"+ socket;
    }
}