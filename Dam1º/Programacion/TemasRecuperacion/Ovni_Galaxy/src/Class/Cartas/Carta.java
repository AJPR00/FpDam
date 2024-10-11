package Class.Cartas;

public abstract class Carta {
    private String nombre;
    private int precio;

    public Carta(String nombre, int precio) {
        this.nombre = nombre;
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}