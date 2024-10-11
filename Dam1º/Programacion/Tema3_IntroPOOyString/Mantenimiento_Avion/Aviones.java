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
public class Aviones {


    private static int numMaxRevisiones;
    private String marca;
    private String modelo;
    private double consumo;
    private Deposito deposito;

    private Revisones[] revisones;


    public Aviones(String marca, String modelo, double consumo, Deposito deposito) {
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.deposito = deposito;
        this.revisones = new Revisones[numMaxRevisiones];


    }

    public void addRevision(Revisones revison) {
        for (int i = 0; i < numMaxRevisiones; i++) {
            if (revisones[i] == null) {
                this.revisones[i] = revison;
                break;
            }
        }
    }

    public Revisones getUltimaRevision() {
        for (int i = numMaxRevisiones - 1; i >= 0; i--) {
            if (revisones[i] != null) {
                return revisones[i];
            }
        }
        return null;
    }


    // Distancia en kilomtros

    public boolean puedeVolar(double distancia) {

        Revisones ultimaRevision = getUltimaRevision();
        double distanciaAlcanzable = deposito.getCantidadActual()/ consumo;
        if (distanciaAlcanzable >= distancia && ultimaRevision.isEstado()){
            return true;

        }
       return false;
    }

    @Override
    public String toString() {
        return "El avion de la marca " + marca +
                " con el modelo " + modelo + " tiene un consumos de "
                + consumo + " litros/kilometro." + deposito + ". Su ultima revion fue " + getUltimaRevision();
    }
}
