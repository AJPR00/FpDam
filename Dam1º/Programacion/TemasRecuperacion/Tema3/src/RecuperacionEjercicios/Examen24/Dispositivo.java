package RecuperacionEjercicios.Examen24;

public class Dispositivo {
    private String nombre;
    private String conexion;
    private String protocolo;


    public Dispositivo(String nombre, String conexion, String protocolo) {
        this.nombre = nombre;
        this.conexion = conexion;
        this.protocolo = protocolo;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getConexion() {
        return conexion;
    }
}
