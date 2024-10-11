package ejer3;

import java.time.LocalDateTime;

public class Mensaje implements Comparable<Mensaje> {

    Persona remitente;
    private String texo;
    private LocalDateTime fechaHora;

    public Mensaje(Persona remitente, String texo) {
        this.remitente = remitente;
        this.texo = texo;
        this.fechaHora = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public String getTexo() {
        return texo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "remitente=" + remitente +
                ", texo='" + texo + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }

    @Override
    public int compareTo(Mensaje otro) {
        return otro.fechaHora.compareTo(fechaHora);
    }
}
