package Tema3_IntroPOOyString.boletin4_2.ejer2;

public class DiscoDuro {

    private String marca;
    private String tipo;
    private int capacidad;

    public DiscoDuro(String marca, String tipo, int capacidad) {
        this.marca = marca;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return  String.format("%s%s%d",marca,tipo,capacidad);
    }
}
