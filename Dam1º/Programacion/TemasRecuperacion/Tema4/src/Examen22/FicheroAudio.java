package Examen22;

public class FicheroAudio extends Fichero implements Reproducible{

    private byte[] contenido;
    private int duracion;

    public FicheroAudio(String nombre) {
        super(nombre);
    }

    @Override
    public void tamano() {
        setTamano(contenido.length);
    }

    @Override
    public void addContenido(String s) {

    }

    @Override
    public void reproduciendo() {
        System.out.println("Reproduciendo "+ getNombre());
    }
}
