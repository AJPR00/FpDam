package RecuperacionEjercicios.Ejerc2;

import RecuperacionEjercicios.MiEntradaSalida;

import java.time.LocalDateTime;

public class Transacion {
    private static int idContador=1;
    private int numTransacion;
    private Producto producto;
    private int cantidad;
    private double pvpProducto;
    private LocalDateTime fTransacion;

    public Transacion(Producto producto, int cantidad) {
        this.numTransacion = idContador;
        this.producto = producto;
        this.cantidad = cantidad;
        this.pvpProducto= producto.getPrecio();
        this.fTransacion = LocalDateTime.now();
        idContador++;
    }

    public double totalTransacion(){
        return MiEntradaSalida.redondeoDecimal(cantidad*pvpProducto,2);
    }

}
