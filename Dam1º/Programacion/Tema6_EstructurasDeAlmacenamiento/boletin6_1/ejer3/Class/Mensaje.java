package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejer3.Class;

import java.time.LocalDateTime;

public class Mensaje implements Comparable<Mensaje> {
    private String contenido;
    private LocalDateTime fecha;
    private Persona remitente;

    public Persona getRemitente() {
        return remitente;
    }

    public String getContenido() {
        return contenido;
    }

    public Mensaje(Persona remitente, String contenido) {
        this.contenido = contenido;
        this.fecha = LocalDateTime.now();
        this.remitente = remitente;
    }

    @Override
    public String toString() {
        return "Remitente: " + remitente.getNombre() + "\nFecha: " + fecha + " \n" + contenido;
    }

    @Override
    public int compareTo(Mensaje otro) {
      /*  int resul=1;
        if (fecha.isEqual(otro.fecha)) {
            resul = 0;
        }else if (fecha.isBefore(otro.fecha)){
            resul=-1;
        }*/
        return fecha.compareTo(otro.fecha);
    }
}
