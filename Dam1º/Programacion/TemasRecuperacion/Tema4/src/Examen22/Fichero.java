package Examen22;

import java.time.LocalDate;

public abstract class Fichero {
    private String nombre;
    private int tamano;
    private LocalDate fecha;

    public Fichero(String nombre) {
        this.nombre = nombre;
        this.fecha = LocalDate.now();
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public abstract void tamano();
   public abstract void addContenido(String s);

    /**
     * @toString  como final para que no pueda se pueda sobreescribir ninguna clase hija
     */
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nombre:").append(nombre);
        sb.append("::Tamano:").append(tamano);
        sb.append("::Fecha:").append(fecha);
       return sb.toString();
    }
}
