package Examen22;

import java.util.Arrays;

public class FicheroBinario extends Fichero{
    private byte[] contenido;

    public FicheroBinario(String nombre, byte[] contenido) {
        super(nombre);
        this.contenido = contenido;
    }

    @Override
    public void tamano() {
       setTamano(contenido.length);
    }

    @Override
    public void addContenido(String s) {

    }

}
