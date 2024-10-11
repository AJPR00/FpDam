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
public class Deposito {
    private double capacidadMaxima;
    private double cantidadActual;

    public Deposito(double cantidadActual, double capacidadMaxima) {
        this.cantidadActual = cantidadActual;
        this.capacidadMaxima = capacidadMaxima;
        setCantidadActual(cantidadActual);


    }

    public void setCantidadActual(double cantidadActual) {
        if (cantidadActual < capacidadMaxima && cantidadActual > 0) {
            this.cantidadActual = cantidadActual;
        }
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    @Override
    public String toString() {
        return " Su nivel de tapacidad actual es de " + capacidadMaxima / cantidadActual * 100 + "%  de un deposito de "
                + capacidadMaxima;
    }

}

