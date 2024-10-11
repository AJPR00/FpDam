package RecuperacionEjercicios.Ejerc1;

/*
2. Gestión de Clientes
        ○ Los clientes pueden comprar y devolver mascotas.
        ○ Cada cliente tiene un nombre y una identificación única.
        ○ Se debe llevar un registro de las mascotas que cada cliente ha comprado.
        ○ Implementa la funcionalidad para que un cliente compre una mascota y para
        que un cliente devuelva una mascota a la tienda.
*/

import java.util.ArrayList;

public class Cliente {
    private static int contadorId = 1;
    private int iD;
    private String nombre;
    private ArrayList<Mascota> carteraMascota;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carteraMascota = new ArrayList<>();
        this.iD = contadorId++;
    }

    public void addMascota(Mascota m) {
        carteraMascota.add(m);
    }

    public void devolucionMascota(Mascota m) {
        carteraMascota.removeIf(mascota -> mascota.equals(m));
    }

    public void listarMascotas() {
        for (Mascota m : carteraMascota) {
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Número de Cliente: ").append(iD).append(" Nombre: ").append(nombre).toString();
    }
}
