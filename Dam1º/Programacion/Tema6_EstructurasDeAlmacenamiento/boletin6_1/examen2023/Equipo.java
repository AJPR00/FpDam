package Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen23;



import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipo {
    private String nombre;
    private Set<Jugador> jugadores;
    
    public Equipo(String nombre) {
        super();
        this.nombre = nombre;
        this.jugadores = new HashSet<>();
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }
    public void addJugadores(Set<Jugador> e2) {
        jugadores.addAll(e2);
    }
    
    public Set<Jugador> getJugadores() {
        return jugadores;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ").append(System.lineSeparator());
        for (Jugador j: jugadores) {
            sb.append(j).append(System.lineSeparator());
        }
        
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
    
    
}
