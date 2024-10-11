public class Dispositivo {

    private String nombre;
    private String conexion;
    private String protocoloSoportado;


    public Dispositivo(String nombre, String conexion, String protocoloSoportado) {

        this.nombre = nombre;
        this.conexion = conexion;
        this.protocoloSoportado = protocoloSoportado;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getProtocoloSoportado() {
        return protocoloSoportado;
    }

    public void setProtocoloSoportado(String protocoloSoportado) {
        this.protocoloSoportado = protocoloSoportado;
    }
}



