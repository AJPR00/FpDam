package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc1;

public class Principal {

    public static void main(String[] args) {
        // Crear instancias de las clases FPSGamer, MOBAGamer y SportsGamer
        FpsGamer fpsGamer = new FpsGamer();
        MobaGamer mobaGamer = new MobaGamer();
        SportsGamer sportsGamer = new SportsGamer();

        // Crear instancia de la clase EsportsTournament
        EsportsTournament esportsTournament = new EsportsTournament();

        // Crear un array de objetos Gamer
        Gamer[] players = {fpsGamer, mobaGamer, sportsGamer};

        // Llamar al método startTournament con el array de jugadores
        EsportsTournament.startTournament(players);
    }

}
