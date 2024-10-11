package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2;

public class Circulo extends Forma implements Dibujable {
    private double radio;

    public void setRadio(double radio) {
        this.radio = radio;
    }
    public Circulo(double radio) {
        this.radio = radio;
    }
    @Override
    public void dibujar() {
        System.out.println("Dibujando Circulo");
    }
    @Override
    public double calcularArea() throws FicheroException {
        return 2 * Math.PI * radio;
    }
}
