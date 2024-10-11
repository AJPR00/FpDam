package Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen23;

import java.util.*;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;

    public Liga(String nombre) {
        super();
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }

    public void addEquipo(Equipo e) throws LigaException {
        if (equipos.contains(e)) throw new LigaException("El equipo ya esta inscrito");
        if (e.getJugadores().isEmpty()) throw new LigaException("El equipo no contiene jugadores");
        equipos.add(e);
    }

    public void eliminaEquipo(Equipo e) throws LigaException {
        if (!equipos.remove(e)) throw new LigaException("El equipo no esta inscrito");

    }

    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)) throw new LigaException("Los equipos deben estar inscrito");
        // creamos un método addJugadores en Equipo  para desacoplar.
        e1.addJugadores(e2.getJugadores());
    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)) throw new LigaException("Los equipos deben estar inscrito");
        Set<Jugador> jugadoresComun = new HashSet<>(e1.getJugadores());
        jugadoresComun.retainAll(e2.getJugadores());
        return new ArrayList<>(jugadoresComun);

    }


    public double mediaEdad() throws LigaException {
        return todosLosJugadores().stream().mapToInt(Jugador::calculaEdad).average().orElseThrow(()-> new LigaException("Sin edad media"));

    }

    public List<Jugador> jugadoresOrdenadosEdad() {
        return todosLosJugadores().stream().sorted((a,b)->b.getFechaNacimiento().compareTo(a.getFechaNacimiento())).toList();

    }

    public List<Jugador> jugadoresOrdenadosNombre() {
        return todosLosJugadores().stream().sorted((a,b)->a.getNombre().compareTo(b.getNombre())).toList();

    }
    private Set<Jugador> todosLosJugadores() {
            Set<Jugador> todosJugadores = new HashSet<>();

            for (Equipo e : equipos) {
                todosJugadores.addAll(e.getJugadores());
            }
            return todosJugadores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e : equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}
