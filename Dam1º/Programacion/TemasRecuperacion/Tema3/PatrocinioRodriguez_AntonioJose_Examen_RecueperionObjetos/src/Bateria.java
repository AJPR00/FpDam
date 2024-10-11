public class Bateria {


    private final int VOLTAJE_BATERIA = 19;
    private int capacidad;
    private int voltaje;
    private int cargaActual;

    public Bateria(int capacidad, int voltaje, int cargaActual) throws ExcepcionCoche {
        this.capacidad = capacidad;
        setVoltaje(voltaje);
        this.cargaActual = cargaActual;
    }

    public boolean batiraOK() {
        return cargaActual > 5;
    }

    private void setVoltaje(int voltaje) throws ExcepcionCoche {
        if (voltaje != VOLTAJE_BATERIA) throw new ExcepcionCoche("Batería debe de ser" + VOLTAJE_BATERIA + " voltios.");
        this.voltaje = voltaje;
    }

    @Override
    public String toString() {
        return "Bateria: " +
                "VOLTAJE_BATERIA: " + VOLTAJE_BATERIA +
                ", capacidad: " + capacidad +
                ", voltaje: " + voltaje +
                ", cargaActual: " + cargaActual;
    }
}
