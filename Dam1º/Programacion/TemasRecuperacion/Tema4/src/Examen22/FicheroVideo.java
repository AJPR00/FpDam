package Examen22;

public class FicheroVideo extends Fichero implements Reproducible{
    private byte[] contenido;
    private int duracion;

    public FicheroVideo(String nombre) {
        super(nombre);
    }

    @Override
    public void tamano() {
        setTamano(contenido.length);
    }

    @Override
    public void reproduciendo() {
        System.out.println("Reproduciendo "+ getClass().getSimpleName()+" "+ getNombre());

    }
}

