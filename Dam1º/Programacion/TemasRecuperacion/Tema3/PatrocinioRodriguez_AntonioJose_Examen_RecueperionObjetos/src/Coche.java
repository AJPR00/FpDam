public class Coche {
    private String nombre;
    private String modelo;
    private EColores color;
    private Motor motor;
    private CajaDeCambio cajaCambio;
    private Bateria bateria;
    private Deposito deposito;


    public Coche(String nombre, String modelo, EColores color, Motor motor, CajaDeCambio cajaCambio, Bateria bateria, Deposito deposito) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.cajaCambio = cajaCambio;
        this.bateria = bateria;
        this.deposito = deposito;
    }

    public void arrancar() {
        if (deposito.estadoOK() && bateria.batiraOK() && cajaCambio.isOperativo() && motor.estadoOK()) {
            System.out.println("Arrancando...");
        }else{
            System.out.println("No puede arrancar");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", color=").append(color);
        sb.append(", motor=").append(motor);
        sb.append(", cajaCambio=").append(cajaCambio);
        sb.append(", bateria=").append(bateria);
        sb.append(", deposito=").append(deposito);
        sb.append('}');
        return sb.toString();
    }
}
