package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc3;

public class MusicApp {

    public static void main(String[] args) {
        MusicPlayer[] players = new MusicPlayer[]{new Spotify(), new ITunes(), new Mp3Player()};
        MusicApp app = new MusicApp();
        app.startMusic(players);
    }

    private void startMusic(MusicPlayer[] players) {

        for (MusicPlayer player : players) {
            if (player instanceof OnlineMusicPlayer) {
                ((OnlineMusicPlayer) player).stream();
            } else if (player instanceof OffineMusicPlayer) {
                ((OffineMusicPlayer) player).load();
            }
            player.play();
            player.stop();
        }
    }
}

