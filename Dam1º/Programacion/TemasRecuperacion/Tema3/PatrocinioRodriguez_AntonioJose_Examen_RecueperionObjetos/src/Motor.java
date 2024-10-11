public class Motor {

    private final double NIVEL_AGUA_MIN = 0;
    private final double NIVEL_AGUA_mAX = 1;
    private final double NIVEL_ACEITE_MIN = 0;
    private final double NIVEL_ACEITE_MAX = 1;
    private final double TEMPERATURA_MIN = 0;
    private final double TEMPERATURA_MAX = 120;

    private String marca;
    private String modelo;
    private String numSerie;
    private double nivelAceite;
    private double tempuratura;
    private int kilometros;
    private double nivelAgua;


    public Motor(String marca, String modelo, String numSerie, double nivelAceite, double tempuratura, int kilometros, double nivelAgua) throws ExcepcionCoche {
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        setNivelAceite(nivelAceite);
        setTempuratura(tempuratura);
        setKilometros(kilometros);
        setNivelAgua(nivelAgua);
    }

    public void setKilometros(int kilometros) throws ExcepcionCoche {
        if (kilometros > 50000 || kilometros < 0)
            throw new ExcepcionCoche("Kilometraje debe de ser inferior a 50000");

        this.kilometros = kilometros;
    }

    public void setNivelAceite(double nivelAceite) throws ExcepcionCoche {
        if (nivelAceite > NIVEL_ACEITE_MAX || nivelAceite < NIVEL_ACEITE_MIN)
            throw new ExcepcionCoche("Nivel de aceite debe de estar entre " + NIVEL_ACEITE_MAX + " y " + NIVEL_ACEITE_MIN);
        this.nivelAceite = nivelAceite;
    }

    public void setTempuratura(double tempuratura) throws ExcepcionCoche {
        if (tempuratura > TEMPERATURA_MAX || tempuratura < TEMPERATURA_MIN)
            throw new ExcepcionCoche("Nivel de tempertura debe de estar entre " + TEMPERATURA_MAX + " y " + TEMPERATURA_MIN);

        this.tempuratura = tempuratura;
    }

    public void setNivelAgua(double nivelAgua) throws ExcepcionCoche {
        if (nivelAgua > NIVEL_AGUA_mAX || nivelAgua < NIVEL_AGUA_MIN)
            new ExcepcionCoche("Nivel de agua debe de estar entre " + NIVEL_AGUA_mAX + " y " + NIVEL_AGUA_MIN);

        this.nivelAgua = nivelAgua;
    }

    public boolean nivelAceite() {
        return nivelAceite >= 0.96 && nivelAceite <= 0.98;
    }

    public boolean nivelAgua() {
        return nivelAgua >= 0.7;
    }

    public boolean temperatura() {
        return tempuratura <= 95;
    }

    public boolean estadoOK() {
        return temperatura() && nivelAgua() && nivelAceite();
    }

    @Override
    public String toString() {
        return "Motor: " +
                "marca: " + marca + '\'' +
                ", modelo:" + modelo + '\'' +
                ", numSerie: " + numSerie + '\'';
    }
}
