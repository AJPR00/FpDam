package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc3;


public class Clerigo extends Personaje {
    public static final int CURAR_DANO = 10;
    // Minimo y Máximo incluidos inteligencia
    public static final int INTELIGENCIA_MIN_CLERIGO = 12;
    public static final int INTELIGENCIA_MAX_CLERIGO = 16;
    public static final int FUERZA_MENOR_CLERIGO = 18;
    private String nombreDios;

    public Clerigo() {
    }

    public String getNombreDios() {
        return nombreDios;
    }

    public void setNombreDios(String nombreDios) {
        this.nombreDios = nombreDios;
    }
     public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima, String nombreDios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMaxima);
        this.nombreDios = nombreDios;
    }

    public void curar(Personaje personaje) throws PersonajeException {
        if (personaje.getVidaActual() == 0) {
            throw new PersonajeException("El personaje está muerto no se puede resucitar");
        }
        if (personaje.getVidaActual() > personaje.getVidaMaxima() - (CURAR_DANO - 1)) {
            personaje.setVidaActual(getVidaMaxima());
        } else {
            personaje.setVidaActual(getVidaActual() + CURAR_DANO);
        }
    }

    @Override
    public String toString() {
        return super.toString() + """
                Es un Clerido y sana a nombre del Dios %s
                 """.formatted(nombreDios);
    }
}
