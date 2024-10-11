package RecuperacionEjercicios.Ejerc1;

import java.util.Objects;

public class Mascota {
    private static int contadorId = 1;
    private int iD;
    private String nombre;
    private Especies especie;
    private boolean disponible;
    private int edad;
    private double pvp;

    public Mascota(String nombre, Especies especie, int edad, double pvp) {
        this.nombre = nombre;
        this.especie = especie;
        this.disponible = true;
        this.edad = edad;
        this.pvp = pvp;
        this.iD = contadorId++;
    }

    public int getiD() {
        return iD;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("# Id: ").append(iD).append(" especie: ").append(especie).append(" Nombre: ").append(nombre).append(" Edad: ").append(edad).append(" Pvp: ").append(pvp).append(" ·"+disponible).toString();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return iD == mascota.iD && Objects.equals(nombre, mascota.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, nombre);
    }
}
