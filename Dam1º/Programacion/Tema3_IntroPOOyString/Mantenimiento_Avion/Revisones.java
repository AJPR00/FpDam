package boletin4_1.Mantenimiento_Avion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*Vamos a implementar la gestión del mantenimiento básico de un avión. El avión tiene:
        ● Una marca
        ● Un modelo
        ● Un consumo, que se entenderá por litros consumidos por kilómetro
        ● Un depósito de combustible, que a su vez tendrá:
        ○ Una capacidad máxima
        ○ Una cantidad actual
        ● Un registro de revisiones, donde cada una de ellas tendrá:
        ○ Una fecha
        ○ Un estado (correcto o incorrecto)
        ○ Un periodo de validez
        El avión deberá poder mostrar sus datos actuales: marca, modelo, nivel de combustible
        actual y si está listo para viajar o no.
        Debe disponer también de un método que nos indique si, dada la distancia a un destino, el
        avión puede realizar el recorrido o no, teniendo en cuenta también si su última revisión está
        en fecha y fue correcta.*/
public class Revisones {


    private LocalDateTime fecha;
    private boolean estado;
    //Se mide en meses
    private int periodoValidez;


    public Revisones(LocalDateTime fecha, boolean estado, int periodoValidez) {
        if (fecha.isAfter(LocalDateTime.now())) {

            this.fecha = fecha;
        }

        this.estado=estado;

        if (periodoValidez > 0) {
            this.periodoValidez = periodoValidez;
        }

    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getPeriodoValidez() {
        return periodoValidez;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter) +
                " con resultado " + (estado ?
                " sastifactorio con una validez " + periodoValidez + "mese" : "no satisfactorio");
    }
}
