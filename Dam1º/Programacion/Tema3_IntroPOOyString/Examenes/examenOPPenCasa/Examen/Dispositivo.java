package Tema3_IntroPOOyString.Examenes.examenOPPenCasa.Examen;

public class Dispositivo {

    private  String nombre, protocolos, conexiones;

    public Dispositivo(String nombre,String conexiones, String protocolos) {
        this.nombre = nombre;
        this.protocolos = protocolos;
        this.conexiones = conexiones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProtocolos() {
        return protocolos;
    }

    public String getConexiones() {
        return conexiones;
    }
}
