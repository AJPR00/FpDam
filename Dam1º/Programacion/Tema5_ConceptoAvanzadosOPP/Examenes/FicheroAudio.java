package Tema5_ConceptoAvanzadosOPP.Examenes;

public class FicheroAudio extends Fichero implements Reproducible {
    private byte[] arrayAudio;
    private int duracionSegundos;

    public FicheroAudio(String name, int duracionSegundos, byte[] arrayAudio) {
        super(name);
        this.arrayAudio = arrayAudio;
        this.duracionSegundos = duracionSegundos;
    }

    public void setArrayAudio(byte[] arrayAudio) throws FicheroException {
        if (arrayAudio.length < 1) {
            throw new FicheroException("No es posible generar un arvhivo de audio vacio");
        }
        this.arrayAudio = arrayAudio;
    }

    public void setDuracionSegundos(int duracionSegundos) throws FicheroException {
        if (duracionSegundos < 1) {
            throw new FicheroException("No es posible generar un arvhivo de audio");
        }
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public long tamanoFichero() {
        return arrayAudio.length;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo " + getName());

    }
}
