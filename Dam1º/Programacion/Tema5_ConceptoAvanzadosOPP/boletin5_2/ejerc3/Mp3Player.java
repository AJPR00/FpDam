package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc3;

public class Mp3Player implements OffineMusicPlayer{
    @Override
    public void play() {
        System.out.println("Playing music on MP3 Player");
    }

    @Override
    public void stop() {
        System.out.println("Stopping music on MP3 Player");
    }

    @Override
    public void load() {
        System.out.println("Loading music on MP3 Player");
    }
}
