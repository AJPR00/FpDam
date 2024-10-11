package RecuperacionEjercicios.Ejerc1;

import java.time.LocalDateTime;

public class Compra {
    private static int contadorId=1;
    private  int idCompra;
    private Cliente cliente;
    private Mascota mascota;
    private LocalDateTime fechaCompra;

    //Todo, averiguar en caso de que un cliente en la misma compra contenga varias mascotas (Mascota...mascota)
    public Compra(Cliente cliente, Mascota mascota) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.fechaCompra = LocalDateTime.now();
        this.idCompra=contadorId++;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nNúmero de tiket ").append(idCompra).append("\n").append(cliente.toString()).append("\n # Compra:\n ").append(mascota.toString()).toString();
    }
}
