package Tema5_ConceptoAvanzadosOPP.Examenes;

import java.time.LocalDateTime;

public abstract class Fichero {
    private String name;
    private LocalDateTime date;
    private byte tamano;


    public Fichero(String name) {
        this.name = name;
        this.date = LocalDateTime.now();
    }

    public abstract long tamanoFichero();

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public byte getTamano() {
        return tamano;
    }


    @Override
    public String toString() {
        return "Fichero{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", tamano=" + tamano +
                '}';
    }
}
