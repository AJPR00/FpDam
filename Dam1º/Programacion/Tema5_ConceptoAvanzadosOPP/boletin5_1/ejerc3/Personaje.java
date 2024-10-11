package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc3;

import java.util.Arrays;


public class Personaje implements Comparable{

    public static final int FUERZA_MAXIMA = 20;
    public static final int INTELIGENCIA_MAXIMA = 20;
    public static final int VIDA_MAXIMA = 100;
    public static final int FUERZA_MIN = 0;
    public static final int INTELIGENCIA_MIN = 0;
    public static final int VIDA_MIN = 0;


    private String nombre;
    private TRaza raza;
    private int fuerza;
    private int inteligencia;
    private int vidaMaxima;
    private int vidaActual;

    public Personaje() {
    }

   public Personaje(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaActual)  {
        this.nombre = nombre;
        this.raza = raza;
        try {
            setFuerza(fuerza);
            setInteligencia(inteligencia);
            setVidaMaxima(VIDA_MAXIMA);
            setVidaActual(vidaActual);
        }catch (PersonajeException e){
            System.out.println(e.getMessage());
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public TRaza getRaza() {
        return raza;
    }

    public void setRaza(TRaza raza) throws PersonajeException {
        // Convierte  Traza en una array y la muestra en una lista, y luego con contains se verifica que es un valor correcto
        if (!Arrays.asList(TRaza.values()).contains(raza)) {
            throw new PersonajeException("Valor de raza no válido");
            // El valor de raza es válido

        } else {
            this.raza = raza;
        }
    }

    public void setFuerza(int fuerza) throws PersonajeException {

        if (fuerza < FUERZA_MIN || fuerza > FUERZA_MAXIMA) {
            throw new PersonajeException("Valor de fuerza no permitido");
        }
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {

        if (inteligencia < INTELIGENCIA_MIN || inteligencia > INTELIGENCIA_MAXIMA) {
            throw new PersonajeException("Valor de inteligencia no permitido");

        }
        this.inteligencia = inteligencia;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) throws PersonajeException {
        if (vidaMaxima < VIDA_MIN || vidaMaxima > VIDA_MAXIMA) {
            throw new PersonajeException("Valor de vida maxima no permitido");
        }

        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) throws PersonajeException {

        if (vidaActual < VIDA_MIN || vidaActual > VIDA_MAXIMA) {
            throw new PersonajeException("Valor de vida no permitido");
        }
        this.vidaActual = vidaActual;
    }

    @Override
    public String toString() {
        return """
                  Se llama: %s
                  Raza: %s
                  Fuerza: %d
                  Inteligencia: %d
                  Salud Máximo: %d
                  Saldu Actual: %d
                """.formatted(nombre, raza, fuerza, inteligencia, vidaMaxima, vidaActual);
    }
    @Override
    public int compareTo(Object o) {

        if (o instanceof Personaje) {
            Personaje otroPersonaje = (Personaje) o;
            return Integer.compare(this.fuerza, otroPersonaje.fuerza);
        }
        return 0; // Devuelve 0 si el objeto no es comparable con Personaje
    }
}
