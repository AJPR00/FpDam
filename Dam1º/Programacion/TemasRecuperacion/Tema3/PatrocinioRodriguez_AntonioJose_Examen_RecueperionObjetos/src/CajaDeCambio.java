public class CajaDeCambio {

    private final int VELOCIDAD_MAX = 7;
    private int numVelocidad;
    private boolean operativo;

    public CajaDeCambio(int numVelocidad, boolean operativo) throws ExcepcionCoche {
        setNumVelocidad(numVelocidad);
        this.operativo = operativo;
    }

    public void setNumVelocidad(int numVelocidad) throws ExcepcionCoche {
        if (numVelocidad > VELOCIDAD_MAX || numVelocidad < 1)
            throw new ExcepcionCoche("Caja de cambio muy grande debe de ser de un máximo de  " + VELOCIDAD_MAX + " velocidaddes.");

        this.numVelocidad = numVelocidad;
    }

    public boolean isOperativo() {
        return operativo;
    }

    @Override
    public String toString() {
        return "CajaDeCambio: " +
                ", numVelocidad: " + numVelocidad;

    }
}
