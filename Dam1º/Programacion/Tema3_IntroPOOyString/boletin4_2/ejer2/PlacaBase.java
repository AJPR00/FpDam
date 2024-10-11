package Tema3_IntroPOOyString.boletin4_2.ejer2;

public class PlacaBase {
    private String marca;
    private String chipset;
    private String socket;

    public PlacaBase(String marca, String chipset, String socket) {
        this.marca = marca;
        this.chipset = chipset;
        this.socket = socket;
    }

    public boolean compatibilidadCpu(Procesador cpu) {
        return this.socket.equals(cpu.getSocket());
    }

    @Override
    public String toString() {
        return marca + "socket"+ socket;
    }
}
