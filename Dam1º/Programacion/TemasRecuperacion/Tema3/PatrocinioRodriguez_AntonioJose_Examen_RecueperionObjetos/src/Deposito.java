public class Deposito {

    private final int CAPACIDAD_TANQUE = 100;
    private int capacidad;
    private double nivel;
    private boolean presionCorrecta;


    public Deposito(int capacidad, int nivel, boolean presionCorrecta) throws ExcepcionCoche {
        setCapacidad(capacidad);
        setNivel(nivel);
        this.presionCorrecta = presionCorrecta;
    }

    /**
     * @param capacidad
     * @throws ExcepcionCoche
     */

    public void setCapacidad(int capacidad) throws ExcepcionCoche {
        if (capacidad > CAPACIDAD_TANQUE)
            throw new ExcepcionCoche("El Tanque debe de ser menor a " + CAPACIDAD_TANQUE + " litros.");

        this.capacidad = capacidad;
    }

    public void setNivel(int nivel) throws ExcepcionCoche {
        if (nivel > CAPACIDAD_TANQUE)
            throw new ExcepcionCoche("Demasiado Combustible para tanque tan pequeño, el tanque es de " + CAPACIDAD_TANQUE + " litros.");

        this.nivel = (double) nivel / CAPACIDAD_TANQUE;
    }

    public boolean isPresionCorrecta() {
        return presionCorrecta;
    }

    public boolean estadoOK() {
        return nivel > 0 && isPresionCorrecta() ;
    }

    @Override
    public String toString() {
        return "Deposito: " +
                ", capacidad: " + capacidad +
                ", nivel: " + nivel +
                ", presionCorrecta: " + presionCorrecta;
    }
}
