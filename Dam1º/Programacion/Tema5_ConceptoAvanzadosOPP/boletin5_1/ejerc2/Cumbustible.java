package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc2;

public enum Cumbustible {

    GASOLINA(3.5), DIESEL(2);

    private double precioCumbustibleDia;

    Cumbustible(double precioCumbustibleDia) {
        this.precioCumbustibleDia = precioCumbustibleDia;
    }

    public double getPrecioCumbustibleDia() {
        return precioCumbustibleDia;
    }
}
