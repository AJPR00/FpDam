package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc3;

public class ITunes implements OffineMusicPlayer{
    @Override
    public void play() {
        System.out.println("Playing music on iTunes");
    }

    @Override
    public void stop() {
        System.out.println("Stop music on iTunes");
    }

    @Override
    public void load() {
        System.out.println("Loading music on iTunes");
    }
}
