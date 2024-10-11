package boletin4_1.Mantenimiento_Avion;

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

import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {


        // Creamos los OBJETO y le pasamos sus valores, ya definido en su constructores

        Deposito d = new Deposito(200000, 180000);
        Aviones a = new Aviones("Airbus", "A230", 13, d);


        a.addRevision(new Revisones(LocalDateTime.now(), true, 6));
        System.out.println(a);
    }
}
