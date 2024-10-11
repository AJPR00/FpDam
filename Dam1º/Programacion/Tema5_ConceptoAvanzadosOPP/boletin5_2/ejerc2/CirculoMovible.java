package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2;

public class CirculoMovible extends Forma implements Dibujable, Animable{
    private double radio;
    public CirculoMovible(double radio) {
        this.radio = radio;
    }
    @Override
    public void animar() {
        System.out.println("Animando CirculoMovible");
    }
    @Override
    public void dibujar() {
        System.out.println("Dibujando CirculoMovible");
    }
    @Override
    public double calcularArea() throws FicheroException {
        return 2 * Math.PI * radio;
    }
}
