package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc3;

import java.util.Arrays;

public class Mago extends Personaje {
    public static final int CAPACIDAD_HECHIZOS = 4;
    public static final int DANO_HECHIZO = 10;
    public static final int INTELIGENCIA_MIN_MAGO = 17;
    public static final int FUERZA_MAX_MAGO = 15;
    private String[] arrayHechizos;



    public Mago() {
        arrayHechizos=new String[CAPACIDAD_HECHIZOS];
    }

    public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima) {
        super(nombre, raza, fuerza, inteligencia, vidaMaxima);
        arrayHechizos = new String[CAPACIDAD_HECHIZOS];}


    @Override
    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza > FUERZA_MAX_MAGO) {
            throw new PersonajeException("Valor no permitido, mucha fuerza para ser MAGO (" + FUERZA_MAX_MAGO + ")");
        }
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia < INTELIGENCIA_MIN_MAGO) {
            throw new PersonajeException("Valor de inteligencia no permitido para ser Mago (" + INTELIGENCIA_MIN_MAGO + ")");
        }
        super.setInteligencia(inteligencia);
    }

    public void aprendeHechizo(String hechizo) throws PersonajeException {
        boolean loTengo = false;
        int posVacia = -1;
        for (int i = 0; i < arrayHechizos.length && !loTengo; i++) {
            if (hechizo.equals(arrayHechizos[i])) {
                loTengo = true;
            }
            if (arrayHechizos[i] == null && posVacia == -1) {
                posVacia = i;
            }
        }

        if (loTengo) {
            throw new PersonajeException("El mago no puede aprender el mismo hechizo");
        }
        if (posVacia == -1) {
            throw new PersonajeException("No tiene espacio suficiente para mas hechizos");
        }
        arrayHechizos[posVacia] = hechizo;
    }

    //Metodo lanzar hechizo
    public void lanzaHechizo(Personaje personaje, String hechizo) throws PersonajeException {
        int posHechizo = -1;
        for (int i = 0; i < arrayHechizos.length && posHechizo == -1; i++) {
            if (hechizo.equals(arrayHechizos[i])) {
                posHechizo = i;
            }
        }
        if (posHechizo == -1) {
            throw new PersonajeException("El Mago no conoce el hechizo");
        }
        if (this == personaje) {
            throw new PersonajeException("No puedes atacarte a ti mismo");
        }
        if (personaje.getVidaActual() == 0) {
            throw new PersonajeException("El personaje esta muerto");
        }
        personaje.setVidaActual(getVidaActual() - DANO_HECHIZO);
        arrayHechizos[posHechizo] = null;
    }


    @Override
    public String toString() {
        return super.toString() + """
                Es un Mago y solo sabe lanzar hechizos %s
                 """.formatted(Arrays.toString(arrayHechizos));
    }
}

