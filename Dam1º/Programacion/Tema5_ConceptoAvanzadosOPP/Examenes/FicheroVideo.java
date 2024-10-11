package Tema5_ConceptoAvanzadosOPP.Examenes;

public class FicheroVideo extends Fichero implements Reproducible {
    private byte[] arrayDeVideo;
    private int duracionSegundos;

    public FicheroVideo(String name, int duracionSegundos, byte[] arrayDeVideo) throws FicheroException {
        super(name);
        setArrayDeVideo(arrayDeVideo);
        setDuracionSegundos(duracionSegundos);
    }

    public void setArrayDeVideo(byte[] arrayDeVideo) throws FicheroException {
        if (arrayDeVideo.length < 1) {
            throw new FicheroException("No es posible generar un archivo vacío");
        }
        this.arrayDeVideo = arrayDeVideo;
    }

    public void setDuracionSegundos(int duracionSegundos) throws FicheroException {
        if (duracionSegundos < 1) {
            throw new FicheroException("No es posible generar un archivo");
        }
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public long tamanoFichero() {
        return arrayDeVideo.length;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo " + getName());
    }
}
